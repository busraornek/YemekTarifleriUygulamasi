package com.busraornek.yemektarifleriuygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.busraornek.yemektarifleriuygulamasi.R
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.databinding.HomeCardBinding

import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.HomePageViewModel

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

       holder.design.selectedRecipe = repices




    }
}