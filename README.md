# lazy-vertical-title-grid

- 1차원 리스트를 데이터로 받는 [LazyVerticalGrid](https://developer.android.com/jetpack/compose/lists#grids) 에서 데이터가 2차원 리스트 이며 각 리스트에 title composable 이 필요한 경우를 생각해 구현한 Custom UI 
    - 이를 LazyVerticalTitleGrid 라 명칭 하였습니다. 
- Based on the Lazy Vertical Grid, which receives one-dimensional lists as data, we implemented a custom UI considering that the data is a two-dimensional list and each list requires a title composable.

## Overview

- LazyVerticalTitleGrid 에 들어가는 data 는 List<Pair<T, List<T2>> 로 전달하며 [T] 는 title Composable 의 데이터 타입이며 [T2] 는 content(grid list) composable 의 데이터 타입이다.
- MaxWidth 값을 가져오기 위해 가장 상단을 [BoxWithConstraints](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/package-summary#BoxWithConstraints(androidx.compose.ui.Modifier,androidx.compose.ui.Alignment,kotlin.Boolean,kotlin.Function1)) 로 감싸고, 
  그 안에 LazyColumn 로 구현 순서대로 Header Composable, Grid Data Composable (title + list) 를 구현 
- LazyVerticalTitleGrid 의 Params

|Params|Type|Description|
|---|---|---|
|cells|[GridCells](https://developer.android.com/reference/kotlin/androidx/compose/foundation/lazy/grid/GridCells)|[LazyVerticalGrid](https://developer.android.com/jetpack/compose/lists#grids) 의 파라미터와 같게 GridCells 옵션 추가|
|modifier|[Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier)|LazyVerticalTitleGrid Modifier 옵션|
|header|(@Composable () -> Unit)? = null|LazyVerticalTitleGrid 의 가장 최상단 header Composable, nullable 하므로 추가는 옵셔널 함|
|title|@Composable LazyItemScope.(titleData: T) -> Unit|LazyVerticalTitleGrid 의 Grid List 의 title Composable, T|
|content|@Composable BoxScope.(contentData: T2) -> Unit|LazyVerticalTitleGrid 의 Grid List 의 content Composable, T2|
|data|List<Pair<T, List<T2>>>|LazyVerticalTitleGrid 에 들어가는 data, T 는 title 의 타입, T2 는 content 의 타입|

## Preview

|GridCells|Screen(Vertical)|Screen(Horizontal)|
|---|---|---|
|GridCells.Adaptive(dp: Dp)|||
|GridCells.Fixed(N)|||

- 전체 동영상

## Usage

Step1.Add the JitPack repository to your build file

a. Arctic Fox 이전 버전 (root: build.gradle)                                                                                                                                                                                                                                                                                     

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

a. Arctic Fox 이후 버전  (setting.gradle)

   	dependencyResolutionManagement { 
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories { 
			...
			maven { url "https://jitpack.io" }
		} 
	}


Step2. Add the dependency 
- ✔ [Latest Version](https://jitpack.io/#olivia-soy/lazy-vertical-title-grid)
```
	dependencies {
	        implementation 'com.github.olivia-soy:lazy-vertical-title-grid:[Latest Version]'
	}
```
Step3. Use "LazyVerticalTitleGrid" Composable 
- ✔ [sample source](sample/src/main/java/com/olivia/lazyverticaltitlegrid/MainActivity.kt)

## Description

- UI
    - [Compose](https://developer.android.com/jetpack/compose) declarative UI framework
    - [Material design](https://material.io/design)
- Tech/Tools
    - [Kotlin](https://kotlinlang.org/) 100% coverage
    - Jetpack
        - [Compose](https://developer.android.com/jetpack/compose)
        - [Coil](https://coil-kt.github.io/coil/compose/) image loader

