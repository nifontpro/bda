package ru.nb.bds.auth.presenter.login

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

fun buildClickableText(
    text: String, // The full text including the specific text
    clickableText: String, // The specific text you want to be clickable
    style: SpanStyle,
    tag: String,
    onClick: ((link: LinkAnnotation) -> Unit)? = null
): AnnotatedString {
    return buildAnnotatedString {
        val startIndex = text.indexOf(clickableText)
        val endIndex = startIndex + clickableText.length

        withStyle(style = style) { append(text) }
        addLink(
            LinkAnnotation.Clickable(
                tag = tag,
                styles = TextLinkStyles(
                    style = style.copy(/* update as needed */)
                ),
                linkInteractionListener = onClick
            ),
            startIndex,
            endIndex
        )
    }
}