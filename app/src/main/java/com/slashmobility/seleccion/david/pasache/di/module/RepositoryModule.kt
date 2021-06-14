package com.example.display.di.module

import com.slashmobility.seleccion.david.pasache.business.datasource.GroupLocalDataSource
import com.slashmobility.seleccion.david.pasache.business.datasource.GroupRemoteDataSource
import com.slashmobility.seleccion.david.pasache.business.repository.GroupRepository
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(DataSourceModule::class))
class RepositoryModule {

    @Provides
    fun provideGroupRepository(remoteDataSource: GroupRemoteDataSource,
                               localDataSource: GroupLocalDataSource
    ): GroupRepository {
        return GroupRepository(remoteDataSource, localDataSource)
    }

}