package com.jd.pkdx.presentation.shared

import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import com.jd.pkdx.presentation.animations.LinearMotionFactory
import com.jd.pkdx.presentation.animations.PathMotionFactory
import com.jd.pkdx.presentation.animations.ProgressThresholds

open class SharedElementsTransitionSpec(
    val pathMotionFactory: PathMotionFactory = LinearMotionFactory,
    /**
     * Frames to wait for before starting transition. Useful when the frame skip caused by
     * rendering the new screen makes the animation not smooth.
     */
    val waitForFrames: Int = 1,
    val durationMillis: Int = AnimationConstants.DefaultDurationMillis,
    val delayMillis: Int = 0,
    val easing: Easing = FastOutSlowInEasing,
    val direction: TransitionDirection = TransitionDirection.Auto,
    val fadeMode: FadeMode = FadeMode.Cross,
    val fadeProgressThresholds: ProgressThresholds? = null,
    val scaleProgressThresholds: ProgressThresholds? = null,
)

val DefaultSharedElementsTransitionSpec = SharedElementsTransitionSpec()