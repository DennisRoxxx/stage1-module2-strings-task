package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> listOfSubstrings = new ArrayList<>();
        StringTokenizer stz = new StringTokenizer(source, String.valueOf(delimiters));

        while (stz.hasMoreTokens())
            listOfSubstrings.add(stz.nextToken());

        return listOfSubstrings;
    }
}
