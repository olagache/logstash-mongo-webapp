package com.github.olagache

import org.apache.commons.lang.StringUtils

class WeblogTagLib {
    static namespace = "weblog"
    static returnObjectForTags = ['applications', 'loglevels']

    def mongo

    /**
     * return all applications names contains in collection
     * @attr collection REQUIRED the mongo collection name
     */
    def applications = { attrs ->
        def db = mongo.getDB("logs");

        def names = db[attrs.collection].distinct("@fields.applicationName")
        return removeNullString(names)
    }

    /**
     * return all log levels contains in collection
     * @attr collection REQUIRED the mongo collection name
     */
    def loglevels = { attrs ->
        def db = mongo.getDB("logs");

        List<String> levels = db[attrs.collection].distinct("@fields.loglevel")
        return removeNullString(levels)
    }

    private List<String> removeNullString(List<String> listWithNull) {
        List<String> copyList = new ArrayList<String>();

        copyList.add("");

        for (String name : listWithNull) {
            if (StringUtils.isNotBlank(name)) {
                copyList.add(name)
            }
        }

        return copyList
    }
}
