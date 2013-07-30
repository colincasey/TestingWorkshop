package piglatin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatinTranslator {
    private final Pattern startingVowels = Pattern.compile("^[aeiou]+", Pattern.CASE_INSENSITIVE);
    private final Pattern regularVowelsWithY = Pattern.compile("[aeiouy]", Pattern.CASE_INSENSITIVE);
    private final Pattern regularVowels = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);
    private final Pattern capitalized = Pattern.compile("^[A-Z]");

    public String translate(String word) {
        boolean isCapitalized = isCapitalized(word);
        String translatedWord = startsWithConsonants(word) ?
            doConsonantTranslation(word) :
            doVowelTranslation(word);
        translatedWord = adjustForCapitalization(translatedWord, isCapitalized);
        return translatedWord;
    }

    private String adjustForCapitalization(String translatedWord, boolean capitalized) {
        String adjustedWord = translatedWord.toLowerCase();
        if(capitalized) {
            adjustedWord = adjustedWord.substring(0, 1).toUpperCase() + adjustedWord.substring(1);
        }
        return adjustedWord;
    }

    private boolean isCapitalized(String word) {
        return capitalized.matcher(word).find();
    }

    private String doConsonantTranslation(String word) {
        Pattern pattern = startsWithY(word) ?
            regularVowels :
            regularVowelsWithY;
        Matcher matcher = pattern.matcher(word);
        matcher.find();
        return word.substring(matcher.start()) +
                word.substring(0, matcher.start()) +
                "ay";
    }

    private boolean startsWithY(String word) {
        return word.startsWith("y") || word.startsWith("Y");
    }

    private String doVowelTranslation(String word) {
        return word + "way";
    }

    private boolean startsWithConsonants(String word) {
        return !startingVowels.matcher(word).find();
    }
}
