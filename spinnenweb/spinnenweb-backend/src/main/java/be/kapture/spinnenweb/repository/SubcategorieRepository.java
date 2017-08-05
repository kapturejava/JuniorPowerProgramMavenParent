package be.kapture.spinnenweb.repository;

import be.kapture.spinnenweb.model.Subcategorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubcategorieRepository extends JpaRepository<Subcategorie, Long> {

    Optional<Subcategorie> findByNaam(String naam);
}
