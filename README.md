### 요약
네이버 영화 API를 통해 검색 결과를 보여주는 Application

### 기능
- 영화 검색
- WebView를 통해 영화 상세보기
- 최근 검색 목록 보기
- 최근 검색 키워드를 이용한 재검색

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
