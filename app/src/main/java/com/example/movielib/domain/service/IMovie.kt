package com.example.movielib.domain.service
import com.example.movielib.domain.model.Movie

interface IMovie {
    fun getMovies(): HashMap<Int, Movie>
    fun getFavoriteMovies(): HashMap<Int, Movie>
    fun createMovie(title: String, year: String, description: String, picture: String, genre: String): Movie
    fun isFavorite(id: Int): Boolean
    fun notFavorite(id: Int): Boolean
    fun delMovie(id: Int): Boolean
}