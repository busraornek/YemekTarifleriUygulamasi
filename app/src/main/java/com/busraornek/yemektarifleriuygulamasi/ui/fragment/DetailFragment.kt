package com.busraornek.yemektarifleriuygulamasi.ui.fragment

import android.os.Bundle
import android.provider.ContactsContract.RawContacts.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.busraornek.yemektarifleriuygulamasi.R
import com.busraornek.yemektarifleriuygulamasi.databinding.FragmentDetailBinding
import com.busraornek.yemektarifleriuygulamasi.databinding.FragmentHomePageBinding
import com.busraornek.yemektarifleriuygulamasi.ui.adapter.RecipesAdapter
import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.DetailViewModel
import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.HomePageViewModel
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
        //binding.detailRecipesToolbar = "Yemek Tarifi"

        val recipeId = args.recipeId

        viewLifecycleOwner.lifecycleScope.launch {
            view.recipeDetail(recipeId)
        }

        view.recipeDetail.observe(viewLifecycleOwner) { recipe ->
            binding.textViewName.text = recipe?.recipe?.name
            binding.textViewRecipe.text = recipe?.recipe?.description
        }
        return binding.root
    }
}