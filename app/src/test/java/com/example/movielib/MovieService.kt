package com.example.movielib
import com.example.movielib.domain.model.Movie
import com.example.movielib.domain.service.MovieService
import com.example.movielib.domain.service.makeMovieService
import org.junit.Test
import org.junit.Assert.*

class MovieService {
    private val testMockMovieService : MovieService = makeMovieService();
    private val testMockMovie = Movie("Sideman", "2005", "Good shit", "Boom", "Action");

    @Test
    fun createMovie() {

        testMockMovieService.createMovie(testMockMovie.title, testMockMovie.year, testMockMovie.description, testMockMovie.picture, testMockMovie.genre);
        assertEquals("Creating a movie should return a list of movies with size 1",1, testMockMovieService.getMovies().size);
        assertEquals("The movie title is Sideman","Sideman",
            testMockMovieService.getMovies().get(testMockMovie.id)?.title ?: null
        );
    }
    @Test
    fun isFavorite() {
        testMockMovieService.createMovie(testMockMovie.title, testMockMovie.year, testMockMovie.description, testMockMovie.picture, testMockMovie.genre);
        assertEquals("Adding a movie to favorite should return true",true, testMockMovieService.isFavorite(testMockMovie.id));
        assertEquals("Adding a movie to favorite with an unknown id should return false",false, testMockMovieService.isFavorite(1));
        assertEquals("Adding a movie to favorite should return a list of favorite movies with size 1",1, testMockMovieService.getFavoriteMovies().size);
        assertEquals("The movie favorite-attribute should be true",true,
            testMockMovieService.getFavoriteMovies().get(testMockMovie.id)?.favorite ?: null
        );
        assertEquals("The movie favorite-attribute should be true",true,
            testMockMovieService.getMovies().get(testMockMovie.id)?.favorite ?: null
        );
    }
    @Test
    fun notFavorite() {
        testMockMovieService.createMovie(testMockMovie.title, testMockMovie.year, testMockMovie.description, testMockMovie.picture, testMockMovie.genre);
        assertEquals("Adding a movie to favorite should return true",true, testMockMovieService.isFavorite(testMockMovie.id));
        assertEquals("Adding a movie to favorite should return a list of favorite movies with size 1",1, testMockMovieService.getFavoriteMovies().size);
        assertEquals("Removing a movie from favorite should return true",true, testMockMovieService.notFavorite(testMockMovie.id));
        assertEquals("Removing a movie from favorite should return a list of favorite movies with size 0",0, testMockMovieService.getFavoriteMovies().size);
        assertEquals("The movie favorite-attribute should be false",false,
            testMockMovieService.getMovies().get(testMockMovie.id)?.favorite ?: null
        );
    }
    @Test
    fun delMovie() {
        testMockMovieService.createMovie(testMockMovie.title, testMockMovie.year, testMockMovie.description, testMockMovie.picture, testMockMovie.genre);
        assertEquals("Creating a movie should return a list of movies with size 1",1, testMockMovieService.getMovies().size);
        assertEquals("Adding a movie to favorite should return true",true, testMockMovieService.isFavorite(testMockMovie.id));
        assertEquals("Adding a movie to favorite should return a list of favorite movies with size 1",1, testMockMovieService.getFavoriteMovies().size);
        assertEquals("Deleting a movie from list should return true",true, testMockMovieService.delMovie(testMockMovie.id));
        assertEquals("Deleting a movie should return a list of movies with size 1",0, testMockMovieService.getMovies().size);
        assertEquals("Deleting a movie should return a list of favorite movies with size 1",0, testMockMovieService.getFavoriteMovies().size);
    }
}