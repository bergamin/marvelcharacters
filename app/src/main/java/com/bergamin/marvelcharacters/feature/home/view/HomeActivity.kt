package com.bergamin.marvelcharacters.feature.home.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.bergamin.marvelcharacters.MarvelApplication
import com.bergamin.marvelcharacters.R
import com.bergamin.marvelcharacters.databinding.ActivityHomeBinding
import com.bergamin.marvelcharacters.di.ViewModelFactory
import com.bergamin.marvelcharacters.domain.model.Character
import com.bergamin.marvelcharacters.feature.home.viewmodel.HomeViewModel
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: HomeViewModel
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        setupBinding()
        setupViewModel()
        setSupportActionBar(binding.homeToolbar)
    }

    private fun setupViewModel() {
        viewModel.liveDataMediator.observe(this, Observer { characters ->
            (binding.charactersRecyclerview.adapter as? CharactersAdapter)?.let {
                it.items = characters
                it.listener = object : CharactersAdapterListener {
                    override fun didSelectCharacter(character: Character) {
                    }
                }
            }
        })
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.viewModel = viewModel
        binding.charactersRecyclerview.layoutManager = GridLayoutManager(this, 2)
        binding.charactersRecyclerview.adapter = CharactersAdapter()
    }

    private fun inject() {
        MarvelApplication.appComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        (menu?.findItem(R.id.menu_search)?.actionView as? SearchView)?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                viewModel.searchCharacter(text ?: "")
                return true
            }
        })
        return true
    }
}
