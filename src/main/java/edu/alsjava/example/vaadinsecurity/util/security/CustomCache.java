package edu.alsjava.example.vaadinsecurity.util.security;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by aluis on 5/10/20.
 */
public class CustomCache extends HttpSessionRequestCache {

    @Override
    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
        if (!SecurityTool.isFrameworkInternal(request)) {
            super.saveRequest(request, response);
        }
    }
}
