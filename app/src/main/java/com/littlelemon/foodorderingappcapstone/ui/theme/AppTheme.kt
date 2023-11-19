package com.littlelemon.foodorderingappcapstone.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.littlelemon.foodorderingappcapstone.R

data class AppColors(
    val primaryGreen : Color = Color(0xFF495E57),
    val primaryYellow : Color = Color(0xFFF4CE14),
    val secondaryDarkPeach : Color = Color(0xFFEE9972),
    val secondaryLightPeach : Color = Color(0xFFFBDABB),
    val highlightWhite : Color = Color(0xFFEDEFEE),
    val highlightGrey : Color = Color(0xFF333333),
    val black: Color = Color(0xFF000000)
)

internal val LocalColors = staticCompositionLocalOf { AppColors() }

private val karla = FontFamily(
    Font(R.font.karla_regular, FontWeight.Normal)
)

private val markazi = FontFamily(
    Font(R.font.markazi_text_regular, FontWeight.Normal)
)

data class AppTypography(
    val mainHead : TextStyle = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    ),
    val subHead : TextStyle = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    val leadText : TextStyle = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    val sectionTitle : TextStyle = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    ),
    val sectionCategory : TextStyle = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp
    ),
    val cardTitle : TextStyle = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    val paragraph : TextStyle = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    val highlight : TextStyle = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    val highlight2 : TextStyle = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    val subTitle : TextStyle = TextStyle(
        fontFamily = markazi,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp
    ),
)

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }

object AppTheme{
    val color : AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography : AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}

@Composable
fun AppTheme(
    colors: AppColors = AppTheme.color,
    typography : AppTypography = AppTheme.typography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography
    ) {
        content()
    }
}