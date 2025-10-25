import java.awt.Color;

import components.standard.Standard;

/**
 * Kernel interface for {@code ColorPalette}.
 *
 * @author Amanda Lan
 */
public interface ColorPaletteKernel extends Standard {

    /*
     * Kernel Methods ----------------------------------------------------------
     */

    /**
     * Adds the given color to this palette.
     *
     * @param c
     *            the Color to add
     * @requires this.size() < MAX_SIZE and c is not null
     * @ensures this = #this * <c>
     */
    void addColor(Color c);

    /**
     * Removes and returns the most recently added color.
     *
     * @return the color that was removed
     * @updates this
     * @requires this.count > 0
     * @ensures removeColor = [last color added] and this.count = #this.count -
     *          1
     */
    void removeColor(Color c);

    /**
     * Checks whether this palette contains the given color.
     *
     * @param c
     *            the color to check
     * @return true if the color is found, false otherwise
     * @requires c is not null
     * @ensures contains = (c is in this)
     */
    boolean contains(Color c);

    /**
     * Reports whether this palette is empty.
     *
     * @return true if the palette contains no colors, false otherwise
     * @ensures isEmpty = (this.count = 0)
     */
    boolean isEmpty();

    /**
     * Returns the number of colors currently in this palette.
     *
     * @return the number of colors
     * @ensures size = this.count
     */
    int size();
}
