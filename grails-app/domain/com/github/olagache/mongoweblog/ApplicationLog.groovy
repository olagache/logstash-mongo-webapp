package com.github.olagache.mongoweblog

import org.bson.types.ObjectId

class ApplicationLog {
    static mapWith = "mongo"

    static constraints = {
    }

    static mapping = {
        collection "applications"

        source attr: "@source"
        tags attr: "@tags"
        fields attr: "@fields"
        timestamps attr: "@timestamp"
        sourceHost attr: "@source_host"
        sourcePath attr: "@source_path"
        message    attr: "@message"
    }

    ObjectId id

    String source

    List<String> tags

    Map<String, String> fields

    String timestamps

    String sourceHost

    String sourcePath

    String message
}
