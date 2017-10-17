package be.kapture.spinnenweb.service;

import be.kapture.spinnenweb.dto.*;
import be.kapture.spinnenweb.model.*;
import be.kapture.spinnenweb.repository.CategorieEvaluatieRepository;
import be.kapture.spinnenweb.repository.EvaluatieDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategorieEvaluatieService {
    @Autowired
    private CategorieService categorieService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private CategorieEvaluatieRepository categorieEvaluatieRepository;
    @Autowired
    private EvaluatieDocumentRepository evaluatieDocumentRepository;

    public CategorieEvaluatie mapFromEvaluatieCategorieDTO(EvaluatieCategorieDTO ec) {
        Categorie categorie = categorieService.mapFromCategorieDTO(ec);

        CategorieEvaluatie categorieEvaluatie = CategorieEvaluatie.CategorieEvaluatieBuilder()
                .withCategorie(categorie)
                .withSubcategorieEvaluaties(ec.getEvaluatieSubcategorieList().stream()
                        .map(se -> mapFromSubcategorieEvaluatieDTO(categorie, se)).collect(Collectors.toList()))
                .build();

//        categorieEvaluatieRepository.save(categorieEvaluatie);

        return categorieEvaluatie;
    }

    private SubcategorieEvaluatie mapFromSubcategorieEvaluatieDTO(Categorie categorie, EvaluatieSubcategorieDTO ec) {
        Subcategorie subcategorie = categorieService.mapFromSubcategorieDTO(categorie, ec);

        return SubcategorieEvaluatie.SubcategorieEvaluatieBuilder()
                .withSubcategorie(subcategorie)
                .withEvaluatieScore(ec.getEvaluatieScore())
                .withSkillEvaluaties(ec.getEvaluatieSkillList().stream().map(se -> mapFromSkillEvaluatiesDTO(subcategorie, se)).collect(Collectors.toList()))
                .build();
    }

    private SkillEvaluatie mapFromSkillEvaluatiesDTO(Subcategorie subcategorie, EvaluatieSkillDTO se) {
        return SkillEvaluatie.SkillEvaluatieBuilder()
                .withSkill(skillService.mapFromSkillDTO(subcategorie, se))
                .withEvaluatieScore(se.getEvaluatieScore())
                .build();
    }

    public List<WebDataDTO> getPersoonWebData(Long persoonId) {
        Optional<EvaluatieDocument> evaluatieDocument = evaluatieDocumentRepository.findFirstByPersoonIdOrderByIdDesc(persoonId);

        List<WebDataDTO> webDataDTOList = new ArrayList<>();

        evaluatieDocument.ifPresent(ed -> ed.getCategorieEvaluaties().forEach(ce -> webDataDTOList.add(mapToWebDataDTO(ce))));

        return webDataDTOList;
    }

    private WebDataDTO mapToWebDataDTO(CategorieEvaluatie ce) {
        WebDataDTO dto = new WebDataDTO();
        List<WebDataPointsDTO> webDataPointsDTOList = new ArrayList<>();
        List<String> labelList = new ArrayList<>();

        dto.setCategorie(ce.getCategorie().getNaam());

        WebDataPointsDTO webDataPointsDTO = new WebDataPointsDTO();
        List<Integer> points = new ArrayList<>();

        ce.getSubcategorieEvaluaties().forEach(sce -> {
            labelList.add(sce.getSubcategorie().getNaam());

            if (sce.getEvaluatieScore().isEvaluated()) {
                points.add(sce.getEvaluatieScore().toIntegerValue());
            }
            else {
                points.add(calculateAverageForSkills(sce.getSkillEvaluaties()));
            }
        });

        dto.setLabels(labelList);
        webDataPointsDTO.setDataPoints(points);
        webDataPointsDTO.setLabel("");
        webDataPointsDTOList.add(webDataPointsDTO);
        dto.setDataPoints(webDataPointsDTOList);
        return dto;
    }

    private Integer calculateAverageForSkills(List<SkillEvaluatie> skillEvaluaties) {
        Double avg = skillEvaluaties.stream().mapToInt(evaluation -> evaluation.getEvaluatieScore().toIntegerValue()).average().orElse(0);
        return avg.intValue();
    }


}
