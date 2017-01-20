package be.kapture.entities;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.awt.Color;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import be.kapture.enums.Gender;

public class ClothingItemTest {
	
	private ClothingItem item, otherItem;
	
	
	@Before
	public void before() {
		item = new ClothingItem(115, Color.BLUE);
		otherItem = new ClothingItem(115, Color.BLUE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createClothingItemWithNegativeSize() {
		item = new ClothingItem(-7, Color.BLUE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createClothingItemWithSizeZero() {
		item = new ClothingItem(0, Color.BLUE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createClothingItemWithColorNull() {
		item = new ClothingItem(115, null);
	}
	
	@Test
	public void ClothingItemEqualsOtherClothingItem() {
		assertEquals(item, otherItem);
		
		otherItem.setSize(120);
		assertNotEquals(item, otherItem);
		item.setSize(120);
		assertEquals(item, otherItem);
		
		otherItem.setColor(Color.RED);
		assertNotEquals(item, otherItem);
		item.setColor(Color.RED);
		assertEquals(item, otherItem);
	}
}