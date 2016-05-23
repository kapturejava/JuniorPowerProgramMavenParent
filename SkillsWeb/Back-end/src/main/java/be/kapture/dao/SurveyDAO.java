package be.kapture.dao;

import java.util.List;

import be.kapture.entities.Survey;

public class SurveyDAO extends AbstractDAO<Survey> {

	protected SurveyDAO(Class<Survey> typeParameterClass) {
		super(typeParameterClass);
	}

	public SurveyDAO() {
		this(Survey.class);
	}

	@SuppressWarnings("unchecked")
	public List<Survey> findAll() {
		return (List<Survey>) getCurrentSession().createQuery("select s from Survey s").list();
	}

}
