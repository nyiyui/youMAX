/**
 * String Assignment
 * <p>
 * Course: ICS3U0
 * Teacher: Ms. Krasteva
 * Created: 2023-02-07
 * Purpose: Strings review assignment. Method insertAt inserts a full word into
 *          the specified location within another string, and method replaceOnce
 *          replaces a word in a string case insensitively.
 * Version: 3.9
 *
 * @author nyiyui (Ken Shibata) and Ivy Zhuang
 */
public class StringsAssignment {
    /**
     * main contains test assertions for methods replaceOnce and insertAt.
     */
    public static void main(String[] args) {
        assert replaceOnce("hello", "a", "a").equals("hello"); // should not be replaced at all
        assert replaceOnce("Shiratama chaya in MeIdO Meido", "mEiDo", "SINE").equals("Shiratama chaya in SINE Meido");
        assert replaceOnce("Shiratama chaya in me MeIdO Meido", "mEiDo", "SINE").equals("Shiratama chaya in me SINE Meido");
        assert insertAt("def", "abc", 0).equals("abcdef"); // test start-insertion
        assert insertAt("Tiny Adiantum", "Little ", 5).equals("Tiny Little Adiantum");
        assert insertAt("abc", "def", 3).equals("abcdef"); // test end-insertion
        System.out.println(replaceOnce("ohiruyasumi no esorabanasi", "SI", "SHI"));
        System.out.println(insertAt("komorebi no syosai", " kara", 17));
    }

    /**
     * replaceOnce replaced the first occurrence of pattern in replacee with replacer.
     * Matching is case insensitive.
     * (Question 30)
     *
     * @param replacee string to replace the word from
     * @param pattern  word to match to replace with
     * @param replacer word to replace once.
     * @return tuple with: a) string with the word replaced, and b) whether the pattern matched.
     */
    public static String replaceOnce(String replacee, String pattern, String replacer) {
        String lowercasePattern = "";
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            char lowercaseChar;
            if (c >= 'A' && c <= 'Z') {
                lowercaseChar = c;
                lowercaseChar -= 'A';
                lowercaseChar += 'a';
            } else {
                lowercaseChar = c;
            }
            lowercasePattern += lowercaseChar;
        }
        String lowercaseReplacee = "";
        for (int i = 0; i < replacee.length(); i++) {
            char c = replacee.charAt(i);
            char lowercaseChar;
            if (c >= 'A' && c <= 'Z') {
                lowercaseChar = c;
                lowercaseChar -= 'A';
                lowercaseChar += 'a';
            } else {
                lowercaseChar = c;
            }
            lowercaseReplacee += lowercaseChar;
        }
        // cmi (current match index) is the index of the pattern which is being
        // compared in the list now.
        int cmi = 0;
        for (int i = 0; i < lowercaseReplacee.length(); i++) {
            char c = lowercaseReplacee.charAt(i);
            if (c == lowercasePattern.charAt(cmi)) {
                // progressively match the pattern with lowercaseReplacee
                cmi++;
            } else if (cmi != 0) {
                // reset if not matched
                cmi = 0;
            }

            if (cmi == pattern.length()) {
                // rebuild replacee with pattern switched
                String replaced = "";
                int matchStart = i - cmi + 1;
                for (int j = 0; j < matchStart; j++) {
                    replaced += replacee.charAt(j);
                }
                replaced += replacer;
                for (int j = matchStart + pattern.length(); j < replacee.length(); j++) {
                    replaced += replacee.charAt(j);
                }
                return replaced;
            }
        }
        // nothing matched
        return replacee;
    }

    /**
     * insertAt inserts a string at a specified location
     *
     * @param base     string that will have another string inserted at a specific lacation
     * @param inserted string that will be inserted at a specific location
     * @param location location to insert string at (can be equal to the length of base, meaning the string will be inserted at the end of the string)
     * @return resultant string with the string inserted.
     */
    public static String insertAt(String base, String inserted, int location) throws StringIndexOutOfBoundsException {
        if (location > base.length()) {
            throw new StringIndexOutOfBoundsException(location);
        }
        String result = "";
        // add part of string base before inserting the string
        for (int i = 0; i < location; i++) {
            result += base.charAt(i);
        }
        // inserts the string into result
        result += inserted;
        // add rest of base to result
        for (int i = location; i < base.length(); i++) {
            result += base.charAt(i);
        }
        return result;
    }
}
