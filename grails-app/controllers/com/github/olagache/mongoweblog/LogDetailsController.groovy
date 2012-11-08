package com.github.olagache.mongoweblog

import com.mongodb.DBObject

class LogDetailsController {

    def requestService

    /**
     * mapping as /logdetails/collectionName/id
     */
    def index() {
        String collectionName = params.collectionName ? params.collectionName : null
        String id = params.id ? params.id : null

        DBObject details = requestService.findById(collectionName, id)

        render(view: "/share/logdetails", model: [details : details])
    }
}
