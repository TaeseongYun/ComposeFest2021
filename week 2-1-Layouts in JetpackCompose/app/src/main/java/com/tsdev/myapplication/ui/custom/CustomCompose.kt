package com.tsdev.myapplication.ui.custom

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp

//measurable -> 자식 뷰
// constraints -> 자식의 제약 조건 constraints

//부모는 여러 자식을 가지고 있다 하지만 그 자식의 UI 계산은 오로지 한번만 발생하게 된다.
fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        // 자식뷰의 Placeable 값 가져오기
        /***
         * Placeable -> width, height measureWidth, measureHeight 가져올 수 있음.
         ***/
        val placeable = measurable.measure(constraints)

        val firstBaseline = placeable[FirstBaseline]
        //false 일시 익셉션
        check(firstBaseline != AlignmentLine.Unspecified)

        // Height of the composable with padding - first baseline
        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        val height = placeable.height + placeableY
        layout(placeable.width, height) {
            placeable.placeRelative(0, placeableY)

            //placeRelative 를 이용하여 재 배치 해당 함수를 호출하지 않을경우 화면에서 그려지지 않음
        }
    }
)
