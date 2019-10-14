package com.bergamin.marvelcharacters.feature.home.viewmodel

import com.bergamin.marvelcharacters.domain.model.Character

data class CharacterItemViewModel(val character: Character) {
    val name = character.name ?: "No Name"
    val pictureUrl = character.picture ?: "https://us.123rf.com/450wm/apoev/apoev1806/apoev180600171/103284764-stock-vector-default-placeholder-fitness-trainer-in-a-t-shirt-half-length-portrait-photo-avatar-gray-color.jpg"
}
