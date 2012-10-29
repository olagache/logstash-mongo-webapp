package com.github.olagache.mongoweblog.utils

import com.mongodb.BasicDBObject

class LogSummaryService {

    def mongo;

    def getLogApplicationSummary() {
        LogSummary logSummary = new LogSummary();

        def db = mongo.getDB("logs");
        assert db.access instanceof com.mongodb.DBCollection

        logSummary.applicationNames = db.access.distinct("@fields.applicationName")
        logSummary.count = db.access.find().count();

        BasicDBObject returnField = new BasicDBObject()
        returnField.put("@timestamp", 1)

        logSummary.startDate = db.access.find(new BasicDBObject(), returnField).limit(1).sort("@timestamp" : 1).next().get("@timestamp")
        logSummary.endDate = db.access.find(new BasicDBObject(), returnField).limit(1).sort("@timestamp" : -1).next().get("@timestamp")

        return logSummary;
    }
}
