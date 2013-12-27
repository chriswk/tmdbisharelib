package com.chriswk.tmdb

import com.chriswk.isharelib.Country
import com.chriswk.isharelib.Genre
import com.chriswk.isharelib.Language
import com.chriswk.isharelib.Movie
import com.chriswk.isharelib.Person
import com.chriswk.isharelib.ProductionCompany
import com.chriswk.isharelib.Role

import grails.transaction.Transactional
import groovyx.net.http.HTTPBuilder

import java.text.ParseException

import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.JSON

@Transactional
class TmdbService {
    def grailsApplication

    def tmdbApiKey = grailsApplication.config.tmdb.api.key
    def tmdbApiUrl = grailsApplication.config.tmdb.api.url
    def tmdbApiVersion = grailsApplication.config.tmdb.api.version
    
    def http = new HTTPBuilder(tmdbApiUrl)
    def params = [
            api_key: tmdbApiKey
    ]

    def updateMovie(Long tmdbId) {
        http.request(GET, JSON) {
            uri.path = "/${tmdbApiVersion}/movie/${tmdbId}"
            uri.query = params

            response.success = { resp, tmdbMovie ->
                def m = Movie.findOrCreateByTmdb_id(tmdbMovie.id)
                m.title = tmdbMovie.title
                m.adult = tmdbMovie.adult
                m.backdrop_path = tmdbMovie.backdrop_path
                m.budget = tmdbMovie.budget
                m.status = tmdbMovie.status
                m.tagline = tmdbMovie.tagline


                m.homepage = tmdbMovie.homepage
                m.imdb_id = tmdbMovie.imdb_id
                m.original_title = tmdbMovie.original_title
                m.overview = tmdbMovie.overview
                m.popularity = tmdbMovie.popularity
                m.poster_path = tmdbMovie.poster_path
                println m.tmdb_id
                try {
                    m.release_date = new Date().parse("yyyy-MM-dd", tmdbMovie.release_date)
                } catch (ParseException pE) {
                    m.release_date = new Date().parse("yyyy-MM-dd", "1999-12-31")
                }
                m.revenue = tmdbMovie.revenue
                m.runtime = tmdbMovie.runtime
                m.save(failOnError: true)
                if (m.id != null) {
                    tmdbMovie.genres.each { g ->
                        def genre = Genre.findOrCreateWhere(tmdb_id: g.id, name: g.name).save(failOnError: true)
                        if (genre != null) {
                            println "ADding ${genre} to ${m}"
                            m.addToGenres(genre)
                            m.save()
                        }
                    }
                    tmdbMovie.production_companies.each { c ->
                        def company = ProductionCompany.findOrCreateWhere(tmdb_id: c.id, name: c.name).save()
                        if (company != null) {
                            m.addToProduction_companies(company)
                            m.save()
                        }
                    }
                    tmdbMovie.production_countries.each { c ->
                        def country = Country.findOrCreateWhere(iso_3166_1: c.iso_3166_1, name: c.name).save()
                        if (country != null) {
                            m.addToProduction_countries(country)
                            m.save()
                        }
                    }
                    tmdbMovie.spoken_languages.each { l ->
                        def lang = Language.findOrCreateWhere(iso_639_1: l.iso_639_1, name: l.name).save()
                        if (lang != null) {
                            m.addToSpoken_languages(lang)
                            m.save(failOnError: true)
                        }
                    }
                } else {
                    println "Not saved"
                }
                m.save(flush: true, failOnError: true)
                println "Saved ${m}"
            }
        }

    }

    def updatePerson(Long tmdbId) {
        http.request(GET, JSON) {
            uri.path = "/${tmdbApiVersion}/person/${tmdbId}"
            uri.query = params

            response.success = { resp, json ->
                def p = new Person(json)
                p.tmdb_id = json.id
                p = p.save()
            }
        }

    }

    def updateRoles(Long personId) {
        def person = Person.findByTmdb_id(personId)
        if (person == null) {
            person = updatePerson(personId)
        }
        person = Person.findByTmdb_id(personId)
        http.request(GET, JSON) {
            uri.path = "/${tmdbApiVersion}/person/${personId}/movie_credits"
            uri.query = params
            response.success = { resp, json ->
                json.cast.each { cast ->
                    def movie = Movie.findByTmdb_id(cast.id)
                    println("Fetched ${movie} for ${cast} and person ${person}")
                    if (movie == null) {
                        updateMovie(cast.id)
                        movie = Movie.findByTmdb_id(cast.id)
                    }
                    if (cast.character != null && cast.character.length() > 0) {
                        def role = Role.findOrCreateWhere(movie: movie, person: person, character: cast.character).save(flush: true)
                        movie?.addToCast(role)
                    }
                    movie?.save()
                }
            }
        }
    }

    def setupGenres() {
        http.request(GET, JSON) {
            uri.path = "/${tmdbApiVersion}/genre/list"
            uri.query = params

            response.success = { resp, json ->
                json.genres.each { genre ->
                    def g = Genre.findOrCreateWhere(tmdb_id: genre.id, name: genre.name)
                    g.save(failOnError: true)
                    println(g)
                }
            }
        }
    }

    def setupCompanies() {

    }


}
