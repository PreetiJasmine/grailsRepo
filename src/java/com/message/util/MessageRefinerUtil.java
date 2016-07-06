package com.message.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Utility class that handles the logic of refining the user input.
 * For now, this class handles the removal of any content between <marquee> start and end tags.
 *
 * Created by preetijasmine on 06/07/16.
 */
public class MessageRefinerUtil {

    private static List<Pattern> INPUT_MSG_PATTERNS = new ArrayList<Pattern>();

    static {
        // Avoid anything between marquee tags
        INPUT_MSG_PATTERNS.add(Pattern.compile("<marquee>(.*?)</marquee>", Pattern.CASE_INSENSITIVE));
    }

    /**
     * This method receives a string and refines the user content based on the defined message patterns
     *
     * @param value
     * @return String - the new refined string.
     */
    public static String refine(String value) {

        try {

            if (value != null) {

                // Avoid null characters
                value = value.replaceAll("\0", "");

                // Refine against known message input patterns
                for (Pattern inputMsgPattern : INPUT_MSG_PATTERNS) {
                    value = inputMsgPattern.matcher(value).replaceAll("");
                }
            }

        } catch (Exception exception) {
            System.out.println("Could not remove unnecessary tags from value = " + value + " | ex = " + exception.getMessage());
        }

        return value;
    }

}
