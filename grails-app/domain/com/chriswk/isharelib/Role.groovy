package com.chriswk.isharelib

import grails.rest.*

@Resource(uri = '/api/roles')
class Role {
    Date dateCreated
    Date lastUpdated
    Movie movie
    Person person
    String character
    static belongsTo = [
        movie: Movie,
        person: Person
    ]
    static constraints = {
        movie unique: 'person'
    }
}
