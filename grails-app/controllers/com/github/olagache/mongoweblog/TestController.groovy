package com.github.olagache.mongoweblog

class TestController {

    def index() {
        render(view: "index" , model: ["applicationLogs" : ApplicationLog.list(max: 50, offset: 0, sort: "timestamps", order: "desc")])
    }
}
