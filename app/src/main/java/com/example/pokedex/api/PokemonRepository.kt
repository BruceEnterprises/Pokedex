package com.example.pokedex.api

import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val service: PokemonService
) {

    suspend fun listPokemons(limit: Int = 100) = service.listPokemons(limit)

    suspend fun getPokemons(number: Int) = service.getPokemon(number)

}
