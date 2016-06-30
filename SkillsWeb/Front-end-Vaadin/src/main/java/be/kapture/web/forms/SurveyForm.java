package be.kapture.web.forms;

import be.kapture.dao.SkillNatureDAO;
import be.kapture.entities.SkillNature;
import be.kapture.entities.Survey;
import com.vaadin.ui.*;

import java.util.List;

/**
 * Created by Yannick Thibos.
 */
public class SurveyForm extends VerticalSplitPanel {

    HorizontalLayout skillNaturesBar = new HorizontalLayout();

    SkillNatureDAO skillNatureDAO = new SkillNatureDAO();

    private Survey survey;

    public SurveyForm(Survey survey) {
        this.survey = survey;
        initSkillNaturesBar();
    }

    private void initSkillNaturesBar() {
        for (SkillNature skillNature : skillNatureDAO.findAll()) {
            Button skillNatureButton = new Button(skillNature.getName());
            skillNatureButton.addClickListener(new SkillNatureButtonClickListener());
            skillNaturesBar.addComponent(skillNatureButton);
        }
    }

    private class SkillNatureButtonClickListener implements Button.ClickListener {
        @Override
        public void buttonClick(Button.ClickEvent event) {
            Notification.show("Show " + event.getButton().getCaption() + " skillgroups & skills.");
        }
    }
}
