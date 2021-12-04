package com.codelab.theming.ui.start.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.codelab.theming.R
import com.codelab.theming.data.Post
import java.util.*

@Composable
fun FeaturedPost(
    post: Post,
    modifier: Modifier = Modifier
) {
    Card(modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* onClick */ }
        ) {
            Image(
                painter = painterResource(post.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .heightIn(min = 180.dp)
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            val padding = Modifier.padding(horizontal = 16.dp)
            Text(
                text = post.title,
                style = MaterialTheme.typography.h6,
                modifier = padding
            )
            Text(
                text = post.metadata.author.name,
                style = MaterialTheme.typography.body2,
                modifier = padding
            )
            PostMetadata(post, padding)
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
private fun PostMetadata(
    post: Post,
    modifier: Modifier = Modifier
) {
    val divider = "  •  "
    val tagDivider = "  "
    val text = buildAnnotatedString {
        append(post.metadata.date)
        append(divider)
        append(stringResource(R.string.read_time, post.metadata.readTimeMinutes))
        append(divider)
        val tagStyle = MaterialTheme.typography.overline.toSpanStyle().copy(
            background = MaterialTheme.colors.primary.copy(alpha = 0.1f)
        )
        post.tags.forEachIndexed { index, tag ->
            if (index != 0) {
                append(tagDivider)
            }
            withStyle(tagStyle) {
                append(" ${tag.uppercase(Locale.getDefault())} ")
            }
        }
    }
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            modifier = modifier
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostItem(
    post: Post,
    modifier: Modifier = Modifier
) {
    ListItem(
        modifier = modifier
            .clickable { /* todo */ }
            .padding(vertical = 8.dp),
        icon = {
            Image(
                painter = painterResource(post.imageThumbId),
                contentDescription = null,
                modifier = Modifier.clip(shape = MaterialTheme.shapes.small)
            )
        },
        text = {
            Text(text = post.title)
        },
        secondaryText = {
            PostMetadata(post)
        }
    )
}
