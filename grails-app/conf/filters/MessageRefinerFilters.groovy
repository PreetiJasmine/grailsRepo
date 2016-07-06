package filters

import com.message.util.MessageRefinerUtil

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MessageRefinerFilters {

    def grailsApplication

    def filters = {
        all(controller: '*', action: '*') {
            before = {
               refineInput(params, request, response)
            }

        }
    }

    // Method to refine every inout received from the user
    private void refineInput(parameters, HttpServletRequest request, HttpServletResponse response) {
        parameters.each { entry ->
            if(entry.value instanceof String) {
                entry.value = MessageRefinerUtil.refine(entry.value)
            }
        }
    }
}
