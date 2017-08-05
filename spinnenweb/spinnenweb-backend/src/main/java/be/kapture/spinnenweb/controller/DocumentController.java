package be.kapture.spinnenweb.controller;

import be.kapture.spinnenweb.dto.EvaluatieDocumentDTO;
import be.kapture.spinnenweb.dto.PersoonDTO;
import be.kapture.spinnenweb.model.EvaluatieDocument;
import be.kapture.spinnenweb.service.DocumentMappingService;
import be.kapture.spinnenweb.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;
    @Autowired
    private DocumentMappingService documentMappingService;

    @PostMapping
    public EvaluatieDocumentDTO uploadDocument(@RequestParam("file") MultipartFile file,
                                               @RequestParam("naam") String naam) {

        EvaluatieDocumentDTO evaluatieDocumentDTO = documentService.processDocument(file);
        PersoonDTO persoon = new PersoonDTO();
        persoon.setNaam(naam);

        evaluatieDocumentDTO.setPersoon(persoon);

        return evaluatieDocumentDTO;
    }

    @PutMapping
    public void bewaarEvaluatie(@RequestBody EvaluatieDocumentDTO evaluatieDocumentDTO) {
        EvaluatieDocument evaluatieDocument = documentMappingService.mapFromDTO(evaluatieDocumentDTO);

        documentService.bewaarEvaluatieDocument(evaluatieDocument);
    }
}
