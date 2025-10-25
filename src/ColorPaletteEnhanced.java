import java.awt.Color;

/**
 * Enhanced interface for {@code ColorPalette}.
 *
 * Extends the basic kernel with additional operations for color analysis.
 *
 * @author Amanda Lan
 */
public interface ColorPaletteEnhanced extends ColorPaletteKernel {

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
     * first color. If empty, return black.
     *
     * @return the most frequent color or black if empty
     * @ensures mostFrequent = [first color in palette if not empty, else (0, 0,
     *          0)]
     */
    Color mostFrequent();
}
