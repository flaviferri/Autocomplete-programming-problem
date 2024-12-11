package org.wincom;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class KeywordsFilterTest {

    @Test
    public void testSuggestionsForValidInput() {
     String [] keywords = {
                "Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv",
                "Priceline", "Press democrat", "Progressive", "Project runway",
                "Proactive", "Programming", "Progeria", "Progesterone", "Progenex",
                "Procurable", "Processor", "Proud", "Print", "Prank", "Bowl",
                "Owl", "River", "Phone", "Kayak", "Stamps", "Reprobe" };

        KeywordsFilter autoComplete = new KeywordsFilter(keywords);


        List<String>suggestions = autoComplete.filterBy("Pro");
        assertEquals(List.of("Proactive","Processor","Procurable", "Progenex"), suggestions);
    }

    @Test
    public void testSuggestionsForEmptyInput() {
        String [] keywords = {"Pandora", "Pinterest", "Paypal"};
        KeywordsFilter autoComplete = new KeywordsFilter(keywords);


        List<String> suggestions = autoComplete.filterBy("");
        assertTrue(suggestions.isEmpty());
    }

    @Test
    public void testSuggestionsForNoMatch() {
        String [] keywords = {"Pandora", "Pinterest", "Paypal"};
        KeywordsFilter autoComplete = new KeywordsFilter(keywords);


        List<String> suggestions = autoComplete.filterBy("XYZ");
        assertTrue(suggestions.isEmpty());
    }

    @Test
    public void testSuggestionsCaseInsensitive() {
        String [] keywords = {"Pandora", "Pinterest", "Paypal"};
        KeywordsFilter autoComplete = new KeywordsFilter(keywords);


        List<String> suggestions = autoComplete.filterBy("p");
        assertEquals(List.of("Pandora", "Paypal", "Pinterest"), suggestions);

        suggestions = autoComplete.filterBy("P");
        assertEquals(List.of("Pandora", "Paypal", "Pinterest"), suggestions);
    }

    @Test
    public void testSuggestionsLimitToFour() {
        String [] keywords = {"Project", "Proactive", "Processor", "Programming", "Progressive"};
        KeywordsFilter autoComplete = new KeywordsFilter(keywords);


        List<String> suggestions = autoComplete.filterBy("Pro");
        assertEquals(List.of("Proactive", "Processor", "Programming", "Progressive"), suggestions);
    }
}