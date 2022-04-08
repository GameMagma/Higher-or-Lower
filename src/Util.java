/**
 * A little Util class for a bunch of random things. May use it again in other projects, may not. Who knows.
 */
public abstract class Util {
    /* Explanation
     * \033 - Escaped sequence represents beginning/ending of the style
     * lowercase m - indicates the end of the sequence
     * [0m - resets all attributes, colors, formatting, etc.
     *
     * Possible Integer Values:
     * 0 - Normal
     * 1 - Bold
     * 2 - Dim
     * 3 - Italic
     * 4 - Underlined
     * 5 - Blinking
     * 7 - Reverse
     * 8 - Invisible
     */

    public static class Styles {
        public static final int BOLD = 1;
        public static final int DIM = 2;       // Doesn't seem to do anything
        public static final int ITALIC = 3;
        public static final int UNDERLINED = 4;
        public static final int BLINKING = 5;  // Doesn't seem to do anything
        public static final int REVERSE = 7;   // Highlights it, doesn't reverse
        public static final int INVISIBLE = 8; // Doesn't seem to do anything
    }

    /**
     * I don't really get it, but it works. Uses this formula: "\033[1mSTRING\033[0m" . In this, you would replace the 1
     * with the style you're looking for (find known style options in {@link Styles}), and STRING with the string you're looking
     * to modify.
     * @param s string you want to modify
     * @param style number that corresponds to the style you want. All known style numbers are in {@link Styles}, but you can
     *              try any int you want to see if it does something
     * @return styled string
     * @see <a href="stackoverflow.com/a/42449998">Stack Overflow Question</a>
     */
    public static String font(String s, int style) { return "\033[" + style + "m" + s + "\033[0m"; }
}
