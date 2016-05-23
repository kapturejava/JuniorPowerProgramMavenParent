package be.kapture.util.pdf;

import java.time.LocalDateTime;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;

import be.kapture.dao.PersonDAO;
import be.kapture.dao.SkillDAO;
import be.kapture.dao.SkillGroupDAO;
import be.kapture.dao.SkillNatureDAO;
import be.kapture.dao.SurveyDAO;
import be.kapture.dao.SurveyDetailDAO;
import be.kapture.entities.Person;
import be.kapture.entities.Skill;
import be.kapture.entities.SkillGroup;
import be.kapture.entities.SkillNature;
import be.kapture.entities.Survey;
import be.kapture.entities.SurveyDetail;

public class PDFContentGenerator extends PDFGenerator {

	PersonDAO personDAO = new PersonDAO();
	SurveyDetailDAO surveyDetailDAO = new SurveyDetailDAO();
	SkillNatureDAO skillNatureDAO = new SkillNatureDAO();
	SurveyDAO surveyDAO = new SurveyDAO();
	SkillGroupDAO skillGroupDAO = new SkillGroupDAO();
	SkillDAO skillDAO = new SkillDAO();

	@Override
	protected void createContent(Document document, String filename) throws DocumentException {
		document.add(new Phrase(filename, new Font(FontFamily.HELVETICA, 24, Font.BOLD)));
		createPersontable(document);
		createSkillNatureTable(document);
		createSKillGroupTable(document);
		createSkillTable(document);
		createSurveyTable(document);
		createSurveyDetailTable(document);
	}

	private void createPersontable(Document document) throws DocumentException {
		document.add(Chunk.NEWLINE);
		document.add(PDFUtils.getTitlePhrase("Person"));
		PdfPTable table = new PdfPTable(3);
		table.addCell(PDFUtils.getTitleCell("ID"));
		table.addCell(PDFUtils.getTitleCell("First Name"));
		table.addCell(PDFUtils.getTitleCell("Last Name"));
		table.setHeaderRows(1);
		List<Person> personList = personDAO.findAll();
		for (Person p : personList) {
			table.addCell(PDFUtils.getTableDetailCell("" + p.getId()));
			table.addCell(PDFUtils.getTableDetailCell(p.getFirstName()));
			table.addCell(PDFUtils.getTableDetailCell(p.getLastName()));
		}
		document.add(table);
	}

	private void createSkillNatureTable(Document document) throws DocumentException {
		document.add(Chunk.NEWLINE);
		document.add(PDFUtils.getTitlePhrase("SkillNature"));
		PdfPTable table = new PdfPTable(2);
		table.addCell(PDFUtils.getTitleCell("ID"));
		table.addCell(PDFUtils.getTitleCell("Name"));
		table.setHeaderRows(1);
		List<SkillNature> skillNatureList = skillNatureDAO.findAll();
		for (SkillNature skillNature : skillNatureList) {
			table.addCell(PDFUtils.getTableDetailCell("" + skillNature.getId()));
			table.addCell(PDFUtils.getTableDetailCell(skillNature.getName()));
		}
		document.add(table);
	}

	private void createSKillGroupTable(Document document) throws DocumentException {
		document.add(Chunk.NEWLINE);
		document.add(PDFUtils.getTitlePhrase("SkillGroup"));
		PdfPTable table = new PdfPTable(3);
		table.addCell(PDFUtils.getTitleCell("ID"));
		table.addCell(PDFUtils.getTitleCell("Name"));
		table.addCell(PDFUtils.getTitleCell("SkillNature_ID"));
		table.setHeaderRows(1);
		List<SkillGroup> skillGroupList = skillGroupDAO.findAll();
		for (SkillGroup s : skillGroupList) {
			table.addCell(PDFUtils.getTableDetailCell("" + s.getId()));
			table.addCell(PDFUtils.getTableDetailCell(s.getName()));
			table.addCell(PDFUtils.getTableDetailCell("" + s.getSkillNature().getId()));
		}
		document.add(table);
	}

	private void createSkillTable(Document document) throws DocumentException {
		document.add(Chunk.NEWLINE);
		document.add(PDFUtils.getTitlePhrase("Skill"));
		PdfPTable table = new PdfPTable(4);
		table.addCell(PDFUtils.getTitleCell("ID"));
		table.addCell(PDFUtils.getTitleCell("Name"));
		table.addCell(PDFUtils.getTitleCell("Weight"));
		table.addCell(PDFUtils.getTitleCell("SkillGroup_ID"));
		table.setHeaderRows(1);
		List<Skill> skillList = skillDAO.findAll();
		for (Skill s : skillList) {
			table.addCell(PDFUtils.getTableDetailCell("" + s.getId()));
			table.addCell(PDFUtils.getTableDetailCell(s.getName()));
			table.addCell(PDFUtils.getTableDetailCell("" + s.getWeight()));
			table.addCell(PDFUtils.getTableDetailCell("" + s.getSkillGroup().getId()));
		}
		document.add(table);
	}

	private void createSurveyTable(Document document) throws DocumentException {
		document.add(Chunk.NEWLINE);
		document.add(PDFUtils.getTitlePhrase("Survey"));
		PdfPTable table = new PdfPTable(3);
		table.addCell(PDFUtils.getTitleCell("ID"));
		table.addCell(PDFUtils.getTitleCell("Date"));
		table.addCell(PDFUtils.getTitleCell("Person_ID"));
		table.setHeaderRows(1);
		List<Survey> surveyList = surveyDAO.findAll();
		for (Survey s : surveyList) {
			table.addCell(PDFUtils.getTableDetailCell("" + s.getId()));
			table.addCell(PDFUtils.getTableDetailCell("" + s.getDate()));
			table.addCell(PDFUtils.getTableDetailCell("" + s.getPerson().getId()));
		}
		document.add(table);
	}

	private void createSurveyDetailTable(Document document) throws DocumentException {
		document.add(Chunk.NEWLINE);
		document.add(PDFUtils.getTitlePhrase("SurveyDetail"));
		PdfPTable table = new PdfPTable(4);
		table.addCell(PDFUtils.getTitleCell("ID"));
		table.addCell(PDFUtils.getTitleCell("Score"));
		table.addCell(PDFUtils.getTitleCell("Survey_ID"));
		table.addCell(PDFUtils.getTitleCell("Skill_ID"));
		table.setHeaderRows(1);
		List<SurveyDetail> surveyDetailList = surveyDetailDAO.findAll();
		for (SurveyDetail s : surveyDetailList) {
			table.addCell(PDFUtils.getTableDetailCell("" + s.getId()));
			table.addCell(PDFUtils.getTableDetailCell("" + s.getScore()));
			table.addCell(PDFUtils.getTableDetailCell("" + s.getSurvey().getId()));
			table.addCell(PDFUtils.getTableDetailCell("" + s.getSkill().getId()));
		}
		document.add(table);
	}

}
