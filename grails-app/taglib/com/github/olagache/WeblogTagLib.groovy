package com.github.olagache

import org.apache.commons.lang.StringUtils

class WeblogTagLib {
    static namespace = "weblog"
    static returnObjectForTags = ['applications', 'loglevels', 'responseCode']

    def mongo

    /**
     * return all distinct applications names contains in collection
     * @attr collection REQUIRED the mongo collection name
     */
    def applications = { attrs ->
        def db = mongo.getDB("logs");

        def names = db[attrs.collection].distinct("@fields.applicationName")
        return sanitizeList(names)
    }

    /**
     * return all distinct log levels contains in the applications collection
     */
    def loglevels = {
        def db = mongo.getDB("logs");

        List<String> levels = db.applications.distinct("@fields.loglevel")
        return sanitizeList(levels)
    }


    /**
     * return all distinct response code contains in the access collection
     */
    def responseCode = {
        def db = mongo.getDB("logs");

        List<String> responses = db.access.distinct("@fields.response")
        return sanitizeList(responses)
    }


    private List<String> sanitizeList(List<String> OriginalList) {
        List<String> copyList = new ArrayList<String>();

        copyList.add("");

        for (String name : OriginalList) {
            if (StringUtils.isNotBlank(name)) {
                copyList.add(name)
            }
        }

        return copyList.sort()
    }
}
