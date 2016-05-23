package be.kapture.dao;

import java.util.List;

import be.kapture.entities.Skill;

public class SkillDAO extends AbstractDAO<Skill> {

	protected SkillDAO(Class<Skill> typeParameterClass) {
		super(typeParameterClass);
	}

	public SkillDAO() {
		this(Skill.class);
	}

	@SuppressWarnings("unchecked")
	public List<Skill> findAll() {
		return (List<Skill>) getCurrentSession().createQuery("select s from Skill s").list();
	}

}
