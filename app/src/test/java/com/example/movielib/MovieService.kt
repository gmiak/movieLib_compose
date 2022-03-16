package com.example.movielib
import com.example.movielib.domain.model.Movie
import com.example.movielib.domain.service.MovieService
import org.junit.Test
import org.junit.Assert.*

class MovieService {
    private val testMockService : MovieService = MovieService();
    private val testMockMovie = Movie("Sideman", "2005", "Good shit", "Boom", "Action");

    @Test
    fun createMovie() {

        testMockService.createMovie(testMockMovie.title, testMockMovie.year, testMockMovie.description, testMockMovie.picture, testMockMovie.genre);
        assertEquals("Creating a movie should return a list of movies with size 1",1, testMockService.getMovies().size);
        assertEquals("The movie title is Sideman","Sideman",
            testMockService.getMovies().get(testMockMovie.id)?.title ?: null
        );
    }
    @Test
    fun isFavorite() {
        testMockService.createMovie(testMockMovie.title, testMockMovie.year, testMockMovie.description, testMockMovie.picture, testMockMovie.genre);
        assertEquals("Adding a movie to favorite should return true",true, testMockService.isFavorite(testMockMovie.id));
        assertEquals("Adding a movie to favorite with an unknown id should return false",false, testMockService.isFavorite(1));
        assertEquals("Adding a movie to favorite should return a list of favorite movies with size 1",1, testMockService.getFavoriteMovies().size);
        assertEquals("The movie favorite-attribute should be true",true,
            testMockService.getFavoriteMovies().get(testMockMovie.id)?.favorite ?: null
        );
        assertEquals("The movie favorite-attribute should be true",true,
            testMockService.getMovies().get(testMockMovie.id)?.favorite ?: null
        );
    }
    @Test
    fun notFavorite() {
        testMockService.createMovie(testMockMovie.title, testMockMovie.year, testMockMovie.description, testMockMovie.picture, testMockMovie.genre);
        assertEquals("Adding a movie to favorite should return true",true, testMockService.isFavorite(testMockMovie.id));
        assertEquals("Adding a movie to favorite should return a list of favorite movies with size 1",1, testMockService.getFavoriteMovies().size);
        assertEquals("Removing a movie from favorite should return true",true, testMockService.notFavorite(testMockMovie.id));
        assertEquals("Removing a movie from favorite should return a list of favorite movies with size 0",0, testMockService.getFavoriteMovies().size);
        assertEquals("The movie favorite-attribute should be false",false,
            testMockService.getMovies().get(testMockMovie.id)?.favorite ?: null
        );
    }
    @Test
    fun delMovie() {
        testMockService.createMovie(testMockMovie.title, testMockMovie.year, testMockMovie.description, testMockMovie.picture, testMockMovie.genre);
        assertEquals("Creating a movie should return a list of movies with size 1",1, testMockService.getMovies().size);
        assertEquals("Adding a movie to favorite should return true",true, testMockService.isFavorite(testMockMovie.id));
        assertEquals("Adding a movie to favorite should return a list of favorite movies with size 1",1, testMockService.getFavoriteMovies().size);
        assertEquals("Deleting a movie from list should return true",true, testMockService.delMovie(testMockMovie.id));
        assertEquals("Deleting a movie should return a list of movies with size 1",0, testMockService.getMovies().size);
        assertEquals("Deleting a movie should return a list of favorite movies with size 1",0, testMockService.getFavoriteMovies().size);
    }
}