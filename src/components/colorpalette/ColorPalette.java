package components.colorpalette;

import java.awt.Color;

/**
 * Enhanced interface for {@code ColorPalette}.
 *
 * Extends the kernel interface with additional color analysis methods.
 *
 * <p>
 * Kernel methods (from {@code ColorPaletteKernel}): addColor, removeColor,
 * contains, isEmpty, size
 * </p>
 *
 * <p>
 * Secondary methods (added here): averageColor, mostFrequent
 * </p>
 *
 * @author Amanda
 */
public interface ColorPalette extends ColorPaletteKernel {

    /**
     * Computes the average (blended) color of all colors in this palette.
     *
     * @return the average Color; returns black (0, 0, 0) if the palette is
     *         empty
     * @ensures averageColor = [average RGB value of all colors if not empty,
     *          else (0, 0, 0)]
     */
    Color averageColor();

    /**
     * Returns the most frequent color in this palette. If not empty, return the
     * most common color. If empty, return black.
     *
     * @return the most frequent color or black if empty
     * @ensures mostFrequent = [most frequent color if not empty, else (0, 0,
     *          0)]
     */
    Color mostFrequent();
}
