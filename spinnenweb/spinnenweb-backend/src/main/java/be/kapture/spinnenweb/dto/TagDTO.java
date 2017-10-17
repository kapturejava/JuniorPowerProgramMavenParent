package be.kapture.spinnenweb.dto;

public class TagDTO {
    private Long id;

    private boolean isNieuw;
    private String tag;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
