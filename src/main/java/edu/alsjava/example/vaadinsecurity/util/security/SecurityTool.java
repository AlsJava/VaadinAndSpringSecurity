package edu.alsjava.example.vaadinsecurity.util.security;

import com.vaadin.flow.server.ServletHelper;
import com.vaadin.flow.shared.ApplicationConstants;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Stream;

/**
 * Created by aluis on 5/10/20.
 */
public final class SecurityTool {

    private SecurityTool() {
    }

    public static boolean isFrameworkInternal(HttpServletRequest request) {
        final String parameter = request.getParameter(ApplicationConstants.REQUEST_TYPE_PARAMETER);
        return parameter != null && Stream.of(ServletHelper.RequestType.values()).anyMatch(requestType -> requestType.getIdentifier().equals(parameter));
    }

    public static boolean isLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null
                && !(authentication instanceof AnonymousAuthenticationToken)
                && authentication.isAuthenticated();
    }
}
