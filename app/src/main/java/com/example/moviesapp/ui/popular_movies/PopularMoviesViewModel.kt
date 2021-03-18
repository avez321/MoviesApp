package com.example.moviesapp.ui.popular_movies

import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.example.moviesapp.model.MoviesResponse
import com.example.moviesapp.repository.RepositoryImp
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import com.example.moviesapp.model.Result
import com.example.moviesapp.network.ResultWrapper

class PopularMoviesViewModel(application: Application) : AndroidViewModel(application), KoinComponent {
    private val repositoryImp: RepositoryImp by inject()
    private val movieDataObservableField: ObservableField<ArrayList<Result>?> =
        ObservableField()
    private val progressVisibilityObservableField:ObservableField<Int> = ObservableField()


    fun getMoviesData() {
        progressVisibilityObservableField.set(View.VISIBLE)
            GlobalScope.launch {
                val resultWarraper = repositoryImp.getMovies()
                withContext(Dispatchers.Main) {
                    when (resultWarraper) {
                        is ResultWrapper.NetworkError -> showNetworkError()
                        is ResultWrapper.GenericError -> showGenericError(resultWarraper)
                        is ResultWrapper.Success ->
                            showSuccess(resultWarraper.value)
                    }
                }
            }

    }

    fun getHomeDataObservableField() = movieDataObservableField

    fun getProgressVisibilityObservableField() = progressVisibilityObservableField



    private fun showSuccess(moviesResponse: MoviesResponse) {
        progressVisibilityObservableField.set(View.GONE)
        movieDataObservableField.set(moviesResponse.results)
    }


    private fun showGenericError(redditResponse: Any) {
        Toast.makeText(getApplication(), redditResponse.toString(), Toast.LENGTH_SHORT).show()

    }

    private fun showNetworkError() {
        Toast.makeText(getApplication(), "network error", Toast.LENGTH_SHORT).show()
    }
}

