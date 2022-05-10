package com.ssafy.movie_search.present.utils

import java.util.regex.Pattern

object KeywordChecker {
    const val KEYWORD = "^[a-zA-Zㄱ-ㅎ가-힣0-9]*\$"

    fun check(keyword: String) {
        if(isOutOfLength(keyword)) throw OutOfLengthException()
        if(hasSpecialChar(keyword)) throw SpecialCharException()
    }

    fun isOutOfLength(keyword: String): Boolean {
        return keyword.isEmpty() || keyword.length > 20
    }

    fun hasSpecialChar(keyword: String): Boolean {
        return !Pattern.matches(KEYWORD, keyword)
    }
}