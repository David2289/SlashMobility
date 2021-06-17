package com.slashmobility.seleccion.david.pasache.di.module

import com.example.display.di.module.ViewModelModule
import com.slashmobility.seleccion.david.pasache.ui.activity.ImagesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(ViewModelModule::class))
    abstract fun bindImagesActivity(): ImagesActivity

}