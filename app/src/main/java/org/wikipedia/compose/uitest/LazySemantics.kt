package org.wikipedia.compose.uitest

import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.semantics

val LazyListItemPositionSemantics = SemanticsPropertyKey<Int>("LazyListItemPosition")
var SemanticsPropertyReceiver.lazyListItemPosition by LazyListItemPositionSemantics

fun Modifier.lazyListItemPosition(position: Int) = semantics { lazyListItemPosition = position }

val LazyListSizeSemantics = SemanticsPropertyKey<Int>("LazyListSize")
var SemanticsPropertyReceiver.lazyListSize by LazyListSizeSemantics

fun Modifier.lazyListSize(size: Int) = semantics { lazyListSize = size }