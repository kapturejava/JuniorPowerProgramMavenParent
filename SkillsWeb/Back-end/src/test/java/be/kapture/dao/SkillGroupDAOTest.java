package be.kapture.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;



public class SkillGroupDAOTest extends AbstractDAOTest{
	
	private SkillGroupDAO skillGroupDAO = new SkillGroupDAO();

	@Before
	public void before(){
		buildAllFields();
	}
	
	@Override
	public void update() {
		skillGroupDAO.create(skillGroup);
		int id = skillGroup.getId();
		skillGroup.setName("updatename");
		skillGroupDAO.update(skillGroup);
		assertSame(skillGroup, skillGroupDAO.read(id));
		
	}

	@Override
	public void delete() {		
		skillGroupDAO.create(skillGroup);
		int id = skillGroup.getId();
		skillGroupDAO.delete(skillGroup);
		assertNull(skillGroupDAO.read(id));
	}

	@Override
	public void create_And_Read() {
		skillGroupDAO.create(skillGroup);
		int id = skillGroup.getId();
		assertSame(skillGroup, skillGroupDAO.read(id));
	}

	@Override
	public void read_With_Negative_Id_Returns_Null() {
		assertNull(skillGroupDAO.read(-1));		
	}

	

}
