/*

Link: https://www.youtube.com/watch?v=7a4r3tIVtCE

Problem Statement: Encode the Message
You have been given a text message. You have to return the Run-length Encoding of the given message.
Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as the character and a single count. For example, the string "aaaabbbccdaa" would be encoded as "a4b3c2d1a2".
Note:
It's guaranteed that the message string will have no digits and consists solely of lowercase alphabetic characters.

 */

import java.util.regex.Pattern;

public class RunLengthEncoding_2 {

    public static String compress(String text){
        StringBuilder sb = new StringBuilder();

        // Create the pattern that find all consecutive occurrences of the same character
        // First parenthesis defines the first group of the pattern (i.e whole repeated block)
        // Backslash 2 and the asterisk represents the second pair of parenthesis (i.e whole repeated character)
        Pattern pattern = Pattern.compile("(([a-zA-Z])\\2*)");

        pattern.matcher(text).results().forEach(result -> {
            int repetitions = result.group(1).length();
            sb.append(result.group(2)).append(repetitions);
        });
        return sb.toString();
    }

    public static String decompress(String text){
        StringBuilder sb = new StringBuilder();

        // Group 1 - repeated character
        // Group 2 - occurrences
        Pattern pattern = Pattern.compile("(([a-zA-Z])\\2*)");

        pattern.matcher(text).results().forEach(result -> {
            int count = Integer.parseInt(result.group(2));
            sb.append(result.group(1).repeat(count));
        });
        return sb.toString();
    }

    public static void main(String[] args) {
        String initialText = "AAAAAABBBBBBCCCCCCCCDDDDDDDDD";
        String encodedText = RunLengthEncoding_2.compress(initialText);
        String decodedText = RunLengthEncoding_2.decompress(initialText);

        System.out.println(encodedText);
        System.out.println(decodedText);
    }
}
