package be.kapture.repository;

import be.kapture.entity.Thema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by peeters.t on 17/10/2017.
 */
@RepositoryRestResource(collectionResourceRel = "thema", path = "thema")
public interface ThemaRepository extends JpaRepository<Thema,Integer> {
}
