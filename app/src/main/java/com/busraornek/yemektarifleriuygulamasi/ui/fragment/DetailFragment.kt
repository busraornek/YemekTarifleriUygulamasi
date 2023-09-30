package com.busraornek.yemektarifleriuygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.databinding.FragmentDetailBinding
import com.busraornek.yemektarifleriuygulamasi.databinding.RecipeUpdateDialogBinding
import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var view: DetailViewModel
    private val args: DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val tempViewModel: DetailViewModel by viewModels()
        view = tempViewModel
        val recipeId = args.recipeId
        viewLifecycleOwner.lifecycleScope.launch {
            view.recipeDetail(recipeId)
        }
        view.recipeDetail.observe(viewLifecycleOwner) { recipe ->
            binding.textViewName.text = recipe?.recipe?.name
            binding.textViewRecipe.text = recipe?.recipe?.description
        }
        binding.button.setOnClickListener {
            view.recipeDetail.value?.let { it1 -> alertShow(recipe = it1.recipe) }
        }
        return binding.root
    }
    fun alertShow(recipe: Recipes) {
        val bindingDialog = RecipeUpdateDialogBinding.inflate(LayoutInflater.from(this.context))
        bindingDialog.editTextRecipeName.setText(recipe.name)
        bindingDialog.editTextRecipeDescription.setText(recipe.description)
        val dialog = this.context?.let { AlertDialog.Builder(it) }
        dialog?.setTitle("Tarif Güncelle")
        dialog?.setView(bindingDialog.root)
        dialog?.setPositiveButton("Güncelle") { dialogInterface, i ->
            val name = bindingDialog.editTextRecipeName.text.toString()
            val description = bindingDialog.editTextRecipeDescription.text.toString()
            //güncelleme
            viewLifecycleOwner.lifecycleScope.launch {
                view.recipeUpdate(
                    Recipes(
                        id = recipe.id,
                        name = name,
                        description = description
                    )
                )
            }
            Toast.makeText(this.context, "$name güncellendi.", Toast.LENGTH_SHORT).show()
        }
        dialog?.setNegativeButton("İptal") { dialogInterface, i ->
        }
        dialog?.create()?.show()
    }
}