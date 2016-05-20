package be.kapture.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;

public class SurveyDetailDAOTest extends AbstractDAOTest {

	private SurveyDetailDAO surveyDetailDAO = new SurveyDetailDAO();

	@Before
	public void before() {
		buildAllFields();
	}

	@Override
	public void update() {
		surveyDetailDAO.create(surveyDetail);
		int id = surveyDetail.getId();
		surveyDetail.setScore(8);
		surveyDetailDAO.update(surveyDetail);
		assertSame(surveyDetail, surveyDetailDAO.read(id));
	}

	@Override
	public void delete() {
		surveyDetailDAO.create(surveyDetail);
		int id = surveyDetail.getId();
		surveyDetailDAO.delete(surveyDetail);
		assertNull(surveyDetailDAO.read(id));
	}

	@Override
	public void create_And_Read() {
		surveyDetailDAO.create(surveyDetail);
		int id = surveyDetail.getId();
		assertSame(surveyDetail, surveyDetailDAO.read(id));
	}

	@Override
	public void read_With_Negative_Id_Returns_Null() {
		assertNull(surveyDetailDAO.read(-1));
	}

}
