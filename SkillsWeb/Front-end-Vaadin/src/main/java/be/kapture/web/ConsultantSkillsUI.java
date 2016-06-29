package be.kapture.web;

import be.kapture.dao.PersonDAO;
import be.kapture.entities.Person;
import be.kapture.util.SkillNotFoundException;
import be.kapture.web.forms.ConsultantSkillsRetrieverForm;
import be.kapture.web.forms.SkillsetForm;
import com.vaadin.annotations.Title;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

import java.util.Arrays;
import java.util.List;

/**
 * Vaadin framework request entry point for URL mapping "/*"
 *
 * Created by Yannick Thibos on 17/06/2016.
 */
@Title("Consultant Surveys")
public class ConsultantSkillsUI extends UI {

    private final HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();

    private final transient PersonDAO personDAO = new PersonDAO();

    @Override
    protected void init(VaadinRequest request) {

        horizontalSplitPanel.setSplitPosition(33F, Unit.PERCENTAGE);
        horizontalSplitPanel.setLocked(true);

        setupLeftPanel();

        setContent(horizontalSplitPanel);
    }

    private void setupLeftPanel() {

        HorizontalLayout leftPanel = new HorizontalLayout();
        leftPanel.setMargin(true);
        leftPanel.setSpacing(true);

        ComboBox consultantsComboBox = createConsultantsComboBox();

        leftPanel.addComponent(consultantsComboBox);
        horizontalSplitPanel.addComponent(leftPanel);

    }

    private ComboBox createConsultantsComboBox() {

        ComboBox comboBox = new ComboBox("Surveyed consultants:");

        BeanItemContainer<Person> consultantContainer = new BeanItemContainer<>(Person.class);
        consultantContainer.addAll(personDAO.findAll());

        comboBox.setContainerDataSource(consultantContainer);

        return comboBox;

    }

}
