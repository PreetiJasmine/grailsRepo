import com.message.filter.RefinerFilter

class MessageRefinerGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.3 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/controllers/**",
            "grails-app/views/**"
    ]

    // TODO Fill in these fields
    def title = "Message Refiner Plugin" // Headline display name of the plugin
    def author = "Preeti Jasmine"
    def authorEmail = ""
    def description = '''\
Plugin to refines user input for <marquee> tags to avoid XSS
'''
    def scm = [url: "https://github.com/PreetiJasmine/grailsRepo"]

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/message-refiner"
    def license = "APACHE"


    def doWithWebDescriptor = { xml ->

        def contextParam = xml.'context-param'
        contextParam[contextParam.size() - 1] + {
            'filter' {
                'filter-name'('refinerFilter')
                'filter-class'(RefinerFilter.name)
            }
        }

        def filter = xml.'filter'
        filter[filter.size() - 1] + {
            'filter-mapping' {
                'filter-name'('refinerFilter')
                'url-pattern'('/*')
            }
        }
    }
}
