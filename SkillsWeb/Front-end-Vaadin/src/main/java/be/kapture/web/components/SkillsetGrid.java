package be.kapture.web.components;

import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Yannick Thibos on 17/06/2016.
 */
public class SkillsetGrid extends GridLayout {

    private static final int COLUMNS = 2;
    private static final int LABEL_COLUMN_INDEX = 0;
    private static final int TEXTFIELD_COLUMN_INDEX = 1;

    private List<String> skillset = new ArrayList<>();

    public SkillsetGrid(List<String> skills) throws NullPointerException {

        super(COLUMNS, skills.size());

        Objects.requireNonNull(skills, "Skillset null reference not allowed");
        skillset = skills;

        for (int i = 0; i < skillset.size(); i++) {

            // Add label with the name of the skill
            Label label = new Label(skillset.get(i));

            // Add a textfield to take input
            TextField textField = new TextField();
            int finalI = i;

            // When the textfield changes, change the value for the skill accordingly
            // TODO input validation for non-integers
            textField.addTextChangeListener(event -> {
                skillset.set(finalI, ((TextField) event.getSource()).getValue());
            });

            this.addComponent(label, LABEL_COLUMN_INDEX, i);
            this.addComponent(textField, TEXTFIELD_COLUMN_INDEX, i);
        }
    }

    public int getSkillscore(String skill) {
        // TODO Implement this
        throw new UnsupportedOperationException("Yes, it's on the TODO list.");
    }

}
