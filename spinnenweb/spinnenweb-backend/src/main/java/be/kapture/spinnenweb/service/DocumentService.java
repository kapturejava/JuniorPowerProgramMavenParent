package be.kapture.spinnenweb.service;

import be.kapture.spinnenweb.dto.EvaluatieCategorieDTO;
import be.kapture.spinnenweb.dto.EvaluatieDocumentDTO;
import be.kapture.spinnenweb.dto.EvaluatieSkillDTO;
import be.kapture.spinnenweb.dto.EvaluatieSubcategorieDTO;
import be.kapture.spinnenweb.exception.DocumentProcessorException;
import be.kapture.spinnenweb.model.EvaluatieDocument;
import be.kapture.spinnenweb.model.EvaluatieScore;
import be.kapture.spinnenweb.repository.EvaluatieDocumentRepository;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentService {
    @Autowired
    private EvaluatieDocumentRepository evaluatieDocumentRepository;

    public EvaluatieDocumentDTO processDocument(MultipartFile file) {
        Workbook workbook = getWorkbookFromMultipartFile(file);

        EvaluatieDocumentDTO evaluatieDocumentDTO = new EvaluatieDocumentDTO();

        for (int sheetIndex=0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);

            if (sheetIsCategory(sheet)) {
                addCategoryToDocument(sheet, evaluatieDocumentDTO);
            }
        }

        try {
            workbook.close();
        } catch (IOException e) {
            throw new DocumentProcessorException("Exception while closing document", e);
        }

        return evaluatieDocumentDTO;
    }

    private void addCategoryToDocument(Sheet sheet, EvaluatieDocumentDTO evaluatieDocumentDTO) {
        EvaluatieCategorieDTO evaluatieCategorie = new EvaluatieCategorieDTO();
        evaluatieCategorie.setNaam(sheet.getSheetName());

        int subcategorieIndex = 0;
        while (sheetHeeftSubcategorie(sheet, subcategorieIndex)) {
            addSubcategoryToCategory(sheet, subcategorieIndex, evaluatieCategorie);
            subcategorieIndex++;
        }

        evaluatieDocumentDTO.getEvaluatieCategorieList().add(evaluatieCategorie);
    }

    private void addSubcategoryToCategory(Sheet sheet, int subcategorieIndex, EvaluatieCategorieDTO evaluatieCategorie) {
        int column = subcategorieIndex * 3;

        EvaluatieSubcategorieDTO evaluatieSubcategorie = new EvaluatieSubcategorieDTO();
        evaluatieSubcategorie.setNaam(getStringCellValue(sheet, 0, column));

        if (hasNumericCellValue(sheet, 0, column+1))
            evaluatieSubcategorie.setEvaluatieScore(EvaluatieScore.fromScoreString(Integer.toString(getIntegerCellValue(sheet, 0, column+1))));
        else
            evaluatieSubcategorie.setEvaluatieScore(EvaluatieScore.GEEN_EVALUATIE);

        int row = 1;
        while (sheetHeeftSkill(sheet, column, row)) {
            addSkillToSubcategorie(sheet, column, row, evaluatieSubcategorie);
            row++;
        }

        evaluatieCategorie.getEvaluatieSubcategorieList().add(evaluatieSubcategorie);
    }

    private void addSkillToSubcategorie(Sheet sheet, int column, int row, EvaluatieSubcategorieDTO evaluatieSubcategorie) {
        EvaluatieSkillDTO skill = new EvaluatieSkillDTO();

        skill.setNaam(getStringCellValue(sheet, row, column));

        if (hasNumericCellValue(sheet, row, column+1))
            skill.setEvaluatieScore(EvaluatieScore.fromScoreString(Integer.toString(getIntegerCellValue(sheet, row, column+1))));
        else
            skill.setEvaluatieScore(EvaluatieScore.GEEN_EVALUATIE);

        evaluatieSubcategorie.getEvaluatieSkillList().add(skill);
    }

    private boolean sheetHeeftSkill(Sheet sheet, int column, int row) {
        return hasStringCellValue(sheet, row, column);
    }

    private boolean sheetHeeftSubcategorie(Sheet sheet, int subcategorieIndex) {
        return hasStringCellValue(sheet, 0, subcategorieIndex*3);
    }

    private boolean sheetIsCategory(Sheet sheet) {
        return hasStringCellValue(sheet, 0, 0)
                && hasStringCellValue(sheet, 1, 0);
    }

    private boolean hasStringCellValue(Sheet sheet, int row, int cell) {
        return hasCellValue(sheet, row, cell)
                && sheet.getRow(row).getCell(cell).getCellType() == XSSFCell.CELL_TYPE_STRING
                && !sheet.getRow(row).getCell(cell).getStringCellValue().isEmpty();
    }

    private boolean hasNumericCellValue(Sheet sheet, int row, int cell) {
        return hasCellValue(sheet, row, cell)
                && sheet.getRow(row).getCell(cell).getCellType() == XSSFCell.CELL_TYPE_NUMERIC;
    }

    private boolean hasCellValue(Sheet sheet, int row, int cell) {
        return sheet.getRow(row) != null && sheet.getRow(row).getCell(cell) != null;
    }

    private String getStringCellValue(Sheet sheet, int row, int cell) {
        return sheet.getRow(row).getCell(cell).getStringCellValue();
    }

    private double getNumericCellValue(Sheet sheet, int row, int cell) {
        return sheet.getRow(row).getCell(cell).getNumericCellValue();
    }

    private int getIntegerCellValue(Sheet sheet, int row, int cell) {
        return new Double(sheet.getRow(row).getCell(cell).getNumericCellValue()).intValue();
    }

    private Workbook getWorkbookFromMultipartFile(MultipartFile file) {
        Workbook workbook;
        try {
            workbook = new XSSFWorkbook(file.getInputStream());
        } catch (IOException e) {
            throw new DocumentProcessorException("Exception while reading document", e);
        }
        return workbook;
    }

    @Transactional
    public void bewaarEvaluatieDocument(EvaluatieDocument evaluatieDocument) {
        evaluatieDocumentRepository.save(evaluatieDocument);
    }
}
