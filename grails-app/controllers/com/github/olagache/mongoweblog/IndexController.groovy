package com.github.olagache.mongoweblog

import com.github.olagache.mongoweblog.utils.LogSummary

class IndexController {

    def index() {
        // render(view: "index")
    }

    def summaryLoader() {
        LogSummary summary = new LogSummary();
    }
}
