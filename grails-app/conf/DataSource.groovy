
// environment specific settings
environments {

    development {
        grails {
            mongo {
                host = "rtl-jdev1.web.groupertl.net"
                port = 27120
                databaseName = "logs"
            }
        }
    }

    test {
        grails {
            mongo {
                host = "rtl-jdev1.web.groupertl.net"
                port = 27017
                databaseName = "logs-integration"
            }
        }
    }

    production {
        grails {
            mongo {
                host = "rtl-jback2.web.groupertl.net"
                port = 27120
                databaseName = "logs"
            }
        }
    }
}
