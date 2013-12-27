package com.chriswk.isharelib

import grails.rest.*

@Resource(uri='/api/genres')
class Genre {
    Integer tmdb_id
    String name
    Date dateCreated
    Date lastUpdated
    static constraints = {

    }

    @Override
    String toString() {
        return "Genre(${tmdb_id}, ${name}) Lastupdated: ${lastUpdated}"
    }
}
