package be.kapture.dao;

import be.kapture.entities.SurveyDetail;

public class SurveyDetailDAO extends AbstractDAO<SurveyDetail> {

	protected SurveyDetailDAO(Class<SurveyDetail> typeParameterClass) {
		super(typeParameterClass);
	}

	public SurveyDetailDAO() {
		this(SurveyDetail.class);
	}

}
