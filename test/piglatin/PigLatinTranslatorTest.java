package piglatin;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*

PIG LATIN RULES
---------------

- For words that begin with consonant sounds, the initial consonant or consonant cluster is moved to the end of the
  word, and "ay" is added, as in the following examples:
    "happy" → "appyhay"
    "duck" → "uckday"
    "glove" → "oveglay"

- For words that begin with vowel sounds or silent letter, "way" is added at the end of the word. Examples are:
    "egg" → "eggway"
    "inbox" → "inboxway"
    "eight" → "eightway"

- In some variants, though, just add an "ay" at the end.
    "egg" → "eggay"

- Yet another acceptable variant is to add the ending "yay" to words that begin with a vowel sound.
    "egg" → "eggyay"

- The following must also apply:
    - Ensures proper capitalization
    - Correct upper case and lower case formatting
    - Correctly translates "qu" (e.g., ietquay instead of uietqay)
    - Differentiates between "Y" as vowel and "Y" as consonant
    - (e.g. yellow = elloyay and style = ylestay) — (except for a very few exceptions)
    - Correctly translates contractions
    - Hyphenated words are treated as two words
    - Words may consist of alphabetic characters only (A-Z and a-z)
    - All punctuation, numerals, symbols and whitespace are not modified

 */
public class PigLatinTranslatorTest {
    private PigLatinTranslator pigLatinTranslator;

    @Before
    public void setUp() throws Exception {
        pigLatinTranslator = new PigLatinTranslator();
    }

    @Test
    public void should_translate_words_that_begin_with_consonants() throws Exception {
        assertThat(translate("happy"), is("appyhay"));
        assertThat(translate("duck"), is("uckday"));
        assertThat(translate("glove"), is("oveglay"));
    }

    @Test
    public void should_translate_words_that_begin_with_vowels() throws Exception {
        assertThat(translate("egg"), is("eggway"));
        assertThat(translate("inbox"), is("inboxway"));
        assertThat(translate("eight"), is("eightway"));
    }

    @Test
    public void should_differentiate_between_y_as_a_vowel_and_y_as_a_consonant() throws Exception {
        assertThat(translate("yellow"), is("ellowyay"));
        assertThat(translate("style"), is("ylestay"));
    }

    @Test
    public void should_retain_capilization() throws Exception {
        assertThat(translate("Radian"), is("Adianray"));

    }

    private String translate(String word) {
        return pigLatinTranslator.translate(word);
    }
}
