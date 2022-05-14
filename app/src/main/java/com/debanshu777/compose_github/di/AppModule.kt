package com.debanshu777.compose_github.di

import android.content.Context
import android.util.Log
import com.debanshu777.compose_github.GithubDatatbase
import com.debanshu777.compose_github.network.dataSource.local.DeveloperDataSource
import com.debanshu777.compose_github.network.dataSource.local.DeveloperDataSourceImpl
import com.debanshu777.compose_github.network.dataSource.local.RepositoryDataSource
import com.debanshu777.compose_github.network.dataSource.local.RepositoryDataSourceImpl
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    @Singleton
    fun providesSqlDriver(@ApplicationContext context: Context): SqlDriver {
        return AndroidSqliteDriver(
            schema = GithubDatatbase.Schema,
            context = context,
            name = "github.db"
        )
    }

    @Provides
    @Singleton
    fun provideRepositoryDataSource(driver: SqlDriver): RepositoryDataSource {
        return RepositoryDataSourceImpl(GithubDatatbase(driver))
    }

    @Provides
    @Singleton
    fun provideDeveloperDataSource(driver: SqlDriver): DeveloperDataSource {
        return DeveloperDataSourceImpl(GithubDatatbase(driver))
    }

    @Provides
    fun provideKtorAPIClient(): HttpClient {
        val json = kotlinx.serialization.json.Json {
            encodeDefaults = true
            ignoreUnknownKeys = true
            isLenient = true
        }
        return HttpClient(Android) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(json)
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.d("Network Message", "log: $message")
                    }
                }
                level = LogLevel.ALL
            }
            install(HttpTimeout) {
                socketTimeoutMillis = 30_0000
                requestTimeoutMillis = 30_0000
                connectTimeoutMillis = 30_0000
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }
    }
}
