package edu.alsjava.example.vaadinsecurity.util.configuration;

import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import edu.alsjava.example.vaadinsecurity.ui.LoginView;
import edu.alsjava.example.vaadinsecurity.util.security.SecurityTool;

/**
 * Created by aluis on 5/10/20.
 */
public class ConfigureUIServiceListener implements VaadinServiceInitListener {

    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.getSource().addUIInitListener(uiEvent -> uiEvent.getUI().addBeforeEnterListener(this::beforeEnter));
    }

    private void beforeEnter(BeforeEnterEvent event) {
        if (!LoginView.class.equals(event.getNavigationTarget()) && !SecurityTool.isLoggedUser()) {
            event.rerouteTo(LoginView.class);
        }
    }
}
