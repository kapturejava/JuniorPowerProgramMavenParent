package be.kapture.spinnenweb.controller;

import be.kapture.spinnenweb.dto.PersoonDTO;
import be.kapture.spinnenweb.dto.WebDataDTO;
import be.kapture.spinnenweb.service.CategorieEvaluatieService;
import be.kapture.spinnenweb.service.PersoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersoonService persoonService;

    @Autowired
    private CategorieEvaluatieService categorieEvaluatieService;

    @GetMapping
    public List<PersoonDTO> getPersonen() {
        return persoonService.getActievePersonen();
    }

    @GetMapping(path = "{id}/webdata")
    public List<WebDataDTO> getPersoonWebData(@PathVariable("id") Long persoonId) {
        return categorieEvaluatieService.getPersoonWebData(persoonId);
    }
}
