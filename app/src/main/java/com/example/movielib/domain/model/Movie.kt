package com.example.movielib.domain.model

import java.util.*

class Movie (
    var title: String,
    var year: String,
    var description: String,
    var picture: String,
    var genre: String,
    ) {
    var id = ((Date().time)/1000).toInt();
    var favorite: Boolean = false;
}