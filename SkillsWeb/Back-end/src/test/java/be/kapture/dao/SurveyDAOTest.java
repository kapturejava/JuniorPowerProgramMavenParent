package be.kapture.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Before;

public class SurveyDAOTest extends AbstractDAOTest {

	private SurveyDAO surveyDAO = new SurveyDAO();

	@Before
	public void before() {
		buildAllFields();
	}

	@Override
	public void update() {
		surveyDAO.create(survey);
		int id = survey.getId();
		survey.setDate(Date.valueOf(LocalDate.of(1999, 9, 9)));
		surveyDAO.update(survey);
		assertSame(survey, surveyDAO.read(id));
	}

	@Override
	public void delete() {
		surveyDAO.create(survey);
		int id = survey.getId();
		surveyDAO.delete(survey);
		assertNull(surveyDAO.read(id));
	}

	@Override
	public void create_And_Read() {
		surveyDAO.create(survey);
		int id = survey.getId();
		assertSame(survey, surveyDAO.read(id));
	}

	@Override
	public void read_With_Negative_Id_Returns_Null() {
		assertNull(surveyDAO.read(-1));
	}

}
