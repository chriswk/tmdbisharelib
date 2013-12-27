databaseChangeLog = {

	changeSet(author: "Christopher (generated)", id: "1388092826310-1") {
		createTable(tableName: "country") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "countryPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "iso_3166_1", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-2") {
		createTable(tableName: "genre") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "genrePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "tmdb_id", type: "int4") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-3") {
		createTable(tableName: "language") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "languagePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "iso_639_1", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-4") {
		createTable(tableName: "movie") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "moviePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "adult", type: "bool")

			column(name: "backdrop_path", type: "varchar(255)")

			column(name: "budget", type: "int8")

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "homepage", type: "varchar(255)")

			column(name: "imdb_id", type: "varchar(255)")

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "original_title", type: "varchar(255)")

			column(name: "overview", type: "varchar(5000)")

			column(name: "popularity", type: "float8")

			column(name: "poster_path", type: "varchar(255)")

			column(name: "release_date", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "revenue", type: "int8")

			column(name: "runtime", type: "int8")

			column(name: "status", type: "varchar(255)")

			column(name: "tagline", type: "varchar(255)")

			column(name: "title", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "tmdb_id", type: "int4") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-5") {
		createTable(tableName: "movie_country") {
			column(name: "movie_production_countries_id", type: "int8")

			column(name: "country_id", type: "int8")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-6") {
		createTable(tableName: "movie_genre") {
			column(name: "movie_genres_id", type: "int8")

			column(name: "genre_id", type: "int8")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-7") {
		createTable(tableName: "movie_language") {
			column(name: "movie_spoken_languages_id", type: "int8")

			column(name: "language_id", type: "int8")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-8") {
		createTable(tableName: "movie_production_company") {
			column(name: "movie_production_companies_id", type: "int8")

			column(name: "production_company_id", type: "int8")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-9") {
		createTable(tableName: "person") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "personPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "adult", type: "bool")

			column(name: "biography", type: "varchar(5000)")

			column(name: "birthday", type: "timestamp")

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "deathday", type: "timestamp")

			column(name: "homepage", type: "varchar(255)")

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "place_of_birth", type: "varchar(255)")

			column(name: "profile_path", type: "varchar(255)")

			column(name: "tmdb_id", type: "int4") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-10") {
		createTable(tableName: "production_company") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "production_coPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "tmdb_id", type: "int4") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-11") {
		createTable(tableName: "role") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "character", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "movie_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "person_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-22") {
		createIndex(indexName: "iso_3166_1_uniq_1388092826247", tableName: "country", unique: "true") {
			column(name: "iso_3166_1")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-23") {
		createIndex(indexName: "id_uniq_1388092826253", tableName: "genre", unique: "true") {
			column(name: "id")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-24") {
		createIndex(indexName: "iso_639_1_uniq_1388092826256", tableName: "language", unique: "true") {
			column(name: "iso_639_1")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-25") {
		createIndex(indexName: "id_uniq_1388092826256", tableName: "movie", unique: "true") {
			column(name: "id")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-26") {
		createIndex(indexName: "tmdb_id_uniq_1388092826259", tableName: "movie", unique: "true") {
			column(name: "tmdb_id")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-27") {
		createIndex(indexName: "tmdb_id_uniq_1388092826268", tableName: "person", unique: "true") {
			column(name: "tmdb_id")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-28") {
		createIndex(indexName: "name_uniq_1388092826268", tableName: "production_company", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-29") {
		createIndex(indexName: "tmdb_id_uniq_1388092826269", tableName: "production_company", unique: "true") {
			column(name: "tmdb_id")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-30") {
		createIndex(indexName: "unique_movie_id", tableName: "role", unique: "true") {
			column(name: "person_id")

			column(name: "movie_id")
		}
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-31") {
		createSequence(sequenceName: "hibernate_sequence")
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-12") {
		addForeignKeyConstraint(baseColumnNames: "country_id", baseTableName: "movie_country", constraintName: "FKFC010D873734EEB", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "country", referencesUniqueColumn: "false")
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-13") {
		addForeignKeyConstraint(baseColumnNames: "movie_production_countries_id", baseTableName: "movie_country", constraintName: "FKFC010D87D54209E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "movie", referencesUniqueColumn: "false")
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-14") {
		addForeignKeyConstraint(baseColumnNames: "genre_id", baseTableName: "movie_genre", constraintName: "FKCAEB87B47785F40B", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "genre", referencesUniqueColumn: "false")
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-15") {
		addForeignKeyConstraint(baseColumnNames: "movie_genres_id", baseTableName: "movie_genre", constraintName: "FKCAEB87B4E1341A7C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "movie", referencesUniqueColumn: "false")
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-16") {
		addForeignKeyConstraint(baseColumnNames: "language_id", baseTableName: "movie_language", constraintName: "FK3A1F9B8732DD23E9", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "language", referencesUniqueColumn: "false")
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-17") {
		addForeignKeyConstraint(baseColumnNames: "movie_spoken_languages_id", baseTableName: "movie_language", constraintName: "FK3A1F9B871178D64E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "movie", referencesUniqueColumn: "false")
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-18") {
		addForeignKeyConstraint(baseColumnNames: "movie_production_companies_id", baseTableName: "movie_production_company", constraintName: "FK98D7E466A423417", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "movie", referencesUniqueColumn: "false")
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-19") {
		addForeignKeyConstraint(baseColumnNames: "production_company_id", baseTableName: "movie_production_company", constraintName: "FK98D7E466D3E21498", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "production_company", referencesUniqueColumn: "false")
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-20") {
		addForeignKeyConstraint(baseColumnNames: "movie_id", baseTableName: "role", constraintName: "FK35807654C78EB", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "movie", referencesUniqueColumn: "false")
	}

	changeSet(author: "Christopher (generated)", id: "1388092826310-21") {
		addForeignKeyConstraint(baseColumnNames: "person_id", baseTableName: "role", constraintName: "FK35807694DF4689", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "person", referencesUniqueColumn: "false")
	}
}
