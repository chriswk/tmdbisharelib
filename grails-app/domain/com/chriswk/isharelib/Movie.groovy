package com.chriswk.isharelib

import grails.rest.*
import org.grails.databinding.BindingFormat

import java.text.ParseException

@Resource(uri = '/api/movies')
class Movie {
    Boolean adult
    String backdrop_path
    Long budget
    Integer tmdb_id
    String title
    @BindingFormat("yyyy-MM-dd")
    Date release_date
    String status
    String tagline
    String original_title
    Long runtime
    Long revenue
    String homepage
    String imdb_id
    String overview
    Double popularity
    String poster_path
    Date dateCreated
    Date lastUpdated
    Set<Genre> genres = new HashSet<>()
    Set<ProductionCompany> production_companies = new HashSet<>()
    Set<Country> production_countries = new HashSet<>()
    Set<Language> spoken_languages = new HashSet<>()
    Set<Role> cast = new HashSet<>()
    static hasMany = [
            genres: Genre,
            production_companies: ProductionCompany,
            production_countries: Country,
            spoken_languages: Language,
            cast: Role
    ]
    static constraints = {
        adult(nullable: true)
        backdrop_path(nullable: true)
        homepage(nullable: true)
        imdb_id(nullable: true)
        original_title(nullable: true)
        overview(nullable: true, maxSize: 5000)
        poster_path(nullable: true)
        status(nullable: true)
        title(nullable: false)
        revenue(nullable: true)
        runtime(nullable: true)
        popularity(nullable: true)
        budget(nullable: true)
        tagline(nullable: true)
        tmdb_id(unique: true, nullable: false)
        genres(nullable: true)
        production_companies(nullable: true)
        production_countries(nullable: true)
        spoken_languages(nullable: true)
        cast(nullable: true)
    }

    @Override
    String toString() {
        "id: ${id} - ${title} - ${tmdb_id}"
    }

}
