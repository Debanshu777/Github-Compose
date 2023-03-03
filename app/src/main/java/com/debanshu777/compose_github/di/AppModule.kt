package com.debanshu777.compose_github.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.debanshu777.compose_github.GithubDatatbase
import com.debanshu777.compose_github.network.dataSource.GitHubViewModel
import com.debanshu777.compose_github.network.dataSource.MainRepository
import com.debanshu777.compose_github.network.dataSource.local.DeveloperDataSource
import com.debanshu777.compose_github.network.dataSource.local.DeveloperDataSourceImpl
import com.debanshu777.compose_github.network.dataSource.local.LocalRepository
import com.debanshu777.compose_github.network.dataSource.local.RepositoryDataSource
import com.debanshu777.compose_github.network.dataSource.local.RepositoryDataSourceImpl
import com.debanshu777.compose_github.network.dataSource.remote.RemoteRepository
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = GithubDatatbase.Schema,
            context = androidContext(),
            name = "github.db"
        )
    }
    single<RepositoryDataSource> {
        RepositoryDataSourceImpl(GithubDatatbase(get()))
    }
    single<DeveloperDataSource> {
        DeveloperDataSourceImpl(GithubDatatbase(get()))
    }
    single {
        Json {
            encodeDefaults = true
            ignoreUnknownKeys = true
            isLenient = true
        }
    }
    single {
        RemoteRepository()
    }
    single {
        LocalRepository(get(), get())
    }
    single {
        MainRepository(get(), get())
    }
    viewModel {
        GitHubViewModel(get())
    }
}