package com.example.movielib.viewmodel
import com.example.movielib.domain.model.Movie
import com.example.movielib.domain.service.IMovie
import com.example.movielib.domain.service.makeMovieService
import java.io.IOException

class MovieViewModel(movService: IMovie) {
    private var movieService : IMovie = movService;

    fun getMovies() : HashMap<Int, Movie>? {
        try {
            var ms = this.movieService;
            var movies : HashMap<Int, Movie> = ms.getMovies();
            return movies;
        } catch (e : IOException) {
            return  null;
        }
    }
    fun getFavMovies() : HashMap<Int, Movie>? {
        try {
            var ms = this.movieService;
            var movies : HashMap<Int, Movie> = ms.getFavoriteMovies();
            return movies;
        } catch (e : IOException) {
            return  null;
        }
    }
    fun putMovie(
        title: String,
        year: String,
        description: String,
        picture: String,
        genre: String
    ) {
        try {
            if (title == null) {
                println("Missing title");
                return;
            }
            var ms = this.movieService;
            ms.createMovie(title, year, description, picture, genre);
        } catch (e : IOException) {
            println(e.message);
            return;
        }
    }
    fun putFavMovie(id : Int) {
        try {
            var ms = this.movieService;
            val completed : Boolean = ms.isFavorite(id);
            if(!completed) {
                println("No movie with id ${id}\n");
                return
            }
            println("Movie is added as favorite\n");
        } catch (e : IOException) {
            return;
        }
    }
    fun delMovie(id : Int) {
        try {
            var ms = this.movieService;
            val completed : Boolean = ms.delMovie(id);
            if(!completed) {
                println("No movie with id ${id}\n");
                return
            }
            println("The movie has been deleted\n");
        } catch (e : IOException) {
            return;
        }
    }
    fun delFavMovie(id : Int) {
        try {
            var ms = this.movieService;
            val completed : Boolean = ms.notFavorite(id);
            if(!completed) {
                println("No movie with id ${id}\n");
                return
            }
            println("The movie has been removed from favorite\n");
        } catch (e : IOException) {
            return;
        }
    }

}

fun makeMovieViewModel(): MovieViewModel {
    return MovieViewModel(makeMovieService());
}