package com.example.movielib.domain.model

interface Movie {
    val id: Int;
    val titel: String;
    val year: String;
    val description: String;
    val picture: String;
    val genre: String;
    val favorite: Boolean;
}