package com.feature.tracker.presentation.overview.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.artemissoftware.core_ui.LocalSpacing
import com.feature.tracker.domain.model.TrackedFood
import com.feature.tracker.presentation.components.NutrientInfo
import core.R as CoreR

@ExperimentalCoilApi
@Composable
fun TrackedFoodItem(
    trackedFood: TrackedFood,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .padding(spacing.spaceExtraSmall)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(5.dp),
            )
            .background(MaterialTheme.colorScheme.surface)
            .padding(end = spacing.spaceMedium)
            .height(100.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = rememberImagePainter(
                data = trackedFood.imageUrl,
                builder = {
                    crossfade(true)
                    error(CoreR.drawable.ic_burger)
                    fallback(CoreR.drawable.ic_burger)
                },
            ),
            contentDescription = trackedFood.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(
                    RoundedCornerShape(
                        topStart = 5.dp,
                        bottomStart = 5.dp,
                    ),
                ),
        )
        Spacer(modifier = Modifier.width(spacing.spaceMedium))
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = trackedFood.name,
                style = MaterialTheme.typography.titleLarge /*body1*/,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
            Text(
                text = stringResource(
                    id = CoreR.string.nutrient_info,
                    trackedFood.amount,
                    trackedFood.calories,
                ),
                style = MaterialTheme.typography.titleMedium, /*body2*/
            )
        }
        Spacer(modifier = Modifier.width(spacing.spaceMedium))
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = stringResource(id = CoreR.string.delete),
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { onDeleteClick() },
            )
            Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                NutrientInfo(
                    name = stringResource(id = CoreR.string.carbs),
                    amount = trackedFood.carbs,
                    unit = stringResource(id = CoreR.string.grams),
                    amountTextSize = 16.sp,
                    unitTextSize = 12.sp,
                    nameTextStyle = MaterialTheme.typography.titleMedium, /*body2*/
                )
                Spacer(modifier = Modifier.width(spacing.spaceSmall))
                NutrientInfo(
                    name = stringResource(id = CoreR.string.protein),
                    amount = trackedFood.protein,
                    unit = stringResource(id = CoreR.string.grams),
                    amountTextSize = 16.sp,
                    unitTextSize = 12.sp,
                    nameTextStyle = MaterialTheme.typography.titleMedium, /*body2*/
                )
                Spacer(modifier = Modifier.width(spacing.spaceSmall))
                NutrientInfo(
                    name = stringResource(id = CoreR.string.fat),
                    amount = trackedFood.fat,
                    unit = stringResource(id = CoreR.string.grams),
                    amountTextSize = 16.sp,
                    unitTextSize = 12.sp,
                    nameTextStyle = MaterialTheme.typography.titleMedium, /*body2*/
                )
            }
        }
    }
}
