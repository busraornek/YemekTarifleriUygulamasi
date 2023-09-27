package com.busraornek.yemektarifleriuygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.busraornek.yemektarifleriuygulamasi.databinding.FragmentHomePageBinding
import com.busraornek.yemektarifleriuygulamasi.ui.adapter.RecipesAdapter
import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding

   private lateinit var viewModel: HomePageViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentHomePageBinding.inflate(inflater)





        binding.toolbarHome.title = "Yemek Tarifleri"
       (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome)


       viewModel.uploadRecipe()
      viewModel.recipesList.observe(viewLifecycleOwner){
          val adapter = RecipesAdapter(requireContext(),it,viewModel)
          binding.recyclerView.adapter = adapter

      }



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel :HomePageViewModel by viewModels ()
        viewModel = tempViewModel
    }




}