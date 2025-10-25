import java.awt.Color;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * ColorPalette models a simple collection of Color objects. The kernel provides
 * basic collection operations, while the secondary methods provide analysis
 * utilities.
 *
 * Kernel methods: addColor, removeColor, contains, isEmpty, size Secondary
 * methods: averageColor, mostFrequent
 *
 * @author Amanda
 */
public final class ColorPalette {

    /**
     * Maximum number of colors allowed in the palette.
     */
    private static final int MAX_SIZE = 10;

    /**
     * Internal representation: an array that holds Color objects.
     */
    private final Color[] colors;

    /**
     * Number of colors currently stored in the palette.
     */
    private int count;

    /**
     * Default constructor that creates an empty ColorPalette.
     *
     * @ensures this.count = 0
     */
    public ColorPalette() {
        this.colors = new Color[MAX_SIZE];
        this.count = 0;
    }

    /*
     * Kernel Methods-----------------------------------------------------------
     */

    /**
     * Adds the given color to this palette.
     *
     * @param c
     *            the Color to add
     * @requires this.size() < MAX_SIZE and c is not null
     * @ensures this = #this * <c>
     */
    public void addColor(Color c) {
        assert c != null : "Violation of: c is not null";
        assert this.count < MAX_SIZE : "Violation of: this.count < MAX_SIZE";

        // Add the new color to the next available index
        this.colors[this.count] = c;
        this.count++;
    }

    /**
     * Removes and returns the most recently added color.
     *
     * @return the color that was removed
     * @updates this
     * @requires this.count > 0
     * @ensures removeColor = [last color added] and this.count = #this.count -
     *          1
     */
    public Color removeColor() {
        assert this.count > 0 : "Violation of: this.count > 0";

        // Decrease count and return the last added color
        this.count--;
        Color removed = this.colors[this.count];
        return removed;
    }

    /**
     * Checks whether this palette contains the given color.
     *
     * @param c
     *            the color to check
     * @return true if the color is found, false otherwise
     * @requires c is not null
     * @ensures contains = (c is in this)
     */
    public boolean contains(Color c) {
        assert c != null : "Violation of: c is not null";

        boolean found = false;
        for (int i = 0; i < this.count; i++) {
            if (this.colors[i].equals(c)) {
                found = true;
            }
        }
        return found;
    }

    /**
     * Reports whether this palette is empty.
     *
     * @return true if the palette contains no colors, false otherwise
     * @ensures isEmpty = (this.count = 0)
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Returns the number of colors currently in this palette.
     *
     * @return the number of colors
     * @ensures size = this.count
     */
    public int size() {
        return this.count;
    }

    /*
     * Secondary Methods--------------------------------------------------------
     */

    /**
     * Computes the average (blended) color of all colors in this palette.
     *
     * @return the average Color; returns black (0, 0, 0) if the palette is
     *         empty
     * @ensures averageColor = [average RGB value of all colors if not empty,
     *          else (0, 0, 0)]
     */
    public Color averageColor() {
        assert this.count >= 0 : "Violation of: count non-negative";

        // default value if palette is empty
        Color avg = new Color(0, 0, 0);

        if (this.count > 0) {
            int totalR = 0, totalG = 0, totalB = 0;

            // Sum all RGB values
            for (int i = 0; i < this.count; i++) {
                Color c = this.colors[i];
                totalR += c.getRed();
                totalG += c.getGreen();
                totalB += c.getBlue();
            }

            // Compute averages and store in avg
            int avgR = totalR / this.count;
            int avgG = totalG / this.count;
            int avgB = totalB / this.count;

            avg = new Color(avgR, avgG, avgB);
        }

        return avg;
    }

    /**
     * Returns the most frequent color in this palette. If not empty, return the
     * first color. If empty, return black.
     *
     * @return the most frequent color or black if empty
     * @ensures mostFrequent = [first color in palette if not empty, else (0, 0,
     *          0)]
     */
    public Color mostFrequent() {
        assert this.count >= 0 : "Violation of: count non-negative";

        // default if empty
        Color result = new Color(0, 0, 0);
        int maxCount = 0;

        for (int i = 0; i < this.count; i++) {
            int currentCount = 1;
            for (int j = i + 1; j < this.count; j++) {
                if (this.colors[i].equals(this.colors[j])) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                result = this.colors[i];
            }
        }

        return result;
    }

    /*
     * Helper Method------------------------------------------------------------
     */

    /**
     * Converts a Color into a readable string format.
     *
     * @param c
     *            the color to convert
     * @return a formatted RGB string
     * @requires c is not null
     * @ensures colorToString = "(r, g, b)"
     */
    private static String colorToString(Color c) {
        assert c != null : "Violation of: c is not null";

        // Return string showing RGB values clearly
        return "(" + c.getRed() + ", " + c.getGreen() + ", " + c.getBlue()
                + ")";
    }

    /*
     * Display Demonstration----------------------------------------------------
     */

    /**
     * Displays all colors currently in this palette.
     *
     * @param out
     *            the output stream
     * @requires out.isOpen
     * @ensures out.content = #out.content * [list of colors in readable form]
     */
    public void display(SimpleWriter out) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.isOpen";

        out.println("Current Colors in Palette:");
        for (int i = 0; i < this.count; i++) {
            Color c = this.colors[i];
            out.println(colorToString(c));
        }
    }

    /*
     * Main Method--------------------------------------------------------------
     *
     * Each color in Java is represented using the RGB (Red, Green, Blue) color
     * model. Each component is an integer in the range 0–255, where: 0 = no
     * intensity (dark) and 255 = full intensity (bright).
     *
     * For example: (255, 0, 0) = Red (0, 255, 0) = Green (0, 0, 255) = Blue
     * (255, 255, 255) = White (0, 0, 0) = Black
     *
     * RGB is used because it represents the primary colors of light. Every
     * visible color can be made by combining red, green, and blue intensities
     * in this range.
     */

    /**
     * Demonstrates ColorPalette functionality by allowing the user to input
     * colors and view summary results.
     *
     * @param args
     *            command line arguments (unused)
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        ColorPalette palette = new ColorPalette();

        // Ask user how many colors to add
        out.print("How many colors would you like to add (max " + MAX_SIZE
                + ")? ");
        int numColors = in.nextInteger();

        // Collect color input from user
        int i = 0;
        while (i < numColors && i < MAX_SIZE) {
            out.println("Enter RGB values for color " + (i + 1) + ": ");
            out.print("Red (0–255): ");
            int r = in.nextInteger();
            out.print("Green (0–255): ");
            int g = in.nextInteger();
            out.print("Blue (0–255): ");
            int b = in.nextInteger();

            Color c = new Color(r, g, b);
            palette.addColor(c);
            i++;
        }

        // Display all entered colors
        out.println();
        palette.display(out);

        // Compute and display secondary method results
        out.println();
        Color avg = palette.averageColor();
        Color freq = palette.mostFrequent();

        out.println("Average color: " + colorToString(avg));
        out.println("Most frequent color: " + colorToString(freq));
        out.println("Palette size: " + palette.size());
        out.println("Is empty? " + palette.isEmpty());

        in.close();
        out.close();
    }
}
