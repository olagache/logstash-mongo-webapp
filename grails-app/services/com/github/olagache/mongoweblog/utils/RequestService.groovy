package com.github.olagache.mongoweblog.utils

import com.mongodb.DBCollection
import com.mongodb.DBObject
import com.mongodb.BasicDBObject
import org.apache.commons.lang.StringUtils
import com.mongodb.DBCursor

class RequestService {
    def mongo;


    def Page<DBObject> withQuery(Query query) {
        def db = mongo.getDB("logs");

        DBCollection collection = db[query.mongoCollection]

        //--- mongo query object
        DBObject queryObject = new BasicDBObject();
        if(StringUtils.isNotBlank(query.applicationName)) {
            queryObject.put("@fields.applicationName", query.applicationName)
        }

        if(StringUtils.isNotBlank(query.logLevel)) {
            queryObject.put("@fields.loglevel", query.logLevel)
        }

        if(StringUtils.isNotBlank(query.responseCode)) {
            queryObject.put("@fields.response", query.responseCode)
        }

        //--- mongo cursor option
        DBCursor cursor = null;
        if(queryObject.isEmpty()) {
            cursor = collection.find()
        }
        else {
            cursor.find(queryObject)
        }

        if(query.index != 0) {
            cursor.skip(query.index * query.size)
        }
        cursor.limit(query.size)
        cursor.sort("@timestamp" : -1)

        Page<DBObject> page = Page.fromQuery(query)
        page.totalCount = cursor.count()
        page.items = cursor.toArray()

        return page;
    }
}