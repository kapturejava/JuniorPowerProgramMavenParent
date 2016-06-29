package be.kapture.web;

import be.kapture.dao.PersonDAO;
import be.kapture.dao.SurveyDAO;
import be.kapture.entities.Person;
import be.kapture.entities.Survey;
import be.kapture.util.SkillNotFoundException;
import be.kapture.web.forms.ConsultantSkillsRetrieverForm;
import be.kapture.web.forms.SkillsetForm;
import com.vaadin.annotations.Title;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
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
    private final VerticalLayout leftPanel = new VerticalLayout();

    private final transient PersonDAO personDAO = new PersonDAO();
    private final transient SurveyDAO surveyDAO = new SurveyDAO();

    @Override
    protected void init(VaadinRequest request) {

        horizontalSplitPanel.setSplitPosition(33F, Unit.PERCENTAGE);
        horizontalSplitPanel.setLocked(true);

        leftPanel.setMargin(true);
        leftPanel.setSpacing(true);
        horizontalSplitPanel.setFirstComponent(leftPanel);

        setupLeftPanel();

        setContent(horizontalSplitPanel);
    }

    private void setupLeftPanel() {

        ComboBox consultantsComboBox = createConsultantsComboBox();

        leftPanel.addComponent(consultantsComboBox);

    }

    private ComboBox createConsultantsComboBox() {

        ComboBox comboBox = new ComboBox("Surveyed consultants:");

        BeanItemContainer<Person> consultantContainer = new BeanItemContainer<>(Person.class);
        consultantContainer.addAll(personDAO.findAll());
        comboBox.setContainerDataSource(consultantContainer);

        comboBox.addValueChangeListener(new ConsultantSelectedListener());

        return comboBox;

    }

    private class ConsultantSelectedListener implements ValueChangeListener {

        @Override
        public void valueChange(ValueChangeEvent event) {
            if (event.getProperty().getValue() != null) {
                Person selectedConsultant = (Person) event.getProperty().getValue();

                System.out.println("------------------SELECTED CONSULTANT-----------------\n" + selectedConsultant
                        + " WITH ID = " + selectedConsultant.getId() + "\n");

                leftPanel.addComponent(createSurveysComboBox(selectedConsultant.getId()));
            }
        }
    }

    private ComboBox createSurveysComboBox(int consultantID) {

        ComboBox comboBox = new ComboBox("Surveys:");

        BeanItemContainer<Survey> surveyContainer = new BeanItemContainer<>(Survey.class);
        List<Survey> foundSurveys = surveyDAO.findByPersonId(consultantID);
        System.out.println("------------------FOUND SURVEYS-----------------\n" + foundSurveys
                + "\n");
        surveyContainer.addAll(foundSurveys);
        comboBox.setContainerDataSource(surveyContainer);

        return comboBox;
    }
}
