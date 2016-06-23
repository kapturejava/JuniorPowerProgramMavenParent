package be.kapture.web.listeners;

import be.kapture.web.forms.SkillsetForm;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import java.util.Arrays;
import java.util.List;

import static com.vaadin.ui.Notification.Type.WARNING_MESSAGE;

/**
 * Created by Yannick Thibos.
 */
public class LookupSkillsBehaviour implements ClickListener {

    private String consultantName;
    private static final List<String> DUMMY_SKILLS = Arrays.asList("Java", "HTML", "C++", "JavaScript", "Spring", "Hibernate", "SQL", "Windows", "IntelliJ");

    // private PersonDAO personDAO = new PersonDAO();

    public LookupSkillsBehaviour(String consultantName) {
        this.consultantName = consultantName;
    }

    @Override
    public void buttonClick(ClickEvent event) {

        Notification.show("Not yet implemented.", WARNING_MESSAGE);

        // TODO session attribute should eventually contain a real skillset
        //VaadinSession.getCurrent().setAttribute(be.kapture.entities.Person.class, personDAO.read(consultantName));

        VaadinSession.getCurrent().setAttribute("consultant", consultantName);
        UI.getCurrent().setContent(new SkillsetForm(DUMMY_SKILLS));


    }
}
