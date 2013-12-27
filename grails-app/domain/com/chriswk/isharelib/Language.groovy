package com.chriswk.isharelib

import grails.rest.*

@Resource(uri='/api/languages')
class Language {
    String iso_639_1
    String name
    Date dateCreated
    Date lastUpdated
    static constraints = {
        iso_639_1 unique: true
    }
}
