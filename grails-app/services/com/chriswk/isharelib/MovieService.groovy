package com.chriswk.isharelib

import grails.transaction.Transactional

@Transactional
class MovieService {

    def saveMovie(Movie m) {
        m.merge()
        m.save()
    }
}
