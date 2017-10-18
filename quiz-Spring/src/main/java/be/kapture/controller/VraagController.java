package be.kapture.controller;

import be.kapture.entity.Thema;
import be.kapture.entity.Vraag;
import be.kapture.repository.ThemaRepository;
import be.kapture.repository.VraagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by peeters.t on 17/10/2017.
 */


@RestController
public class VraagController {

    private final VraagRepository vraagRepository;

    @Autowired
    public VraagController(VraagRepository vraagRepository) {
        this.vraagRepository = vraagRepository;
    }

    @RequestMapping("/vraagInfo/{vraagId}")
    public Vraag themaOutput(@PathVariable(value = "vraagId") Integer vraagId){
        if(vraagId == null) return null;
        Vraag vraag = vraagRepository.findOne(vraagId);
        if(vraag == null) return null;
        return vraag;
    }

    @RequestMapping("/vraagInsert")
    public void insertVraag(@RequestParam("data") Vraag vraag){
        vraagRepository.save(vraag);
    }

}
