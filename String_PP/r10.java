public class CharacterRemover {
    public static String removeChar(String str, char toRemove) {
        String result = "";
        for (char ch : str.toCharArray()) {
            if (ch != toRemove)
                result += ch;
        }
        return result;
    }
}
