package com.example.tradetransit.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


public val Facebook: ImageVector
    get() {
        if (_Facebook != null) {
            return _Facebook!!
        }
        _Facebook = ImageVector.Builder(
            name = "Facebook",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(16f, 8.049f)
                curveToRelative(0f, -4.446f, -3.582f, -8.05f, -8f, -8.05f)
                curveTo(3.58f, 0f, -0.002f, 3.603f, -0.002f, 8.05f)
                curveToRelative(0f, 4.017f, 2.926f, 7.347f, 6.75f, 7.951f)
                verticalLineToRelative(-5.625f)
                horizontalLineToRelative(-2.03f)
                verticalLineTo(8.05f)
                horizontalLineTo(6.75f)
                verticalLineTo(6.275f)
                curveToRelative(0f, -2.017f, 1.195f, -3.131f, 3.022f, -3.131f)
                curveToRelative(0.876f, 0f, 1.791f, 0.157f, 1.791f, 0.157f)
                verticalLineToRelative(1.98f)
                horizontalLineToRelative(-1.009f)
                curveToRelative(-0.993f, 0f, -1.303f, 0.621f, -1.303f, 1.258f)
                verticalLineToRelative(1.51f)
                horizontalLineToRelative(2.218f)
                lineToRelative(-0.354f, 2.326f)
                horizontalLineTo(9.25f)
                verticalLineTo(16f)
                curveToRelative(3.824f, -0.604f, 6.75f, -3.934f, 6.75f, -7.951f)
            }
        }.build()
        return _Facebook!!
    }


public val Twitter: ImageVector
    get() {
        if (_Twitter != null) {
            return _Twitter!!
        }
        _Twitter = ImageVector.Builder(
            name = "Twitter",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(5.026f, 15f)
                curveToRelative(6.038f, 0f, 9.341f, -5.003f, 9.341f, -9.334f)
                quadToRelative(0.002f, -0.211f, -0.006f, -0.422f)
                arcTo(6.7f, 6.7f, 0f, isMoreThanHalf = false, isPositiveArc = false, 16f, 3.542f)
                arcToRelative(6.7f, 6.7f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.889f, 0.518f)
                arcToRelative(3.3f, 3.3f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.447f, -1.817f)
                arcToRelative(6.5f, 6.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, -2.087f, 0.793f)
                arcTo(3.286f, 3.286f, 0f, isMoreThanHalf = false, isPositiveArc = false, 7.875f, 6.03f)
                arcToRelative(9.32f, 9.32f, 0f, isMoreThanHalf = false, isPositiveArc = true, -6.767f, -3.429f)
                arcToRelative(3.29f, 3.29f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.018f, 4.382f)
                arcTo(3.3f, 3.3f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.64f, 6.575f)
                verticalLineToRelative(0.045f)
                arcToRelative(3.29f, 3.29f, 0f, isMoreThanHalf = false, isPositiveArc = false, 2.632f, 3.218f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.865f, 0.115f)
                arcToRelative(3f, 3f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.614f, -0.057f)
                arcToRelative(3.28f, 3.28f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.067f, 2.277f)
                arcTo(6.6f, 6.6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.78f, 13.58f)
                arcToRelative(6f, 6f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.78f, -0.045f)
                arcTo(9.34f, 9.34f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5.026f, 15f)
            }
        }.build()
        return _Twitter!!
    }

private var _Twitter: ImageVector? = null

private var _Facebook: ImageVector? = null
