package be.kapture.web.components;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.ui.*;

import java.util.*;

/**
 * Created by Yannick Thibos on 17/06/2016.
 */
public class SkillsetGrid extends GridLayout {

    private static final int COLUMNS = 2;
    private static final int LABEL_COLUMN_INDEX = 0;
    private static final int TEXTFIELD_COLUMN_INDEX = 1;

    private Map<String, Integer> skillset = new TreeMap<>();

    public SkillsetGrid(List<String> skills) throws NullPointerException {

        super(COLUMNS, skills.size());

        Objects.requireNonNull(skills, "Skillset null reference not allowed");

        collectSkills(skills);
        addComponentsToGrid();

    }

    private void addComponentsToGrid() {
        int i = 0;
        for (Map.Entry<String, Integer> skillsetEntry : skillset.entrySet()) {

            // Add label with the name of the skill
            Label label = new Label(skillsetEntry.getKey());

            // Add a textfield to take input
            TextField textField = new TextField();
            textField.setConverter(Integer.class);
            textField.setWidth(36F, Unit.PIXELS);

            // When the textfield changes, change the value for the skill accordingly
            // TODO input validation for non-integers
            textField.addValueChangeListener(event -> {
                try {
                    Integer skillScore = (Integer) textField.getConvertedValue();
                    skillset.put(skillsetEntry.getKey(), skillScore);
                } catch (Converter.ConversionException | NumberFormatException e) {
                    Notification.show("Please enter an integer number.");
                }
            });

            this.addComponent(label, LABEL_COLUMN_INDEX, i);
            this.addComponent(textField, TEXTFIELD_COLUMN_INDEX, i);

            i++;
        }
    }

    private void collectSkills(List<String> skills) {
        for (String skill : skills) {
            skillset.put(skill, null);
        }
    }

    public int getSkillscore(String skill) {
        return skillset.get(skill);
    }


}
