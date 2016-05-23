package be.kapture.dao;

import java.util.List;

import be.kapture.entities.SkillGroup;

public class SkillGroupDAO extends AbstractDAO<SkillGroup> {

	protected SkillGroupDAO(Class<SkillGroup> typeParameterClass) {
		super(typeParameterClass);
	}

	public SkillGroupDAO() {
		this(SkillGroup.class);
	}

	@SuppressWarnings("unchecked")
	public List<SkillGroup> findAll() {
		return (List<SkillGroup>) getCurrentSession().createQuery("select s from SkillGroup s").list();
	}

}
