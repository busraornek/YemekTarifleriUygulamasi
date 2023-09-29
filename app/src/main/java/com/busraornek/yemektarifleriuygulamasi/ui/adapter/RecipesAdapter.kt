package com.busraornek.yemektarifleriuygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.busraornek.yemektarifleriuygulamasi.R
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.databinding.HomeCardBinding
import com.busraornek.yemektarifleriuygulamasi.ui.fragment.HomePageFragmentDirections
import com.busraornek.yemektarifleriuygulamasi.ui.fragment.RecipeUpdateFragmentDirections
import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.HomePageViewModel
import com.busraornek.yemektarifleriuygulamasi.util.toggle
import com.google.android.material.snackbar.Snackbar

class RecipesAdapter(var mContex:Context,
                     var recipesList:List<Recipes>,
                     var view: HomePageViewModel ): RecyclerView.Adapter<RecipesAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(val design:HomeCardBinding) : RecyclerView.ViewHolder(design.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContex)

        val design: HomeCardBinding = DataBindingUtil.inflate(layoutInflater,R.layout.home_card,parent,false)
        return CardDesignHolder(design)
    }

    override fun getItemCount(): Int {
      return recipesList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val repices = recipesList.get(position)

          holder.design.recipeObj= repices


        holder.design.goToDetail.setOnClickListener {
            Log.e ("Recipe Adapter", "satırCard tıklandı")
            Log.e("detay","${repices.description} - ${repices.name} - ${repices.id} ")
            val passing = HomePageFragmentDirections.actionHomePageFragmentToDetailFragment(recipeId = repices.id)
            Navigation.toggle(it,passing)
            Log.e("detay","${repices.description} - ${repices.name} ")
        }

        holder.design.imageViewUpdate.setOnClickListener {
            Log.e("Liste","${repices.name} - ${repices.id}-${repices.description}-${repices.id}" )
/*
            val passing = HomePageFragmentDirections.actionHomePageFragmentToRecipeUpdateFragment(recipes = repices)
            Navigation.toggle(it,passing)

 */


        }








    }
}



