package com.github.olagache.mongoweblog.utils

import com.mongodb.BasicDBObject

class LogSummaryService {

    def mongo;

    def getLogApplicationSummary(boolean withApplicationName) {
        getLogSummary("applications", withApplicationName)
    }

    def getLogAccessSummary(boolean withApplicationName) {
        getLogSummary("access", withApplicationName)
    }

    def getLogCatalinaSummary(boolean withApplicationName) {
        getLogSummary("catalina", withApplicationName)
    }


    def getLogSummary(String collectionName, boolean withApplicationName) {
        def db = mongo.getDB("logs");

        LogSummary logSummary = new LogSummary();

        if(withApplicationName) {
            logSummary.applicationNames = db[collectionName].distinct("@fields.applicationName")
        }

        logSummary.count = db[collectionName].find().count();

//        BasicDBObject returnField = new BasicDBObject()
//        returnField.put("@timestamp", 1)

        logSummary.setStartDate(db[collectionName].find([] as BasicDBObject, ["@timestamp":1] as BasicDBObject).limit(1).sort("@timestamp" : 1).next().get("@timestamp"))
        logSummary.setEndDate  (db[collectionName].find([] as BasicDBObject, ["@timestamp":1] as BasicDBObject).limit(1).sort("@timestamp" : -1).next().get("@timestamp"))


        return logSummary;

    }
}
