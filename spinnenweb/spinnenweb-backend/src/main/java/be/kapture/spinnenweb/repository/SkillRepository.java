package be.kapture.spinnenweb.repository;

import be.kapture.spinnenweb.model.Skill;
import be.kapture.spinnenweb.model.Subcategorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Optional<Skill> findByNaam(String naam);

    Optional<Skill> findBySubcategorieAndNaam(Subcategorie subcategorie, String naam);
}
