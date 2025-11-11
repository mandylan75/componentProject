package components.colorpalette;

import java.awt.Color;

/**
 * Layered implementations of secondary methods for {@code ColorPalette}.
 * Provides analysis methods and Object overrides using only kernel methods.
 *
 * @author Amanda
 */
public abstract class ColorPaletteSecondary implements ColorPalette {

    /*
     * Secondary Methods ------------------------------------------------------
     */

    @Override
    public Color averageColor() {
        int totalR = 0;
        int totalG = 0;
        int totalB = 0;

        if (this.isEmpty()) {
            return new Color(0, 0, 0);
        }

        ColorPalette temp = this.newInstance();

        while (!this.isEmpty()) {
            Color c = this.removeColor();
            temp.addColor(c);

            totalR += c.getRed();
            totalG += c.getGreen();
            totalB += c.getBlue();
        }

        // Restore original palette
        while (!temp.isEmpty()) {
            this.addColor(temp.removeColor());
        }

        int avgR = totalR / this.size();
        int avgG = totalG / this.size();
        int avgB = totalB / this.size();

        return new Color(avgR, avgG, avgB);
    }

    @Override
    public Color mostFrequent() {
        if (this.isEmpty()) {
            return new Color(0, 0, 0);
        }

        ColorPalette temp = this.newInstance();
        Color result = this.removeColor();
        temp.addColor(result);
        int maxCount = 1;

        while (!this.isEmpty()) {
            Color c = this.removeColor();
            temp.addColor(c);

            int count = 0;
            ColorPalette scan = temp.newInstance();

            while (!scan.isEmpty()) {
                Color scanC = scan.removeColor();
                if (scanC.equals(c)) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                result = c;
            }
        }

        // Restore original palette
        while (!temp.isEmpty()) {
            this.addColor(temp.removeColor());
        }

        return result;
    }

    /*
     * Object methods --------------------------------------------------------
     */

    @Override
    public boolean equals(Object obj) {
        assert obj != null : "Violation of: obj is not null";
        if (!(obj instanceof ColorPalette)) {
            return false;
        }

        ColorPalette other = (ColorPalette) obj;
        if (this.size() != other.size()) {
            return false;
        }

        ColorPalette tempThis = this.newInstance();
        boolean result = true;

        while (!this.isEmpty()) {
            Color c = this.removeColor();
            tempThis.addColor(c);
            if (!other.contains(c)) {
                result = false;
            }
        }

        while (!tempThis.isEmpty()) {
            this.addColor(tempThis.removeColor());
        }

        return result;
    }

    @Override
    public String toString() {
        ColorPalette temp = this.newInstance();
        String s = "[";

        while (!this.isEmpty()) {
            Color c = this.removeColor();
            temp.addColor(c);

            s += "(" + c.getRed() + ", " + c.getGreen() + ", " + c.getBlue()
                    + ")";
            if (!this.isEmpty()) {
                s += ", ";
            }
        }

        while (!temp.isEmpty()) {
            this.addColor(temp.removeColor());
        }

        s += "]";
        return s;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        ColorPalette temp = this.newInstance();

        while (!this.isEmpty()) {
            Color c = this.removeColor();
            temp.addColor(c);
            hash += c.getRed() * 31 * 31 + c.getGreen() * 31 + c.getBlue();
        }

        while (!temp.isEmpty()) {
            this.addColor(temp.removeColor());
        }

        return hash;
    }
}
