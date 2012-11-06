package com.github.olagache.mongoweblog

import com.github.olagache.mongoweblog.utils.Query
import com.github.olagache.mongoweblog.utils.Page
import com.mongodb.DBObject

class ApplicationController {

    def requestService

    def index() {
        Query query = Query.collection("applications")
        Page<DBObject> page = requestService.withQuery(query)

        render(view: "index", model: ["page":page])
    }
}
