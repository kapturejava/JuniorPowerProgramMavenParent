package be.kapture.dao;

import java.util.List;

import be.kapture.entities.SkillNature;

public class SkillNatureDAO extends AbstractDAO<SkillNature> {

	protected SkillNatureDAO(Class<SkillNature> typeParameterClass) {
		super(typeParameterClass);
	}

	public SkillNatureDAO() {
		this(SkillNature.class);
	}

	@SuppressWarnings("unchecked")
	public List<SkillNature> findAll() {
		return (List<SkillNature>) getCurrentSession().createQuery("select s from SkillNature s").list();
	}

}
