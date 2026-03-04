package edu.ucne.joseph_camilo_ap2_p2.domain.repository

import edu.ucne.joseph_camilo_ap2_p2.data.remote.Resource

interface CharacterRepository {
    suspend fun getCharacters(
        page: Int,
        limit: Int,
        name: String?,
        gender: String?,
        race: String?,
    ): Resource<List<Character>>
    suspend fun getCharacterDetail(id: Int): Resource<Character>
}
