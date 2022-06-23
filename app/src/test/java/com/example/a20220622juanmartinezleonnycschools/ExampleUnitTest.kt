package com.example.a20220622juanmartinezleonnycschools

import com.example.a20220622juanmartinezleonnycschools.validation.Validator
import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun whenCityIsValid() {
        val cityName = "Brooklyn"
        val result = Validator.validateCityName(cityName)
        assertEquals(true, result)
    }

    @Test
    fun whenCityIsNotValid() {
        val cityName = ""
        val result = Validator.validateCityName(cityName)
        assertEquals(false, result)
    }
}