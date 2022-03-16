package com.example.movielib.domain.service
import com.example.movielib.domain.model.Movie

class MovieService : IMovie {
    private val movies: HashMap<Int, Movie> = hashMapOf();
    private val favoriteMovies : HashMap<Int, Movie> = hashMapOf();
    constructor()

    override fun getMovies(): HashMap<Int, Movie> {
        return this.movies;
    }

    override fun getFavoriteMovies(): HashMap<Int, Movie> {
        return this.favoriteMovies;
    }

    override fun createMovie(
        title: String,
        year: String,
        description: String,
        picture: String,
        genre: String
    ): Movie {
        val newMovie = Movie(title, year, description, picture, genre);
        this.movies.put(newMovie.id, newMovie);
        return newMovie;
    }

    override fun isFavorite(id: Int): Boolean {
        val movie = this.movies[id];
        if (movie == null) {
            return false;
        }
        movie.favorite = true;
        favoriteMovies.put(id, movie);
        return true;
    }

    override fun notFavorite(id: Int): Boolean {
        val movie = this.movies[id];
        if (movie == null) {
            return false;
        }
        movie.favorite = false;
        favoriteMovies.remove(id);
        return true;
    }

    override fun delMovie(id: Int): Boolean {
        val movie = this.movies[id];
        val movieIsFavorite = this.favoriteMovies[id];
        if (movie == null) {
            return false;
        }
        if (movieIsFavorite != null) {
            this.favoriteMovies.remove(id);
        }
        this.movies.remove(id);
        return true;
    }
}
// Factoring method
fun makeMovieService() : MovieService {
    return MovieService();
}