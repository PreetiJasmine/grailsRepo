package com.message.filter.wrapper;

import com.message.util.MessageRefinerUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Class to refine the user parameter captured in the request object
 *
 * Created by preetijasmine on 06/07/16.
 */
public class MessageRequestWrapper extends HttpServletRequestWrapper {

    public MessageRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);

        if (values == null) {
            return null;
        }

        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = MessageRefinerUtil.refine(values[i]);
        }

        return encodedValues;
    }

    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        if (value != null) {
            value = MessageRefinerUtil.refine(value);
        }
        return value;
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value != null) {
            value = MessageRefinerUtil.refine(value);
        }
        return value;
    }

}
