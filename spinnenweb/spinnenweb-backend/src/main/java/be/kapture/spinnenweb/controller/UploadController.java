package be.kapture.spinnenweb.controller;

import be.kapture.spinnenweb.dto.EvaluatieDocumentDTO;
import be.kapture.spinnenweb.dto.PersoonDTO;
import be.kapture.spinnenweb.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public String uploadPage() {
        return "upload";
    }

    @PostMapping
    public String uploadDocument(@RequestParam("file") MultipartFile file,
                                 @RequestParam("naam") String naam,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {

        EvaluatieDocumentDTO evaluatieDocumentDTO = documentService.processDocument(file);
        PersoonDTO persoon = new PersoonDTO();
        persoon.setNaam(naam);

        evaluatieDocumentDTO.setPersoon(persoon);

        //model.addAttribute("result", GeneralResult.errorResult("Er heeft zich een fout voorgedaan"));
        model.addAttribute("document", evaluatieDocumentDTO);

        return "upload-edit";
    }
}
