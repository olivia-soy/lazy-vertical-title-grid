package com.olivia.lazyverticaltitlegrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.olivia.lazyverticaltitlegrid.ui.theme.LazyVerticalTitleGridTheme
import com.olivia.lazyverticaltitlegridlibrary.LazyVerticalTitleGrid
import kotlinx.coroutines.launch

val data: List<Pair<String, List<String>>> = listOf(
    Pair(
        "TITLE1",
        listOf(
            "https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510__340.jpg",
            "https://cdn.pixabay.com/photo/2013/04/03/21/25/flower-100263__340.jpg",
            "https://cdn.pixabay.com/photo/2013/08/20/15/47/poppies-174276__480.jpg",
            "https://cdn.pixabay.com/photo/2017/02/15/13/40/tulips-2068692__480.jpg",
            "https://cdn.pixabay.com/photo/2017/04/23/20/36/tulips-2254970__480.jpg",
            "https://cdn.pixabay.com/photo/2020/07/08/08/07/daisy-5383056__480.jpg",
            "https://cdn.pixabay.com/photo/2016/02/27/06/43/cherry-blossom-tree-1225186__480.jpg",
            "https://cdn.pixabay.com/photo/2021/08/07/19/49/cosmea-6529220__480.jpg",
        )
    ),
    Pair(
        "TITLE2",
        listOf(
            "https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510__340.jpg",
            "https://cdn.pixabay.com/photo/2017/02/15/13/40/tulips-2068692__480.jpg",
            "https://cdn.pixabay.com/photo/2013/04/03/21/25/flower-100263__340.jpg",
            "https://cdn.pixabay.com/photo/2013/08/20/15/47/poppies-174276__480.jpg",
            "https://cdn.pixabay.com/photo/2016/02/27/06/43/cherry-blossom-tree-1225186__480.jpg",
            "https://cdn.pixabay.com/photo/2017/04/23/20/36/tulips-2254970__480.jpg",
            "https://cdn.pixabay.com/photo/2021/08/07/19/49/cosmea-6529220__480.jpg",
            "https://cdn.pixabay.com/photo/2020/07/08/08/07/daisy-5383056__480.jpg",
        )
    ),
    Pair(
        "TITLE3",
        listOf(
            "https://cdn.pixabay.com/photo/2016/02/27/06/43/cherry-blossom-tree-1225186__480.jpg",
            "https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510__340.jpg",
            "https://cdn.pixabay.com/photo/2013/08/20/15/47/poppies-174276__480.jpg",
            "https://cdn.pixabay.com/photo/2017/02/15/13/40/tulips-2068692__480.jpg",
            "https://cdn.pixabay.com/photo/2013/04/03/21/25/flower-100263__340.jpg",
            "https://cdn.pixabay.com/photo/2020/07/08/08/07/daisy-5383056__480.jpg",
            "https://cdn.pixabay.com/photo/2017/04/23/20/36/tulips-2254970__480.jpg",
            "https://cdn.pixabay.com/photo/2021/08/07/19/49/cosmea-6529220__480.jpg",
        )
    ),
    Pair(
        "TITLE4",
        listOf(
            "https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510__340.jpg",
            "https://cdn.pixabay.com/photo/2013/04/03/21/25/flower-100263__340.jpg",
            "https://cdn.pixabay.com/photo/2013/08/20/15/47/poppies-174276__480.jpg",
            "https://cdn.pixabay.com/photo/2017/02/15/13/40/tulips-2068692__480.jpg",
            "https://cdn.pixabay.com/photo/2017/04/23/20/36/tulips-2254970__480.jpg",
            "https://cdn.pixabay.com/photo/2020/07/08/08/07/daisy-5383056__480.jpg",
            "https://cdn.pixabay.com/photo/2016/02/27/06/43/cherry-blossom-tree-1225186__480.jpg",
            "https://cdn.pixabay.com/photo/2021/08/07/19/49/cosmea-6529220__480.jpg",
        )
    ),
    Pair(
        "TITLE5",
        listOf(
            "https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510__340.jpg",
            "https://cdn.pixabay.com/photo/2017/02/15/13/40/tulips-2068692__480.jpg",
            "https://cdn.pixabay.com/photo/2013/04/03/21/25/flower-100263__340.jpg",
            "https://cdn.pixabay.com/photo/2013/08/20/15/47/poppies-174276__480.jpg",
            "https://cdn.pixabay.com/photo/2016/02/27/06/43/cherry-blossom-tree-1225186__480.jpg",
            "https://cdn.pixabay.com/photo/2017/04/23/20/36/tulips-2254970__480.jpg",
            "https://cdn.pixabay.com/photo/2021/08/07/19/49/cosmea-6529220__480.jpg",
            "https://cdn.pixabay.com/photo/2020/07/08/08/07/daisy-5383056__480.jpg",
        )
    ),
    Pair(
        "TITLE6",
        listOf(
            "https://cdn.pixabay.com/photo/2016/02/27/06/43/cherry-blossom-tree-1225186__480.jpg",
            "https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510__340.jpg",
            "https://cdn.pixabay.com/photo/2013/08/20/15/47/poppies-174276__480.jpg",
            "https://cdn.pixabay.com/photo/2017/02/15/13/40/tulips-2068692__480.jpg",
            "https://cdn.pixabay.com/photo/2013/04/03/21/25/flower-100263__340.jpg",
            "https://cdn.pixabay.com/photo/2020/07/08/08/07/daisy-5383056__480.jpg",
            "https://cdn.pixabay.com/photo/2017/04/23/20/36/tulips-2254970__480.jpg",
            "https://cdn.pixabay.com/photo/2021/08/07/19/49/cosmea-6529220__480.jpg",
        )
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyVerticalTitleGridTheme {
                val tabData = listOf(
                    "GridCells.Adaptive",
                    "GridCells.Fixed"
                )

                val pagerState: PagerState = rememberPagerState()
                val coroutineScope = rememberCoroutineScope()
                val tabIndex = pagerState.currentPage

                Column {
                    TabRow(
                        selectedTabIndex = tabIndex,
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        tabData.forEachIndexed { index, text ->
                            Tab(selected = tabIndex == index, onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            }, text = {
                                Text(text = text)
                            })
                        }
                    }
                    HorizontalPager(
                        state = pagerState,
                        count = tabData.size
                    ) { index ->
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            if (index == 0) {
                                // GridCells.Adaptive ver
                                LazyVerticalTitleGridPage(cells = GridCells.Adaptive(100.dp))
                            } else {
                                // GridCells.Fixed ver
                                LazyVerticalTitleGridPage(cells = GridCells.Fixed(4))
                            }
                        }
                    }
                }

            }
        }
    }
}

@Composable
private fun LazyVerticalTitleGridPage(
    cells: GridCells
) {
    LazyVerticalTitleGrid(
        cells = cells,
        title = { title ->
            Text(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                text = title,
                style = MaterialTheme.typography.body1
            )
        },
        content = { content ->
            AsyncImage(
                modifier = Modifier.fillMaxWidth().aspectRatio(1f),
                contentScale = ContentScale.Crop,
                model = content,
                contentDescription = "content"
            )
        },
        data = data,
        header = {  //nullable
            Text(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                text = "HEADER",
                style = MaterialTheme.typography.h6
            )
        }
    )
}
