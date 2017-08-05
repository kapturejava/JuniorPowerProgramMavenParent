package be.kapture.spinnenweb.repository;

import be.kapture.spinnenweb.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    Optional<Categorie> findByNaam(String naam);
}
