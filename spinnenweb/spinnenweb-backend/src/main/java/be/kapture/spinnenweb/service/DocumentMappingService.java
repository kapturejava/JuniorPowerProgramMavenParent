package be.kapture.spinnenweb.service;

import be.kapture.spinnenweb.dto.*;
import be.kapture.spinnenweb.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DocumentMappingService {

    @Autowired
    private PersoonService persoonService;

    @Autowired
    private CategorieEvaluatieService categorieEvaluatieService;

    public EvaluatieDocument mapFromDTO(EvaluatieDocumentDTO evaluatieDocumentDTO) {
        return EvaluatieDocument.EvaluatieDocumentBuilder()
                .withPersoon(persoonService.mapFromPersoonDTO(evaluatieDocumentDTO.getPersoon()))
                .withEvaluatieDoel(evaluatieDocumentDTO.getEvaluatieDoel())
                .withCategorieEvaluaties(evaluatieDocumentDTO.getEvaluatieCategorieList().stream()
                        .map(ec -> categorieEvaluatieService.mapFromEvaluatieCategorieDTO(ec)).collect(Collectors.toList()))
                .build();
    }

}
