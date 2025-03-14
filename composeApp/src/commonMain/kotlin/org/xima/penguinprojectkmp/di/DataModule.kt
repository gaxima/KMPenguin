package org.xima.penguinprojectkmp.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.xima.penguinprojectkmp.data.remote.KtorApiClient
import org.xima.penguinprojectkmp.data.remote.PenguinService
import org.xima.penguinprojectkmp.data.remote.PenguinServiceImpl
import org.xima.penguinprojectkmp.data.repositoryImpl.PenguinRepositoryImpl
import org.xima.penguinprojectkmp.domain.repository.PenguinRepository
import org.xima.penguinprojectkmp.presentation.penguinList.PenguinListViewModel

val dataModules = module {

    single<PenguinRepository> {
        PenguinRepositoryImpl(
            penguinService = get()
        )
    }
    single<PenguinService> {
        PenguinServiceImpl(
            httpClient = KtorApiClient.httpClient
        )
    }
}

val viewModelModules = module {
    viewModel { PenguinListViewModel(get()) }
}

val appModules = listOf(dataModules, viewModelModules)