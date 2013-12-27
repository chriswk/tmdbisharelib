package com.chriswk.isharelib

import grails.rest.*

@Resource(uri='/api/countries')
class Country {
    String iso_3166_1
    String name
    Date dateCreated
    Date lastUpdated
    static constraints = {
        iso_3166_1(unique: true)
    }
}
