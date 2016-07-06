package com.message.util

import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

/**
 * Test Cases for MessageRefinerUtil class
 *
 * Created by preetijasmine on 06/07/16.
 */
class MessageRefinerUtilTest {

    @Test
    public void refineNonMarqueeContent() {
        final String output = MessageRefinerUtil.refine("some-content<marquee>marquee-content</marquee>");
        assertThat(output, is("some-content"));
    }

    @Test
    public void refineContentInsideMarqueeTags() {
        final String output = MessageRefinerUtil.refine("<marquee>marquee-content</marquee>");
        assertThat(output, is(""));
    }

}
