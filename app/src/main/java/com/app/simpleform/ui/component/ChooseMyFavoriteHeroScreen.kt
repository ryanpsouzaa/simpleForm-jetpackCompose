package com.app.simpleform.ui.component

import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.simpleform.R
import com.app.simpleform.ui.model.Hero
import com.app.simpleform.ui.model.createHeroList
import com.app.simpleform.ui.theme.SimpleFormTheme

@Composable
fun ChooseMyFavoriteHeroScreen(modifier: Modifier = Modifier) {
    val heroSelectedIndex = rememberSaveable { mutableIntStateOf(-1) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text = "Escolha seu herói favorito",
            style = MaterialTheme.typography.bodyLarge)
        HorizontalDivider(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp))
        ChooseHeroList(
            heroes = createHeroList(),
            heroSelectedIndex = heroSelectedIndex.value,
            onSelectedHero = { index, selectedHero ->
                heroSelectedIndex.value = index
                //dispara uma acao qualquer...
             }
        )
    }
}

@Composable
fun ChooseHeroList(
    modifier: Modifier = Modifier,
    heroes: List<Hero>,
    heroSelectedIndex: Int ,
    onSelectedHero: (index: Int, selectedHero: Hero) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        itemsIndexed(items = heroes, key ={ index, hero -> hero.hashCode() }){
            index, hero ->
            CardHero(
                modifier = modifier,
                hero = hero,
                isSelected = heroSelectedIndex == index,
                onClick = {
                    onSelectedHero(index, hero)
                }
            )
        }
    }
//    heroes.forEachIndexed { index, hero ->
//        CardHero(hero,
//            isSelected = heroSelectedIndex == index,
//            onClick = {
//                onSelectedHero(index, hero)
//            })
//    }
}

@Composable
fun CardHero(hero: Hero, modifier: Modifier = Modifier, isSelected: Boolean, onClick: () -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = isSelected,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red
                ),
                onClick = onClick
            )
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(CircleShape)
                    .size(64.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(
                    id = hero.imageRes,
                ),
                contentDescription = null
            )
            Column {
                Text(text = hero.name, style = MaterialTheme.typography.bodyLarge)
                Text(text = hero.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChooseMyFavoriteHeroScreenPreview() {
    SimpleFormTheme {
        ChooseMyFavoriteHeroScreen()
    }
}

@Preview(showBackground = true)
@Composable
private fun CardHeroPreview() {
    CardHero(createHeroList()[0], isSelected = true, onClick = {})
}