import java.awt.Color;

import components.colorpalette.ColorPalette;
import components.colorpalette.ColorPalette1;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

/**
 * Demo for the ColorPalette component showing basic color operations.
 *
 * @author Amanda Lan
 */
public final class ColorPaletteDEMO1 {

    /**
     * Private constructor to prevent instantiation.
     */
    private ColorPaletteDEMO1() {
    }

    /**
     * Main method for demo.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {
        SimpleReader reader = new SimpleReader1L();
        ColorPalette palette = new ColorPalette1();
        ColorPalette temp = new ColorPalette1();

        System.out.print("How many colors would you like to add? ");
        int count = reader.nextInteger();

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter RGB values for color " + (i + 1) + ":");

            System.out.print("  Red (0–255): ");
            int r = reader.nextInteger();

            System.out.print("  Green (0–255): ");
            int g = reader.nextInteger();

            System.out.print("  Blue (0–255): ");
            int b = reader.nextInteger();

            palette.addColor(new Color(r, g, b));
        }

        System.out.println("\nCurrent palette size: " + palette.size());

        reader.nextLine();

        System.out.print("\n Remove the last color? (yes/no) ");
        String removeResp = reader.nextLine();
        if (removeResp.equalsIgnoreCase("yes")) {
            if (!palette.isEmpty()) {
                Color removed = palette.removeColor();
                System.out.println("Removed color: " + removed);
            } else {
                System.out.println("Palette is empty, nothing to remove.");
            }
        } else {
            System.out.println("No color removed.");
        }

        System.out.println("\nCreating a temporary palette...");
        temp.addColor(new Color(0, 255, 255)); // cyan
        temp.addColor(new Color(255, 0, 255)); // magenta
        temp.addColor(new Color(255, 165, 0)); // orange
        System.out.println("Temporary palette size: " + temp.size());

        System.out.print(
                "\nTransfer colors from temp to main palette? (yes/no) ");
        String transferResp = reader.nextLine();
        if (transferResp.equalsIgnoreCase("yes")) {
            palette.transferFrom(temp);
            System.out.println("Transfer complete.");
            System.out.println("Main palette size: " + palette.size());
            System.out.println("Temp palette size: " + temp.size());
        } else {
            System.out.println("No transfer performed.");
        }

        System.out.print("\nClear the main palette? (yes/no) ");
        String clearResp = reader.nextLine();
        if (clearResp.equalsIgnoreCase("yes")) {
            palette.clear();
            System.out.println("Palette cleared.");
        } else {
            System.out.println("Palette left unchanged.");
        }

        System.out.println("\nFinal palette size: " + palette.size());

        reader.close();
    }

}
