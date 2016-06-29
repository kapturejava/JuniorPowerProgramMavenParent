package be.kapture.dao;

import java.util.Collection;
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

	public List<Survey> findByPersonId(int id) {
		return (List<Survey>) getCurrentSession().createQuery("select s from Survey s where s.person.id = s.id");
	}
}
