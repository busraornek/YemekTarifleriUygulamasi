package com.busraornek.yemektarifleriuygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.busraornek.yemektarifleriuygulamasi.R
import com.busraornek.yemektarifleriuygulamasi.databinding.FragmentDetailBinding
import com.busraornek.yemektarifleriuygulamasi.databinding.FragmentHomePageBinding
import com.busraornek.yemektarifleriuygulamasi.ui.adapter.RecipesAdapter
import com.busraornek.yemektarifleriuygulamasi.ui.viewmodel.HomePageViewModel
import com.busraornek.yemektarifleriuygulamasi.util.toggle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomePageFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var viewModel: HomePageViewModel
    private lateinit var adapter: RecipesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)

        val tempViewModel: HomePageViewModel by viewModels()
        viewModel = tempViewModel
        viewModel.getRecipes()

       // (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome)

        viewModel.recipesList.observe(viewLifecycleOwner) {
            adapter = RecipesAdapter(it.recipes, viewModel)
            binding.recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
        binding.fab.setOnClickListener {
            val passing = HomePageFragmentDirections.actionHomePageFragmentToAddRecipeFragment()
            Navigation.toggle(it, passing)
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

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }

    fun addRecipe(it: View) {
        Navigation.toggle(R.id.action_homePageFragment_to_addRecipeFragment, it)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        viewLifecycleOwner.lifecycleScope.launch {
            if (query != null) {
                viewModel.foodSearch(query)
                viewModel.recipeSearch.observe(viewLifecycleOwner) {
                    adapter = RecipesAdapter(it.recipes, viewModel)
                    binding.recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
            }
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        viewLifecycleOwner.lifecycleScope.launch {
            if (newText != null) {
                viewModel.foodSearch(newText)
                viewModel.recipeSearch.observe(viewLifecycleOwner) {
                    adapter = RecipesAdapter(it.recipes, viewModel)
                    binding.recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
            }
        }
        return true
    }
}