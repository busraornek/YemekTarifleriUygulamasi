package com.busraornek.yemektarifleriuygulamasi.ui.fragment

import android.os.Bundle
import android.provider.ContactsContract.RawContacts.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.busraornek.yemektarifleriuygulamasi.R
import com.busraornek.yemektarifleriuygulamasi.databinding.FragmentDetailBinding
import com.busraornek.yemektarifleriuygulamasi.databinding.FragmentHomePageBinding
import com.busraornek.yemektarifleriuygulamasi.ui.adapter.RecipesAdapter
import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.DetailViewModel
import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var view:DetailViewModel
  //  private lateinit var adapter: RecipesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)

        binding.detailRecipesToolbar = "Yemek Tarifi"

        val bundle: DetailFragmentArgs  by navArgs()
        val foodComing = bundle.repices
        binding.recipeObj = foodComing

         */
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        binding.detailRecipesToolbar = "Yemek Tarifi"
        val bundle: DetailFragmentArgs by navArgs()
        val getRecipe = bundle.recipeId

        val recipeId = getRecipe
        view.modelGetRecipeDetail(recipeId)

        view.recipeDetail.observe(viewLifecycleOwner){ recipeDetail->//Recipe type
            binding.textViewName.text= recipeDetail.name
            binding.textViewRecipe.text= recipeDetail.description

        }
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       val tempViewModel : DetailViewModel by viewModels ()
       view = tempViewModel
   }


}