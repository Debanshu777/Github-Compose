package com.debanshu777.compose_github.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideKtorAPIClient():HttpClient{
        val json = kotlinx.serialization.json.Json {
            encodeDefaults = true
            ignoreUnknownKeys = true
        }
       return HttpClient(Android){
            install(JsonFeature){
                serializer = KotlinxSerializer(json)
            }
            install(Logging){
                logger= object : Logger {
                    override fun log(message: String) {
                        Log.d("Network Message","log: $message")
                    }
                }
                level= LogLevel.ALL
            }
            install(HttpTimeout){
                socketTimeoutMillis=30_000
                requestTimeoutMillis=30_000
                connectTimeoutMillis=30_000
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }
    }
}