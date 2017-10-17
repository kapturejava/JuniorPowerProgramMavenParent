package be.kapture.spinnenweb.service;

import be.kapture.spinnenweb.dto.EvaluatieCategorieDTO;
import be.kapture.spinnenweb.dto.EvaluatieSubcategorieDTO;
import be.kapture.spinnenweb.model.Categorie;
import be.kapture.spinnenweb.model.Persoon;
import be.kapture.spinnenweb.model.Subcategorie;
import be.kapture.spinnenweb.repository.CategorieRepository;
import be.kapture.spinnenweb.repository.SubcategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private SubcategorieRepository subcategorieRepository;

    @Autowired
    private SkillService skillService;

    public Categorie mapFromCategorieDTO(EvaluatieCategorieDTO ec) {
        Optional<Categorie> dbCategorie = categorieRepository.findByNaam(ec.getNaam());

        if (dbCategorie.isPresent()) {
            return dbCategorie.get();
        }
        else {
            Categorie nieuweCategorie = Categorie.CategorieBuilder().withNaam(ec.getNaam()).build();
            categorieRepository.save(nieuweCategorie);

            return nieuweCategorie;
        }
    }

    public Subcategorie mapFromSubcategorieDTO(Categorie categorie, EvaluatieSubcategorieDTO ec) {
        Optional<Subcategorie> dbSubcategorie = subcategorieRepository.findByNaam(ec.getNaam());

        if (dbSubcategorie.isPresent()) {
            Subcategorie subcategorie = dbSubcategorie.get();
            skillService.mapFromEvaluatieSkillDTOToSubcategorie(subcategorie, ec.getEvaluatieSkillList());
            return subcategorie;
        }
        else {
            Subcategorie nieuweSubcategorie = Subcategorie.SubcategorieBuilder()
                    .withCategorie(categorie)
                    .withNaam(ec.getNaam())
                    .build();
            skillService.mapFromEvaluatieSkillDTOToSubcategorie(nieuweSubcategorie, ec.getEvaluatieSkillList());

            subcategorieRepository.save(nieuweSubcategorie);

            return nieuweSubcategorie;
        }
    }
}
