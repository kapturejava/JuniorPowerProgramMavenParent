package be.kapture.spinnenweb.repository;

import be.kapture.spinnenweb.model.Persoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersoonRepository extends JpaRepository<Persoon, Long> {

    Optional<Persoon> findByNaam(String naam);
}
