package be.kapture.web;

import be.kapture.web.components.SkillsetGrid;
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

    @Override
    protected void init(VaadinRequest request) {

        final TextField consultantName = new TextField();
        consultantName.setCaption("Enter your name: ");

        List<String> dummySkills = Arrays.asList(new String[]{"Java", "HTML", "C++", "JavaScript", "Spring", "Hibernate", "SQL", "Windows", "IntelliJ"});
        SkillsetGrid skillsetGrid = new SkillsetGrid(dummySkills);

        final Button nextPage = new Button("Next");

        nextPage.addClickListener(event -> {
            // GO TO NEXT PAGE

        });

        layout.addComponents(consultantName, skillsetGrid, nextPage);

        layout.setMargin(true);
        layout.setSpacing(true);

        this.setContent(layout);

    }
}
