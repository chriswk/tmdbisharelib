package com.chriswk.isharelib

import grails.rest.*

@Resource(uri='/api/productioncompanies')
class ProductionCompany {
    Integer tmdb_id
    String name
    Date dateCreated
    Date lastUpdated

    static constraints = {
        tmdb_id unique: true
        name unique: true
    }
}
