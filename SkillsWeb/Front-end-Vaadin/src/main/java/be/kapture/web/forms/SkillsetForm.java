package be.kapture.web.forms;

import be.kapture.util.SkillNotFoundException;
import com.vaadin.data.util.converter.Converter.ConversionException;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.ui.*;

import java.util.*;
import java.util.Map.Entry;

import static com.vaadin.ui.Notification.Type.WARNING_MESSAGE;

/**
 * Created by Yannick Thibos.
 */
public class SkillsetForm extends FormLayout {

    private Map<String, Integer> skillset = new TreeMap<>() ;

    public SkillsetForm(List<String> skills) throws NullPointerException {

        Objects.requireNonNull(skills, "Skillset null reference not allowed");

        collectSkills(skills);
        addComponentsToGrid();

    }

    private void collectSkills(List<String> skills) {
        for (String skill : skills) {
            skillset.put(skill, null);
        }
    }

    private void addComponentsToGrid() {

        for (Entry<String, Integer> skillsetEntry : skillset.entrySet()) {

            TextField textField = createTextField(skillsetEntry.getKey());
            implementValueChangeListener(textField);

            this.addComponent(textField);

        }
    }

    private void implementValueChangeListener(TextField textField) {
        // When the textfield changes, change the value for the skill accordingly
        textField.addValueChangeListener(event -> {
            try {
                Integer skillScore = (Integer) textField.getConvertedValue();
                skillset.put(textField.getCaption(), skillScore);
            } catch (ConversionException ex) {
                Notification.show("Please enter an integer number.", WARNING_MESSAGE);
            }
        });
    }

    private TextField createTextField(String skill) {
        // Add a textfield to take input
        TextField textField = new TextField(skill);
        textField.setConverter(Integer.class);
        textField.addValidator(new IntegerRangeValidator("Skills should be scored between 0 en 5.", 0, 5));
        textField.setWidth(36F, Unit.PIXELS);
        textField.setNullRepresentation("");
        return textField;
    }

    /**
     *
     * @param skill
     * @return  The queried skillscore if present.
     * @throws SkillNotFoundException   Thrown when the queried skill is not found in the datasource.
     * @throws NullPointerException     Thrown when queried skill String is a null reference.
     */
    public int getSkillscore(String skill) throws SkillNotFoundException, NullPointerException {
        Objects.requireNonNull(skill, "Queried skill String null reference not allowed.");
        if (skillset.get(skill) == null) {
            throw new SkillNotFoundException();
        }
        return skillset.get(skill);
    }

}
