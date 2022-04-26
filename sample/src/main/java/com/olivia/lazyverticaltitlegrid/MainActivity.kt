package com.olivia.lazyverticaltitlegrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.olivia.lazyverticaltitlegrid.ui.theme.LazyVerticalTitleGridTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyVerticalTitleGridTheme {
/*
                // A surface container using the 'background' color from the theme
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
                LazyVerticalTitleGrid(
                    cells = GridCells.Adaptive(100.dp),
                    title = { title ->
                        Text(
                            modifier = Modifier.fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 8.dp),
                            text = title,
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
                        )
                    },
                    content = { content ->
                        AsyncImage(
                            contentScale = ContentScale.Crop,
                            model = content,
                            contentDescription = "content"
                        )
                    },
                    data = data
                )
*/

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyVerticalTitleGridTheme {
        Greeting("Android")
    }
}