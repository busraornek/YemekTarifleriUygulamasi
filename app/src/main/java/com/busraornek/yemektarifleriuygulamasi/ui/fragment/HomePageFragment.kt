package com.busraornek.yemektarifleriuygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.busraornek.yemektarifleriuygulamasi.R
import com.busraornek.yemektarifleriuygulamasi.databinding.FragmentHomePageBinding
import com.busraornek.yemektarifleriuygulamasi.ui.adapter.RecipesAdapter
import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.HomePageViewModel
import com.busraornek.yemektarifleriuygulamasi.util.toggle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomePageBinding

   private lateinit var viewModel: HomePageViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page,container,false)
        binding.homePageFragment = this

        binding.homePageToolbar = "Yemek Tarifleri"
       (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome)


       viewModel.uploadRecipe()
      viewModel.recipesList.observe(viewLifecycleOwner){
          val adapter = RecipesAdapter(requireContext(),it,viewModel)
          binding.recyclerView.adapter = adapter

      }
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView

                searchView.setOnQueryTextListener(this@HomePageFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner, Lifecycle.State.RESUMED)


        return binding.root
    }

    fun addRecipe(it:View){
        Navigation.toggle(R.id.action_homePageFragment_to_addRecipeFragment,it)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel :HomePageViewModel by viewModels ()
        viewModel = tempViewModel
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }
    override fun onResume() {
        super.onResume()
        viewModel.uploadRecipe()
    }


}