grails.project.class.dir = 'target'


grails.project.dependency.resolver = "maven"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {

    }

    log "warn"

    repositories {
        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
    }

    dependencies {
        compile('org.owasp.esapi:esapi:2.1.0') {
            excludes 'antisamy', 'bsh-core', 'commons-beanutils-core', 'commons-collections', 'commons-configuration',
                    'commons-fileupload', 'commons-io', 'jsp-api', 'junit', 'log4j', 'servlet-api', 'xom'
        }
    }

    plugins {
        build(":release:3.0.1",
              ":rest-client-builder:1.0.3", ":tomcat:7.0.50") {
            export = false
        }
    }
}
