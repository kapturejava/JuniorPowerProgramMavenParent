package be.kapture.spinnenweb.service;

import be.kapture.spinnenweb.dto.PersoonDTO;
import be.kapture.spinnenweb.dto.WebDataDTO;
import be.kapture.spinnenweb.mapper.PersoonMapper;
import be.kapture.spinnenweb.model.Persoon;
import be.kapture.spinnenweb.repository.PersoonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersoonService {
    @Autowired
    private PersoonRepository persoonRepository;
    @Autowired
    private PersoonMapper persoonMapper;

    public Persoon mapFromPersoonDTO(PersoonDTO persoon) {
        Optional<Persoon> dbPersoon = persoonRepository.findByNaam(persoon.getNaam());

        if (dbPersoon.isPresent()) {
            return dbPersoon.get();
        }
        else {
            Persoon nieuwePersoon = Persoon.PersoonBuilder()
                    .withNaam(persoon.getNaam())
                    .withPersoonType(persoon.getPersoonType())
                    .build();
            persoonRepository.save(nieuwePersoon);

            return nieuwePersoon;
        }
    }

    public List<PersoonDTO> getActievePersonen() {
        return persoonMapper.mapToPersoonDTO(persoonRepository.findAll());
    }

}
