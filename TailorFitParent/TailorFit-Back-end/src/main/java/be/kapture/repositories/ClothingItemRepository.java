package be.kapture.repositories;

import be.kapture.entities.ClothingItem;;

public class ClothingItemRepository extends AbstractRepository<ClothingItem>{
	
	public ClothingItemRepository(Class<ClothingItem> typeClass) {
		super(typeClass);
	}

//	@Override
//	public void create(ClothingItem t) {
//		// TODO Auto-generated method stub
//		super.create(t);
//	}
//	
//	@Override
//	public ClothingItem read(int id) {
//		// TODO Auto-generated method stub
//		return super.read(id);
//	}
//	
//	@Override
//	public void update(ClothingItem t) {
//		// TODO Auto-generated method stub
//		super.update(t);
//	}
//	
//	@Override
//	public void delete(ClothingItem t) {
//		// TODO Auto-generated method stub
//		super.delete(t);
//	}
	
}
