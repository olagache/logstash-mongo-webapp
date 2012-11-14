package com.github.olagache.mongoweblog

import com.github.olagache.mongoweblog.utils.Query
import org.apache.commons.lang.StringUtils
import com.mongodb.DBObject
import com.github.olagache.mongoweblog.utils.Page

class AccessController {

    def requestService

    def index() {
        Query query = Query.collection("access")

        //--- params
        if (StringUtils.isNotBlank(params["application"])) {
            query = query.withApplicationName(params["application"])
        }
        if (StringUtils.isNotBlank(params["responseCode"])) {
            query = query.withResponseCode(params["responseCode"])
        }

        //--- Params, pagination
        int size = params.max ? params.int("max") : 50
        if (size <=0) {
            size = 50
        }
        if (size > 200) {
            size = 200
        }
        query = query.withSize(size)

        int offset = params.offset ? params.int("offset") : 0
        if (offset > 0) {
            int index = (offset / size)
            if (index <= 0) {
                index = 0
            }
            query = query.withIndex(index)
        }

        Page<DBObject> page = requestService.withQuery(query)

        render(view: "index", model: ["page":page])
    }
}
