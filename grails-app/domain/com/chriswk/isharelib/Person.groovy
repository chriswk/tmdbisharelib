package com.chriswk.isharelib

import grails.rest.*
import org.grails.databinding.BindingFormat

@Resource(uri='/api/people')
class Person {
    Boolean adult
    List<String> also_known_as
    String biography
    @BindingFormat("yyyy-MM-dd")
    Date birthday
    @BindingFormat("yyyy-MM-dd")
    Date deathday
    String homepage
    Integer tmdb_id
    String name
    String place_of_birth
    String profile_path

    Date dateCreated
    Date lastUpdated
    static hasMany = [
            roles: Role
    ]

    static constraints = {
        adult(nullable: true)
        also_known_as(nullable: true)
        biography(nullable:true, maxSize: 5000)
        birthday(nullable:true)
        deathday(nullable:true)
        homepage(nullable:true)
        tmdb_id(unique: true, nullable:false)
        name(nullable: false)
        place_of_birth(nullable:true)
        profile_path(nullable:true)
    }

    @Override
    String toString() {
        "${name} - ${tmdb_id}"
    }
}
