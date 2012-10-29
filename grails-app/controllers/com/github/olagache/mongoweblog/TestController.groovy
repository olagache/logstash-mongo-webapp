package com.github.olagache.mongoweblog

import com.github.olagache.mongoweblog.utils.LogSummaryService

class TestController {

    def logSummaryService;

    def index() {
        def applicationSummary = logSummaryService.getLogApplicationSummary();

        render(view: "index" ,
                model: ["applicationLogs" : ApplicationLog.list(max: 50, offset: 0, sort: "timestamps", order: "desc"),
                "applicationSummary" : applicationSummary])
    }
}
