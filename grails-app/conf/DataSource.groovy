
// environment specific settings
environments {

    development {
        grails {
            mongo {
                host = "localhost"
                port = 27017
                databaseName = "logs"
            }
        }
    }

    test {
        grails {
            mongo {
                host = "localhost"
                port = 27017
                databaseName = "logs"
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
