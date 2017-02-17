package be.kapture.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import be.kapture.entities.ClothingItem;
import be.kapture.util.HibernateUtil;

public class ClothingItemRepository extends AbstractRepository<ClothingItem>{
	
    public ClothingItemRepository() {
        this(ClothingItem.class);
    }

    public ClothingItemRepository(Class<ClothingItem> typeParameterClass) {
        super(typeParameterClass);
    }
    
    public List<ClothingItem> findClothingItemsBySize(int s){
    	Session session = HibernateUtil.getSession();
    	CriteriaBuilder builder = session.getCriteriaBuilder();
    	CriteriaQuery<ClothingItem> criteria = builder.createQuery(ClothingItem.class);
    	
    	Root<ClothingItem> clothingItemRoot = criteria.from(ClothingItem.class);
    	criteria.select(clothingItemRoot);
    	criteria.where(builder.greaterThanOrEqualTo(clothingItemRoot.get("size"), s));
    	
    	return session.createQuery(criteria).getResultList();
    }
}
