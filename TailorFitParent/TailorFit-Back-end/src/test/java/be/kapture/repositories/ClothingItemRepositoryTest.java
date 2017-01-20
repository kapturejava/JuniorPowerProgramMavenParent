package be.kapture.repositories;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import be.kapture.entities.ClothingItem;

public class ClothingItemRepositoryTest extends AbstractRepositoryTest{

	private ClothingItemRepository clothingItemRepository = new ClothingItemRepository(ClothingItem.class);
	private int id;
	private ClothingItem clothingItem;

	@Before
	public void before() {
		clothingItem = new ClothingItem(125, Color.BLUE.toString());
		clothingItemRepository.create(clothingItem);
		id = clothingItem.getId();
	}

	@Test
	public void read_With_Negative_Id_Returns_Null() {
		assertNull(clothingItemRepository.read(-1));
	}

	@Test
	public void create() {
		clothingItemRepository.create(clothingItem);
		id = clothingItem.getId();
		assertSame(clothingItem, clothingItemRepository.read(id));
	}
	
	@Test
	public void read() {
		assertSame(clothingItem, clothingItemRepository.read(id));
	}

	@Test
	public void update() {
		clothingItem.setColor(Color.RED.toString());
		clothingItemRepository.update(clothingItem);
		assertSame(clothingItem, clothingItemRepository.read(id));
	}

	@Test
	public void delete() {
		clothingItemRepository.delete(clothingItem);
		assertNull(clothingItemRepository.read(id));
	}

}
