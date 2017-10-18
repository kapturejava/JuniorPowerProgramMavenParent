package be.kapture.controller;

import be.kapture.entity.Thema;
import be.kapture.repository.ThemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by peeters.t on 17/10/2017.
 */


@RestController
public class ThemaController {

    private final ThemaRepository themaRepository;

    @Autowired
    public ThemaController(ThemaRepository themaRepository) {
        this.themaRepository = themaRepository;
    }

    @RequestMapping("/themaOut/{themaId}")
    public String themaOutput(@PathVariable(value = "themaId") Integer themaId){
        if(themaId == null) return "No id parameter";
        Thema thema = themaRepository.findOne(themaId);
        if(thema == null) return "No thema found for id "+themaId;
        return thema.getName();
    }

}
