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

internal val Male: ImageVector
    get() {
        if (_male != null) {
            return _male!!
        }
        _male = Builder(
            name = "Male", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1.5f, strokeLineCap = Round, strokeLineJoin =
                StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = EvenOdd
            ) {
                moveTo(15.5631f, 16.1199f)
                curveTo(14.871f, 16.81f, 13.9885f, 17.2774f, 13.0288f, 17.462f)
                curveTo(12.0617f, 17.6492f, 11.0607f, 17.5459f, 10.1523f, 17.165f)
                curveTo(8.2911f, 16.3858f, 7.0735f, 14.5723f, 7.0566f, 12.5547f)
                curveTo(7.0468f, 11.0715f, 7.7082f, 9.6635f, 8.8559f, 8.724f)
                curveTo(10.0036f, 7.7845f, 11.5145f, 7.4142f, 12.9666f, 7.7167f)
                curveTo(13.9237f, 7.9338f, 14.7953f, 8.429f, 15.4718f, 9.1401f)
                curveTo(16.4206f, 10.0503f, 16.9696f, 11.2996f, 16.9985f, 12.6141f)
                curveTo(17.008f, 13.9276f, 16.491f, 15.1903f, 15.5631f, 16.1199f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(14.9415f, 8.6098f)
                curveTo(14.6486f, 8.9027f, 14.6486f, 9.3775f, 14.9415f, 9.6704f)
                curveTo(15.2344f, 9.9633f, 15.7093f, 9.9633f, 16.0022f, 9.6704f)
                lineTo(14.9415f, 8.6098f)
                close()
                moveTo(18.9635f, 6.7091f)
                curveTo(19.2564f, 6.4162f, 19.2564f, 5.9413f, 18.9635f, 5.6484f)
                curveTo(18.6706f, 5.3555f, 18.1958f, 5.3555f, 17.9029f, 5.6484f)
                lineTo(18.9635f, 6.7091f)
                close()
                moveTo(16.0944f, 5.4146f)
                curveTo(15.6802f, 5.4121f, 15.3424f, 5.7459f, 15.3399f, 6.1601f)
                curveTo(15.3374f, 6.5743f, 15.6711f, 6.9121f, 16.0853f, 6.9146f)
                lineTo(16.0944f, 5.4146f)
                close()
                moveTo(18.4287f, 6.9287f)
                curveTo(18.8429f, 6.9312f, 19.1807f, 6.5975f, 19.1832f, 6.1833f)
                curveTo(19.1857f, 5.7691f, 18.8519f, 5.4313f, 18.4377f, 5.4288f)
                lineTo(18.4287f, 6.9287f)
                close()
                moveTo(19.1832f, 6.1742f)
                curveTo(19.1807f, 5.76f, 18.8429f, 5.4262f, 18.4287f, 5.4288f)
                curveTo(18.0145f, 5.4313f, 17.6807f, 5.7691f, 17.6832f, 6.1833f)
                lineTo(19.1832f, 6.1742f)
                close()
                moveTo(17.6973f, 8.5266f)
                curveTo(17.6998f, 8.9408f, 18.0377f, 9.2746f, 18.4519f, 9.2721f)
                curveTo(18.8661f, 9.2696f, 19.1998f, 8.9318f, 19.1973f, 8.5176f)
                lineTo(17.6973f, 8.5266f)
                close()
                moveTo(16.0022f, 9.6704f)
                lineTo(18.9635f, 6.7091f)
                lineTo(17.9029f, 5.6484f)
                lineTo(14.9415f, 8.6098f)
                lineTo(16.0022f, 9.6704f)
                close()
                moveTo(16.0853f, 6.9146f)
                lineTo(18.4287f, 6.9287f)
                lineTo(18.4377f, 5.4288f)
                lineTo(16.0944f, 5.4146f)
                lineTo(16.0853f, 6.9146f)
                close()
                moveTo(17.6832f, 6.1833f)
                lineTo(17.6973f, 8.5266f)
                lineTo(19.1973f, 8.5176f)
                lineTo(19.1832f, 6.1742f)
                lineTo(17.6832f, 6.1833f)
                close()
            }
        }
            .build()
        return _male!!
    }

private var _male: ImageVector? = null
