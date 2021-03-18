package com.example.moviesapp.ui.popular_movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMovieListBinding


import org.koin.android.viewmodel.ext.android.viewModel


class PopularMoviesFragment : Fragment() {
    private lateinit var fragmentMovieListBinding: FragmentMovieListBinding
    private val popularMoviesViewModel: PopularMoviesViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().setTitle(R.string.popular_movies)
        fragmentMovieListBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)
        fragmentMovieListBinding.viewmodel = popularMoviesViewModel
        initRecycleView()
        popularMoviesViewModel.getMoviesData()
        return fragmentMovieListBinding.root
    }


    private fun initRecycleView() {
        val adapter = PopularMoviesAdapter()
        val layoutManager =
                 GridLayoutManager(requireContext(), 2)

        adapter.setHasStableIds(true)
        fragmentMovieListBinding.rvUpcomingMovies.layoutManager = layoutManager
        fragmentMovieListBinding.rvUpcomingMovies.adapter = adapter

    }

}
