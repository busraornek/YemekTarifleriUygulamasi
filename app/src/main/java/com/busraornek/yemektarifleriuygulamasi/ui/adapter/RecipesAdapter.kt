package com.busraornek.yemektarifleriuygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.databinding.HomeCardBinding

import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.HomePageViewModel

class RecipesAdapter(var mContex:Context,
                     var recipesList:List<Recipes>,
                     var view: HomePageViewModel ): RecyclerView.Adapter<RecipesAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(val design:HomeCardBinding) : RecyclerView.ViewHolder(design.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val design = HomeCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardDesignHolder(design)
    }

    override fun getItemCount(): Int {
      return recipesList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val repices = recipesList.get(position)

        holder.design.textViewName.text = "${repices.name}"

      //  holder.design.textView2.setOnClickListener {
        //    Navigation.findNavController(it).navigate(R.id.action_homePageFragment_to_detailFragment)
       // }
    }
}