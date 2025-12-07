import java.awt.Color;

import components.colorpalette.ColorPalette;
import components.colorpalette.ColorPalette1;

/**
 * Simple demo for the ColorPalette component.
 *
 * @author Amanda Lan
 */
public final class ColorPaletteDEMO {
    /**
     * Prevent instantiation.
     */
    private ColorPaletteDEMO() {
    }

    /**
     * Main method for demo.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {

        // Create two empty ColorPalettes
        ColorPalette paletteA = new ColorPalette1();
        ColorPalette paletteB = new ColorPalette1();

        // Add a few colors to palette A
        paletteA.addColor(Color.RED);
        paletteA.addColor(Color.GREEN);
        paletteA.addColor(Color.BLUE);

        // Add a few colors to palette B
        paletteB.addColor(Color.YELLOW);
        paletteB.addColor(Color.MAGENTA);

        // Print out both palettes
        System.out.println("Palette A: " + paletteA);
        System.out.println("Palette B: " + paletteB);

        // Check if a specific color is in palette A
        System.out.println(
                "Palette A contains green? " + paletteA.contains(Color.GREEN));

        // Remove a color from the front of palette A
        Color removed = paletteA.removeColor();
        System.out.println("Removed from A: " + removed);

        // Move all colors from palette B into palette A
        paletteA.transferFrom(paletteB);
        System.out.println("Palette A after transferFrom(B): " + paletteA);
        System.out.println("Palette B after transferFrom: " + paletteB);

        // Clear palette A
        paletteA.clear();
        System.out.println("Palette A after clear(): " + paletteA);
    }
}
