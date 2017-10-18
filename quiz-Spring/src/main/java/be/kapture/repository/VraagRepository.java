package be.kapture.repository;

import be.kapture.entity.Vraag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by peeters.t on 17/10/2017.
 */
@RepositoryRestResource(collectionResourceRel = "vraag", path = "vraag")
public interface VraagRepository extends JpaRepository<Vraag,Integer> {
}
