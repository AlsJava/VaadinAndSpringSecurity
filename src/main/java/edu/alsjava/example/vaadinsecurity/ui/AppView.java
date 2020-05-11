package edu.alsjava.example.vaadinsecurity.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Created by aluis on 5/10/20.
 */
@Route("app")
public class AppView extends VerticalLayout {

    public AppView() {
        add(new Text("Hola Mundo con Spring Security y Vaadin 14.1"));
    }
}
