package com.example.laboratorio05.ui

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio05.MovieReviewerApplication
import com.example.laboratorio05.data.model.Movie_model
import com.example.laboratorio05.repository.MovieRepository

class MovieViewModel(private val repository: MovieRepository): ViewModel() {
    fun getMovies()= repository.getMovie()// llama a repository y le pase la lista
    fun addMovie(movie:Movie_model)= repository.addMovie(movie)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }

}