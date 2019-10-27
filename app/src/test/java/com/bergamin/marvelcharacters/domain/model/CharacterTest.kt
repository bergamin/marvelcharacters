package com.bergamin.marvelcharacters.domain.model

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CharacterTest {

    @Test
    fun parcelTest() {
        ParcelableTester.assertParcelable(character, Character)
    }

    private val character by lazy {
        Character(
            "1009610",
            "Spider-Man",
            "Bitten by a radioactive spider, high school student Peter Parker gained the speed, strength and powers of a spider. Adopting the name Spider-Man, Peter hoped to start a career using his new abilities. Taught that with great power comes great responsibility, Spidey has vowed to use his powers to help people.",
            "http://i.annihil.us/u/prod/marvel/i/mg/3/50/526548a343e4b.jpg"
        )
    }
}
