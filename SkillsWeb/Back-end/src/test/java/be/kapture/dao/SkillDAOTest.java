package be.kapture.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;

public class SkillDAOTest extends AbstractDAOTest{
	
	private SkillDAO skillDAO = new SkillDAO();
	
	@Before
	public void before(){
		buildAllFields();
	}

	@Override
	public void update() {
		skillDAO.create(skill);
		int id = skill.getId();
		skill.setName("updatename");
		skill.setWeight(3);
		skillDAO.update(skill);
		assertSame(skill, skillDAO.read(id));
	}

	@Override
	public void delete() {
		skillDAO.create(skill);
		int id = skill.getId();
		skillDAO.delete(skill);
		assertNull(skillDAO.read(id));
	}

	@Override
	public void create_And_Read() {
		skillDAO.create(skill);
		int id = skill.getId();
		assertSame(skill, skillDAO.read(id));
	}

	@Override
	public void read_With_Negative_Id_Returns_Null() {
		assertNull(skillDAO.read(-1));		
	}
	
	
	

}
