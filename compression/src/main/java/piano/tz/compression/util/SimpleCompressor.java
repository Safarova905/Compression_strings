package piano.tz.compression.util;

import java.util.ArrayList;

public class SimpleCompressor implements Compressor {

    public SimpleCompressor() {
        ArrayList<Character> arr = new ArrayList<>();
        for (int i = 'a'; i < 'z'; i++) {
            arr.add((char) i);
        }
        for (int i = 'A'; i < 'Z'; i++) {
            arr.add((char) i);
        }
        for (int i = 0; i < 9; i++) {
            arr.add((char) i);
        }
        arr.add('$');
        arr.add('_');
        dict = arr;
    }

    protected final ArrayList<Character> dict;

    /**
     * @param str is the input string which should be decompressed
     * @param count is the input number of characters in a string
     * @return compressed string
     */
    @Override
    public String compress(final String str, final long count) {
        StringBuilder sb = new StringBuilder();
        long num = count;
        do {
            final long val = num % dict.size();
            sb.append(dict.get((int) val));
            num /= dict.size();
        } while (num != 0);
        return sb.toString();
    }
}
