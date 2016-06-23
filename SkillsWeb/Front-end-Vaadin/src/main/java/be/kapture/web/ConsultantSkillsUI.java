package be.kapture.web;

import be.kapture.util.SkillNotFoundException;
import be.kapture.web.forms.ConsultantSkillsRetrieverForm;
import be.kapture.web.forms.SkillsetForm;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

import java.util.Arrays;
import java.util.List;

/**
 * Vaadin framework request entry point for URL mapping /*
 *
 * Created by Yannick Thibos on 17/06/2016.
 */
public class ConsultantSkillsUI extends UI {

    private final HorizontalLayout horizontalLayout = new HorizontalLayout();

    private static final List<String> DUMMY_SKILLGROUPS = Arrays.asList("Web front-end", "Java", "Softskills");

    @Override
    protected void init(VaadinRequest request) {

        horizontalLayout.setMargin(true);
        horizontalLayout.setSpacing(true);

        horizontalLayout.addComponent(new ConsultantSkillsRetrieverForm());

        setContent(horizontalLayout);
    }


    private void addSkillscoreRetrieverForTestingPurposes(SkillsetForm skillsetForm) {
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

        horizontalLayout.addComponent(retrieveGrid);
    }
}
