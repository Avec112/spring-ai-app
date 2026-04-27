package com.github.avec112.report.ui;

import com.github.avec112.report.RagChatService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;

@Route("rag")
@Menu(order = 1, icon = "icons/ai.svg", title = "AI")
public class RagView extends VerticalLayout {


    public RagView(RagChatService ragChatService) {

        setSizeFull();
        setPadding(true);
        setSpacing(true);

        H2 title = new H2("RAG Demo");

        ComboBox<String> office = new ComboBox<>("Office");
        office.setItems("A", "B");
        office.setValue("A");

        TextArea question = new TextArea("Question");
        question.setWidthFull();
        question.setPlaceholder("Ask about reports...");
        question.setValue("What do the reports say about water in the basement?");

        TextArea answer = new TextArea("Answer");
        answer.setWidthFull();
        answer.setHeight("250px");
        answer.setReadOnly(true);

        Button askButton = new Button("Ask", _ -> {
            String result = ragChatService.ask(question.getValue(), office.getValue());
            answer.setValue(result == null ? "" : result);
        });

        add(title, office, question, askButton, answer);
    }
}
