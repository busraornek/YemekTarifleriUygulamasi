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
    val args: DetailFragmentArgs by navArgs()
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

        val recipeId = args.recipeId
        view.modelGetRecipeDetail(recipeId)//Recipe type

        view.recipeDetail.observe(viewLifecycleOwner){

           // binding.textViewName.text= recipeDetail.name
          //  binding.textViewRecipe.text= recipeDetail.description
            it.let {
                binding.recipeObj = it

            }


        }
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       val tempViewModel : DetailViewModel by viewModels ()
       view = tempViewModel
   }


}