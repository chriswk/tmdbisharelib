package com.chriswk.isharelib

import com.chriswk.tmdb.TmdbService

class TmdbLookupController {
    TmdbService tmdbService

    def movie() {
        tmdbService.updateMovie(Long.parseLong(params.id))
    }

    def person() {
        tmdbService.updatePerson(Long.parseLong(params.id))
    }

    def findRoles() {
        tmdbService.updateRoles(Long.parseLong(params.id))
    }

    def downloadGenres() {
        tmdbService.setupGenres()
    }
}
