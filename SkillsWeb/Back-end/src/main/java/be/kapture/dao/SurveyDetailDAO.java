package be.kapture.dao;

import java.util.List;

import be.kapture.entities.SurveyDetail;

public class SurveyDetailDAO extends AbstractDAO<SurveyDetail> {

	protected SurveyDetailDAO(Class<SurveyDetail> typeParameterClass) {
		super(typeParameterClass);
	}

	public SurveyDetailDAO() {
		this(SurveyDetail.class);
	}

	@SuppressWarnings("unchecked")
	public List<SurveyDetail> findAll() {
		return (List<SurveyDetail>) getCurrentSession().createQuery("select s from SurveyDetail s").list();
	}

}
