package com.github.olagache.mongoweblog.utils

import com.mongodb.BasicDBObject

class LogSummaryService {

    def mongo;

    def getLogApplicationSummary() {
        getLogSummary("applications")
    }

    def getLogAccessSummary() {
        getLogSummary("access")
    }

    def getLogCatalinaSummary() {
        getLogSummary("catalina")
    }


    def getLogSummary(String collectionName) {
        def db = mongo.getDB("logs");

        LogSummary logSummary = new LogSummary();


        logSummary.applicationNames = db[collectionName].distinct("@fields.applicationName")
        logSummary.count = db[collectionName].find().count();

        BasicDBObject returnField = new BasicDBObject()
        returnField.put("@timestamp", 1)

        logSummary.setStartDate(db[collectionName].find(new BasicDBObject(), returnField).limit(1).sort("@timestamp" : 1).next().get("@timestamp"))
        logSummary.setEndDate  (db[collectionName].find(new BasicDBObject(), returnField).limit(1).sort("@timestamp" : -1).next().get("@timestamp"))


        return logSummary;

    }
}
