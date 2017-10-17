package be.kapture.spinnenweb.dto;

import be.kapture.spinnenweb.model.PersoonType;

import java.util.List;

public class PersoonDTO {
    private Long id;

    private boolean isNieuw;
    private String naam;
    private PersoonType persoonType;
    private List<TagDTO> tagList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNieuw() {
        return isNieuw;
    }

    public void setNieuw(boolean nieuw) {
        isNieuw = nieuw;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<TagDTO> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagDTO> tagList) {
        this.tagList = tagList;
    }

    public PersoonType getPersoonType() {
        return persoonType;
    }

    public void setPersoonType(PersoonType persoonType) {
        this.persoonType = persoonType;
    }
}
