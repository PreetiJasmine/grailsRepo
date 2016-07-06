// configuration for plugin testing - will not be included in the plugin zip

log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate',
            'org.codehaus.groovy.grails'
}
