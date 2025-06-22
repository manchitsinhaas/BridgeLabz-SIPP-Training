public class MostFrequentChar {
    public static char findMostFrequentChar(String str) {
        int[] freq = new int[256];
        for (char ch : str.toCharArray())
            freq[ch]++;
        
        int max = 0;
        char result = ' ';
        for (char ch : str.toCharArray()) {
            if (freq[ch] > max) {
                max = freq[ch];
                result = ch;
            }
        }
        return result;
    }
}
