package com.busraornek.yemektarifleriuygulamasi.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.toggle(id:Int, it: View){
    findNavController(it).navigate(id)
}
fun Navigation.toggle(it: View, id:NavDirections){
    findNavController(it).navigate(id)
}