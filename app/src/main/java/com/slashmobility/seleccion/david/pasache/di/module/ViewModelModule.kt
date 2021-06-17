package com.example.display.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.brastlewark.ui.utility.factory.ViewModelFactory
import com.slashmobility.seleccion.david.pasache.di.key.ViewModelKey
import com.slashmobility.seleccion.david.pasache.ui.viewmodel.DetailViewModel
import com.slashmobility.seleccion.david.pasache.ui.viewmodel.FavoritesViewModel
import com.slashmobility.seleccion.david.pasache.ui.viewmodel.ImagesViewModel
import com.slashmobility.seleccion.david.pasache.ui.viewmodel.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = arrayOf(RepositoryModule::class))
abstract class ViewModelModule {

    @Binds
    abstract fun binViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoritesViewModel::class)
    abstract fun bindFavoritesViewModel(favoritesViewModel: FavoritesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ImagesViewModel::class)
    abstract fun bindImagesViewModel(imagesViewModel: ImagesViewModel): ViewModel

}