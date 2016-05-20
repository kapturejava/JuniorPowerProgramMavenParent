package be.kapture.dao;

import be.kapture.entities.Survey;

public class SurveyDAO extends AbstractDAO<Survey> {

	protected SurveyDAO(Class<Survey> typeParameterClass) {
		super(typeParameterClass);
	}

	public SurveyDAO() {
		this(Survey.class);
	}

}
