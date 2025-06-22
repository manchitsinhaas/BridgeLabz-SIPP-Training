public class WordReplacer {
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String[] words = sentence.split(" ");
        String result = "";
        for (String word : words) {
            result += (word.equals(oldWord) ? newWord : word) + " ";
        }
        return result.trim();
    }
}
