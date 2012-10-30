package com.github.olagache.mongoweblog

class TestController {

    def logSummaryService;

    def index() {
        def LogsSummaries = ['Applications': logSummaryService.getLogApplicationSummary(),
                             'Access': logSummaryService.getLogAccessSummary(),
                             'Catalina': logSummaryService.getLogCatalinaSummary()
                            ]

        render(view: "index",
                model: ["applicationLogs": ApplicationLog.list(max: 50, offset: 0, sort: "timestamps", order: "desc"),
                        "logsSummaries": LogsSummaries])
    }
}
