package be.kapture.repositories;

import be.kapture.entities.ClothingItem;;

public class ClothingItemRepository extends AbstractRepository<ClothingItem>{
	
	public ClothingItemRepository(Class<ClothingItem> typeClass) {
		super(typeClass);
	}
}
