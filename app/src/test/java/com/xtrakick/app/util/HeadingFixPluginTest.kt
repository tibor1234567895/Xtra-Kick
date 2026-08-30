package com.xtrakick.app.util

import org.commonmark.node.Heading
import org.commonmark.node.Text
import org.commonmark.parser.Parser
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class HeadingFixPluginTest {

    private fun parse(text: String) = Parser.builder().also(HeadingFixPlugin()::configureParser).build().parse(text)

    private fun headingText(text: String): String? {
        val heading = parse(text).firstChild as? Heading ?: return null
        return (heading.firstChild as? Text)?.literal
    }

    @Test
    fun malformedHeadingKeepsFullText() {
        assertEquals("Rules", headingText("#Rules"))
    }

    @Test
    fun malformedHeadingWithMultipleHashesKeepsFullText() {
        assertEquals("About Me!", headingText("##About Me!"))
    }

    @Test
    fun wellFormedHeadingUnchanged() {
        assertEquals("Rules", headingText("# Rules"))
    }

    @Test
    fun indentedMalformedHeadingKeepsFullText() {
        assertEquals("Rules", headingText("  #Rules"))
    }

    @Test
    fun paragraphWithoutHeadingMarkerUnchanged() {
        assertNull(parse("Rules").firstChild as? Heading)
    }

    @Test
    fun markerOnlyLineStaysEmptyHeading() {
        val heading = parse("#").firstChild as? Heading
        assertNull(heading?.firstChild as? Text)
    }
}
