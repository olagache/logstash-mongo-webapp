package com.github.olagache.mongoweblog

import com.github.olagache.mongoweblog.utils.LogSummary

class IndexController {

    def logSummaryService

    def index() {
        def LogsSummaries = ['Application': logSummaryService.getLogApplicationSummary(false),
                             'Access': logSummaryService.getLogAccessSummary(false),
                             'Catalina': logSummaryService.getLogCatalinaSummary(false)
                            ]

        render(view: "index", model: ["logsSummaries": LogsSummaries])
    }
}
