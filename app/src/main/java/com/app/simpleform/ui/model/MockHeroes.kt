package com.app.simpleform.ui.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringArrayResource
import com.app.simpleform.R

@Composable
fun createHeroList(): List<Hero> {
    val heroNames = stringArrayResource(id = R.array.hero_names)
    val heroDescriptions = stringArrayResource(id = R.array.hero_descriptions)
    val heroImages = listOf(
        R.drawable.ic_captain_america,
        R.drawable.ic_hulk,
        R.drawable.ic_black_panther,
        R.drawable.ic_spider_man,
        R.drawable.ic_iron_man)

    val heroes: List<Hero> = heroNames.zip(heroDescriptions).zip(heroImages)
    { (name, description), imageRes ->
        Hero(name = name, description = description, imageRes = imageRes)}

    return heroes
}