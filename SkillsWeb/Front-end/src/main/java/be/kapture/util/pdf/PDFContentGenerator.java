package be.kapture.util.pdf;

import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
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

public class PDFContentGenerator extends PDFGenerator{

	@Override
	protected void createContent(Document document) throws DocumentException {
		createPersontable(document);
		createSkillNatureTable(document);
		createSKillGroupTable(document);
		createSkillTable(document);
		createSurveyTable(document);
		createSurveyDetailTable(document);
	}

	private void createPersontable(Document document) throws DocumentException {
		PdfPTable table= new PdfPTable(3);
		table.addCell("ID");
		table.addCell("First Name");
		table.addCell("Last Name");
		table.setHeaderRows(1);
		List<Person> personList = new PersonDAO().findAll();
		for(Person p : personList){
			table.addCell(""+p.getId());
			table.addCell(p.getFirstName());
			table.addCell(p.getLastName());
		}
		document.add(table);
	}
	private void createSkillNatureTable(Document document) throws DocumentException {
		PdfPTable table= new PdfPTable(2);
		table.addCell("ID");
		table.addCell("Name");
		table.setHeaderRows(1);
		List<SkillNature> skillNatureList = new SkillNatureDAO().findAll();
		for (SkillNature skillNature : skillNatureList) {
			table.addCell(""+skillNature.getId());
			table.addCell(skillNature.getName());
		}
		document.add(table);
	}
	
	private void createSKillGroupTable(Document document) throws DocumentException {
		PdfPTable table= new PdfPTable(3);
		table.addCell("ID");
		table.addCell("Name");
		table.addCell("SkillNature_ID");
		table.setHeaderRows(1);
		List<SkillGroup> skillGroupList = new SkillGroupDAO().findAll();
		for(SkillGroup s : skillGroupList){
			table.addCell(""+s.getId());
			table.addCell(s.getName());
			table.addCell(""+s.getSkillNature().getId());
		}
		document.add(table);
	}

	private void createSkillTable(Document document) throws DocumentException {
		PdfPTable table= new PdfPTable(4);
		table.addCell("ID");
		table.addCell("Name");
		table.addCell("Weight");
		table.addCell("SkillGroup_ID");
		table.setHeaderRows(1);
		List<Skill> skillList = new SkillDAO().findAll();
		for(Skill s : skillList){
			table.addCell(""+s.getId());
			table.addCell(s.getName());
			table.addCell(""+s.getWeight());
			table.addCell(""+s.getSkillGroup().getId());
		}
		document.add(table);		
	}

	private void createSurveyTable(Document document) throws DocumentException {
		PdfPTable table= new PdfPTable(3);
		table.addCell("ID");
		table.addCell("Date");
		table.addCell("Person_ID");
		table.setHeaderRows(1);
		List<Survey> surveyList = new SurveyDAO().findAll();
		for(Survey s : surveyList){
			table.addCell(""+s.getId());
			table.addCell(""+s.getDate());
			table.addCell(""+s.getPerson().getId());
		}
		document.add(table);	
	}

	private void createSurveyDetailTable(Document document) throws DocumentException {
		PdfPTable table= new PdfPTable(4);
		table.addCell("ID");
		table.addCell("Score");
		table.addCell("Survey_ID");
		table.addCell("Skill_ID");
		table.setHeaderRows(1);
		List<SurveyDetail> surveyDetailList = new SurveyDetailDAO().findAll();
		for(SurveyDetail s : surveyDetailList){
			table.addCell(""+s.getId());
			table.addCell(""+s.getScore());
			table.addCell(""+s.getSurvey().getId());
			table.addCell(""+s.getSkill().getId());
		}
		document.add(table);
	}

}
