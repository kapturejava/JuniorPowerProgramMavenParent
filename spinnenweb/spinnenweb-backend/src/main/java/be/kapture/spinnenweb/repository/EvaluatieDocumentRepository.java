package be.kapture.spinnenweb.repository;

import be.kapture.spinnenweb.model.EvaluatieDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvaluatieDocumentRepository extends JpaRepository<EvaluatieDocument, Long> {

    Optional<EvaluatieDocument> findFirstByPersoonIdOrderByIdDesc(Long persoonId);
}
