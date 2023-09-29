package com.busraornek.yemektarifleriuygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.busraornek.yemektarifleriuygulamasi.databinding.FragmentAddRecipeBinding
import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.AddRecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddRecipeFragment : Fragment() {
private lateinit var binding:FragmentAddRecipeBinding
private lateinit var view:AddRecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddRecipeBinding.inflate(inflater,container,false)

        binding.buttonAdd.setOnClickListener{
            view.buttonAdd(binding.editTextFoodName.text.toString(), binding.editTextRecipe.text.toString())
            val gecis = AddRecipeFragmentDirections.actionAddRecipeFragmentToHomePageFragment()
            Navigation.findNavController(it).navigate(gecis)
            Toast.makeText(context,"Tarif Eklendi", Toast.LENGTH_SHORT).show()}

        binding.viewModel = view
        binding.addRecipesToolbar = "Yemek Kayıt"
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AddRecipeViewModel by viewModels ()
        view = tempViewModel
    }

}