package be.kapture.web;

import be.kapture.util.SkillNotFoundException;
import be.kapture.web.components.SkillsetForm;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

import java.util.Arrays;
import java.util.List;

/**
 * Vaadin framework request entry point for URL mapping /*
 *
 * Created by Yannick Thibos on 17/06/2016.
 */
public class InputUI extends UI {

    private final VerticalLayout layout = new VerticalLayout();

    private static final List<String> DUMMY_SKILLS = Arrays.asList(new String[]{"Java", "HTML", "C++", "JavaScript", "Spring", "Hibernate", "SQL", "Windows", "IntelliJ"});

    @Override
    protected void init(VaadinRequest request) {

        final TextField consultantName = new TextField("Enter consultant name:");

        SkillsetForm skillsetForm = new SkillsetForm(DUMMY_SKILLS);

        final Button nextPage = new Button("Next");

        nextPage.addClickListener(event -> {
            // GO TO NEXT PAGE

        });

        layout.addComponents(consultantName, skillsetForm, nextPage);
        layout.setMargin(true);
        layout.setSpacing(true);

        GridLayout retrieveGrid = new GridLayout(4, 1);
        retrieveGrid.addComponent(new Label("Enter score to retrieve"), 0, 0);
        TextField retrievedSkill = new TextField();
        retrieveGrid.addComponent(retrievedSkill, 1, 0);
        Button get = new Button("Get");
        get.addClickListener(event -> {
            try {
                String message = String.valueOf(skillsetForm.getSkillscore(retrievedSkill.getValue()));
                Notification.show(message);
            } catch (SkillNotFoundException e) {
                Notification.show("Skill not found.");
                System.out.println("skill not found");
            }
        });
        retrieveGrid.addComponent(get);

        layout.addComponent(retrieveGrid);

        this.setContent(layout);

    }
}
