package edu.ucne.joseph_camilo_ap2_p2.di

import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.joseph_camilo_ap2_p2.data.remote.DragonBallApi
import edu.ucne.joseph_camilo_ap2_p2.domain.repository.CharacterRepository
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    @Provides
    @Singleton
    fun provideApi(moshi: Moshi): DragonBallApi {
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl("https://dragonball-api.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
//.addConverterFactory(json.asConverterFactory("application/jso
            .build()
            .create(DragonBallApi::class.java)
    }
    @Provides
    @Singleton
    fun provideRepository(api: DragonBallApi): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }
}