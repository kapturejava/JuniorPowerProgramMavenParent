package be.kapture.dao;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import be.kapture.entities.Person;
import be.kapture.entities.Skill;
import be.kapture.entities.SkillGroup;
import be.kapture.entities.SkillNature;
import be.kapture.entities.Survey;
import be.kapture.entities.SurveyDetail;
import be.kapture.util.HibernateUtil;

public abstract class AbstractDAOTest {
	
	protected static Session session = HibernateUtil.getSession();
	protected Person person = new Person();
	protected Skill skill = new Skill();
	protected SkillGroup skillGroup = new SkillGroup();
	protected SkillNature skillNature = new SkillNature();
	protected Survey survey = new Survey();
	protected SurveyDetail surveyDetail = new SurveyDetail();
	
	protected AbstractDAOTest(){
		person.setFirstName("firstname");
		person.setLastName("lastname");
		surveyDetail.setScore(5);
		skill.setName("skillname");
		skill.setWeight(20);
		skillGroup.setName("skillgroupname");
		skillNature.setName("skillnaturename");
		survey.setDate(Date.valueOf(LocalDate.now()));

	}
	
	protected void buildAllFields(){	
		new PersonDAO().create(person);
		survey.setPerson(person);
		new SurveyDAO().create(survey);
		new SkillNatureDAO().create(skillNature);
		skillGroup.setSkillNature(skillNature);
		new SkillGroupDAO().create(skillGroup);
		skill.setSkillGroup(skillGroup);
		new SkillDAO().create(skill);
		surveyDetail.setSkill(skill);
		surveyDetail.setSurvey(survey);
		new SurveyDetailDAO().create(surveyDetail);
	}	
	
	@BeforeClass
	public static void beforeClass(){		
		session.beginTransaction();
	}
	
	@AfterClass
	public static void afterClass(){
		session.getTransaction().rollback();
	}
	
	@Test
	public abstract void update();
	
	@Test
	public abstract void delete();
	
	@Test
	public abstract void create();
	
	@Test
	public abstract void read_With_Negative_Id_Returns_Null();
	
	
	

}
