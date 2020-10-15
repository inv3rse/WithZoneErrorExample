package com.inverse.cc.withzoneerrorexample

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.threeten.bp.Instant
import org.threeten.bp.ZoneOffset
import org.threeten.bp.format.DateTimeFormatter

/**
 * Test cases for the threeten [DateTimeFormatter.withZone] behavior.
 */
class ThreeTenDateTimeFormatterTest {

    companion object {
        // Formatter with an optional time zone, which should use UTC if the zone is missing
        private val FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm[Z]").withZone(ZoneOffset.UTC)
        private val EXPECTED_INSTANT = Instant.parse("2001-01-01T01:00:00Z")
    }

    @Test
    fun parseWithoutZoneId() {
        val withoutTimeZone = "2001-01-01T01:00"
        assertEquals(EXPECTED_INSTANT, FORMATTER.parse(withoutTimeZone, Instant::from))
    }

    @Test
    fun parseWithZoneId() {
        val withTimeZone = "2001-01-01T02:00+0100"
        assertEquals(EXPECTED_INSTANT, FORMATTER.parse(withTimeZone, Instant::from))
    }
}