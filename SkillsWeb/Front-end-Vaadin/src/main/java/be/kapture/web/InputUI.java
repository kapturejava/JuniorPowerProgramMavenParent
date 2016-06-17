package be.kapture.web;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

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

        final Button nextPage = new Button("Next");

        nextPage.addClickListener(event -> {
            // GO TO NEXT PAGE
        });


        layout.addComponents(consultantName, nextPage);

        layout.setMargin(true);
        layout.setSpacing(true);

        this.setContent(layout);

    }
}
