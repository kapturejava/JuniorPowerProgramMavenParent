package be.kapture.web.forms;

import be.kapture.web.listeners.LookupSkillsBehaviour;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

/**
 * Created by Yannick Thibos.
 */
public class ConsultantSkillsRetrieverForm extends FormLayout {

    private  final TextField consultantName;

    public ConsultantSkillsRetrieverForm() {

        consultantName = new TextField("Consultant name:");

        Button lookupSkillsButton = new Button("Lookup");
        lookupSkillsButton.addClickListener(new LookupSkillsBehaviour(consultantName.getValue()));

        addComponent(consultantName);
        addComponent(lookupSkillsButton);

    }

}
