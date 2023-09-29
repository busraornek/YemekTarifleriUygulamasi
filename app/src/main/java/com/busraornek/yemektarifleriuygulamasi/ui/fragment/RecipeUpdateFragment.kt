package com.busraornek.yemektarifleriuygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.busraornek.yemektarifleriuygulamasi.R
import com.busraornek.yemektarifleriuygulamasi.databinding.FragmentRecipeUpdateBinding
import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.RecipeUpdateViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.GenericDeclaration

@AndroidEntryPoint
class RecipeUpdateFragment : Fragment() {
    private lateinit var binding:FragmentRecipeUpdateBinding
    private lateinit var view : RecipeUpdateViewModel
    private lateinit var detail:DetailFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipe_update, container, false)
       binding.recipeUpdateFragment = this

        binding.updateRecipesToolbar = "Güncelle"



        val bundle: RecipeUpdateFragmentArgs  by navArgs()
        val foodComing = bundle.recipes
        binding.recipeObj = foodComing
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : RecipeUpdateViewModel by viewModels ()
        view = tempViewModel
    }

    fun buttonUpdate(id: Int, name: String, declaration: String) {
        view.recipeUpdate(id,name,declaration)
       // detail.view.modelGetRecipeDetail(recipeId)

    }



}