### 요약
네이버 영화 API를 통해 검색 결과를 보여주는 Application

### 필수 구현 기능
- 영화 검색
  - `retrofit`, `rxJava`, `Glide`
- 최근 검색 목록 보기
  - `Room`, `Coroutine`, `LiveData`, `chip`
- 최근 검색 키워드를 이용한 재검색
- `WebView`를 통해 영화 상세보기

### 추가 구현 기능
- 로딩 안내
  - `Lottie`
- 검색어 유효성 검사
- 유효성 검사 테스트 코드
- 네이버 API 토큰값 숨기기
  - `BuildConfig`
- 의존성 주입
  - `Dagger Hilt`
- 디자인 패턴
  - `MVVM`

### 패키지 구조
```
📦 com.juhwan.movie_search
📦 com.movie_search
 ┣ 📂 data
 ┃ ┗ 📂 api
 ┃    ┗ 📜 movieApi
 ┃ ┗ 📂 db
 ┃    ┗ 📂 dao
 ┃       ┗ 📜 RecentSearchDao
 ┃    ┗ 📜 AppDatabase
 ┃ ┗ 📂 di
 ┃    ┗ 📜 ApiModule
 ┃    ┗ 📜 LocalDataModule
 ┃    ┗ 📜 RemoteDataModule
 ┃    ┗ 📜 RepoisotryModule
 ┃ ┗ 📂 mapper
 ┃    ┗ 📜 Mapper
 ┃ ┗ 📂 model
 ┃    ┗ 📜 MovieEntity
 ┃    ┗ 📜 MovieResponse
 ┃    ┗ 📜 RecentSearchEntity
 ┃ ┗ 📂 repository
 ┃    ┗ 📂 Movie
 ┃       ┗ 📜 MovieRemoteDataSource
 ┃       ┗ 📜 MovieRemoteDataSourceImpl
 ┃    ┗ 📂 RecentSearch
 ┃       ┗ 📜 RecentSearchLocalDataSource
 ┃       ┗ 📜 RecentSearchLocalDataSourceImpl
 ┃    ┗ 📜 MovieRepositoryImpl
 ┃    ┗ 📜 RecentSearchRepositoryImpl
 ┣ 📂 domain
 ┃ ┗ 📂 model
 ┃    ┗ 📜 Movie
 ┃ ┗ 📂 repository
 ┃    ┗ 📜 MovieRepository
 ┃    ┗ 📜 RecentSearchRepository
 ┃ ┗ 📂 usecase
 ┃    ┗ 📂 recent_search
 ┃        ┗ 📜 ReadRecentSearchListUseCase
 ┃        ┗ 📜 WriteRecentSearchListUseCase
 ┃    ┗ 📜 GetMoviesUseCase
 ┣ 📂 present
 ┃ ┗ 📂 config
 ┃    ┗ 📜 ApplicationClass
 ┃    ┗ 📜 BaseActivity
 ┃    ┗ 📜 BaseFragment
 ┃    ┗ 📜 SingleLiveEvent
 ┃ ┗ 📂 utils
 ┃    ┗ 📜 BindingAdapter
 ┃    ┗ 📜 IOConsts
 ┃    ┗ 📜 KeywordChecker
 ┃    ┗ 📜 KeywordExceptions
 ┃    ┗ 📜 PageSet
 ┃    ┗ 📜 RetrofitUtil
 ┃    ┗ 📜 TokenInterceptor
 ┃ ┗ 📂 views
 ┃    ┗ 📜 MainActivity
 ┃    ┗ 📜 MovieAdapter
 ┃    ┗ 📜 MovieFragment
 ┃    ┗ 📜 MovieViewModel
 ┃    ┗ 📜 RecentSearchFragment
 ┃    ┗ 📜 RecentSearchViewModel
 ┃    ┗ 📜 WebViewFragment
```

### 작업 과정
- [Issue](https://github.com/juhwankim-dev/movie-search/issues?q=is%3Aissue+is%3Aclosed)
- [Pull Request](https://github.com/juhwankim-dev/movie-search/pulls?q=is%3Apr+is%3Aclosed)
- [Kanban board](https://github.com/juhwankim-dev/movie-search/projects/1)
