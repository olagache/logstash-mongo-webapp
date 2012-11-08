package com.github.olagache.mongoweblog.utils

import com.mongodb.DBCollection
import com.mongodb.DBObject
import com.mongodb.BasicDBObject
import org.apache.commons.lang.StringUtils
import com.mongodb.DBCursor
import org.bson.types.ObjectId

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
            cursor = collection.find(queryObject)
        }

        if(query.index != 0) {
            cursor.skip(query.start)
        }
        cursor.limit(query.size)
        cursor.sort("@timestamp" : -1)

        Page<DBObject> page = Page.fromQuery(query)
        page.totalCount = cursor.count()
        page.items = cursor.toArray()

        return page;
    }


    def DBObject findById(String collectionName, String idAsString) {

        def db = mongo.getDB("logs");

        ObjectId objectId = new ObjectId(idAsString)
        return  db[collectionName].findOne(objectId)
    }
}
