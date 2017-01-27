package be.kapture.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    	CriteriaBuilder builder = HibernateUtil.getSession().getCriteriaBuilder();
    	CriteriaQuery<ClothingItem> criteria = builder.createQuery(ClothingItem.class);
    	Root<ClothingItem> clothingItemRoot = criteria.from(ClothingItem.class);
    	criteria.select(clothingItemRoot);
    	criteria.where(builder.greaterThanOrEqualTo(clothingItemRoot.get("size"), s));
    	List<ClothingItem> results = HibernateUtil.getSession().getEntityManagerFactory().createEntityManager().createQuery(criteria).getResultList();
    	
    	return results;
    }
}
