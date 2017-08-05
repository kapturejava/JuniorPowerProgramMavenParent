package be.kapture.spinnenweb.mapper;

import be.kapture.spinnenweb.dto.PersoonDTO;
import be.kapture.spinnenweb.dto.TagDTO;
import be.kapture.spinnenweb.model.Persoon;
import be.kapture.spinnenweb.model.Tag;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersoonMapper {

    public List<PersoonDTO> mapToPersoonDTO(List<Persoon> all) {
        return all.stream().map(persoon -> mapToPersoonDTO(persoon)).collect(Collectors.toList());
    }

    private PersoonDTO mapToPersoonDTO(Persoon persoon) {
        PersoonDTO dto = new PersoonDTO();
        dto.setNaam(persoon.getNaam());
        dto.setId(persoon.getId());
        dto.setNieuw(false);
        dto.setPersoonType(persoon.getPersoonType());
        dto.setTagList(persoon.getTags().stream().map(tag -> mapToTagDTO(tag)).collect(Collectors.toList()));
        return dto;
    }

    private TagDTO mapToTagDTO(Tag tag) {
        TagDTO dto = new TagDTO();
        dto.setId(tag.getId());
        dto.setTag(tag.getNaam());
        dto.setNieuw(false);
        return dto;
    }
}
