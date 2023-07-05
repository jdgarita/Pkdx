package com.jd.pkdx.presentation.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

internal val Female: ImageVector
    get() {
        if (_female != null) {
            return _female!!
        }
        _female = Builder(
            name = "Female", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1.5f, strokeLineCap = Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = EvenOdd
            ) {
                moveTo(7.0f, 9.9417f)
                curveTo(7.0014f, 8.9644f, 7.295f, 8.0099f, 7.843f, 7.2007f)
                curveTo(8.3945f, 6.3845f, 9.1753f, 5.7498f, 10.087f, 5.3767f)
                curveTo(11.9541f, 4.6117f, 14.0974f, 5.033f, 15.536f, 6.4477f)
                curveTo(16.5916f, 7.4896f, 17.1196f, 8.9529f, 16.9724f, 10.4288f)
                curveTo(16.8252f, 11.9047f, 16.0186f, 13.2349f, 14.778f, 14.0477f)
                curveTo(13.9477f, 14.571f, 12.9812f, 14.8372f, 12.0f, 14.8127f)
                curveTo(10.6855f, 14.84f, 9.4138f, 14.3448f, 8.464f, 13.4357f)
                curveTo(7.5285f, 12.5137f, 7.0012f, 11.2553f, 7.0f, 9.9417f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(12.75f, 14.8127f)
                curveTo(12.75f, 14.3985f, 12.4142f, 14.0627f, 12.0f, 14.0627f)
                curveTo(11.5858f, 14.0627f, 11.25f, 14.3985f, 11.25f, 14.8127f)
                horizontalLineTo(12.75f)
                close()
                moveTo(11.25f, 17.0007f)
                curveTo(11.25f, 17.415f, 11.5858f, 17.7507f, 12.0f, 17.7507f)
                curveTo(12.4142f, 17.7507f, 12.75f, 17.415f, 12.75f, 17.0007f)
                horizontalLineTo(11.25f)
                close()
                moveTo(14.0f, 17.7507f)
                curveTo(14.4142f, 17.7507f, 14.75f, 17.415f, 14.75f, 17.0007f)
                curveTo(14.75f, 16.5865f, 14.4142f, 16.2507f, 14.0f, 16.2507f)
                verticalLineTo(17.7507f)
                close()
                moveTo(12.0f, 16.2507f)
                curveTo(11.5858f, 16.2507f, 11.25f, 16.5865f, 11.25f, 17.0007f)
                curveTo(11.25f, 17.415f, 11.5858f, 17.7507f, 12.0f, 17.7507f)
                verticalLineTo(16.2507f)
                close()
                moveTo(11.25f, 19.0007f)
                curveTo(11.25f, 19.415f, 11.5858f, 19.7507f, 12.0f, 19.7507f)
                curveTo(12.4142f, 19.7507f, 12.75f, 19.415f, 12.75f, 19.0007f)
                horizontalLineTo(11.25f)
                close()
                moveTo(12.75f, 17.0007f)
                curveTo(12.75f, 16.5865f, 12.4142f, 16.2507f, 12.0f, 16.2507f)
                curveTo(11.5858f, 16.2507f, 11.25f, 16.5865f, 11.25f, 17.0007f)
                horizontalLineTo(12.75f)
                close()
                moveTo(12.0f, 17.7507f)
                curveTo(12.4142f, 17.7507f, 12.75f, 17.415f, 12.75f, 17.0007f)
                curveTo(12.75f, 16.5865f, 12.4142f, 16.2507f, 12.0f, 16.2507f)
                verticalLineTo(17.7507f)
                close()
                moveTo(10.0f, 16.2507f)
                curveTo(9.5858f, 16.2507f, 9.25f, 16.5865f, 9.25f, 17.0007f)
                curveTo(9.25f, 17.415f, 9.5858f, 17.7507f, 10.0f, 17.7507f)
                verticalLineTo(16.2507f)
                close()
                moveTo(11.25f, 14.8127f)
                verticalLineTo(17.0007f)
                horizontalLineTo(12.75f)
                verticalLineTo(14.8127f)
                horizontalLineTo(11.25f)
                close()
                moveTo(14.0f, 16.2507f)
                horizontalLineTo(12.0f)
                verticalLineTo(17.7507f)
                horizontalLineTo(14.0f)
                verticalLineTo(16.2507f)
                close()
                moveTo(12.75f, 19.0007f)
                verticalLineTo(17.0007f)
                horizontalLineTo(11.25f)
                verticalLineTo(19.0007f)
                horizontalLineTo(12.75f)
                close()
                moveTo(12.0f, 16.2507f)
                horizontalLineTo(10.0f)
                verticalLineTo(17.7507f)
                horizontalLineTo(12.0f)
                verticalLineTo(16.2507f)
                close()
            }
        }
            .build()
        return _female!!
    }

private var _female: ImageVector? = null
