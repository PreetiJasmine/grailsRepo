package com.message.filter;

import com.message.filter.wrapper.MessageRequestWrapper;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by preetijasmine on 06/07/16.
 */
public class RefinerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        // Wrap the filter with the new filter.
        // Any requests to the HttpRequest or HttpResponse will go through the wrapper.
        chain.doFilter(new MessageRequestWrapper(request), response);
    }

}
