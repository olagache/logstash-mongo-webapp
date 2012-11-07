package com.github.olagache.mongoweblog.utils

public class Query {
    private static final int DEFAULT_SIZE = 50

    int index = 0
    int size = DEFAULT_SIZE

    String mongoCollection
    String applicationName
    String logLevel
    String responseCode

    private Query() {super()}

    public static Query collection(String mongoCollection) {
        Query query = new Query();
        query.setMongoCollection(mongoCollection)

        return query
    }

    public Query withIndex(int index) {
        Query query = copy()
        if(index < 0) {
            index = 0
        }

        query.setIndex(index);
        return query
    }

    public Query withSize(int size) {
        if(size < 0) {
            throw new IllegalArgumentException("size must be stricly positive (size > 0)")
        }
        Query query = copy()
        query.setSize(size)

        return query
    }

    public Query withApplicationName(String applicationName) {
        Query query = copy()
        query.setApplicationName(applicationName)

        return query
    }

    public Query withLogLevel(String logLevel) {
        Query query = copy()
        query.setLogLevel(logLevel)

        return query
    }

    public Query withResponseCode(String responseCode) {
        Query query = copy()
        query.setResponseCode(responseCode)

        return query
    }

    /* ---------- */
    /* ---------- */
    public int getStart() {
        return index * size
    }

    public int getEnd() {
        return start + size
    }

    /* ------- */
    /* Private */
    /* ------- */
    private Query copy() {
        Query query = new Query();

        query.index = index
        query.size = size

        query.mongoCollection = mongoCollection
        query.applicationName = applicationName
        query.logLevel = logLevel
        query.responseCode = responseCode

        return query
    }
}
