package com.message.filter;

import com.message.filter.wrapper.MessageRequestWrapper;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class that invokes the wrapper class to be executed once the request is received
 *
 * Created by preetijasmine on 06/07/16.
 */
public class RefinerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        chain.doFilter(new MessageRequestWrapper(request), response);
    }

}
