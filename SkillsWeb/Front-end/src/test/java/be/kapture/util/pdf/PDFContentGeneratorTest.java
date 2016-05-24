package be.kapture.util.pdf;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

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

public class PDFContentGeneratorTest {

	private Person person1 = new Person();
	private Person person2 = new Person();
	private Survey survey = new Survey();
	private SurveyDetail surveyDetail = new SurveyDetail();
	private Skill skill = new Skill();
	private SkillNature skillNature = new SkillNature();
	private SkillGroup skillGroup = new SkillGroup();

	private PDFContentGenerator pdfContentGenerator = new PDFContentGenerator();

	@Before
	public void before() {
		pdfContentGenerator.personDAO = mock(PersonDAO.class);
		pdfContentGenerator.skillDAO = mock(SkillDAO.class);
		pdfContentGenerator.skillNatureDAO = mock(SkillNatureDAO.class);
		pdfContentGenerator.skillGroupDAO = mock(SkillGroupDAO.class);
		pdfContentGenerator.surveyDAO = mock(SurveyDAO.class);
		pdfContentGenerator.surveyDetailDAO = mock(SurveyDetailDAO.class);
		createInstances();
		createPersonMock();
		createSkillMock();
		createSkillNatureMock();
		createSkillGroupMock();
		createSurveyMock();
		createSurveyDetailMock();
	}

	private void createInstances() {
		person1.setId(1);
		person1.setFirstName("firstname1");
		person1.setLastName("lastname1");
		person2.setId(2);
		person2.setFirstName("firstname2");
		person2.setLastName("lastname2");
		survey.setId(1);
		survey.setDate(Date.valueOf(LocalDate.now()));
		survey.setPerson(person1);
		skillNature.setId(1);
		skillNature.setName("skillnature");
		skillGroup.setId(1);
		skillGroup.setName("skillGroup");
		skillGroup.setSkillNature(skillNature);
		skill.setId(1);
		skill.setName("skill1");
		skill.setWeight(5);
		skill.setSkillGroup(skillGroup);
		surveyDetail.setId(1);
		surveyDetail.setScore(10);
		surveyDetail.setSkill(skill);
		surveyDetail.setSurvey(survey);
	}

	private void createSurveyDetailMock() {
		when(pdfContentGenerator.surveyDetailDAO.findAll()).thenReturn(asList(surveyDetail));
	}

	private void createSurveyMock() {

		when(pdfContentGenerator.surveyDAO.findAll()).thenReturn(asList(survey));
	}

	private void createPersonMock() {
		when(pdfContentGenerator.personDAO.findAll()).thenReturn(asList(person1, person2));
	}

	private void createSkillMock() {
		when(pdfContentGenerator.skillDAO.findAll()).thenReturn(asList(skill));

	}

	private void createSkillNatureMock() {
		when(pdfContentGenerator.skillNatureDAO.findAll()).thenReturn(asList(skillNature));
	}

	private void createSkillGroupMock() {
		when(pdfContentGenerator.skillGroupDAO.findAll()).thenReturn(asList(skillGroup));

	}

	@Test
	public void createContent() {
		LocalDateTime now = LocalDateTime.now();
		String filename = "ENTITIES " + now.getDayOfMonth() + "-" + now.getMonth().getValue() + "-" + now.getYear()
				+ " " + now.getHour() + "u" + now.getMinute() + "min" + now.getSecond() + "sec";
		pdfContentGenerator.generate(filename);
		assertTrue(new File(filename + ".pdf").exists());
	}

}
