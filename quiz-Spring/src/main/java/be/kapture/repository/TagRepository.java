package be.kapture.repository;

import be.kapture.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by peeters.t on 17/10/2017.
 */
public interface TagRepository extends JpaRepository<Tag,Integer> {
}
