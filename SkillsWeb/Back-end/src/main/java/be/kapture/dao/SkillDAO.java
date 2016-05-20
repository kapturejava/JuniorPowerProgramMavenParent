package be.kapture.dao;

import be.kapture.entities.Skill;

public class SkillDAO extends AbstractDAO<Skill> {

	protected SkillDAO(Class<Skill> typeParameterClass) {
		super(typeParameterClass);
	}

	public SkillDAO() {
		this(Skill.class);
	}

}
