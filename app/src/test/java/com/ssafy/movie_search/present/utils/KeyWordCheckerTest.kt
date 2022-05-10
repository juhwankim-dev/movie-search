package com.ssafy.movie_search.present.utils

import org.junit.Test
import com.google.common.truth.Truth.assertThat

class KeyWordCheckerTest {

    val normalKeyword = "과속스캔들"
    val emptyKeyword = ""
    val longKeyword = "가나다라마바사아자차카타파하가나다라마바사아자차카타파하"
    val specialCharKeyword = "!@#$%"

    @Test
    fun `정상적인 검색어라면`() {
        val result = KeywordChecker.isOutOfLength(normalKeyword)
        assertThat(result).isFalse()
    }

    @Test
    fun `검색어가 비어있으면`() {
        val result = KeywordChecker.isOutOfLength(emptyKeyword)
        assertThat(result).isTrue()
    }

    @Test
    fun `검색어가 20자보다 길면`() {
        val result = KeywordChecker.isOutOfLength(longKeyword)
        assertThat(result).isTrue()
    }

    @Test
    fun `검색어에 특수문자가 포함되어 있으면`() {
        val result = KeywordChecker.hasSpecialChar(specialCharKeyword)
        assertThat(result).isTrue()
    }
}