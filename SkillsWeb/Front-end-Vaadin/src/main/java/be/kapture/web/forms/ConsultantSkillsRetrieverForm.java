package be.kapture.web.forms;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

/**
 * Created by Yannick Thibos.
 */
public class ConsultantSkillsRetrieverForm extends FormLayout {

    public ConsultantSkillsRetrieverForm() {

        addComponent(new TextField("Consultant name: "));
        addComponent(new Button("Lookup"));

    }

}
