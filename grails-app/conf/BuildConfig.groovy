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
        grails.project.repos.default = "https://github.com/PreetiJasmine/grailsRepo"
    }

   plugins {
        build(":release:3.0.1",
              ":rest-client-builder:1.0.3", ":tomcat:7.0.50") {
            export = false
        }
    }
}
