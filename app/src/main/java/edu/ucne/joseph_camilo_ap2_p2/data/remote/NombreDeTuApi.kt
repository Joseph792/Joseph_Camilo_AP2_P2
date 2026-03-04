package edu.ucne.joseph_camilo_ap2_p2.data.remote

import edu.ucne.joseph_camilo_ap2_p2.domain.model.CharacterDto
import edu.ucne.joseph_camilo_ap2_p2.domain.model.CharacterResponseDto
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DragonBallApi {
    @GET("characters")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("name") name: String?,
        @Query("gender") gender: String?,
        @Query("race") race: String?
    ): Response<CharacterResponseDto>
    @GET("characters/{id}")
    suspend fun getCharacterDetail(
        @Path("id") id: Int
    ): Response<CharacterDto>
}