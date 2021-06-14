package com.slashmobility.seleccion.david.pasache.di.component

import android.app.Application
import com.example.display.di.module.AppModule
import com.example.display.di.module.FragmentBindingModule
import com.slashmobility.seleccion.david.pasache.AppApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = arrayOf(
    AppModule::class,
    FragmentBindingModule::class,
    AndroidSupportInjectionModule::class
))
interface AppComponent: AndroidInjector<AppApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}