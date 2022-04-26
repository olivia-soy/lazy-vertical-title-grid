package com.olivia.lazyverticaltitlegridlibrary

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlin.math.ceil

/**
 * # LazyVerticalTitleGrid
 * # LazyVerticalGrid with Title
 * @author LEESOYOUNG
 * @since 2022-04-25
 */

/**
 * @param cells LazyVerticalTitleGrid [GridCells]
 * @param modifier LazyVerticalTitleGrid modifier
 * @param header LazyVerticalTitleGrid header composable
 * @param title LazyVerticalTitleGrid title composable
 * @param content LazyVerticalTitleGrid content composable
 * @param data LazyVerticalTitleGrid data List<Pair<[title], List<[content]>>
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T, T2> LazyVerticalTitleGrid(
    cells: GridCells,
    modifier: Modifier = Modifier,
    header: (@Composable () -> Unit)? = null,
    title: @Composable LazyItemScope.(titleData: T) -> Unit,
    content: @Composable BoxScope.(contentData: T2) -> Unit,
    data: List<Pair<T, List<T2>>>
) {
    BoxWithConstraints(
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            /**
             * [header] composable
             */
            header?.let {
                item {
                    header()
                }
            }

            data.forEach {
                /**
                 * [title] Composable
                 */
                item {
                    title(it.first)
                }
                var columns = 0
                var rows = 0
                //cells Type 에 따라 column 개수와 row 개수 계산
                when (cells) {
                    is GridCells.Fixed -> {
                        /**
                         * [GridCells.Fixed] 의 경우
                         * 열(Column) 의 개수는 [cells.count] 의 개수와 같다
                         * 행(row) 의 개수는 grid 영역에 들어가는 list size 를  열로 나눈 값과 같다
                         * 이 때, 소수점 출력을 위해 toDouble 사용 && 올림 적용 한다
                         */
                        columns = cells.count
                        rows = ceil(it.second.size / columns.toDouble()).toInt()
                    }
                    is GridCells.Adaptive -> {
                        /**
                         * [GridCells.Adaptive] 의 경우
                         * 열(Column) 의 개수는 전체 화면의 maxWidth 를 [cells.minSize] 로 나눈 값과 같다
                         * 행(row) 의 개수는 LazyVerticalGrid GridCells.Adaptive 의 계산식 참고
                         */
                        columns = maxOf((maxWidth / cells.minSize).toInt(), 1)
                        rows = (it.second.size + columns - 1) / columns
                    }
                }

                items(rows) { row ->
                    Row(Modifier.fillParentMaxWidth()) {
                        for (columnIndex in 0 until columns) {
                            val itemIndex = row * columns + columnIndex
                            if (itemIndex < it.second.size) {
                                Box(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    /**
                                     * [content] Composable
                                     */
                                    content(it.second[itemIndex])
                                }
                            } else {
                                //여백 설정
                                Spacer(Modifier.weight(1f))
                            }
                        }
                    }
                }
            }
        }
    }
}