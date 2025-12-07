package components.colorpalette;

import java.awt.Color;

/**
 * {@code ColorPalette1} represented as an array of {@code Color} with
 * implementations of primary methods.
 *
 * @convention 0 <= this.count <= this.colors.length and for all i in [0,
 *             this.count), this.colors[i] is a valid Color object
 *
 * @correspondence this = [the sequence of colors in this.colors[0..this.count -
 *                 1]]
 *
 * @author Amanda Lan
 */
public final class ColorPalette1 extends ColorPaletteSecondary {

    /**
     * Array storing the colors in this palette.
     */
    private Color[] colors;

    /**
     * Number of colors currently in this palette.
     */
    private int count;

    /**
     * Creates a new, empty {@code ColorPalette1}.
     */
    public ColorPalette1() {
        this.createNewRep();
    }

    /**
     * Creates a new, empty internal representation.
     */
    private void createNewRep() {
        final int defaultCapacity = 100;
        this.colors = new Color[defaultCapacity];
        this.count = 0;
    }

    @Override
    public void addColor(Color c) {
        assert c != null : "Violation of: c is not null";
        assert this.count < this.colors.length : "Violation of: palette not full";

        this.colors[this.count] = c;
        this.count++;
    }

    @Override
    public Color removeColor() {
        assert this.count > 0 : "Violation of: this is not empty";

        this.count--;
        Color removed = this.colors[this.count];
        this.colors[this.count] = null;
        return removed;
    }

    @Override
    public boolean contains(Color c) {
        assert c != null : "Violation of: c is not null";

        boolean found = false;
        int i = 0;
        while (i < this.count && !found) {
            if (this.colors[i].equals(c)) {
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public ColorPalette1 newInstance() {
        return new ColorPalette1();
    }

    @Override
    public void transferFrom(ColorPalette source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";

        ColorPalette1 src = (ColorPalette1) source;

        this.colors = src.colors;
        this.count = src.count;

        src.createNewRep();
    }
}
