package com.bergamin.marvelcharacters.feature.character.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bergamin.marvelcharacters.MarvelApplication
import com.bergamin.marvelcharacters.R
import com.bergamin.marvelcharacters.databinding.ActivityCharacterBinding
import com.bergamin.marvelcharacters.domain.model.Character
import com.bergamin.marvelcharacters.feature.character.viewmodel.CharacterViewModel
import javax.inject.Inject

class CharacterActivity : AppCompatActivity() {

    lateinit var binding: ActivityCharacterBinding
    private val characterArg: Character by lazy { intent.getParcelableExtra<Character>(CHARACTER_ARG) }
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    companion object {
        const val CHARACTER_ARG = "CHARACTER_ARG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        setupBinding()
        setupViewModel()
    }

    private fun setupViewModel() {
        characterArg.id?.let {id ->
            binding.viewModel?.loadData(id)
        }
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_character)
        binding.viewModel = ViewModelProviders.of(this, viewModelFactory)[CharacterViewModel::class.java]
        binding.lifecycleOwner = this
    }

    private fun inject() {
        MarvelApplication.appComponent.inject(this)
    }
}
