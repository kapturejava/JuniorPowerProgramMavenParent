package be.kapture.dao;

import be.kapture.entities.SkillNature;

public class SkillNatureDAO extends AbstractDAO<SkillNature> {

	protected SkillNatureDAO(Class<SkillNature> typeParameterClass) {
		super(typeParameterClass);
	}

	public SkillNatureDAO() {
		this(SkillNature.class);
	}

}
