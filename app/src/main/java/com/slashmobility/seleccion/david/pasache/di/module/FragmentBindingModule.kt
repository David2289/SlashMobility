package com.example.display.di.module

import com.slashmobility.seleccion.david.pasache.ui.fragment.DetailFragment
import com.slashmobility.seleccion.david.pasache.ui.fragment.FavoritesFragment
import com.slashmobility.seleccion.david.pasache.ui.fragment.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    abstract fun bindListFragment(): ListFragment

    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    abstract fun bindDetailFragment(): DetailFragment

    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    abstract fun bindFavoritesFragment(): FavoritesFragment

}