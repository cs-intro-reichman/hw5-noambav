import java.util.Dictionary;
import java.util.Hashtable;

/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c')
     * returns 0.
     * 
     * @param str - a string
     * @param c   - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        char[] charArr = str.toCharArray();
        int count = 0;
        //// Replace the following statement with your code
        for (char c : charArr) {
            if (c == ch)
                count++;
        }
        return count;
    }

    /**
     * Returns true if str1 is a subset string str2, false otherwise
     * Examples:
     * subsetOf("sap","space") returns true
     * subsetOf("spa","space") returns true
     * subsetOf("pass","space") returns false
     * subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        boolean isSubset = true;
        int[] wordCountArray = new int[str1.length()];

        for (int i = 0; i < str1.length(); i++)
            wordCountArray[i] = countChar(str1, str1.charAt(i));

        for (int i = 0; i < str1.length(); i++)
            if (countChar(str2, str1.charAt(i)) < wordCountArray[i])
                isSubset = false;

        return isSubset;

    }

    /**
     * Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character.
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String newString = new String();
        for (int i = 0; i < str.length(); i++) {
            newString += str.charAt(i);
            if (i < str.length() - 1)
                newString += " ";
        }

        return newString;
    }

    /**
     * Returns a string of n lowercase letters, selected randomly from
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        String randomString = "";
        for (int i = 0; i < n; i++)
            randomString += alphabet[(int) (Math.random() * alphabet.length)];

        return randomString;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in
     * the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit"
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String longerWord, String shorterWord) {
        String modifiedString = "";
        boolean shouldRemove = false;

        final int EXPECTED_LENGTH = longerWord.length() - shorterWord.length(); // for slightly better readabilty :D
        for (int i = 0; i < longerWord.length(); i++) {
            if (modifiedString.length() == EXPECTED_LENGTH) // Means we are finished removing
                break;
            shouldRemove = false;
            for (int j = 0; j < shorterWord.length(); j++) {
                if (longerWord.charAt(i) == shorterWord.charAt(j)) {
                    shouldRemove = true;
                    shorterWord = shorterWord.substring(0, j) + shorterWord.substring(j + 1);
                    break;
                }
            }
            if (!shouldRemove)
                modifiedString += longerWord.charAt(i);
        }
        return modifiedString;
    }

    /**
     * Returns a string consisting of the given string, with the given
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or
     * "cast", or "cats".
     * 
     * @param ch  - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
        // Generate a random index between 0 and str.length()
        int randomIndex = (int) (Math.random() * (str.length() + 1));
        // Insert the character at the random index
        String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
        return result;
    }
}
