package components.colorpalette;

import java.awt.Color;

import components.standard.Standard;

/**
 * Kernel interface for {@code ColorPalette}.
 *
 * @author Amanda Lan
 */
public interface ColorPaletteKernel extends Standard<ColorPalette> {

    /**
     * Adds the given color to this palette.
     *
     * @param c
     *            the Color to add
     * @updates this
     * @requires c is not null
     * @ensures this = #this union {c}
     */
    void addColor(Color c);

    /**
     * Removes and returns one color from this palette.
     *
     * @return the color that was removed
     * @updates this
     * @requires this is not empty
     * @ensures removeColor is in #this and this = #this \ {removeColor}
     */
    Color removeColor();

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
     * @ensures size = [number of colors]
     */
    int size();
}
