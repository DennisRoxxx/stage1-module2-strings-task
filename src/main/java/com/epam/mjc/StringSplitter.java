package com.epam.mjc;

import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> substrings = new ArrayList<>();
        String stringDelimiter = "";
        for(String delimiter: delimiters){
            stringDelimiter += delimiter + "|";
        }

        String delimiterForSplit = stringDelimiter.substring(0, stringDelimiter.length()-1);

        String[] elements = source.split(delimiterForSplit);
        for (String element: elements){
            if(!element.equals("")){
                substrings.add(element);
            }
        }
        return substrings;
    }
}
