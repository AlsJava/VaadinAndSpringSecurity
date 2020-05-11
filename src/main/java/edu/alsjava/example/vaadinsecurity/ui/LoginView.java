package edu.alsjava.example.vaadinsecurity.ui;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterListener;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Collections;

/**
 * Created by aluis on 5/10/20.
 */
@Route("login")
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterListener {

    private final LoginForm login = new LoginForm();

    public LoginView() {
        login.setAction("login");
        getElement().appendChild(login.getElement());
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (!event.getLocation().getQueryParameters().getParameters().getOrDefault("error", Collections.emptyList()).isEmpty()) {
            login.setError(true);
        }
    }
}
