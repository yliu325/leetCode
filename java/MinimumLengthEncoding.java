import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yang on 2020/3/28.
 * @version 1.0
 */
public class MinimumLengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                wordSet.remove(word.substring(i));
            }
        }

        int result = 0;
        for (String word : wordSet) {
            result += word.length() + 1;
        }
        return result;
    }
}
