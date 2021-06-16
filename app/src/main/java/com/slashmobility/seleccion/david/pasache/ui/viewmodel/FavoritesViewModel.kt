package com.slashmobility.seleccion.david.pasache.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.slashmobility.seleccion.david.pasache.business.repository.GroupRepository
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(private val groupRepository: GroupRepository): ViewModel() {
}