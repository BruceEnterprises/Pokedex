package com.example.pokedex.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedex.R
import com.example.pokedex.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_pokedex_home.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokedexHomeFragment : Fragment(R.layout.fragment_pokedex_home) {

    private lateinit var viewModel2: PokemonViewModel

    private val pokemonAdapter by lazy { PokemonAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel2 = ViewModelProvider(this).get(PokemonViewModel::class.java)
        pokemonsObserver()
        loadRecyclerView()
    }

    private fun pokemonsObserver() = lifecycleScope.launch {
        viewModel2.pokemons.observe(
            viewLifecycleOwner,
            Observer {
                pokemonAdapter.pokemons = it
            }
        )
    }

    private fun loadRecyclerView() {
//        this.pokemonAdapter = PokemonAdapter(pokemons) { pokemon ->
//            val actions = PokedexHomeFragmentDirections.actionFirstDestinationToPokedexDetailsFragment(pokemon)
//            findNavController().navigate(actions)
//        }
        pokemon_recycler.layoutManager = GridLayoutManager(context, 2)
        pokemon_recycler.adapter = pokemonAdapter
    }
}
