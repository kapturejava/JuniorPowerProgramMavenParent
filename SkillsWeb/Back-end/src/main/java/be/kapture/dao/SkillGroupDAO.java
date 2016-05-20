package be.kapture.dao;

import be.kapture.entities.SkillGroup;

public class SkillGroupDAO extends AbstractDAO<SkillGroup> {

	protected SkillGroupDAO(Class<SkillGroup> typeParameterClass) {
		super(typeParameterClass);
	}

	public SkillGroupDAO() {
		this(SkillGroup.class);
	}

}
