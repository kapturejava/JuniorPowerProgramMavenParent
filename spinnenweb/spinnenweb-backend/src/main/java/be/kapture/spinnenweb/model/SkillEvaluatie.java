package be.kapture.spinnenweb.model;

import javax.persistence.*;

@Entity
public class SkillEvaluatie {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Skill skill;

    @Column
    @Enumerated(EnumType.STRING)
    private EvaluatieScore evaluatieScore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public EvaluatieScore getEvaluatieScore() {
        return evaluatieScore;
    }

    public void setEvaluatieScore(EvaluatieScore evaluatieScore) {
        this.evaluatieScore = evaluatieScore;
    }

    public static SkillEvaluatieBuilder SkillEvaluatieBuilder() {
        return new SkillEvaluatieBuilder();
    }

    public static class SkillEvaluatieBuilder {
        private SkillEvaluatie skillEvaluatie = new SkillEvaluatie();

        private SkillEvaluatieBuilder() {}

        public SkillEvaluatieBuilder withSkill(Skill skill) {
            skillEvaluatie.setSkill(skill);
            return this;
        }

        public SkillEvaluatieBuilder withEvaluatieScore(EvaluatieScore evaluatieScore) {
            skillEvaluatie.setEvaluatieScore(evaluatieScore);
            return this;
        }

        public SkillEvaluatie build() {
            return skillEvaluatie;
        }
    }
}
