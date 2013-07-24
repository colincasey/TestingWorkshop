package piglatin;

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
}
