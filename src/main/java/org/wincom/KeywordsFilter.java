package org.wincom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeywordsFilter {

    private final String[] keywords;

    public KeywordsFilter(String[] keywords) {
        this.keywords = keywords;
    }


    public List<String> filterBy (String characters){

        if (characters.isEmpty()) {
           return Collections.emptyList();
        }
        List<String> filterKeywords= new ArrayList<String>();

        for (int i = 0; i < keywords.length; i++) {
            String keywordsItem = keywords[i];

            if (keywordsItem.toLowerCase().startsWith(characters.toLowerCase())) {
                // If you don't want to autocomplete and just want to know if the chars are part of any string : .contains() it's also an option.
                filterKeywords.add(keywordsItem);
            }
        }
        Collections.sort(filterKeywords);
        if (filterKeywords.size()>= 4) {

           return filterKeywords.subList(0, 4);
        }
        return filterKeywords;
    }


}


