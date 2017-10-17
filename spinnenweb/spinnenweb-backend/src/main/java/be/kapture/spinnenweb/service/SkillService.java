package be.kapture.spinnenweb.service;

import be.kapture.spinnenweb.dto.EvaluatieSkillDTO;
import be.kapture.spinnenweb.dto.PersoonDTO;
import be.kapture.spinnenweb.model.Persoon;
import be.kapture.spinnenweb.model.Skill;
import be.kapture.spinnenweb.model.Subcategorie;
import be.kapture.spinnenweb.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public Skill mapFromSkillDTO(Subcategorie subcategorie, EvaluatieSkillDTO skillDTO) {
        if (subcategorie.isPersisted()) {
            Optional<Skill> dbSkill = skillRepository.findBySubcategorieAndNaam(subcategorie, skillDTO.getNaam());

            if (dbSkill.isPresent()) {
                return dbSkill.get();
            }

        }

        Skill skill = Skill.SkillBuilder()
                .withNaam(skillDTO.getNaam())
                .withSubcategorie(subcategorie)
                .build();

        skillRepository.save(skill);

        return skill;
    }

    public void mapFromEvaluatieSkillDTOToSubcategorie(Subcategorie subcategorie, List<EvaluatieSkillDTO> evaluatieSkillList) {
        evaluatieSkillList.forEach(skillDTO -> mapFromSkillDTO(subcategorie, skillDTO));
    }
}
