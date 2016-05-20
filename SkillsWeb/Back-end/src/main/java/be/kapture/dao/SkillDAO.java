package be.kapture.dao;

import be.kapture.entities.Skill;

public class SkillDAO extends AbstractDAO {

	@Override
	public Skill read(int id) {
		return getCurrentSession().get(Skill.class, id);
	}

}
