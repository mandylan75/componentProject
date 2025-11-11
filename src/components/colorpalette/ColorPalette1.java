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

    /**
     * Adds the given color to this palette.
     *
     * @param c
     *            the color to add
     * @updates this
     * @requires c is not null and this.size() < this.colors.length
     * @ensures this = #this * <c>
     */
    @Override
    public void addColor(Color c) {
        assert c != null : "Violation of: c is not null";
        assert this.count < this.colors.length : "Violation of: palette not full";

        this.colors[this.count] = c;
        this.count = this.count + 1;
    }

    /**
     * Removes and returns the last color in this palette.
     *
     * @updates this
     * @requires this.size() > 0
     * @ensures removeColor = [the last color of #this] and this = [#this
     *          without its last color]
     */
    @Override
    public Color removeColor() {
        assert this.count > 0 : "Violation of: this is not empty";

        this.count = this.count - 1;
        Color removed = this.colors[this.count];
        this.colors[this.count] = null;
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
    @Override
    public boolean contains(Color c) {
        assert c != null : "Violation of: c is not null";

        boolean found = false;
        int i = 0;
        while (i < this.count && !found) {
            if (this.colors[i].equals(c)) {
                found = true;
            } else {
                i = i + 1;
            }
        }
        return found;
    }

    /**
     * Returns the number of colors in this palette.
     *
     * @return the number of colors in this
     * @ensures size = |this|
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Checks whether this palette is empty.
     *
     * @return true if this has no colors, false otherwise
     * @ensures isEmpty = (|this| = 0)
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Clears this palette, resetting it to the empty state.
     *
     * @updates this
     * @ensures this = {}
     */
    @Override
    public void clear() {
        this.createNewRep();
    }

    /**
     * Creates and returns a new instance of this component type.
     *
     * @return a new empty {@code ColorPalette1}
     * @ensures newInstance = new ColorPalette1 and newInstance = {}
     */
    @Override
    public ColorPalette1 newInstance() {
        return new ColorPalette1();
    }

    /**
     * Transfers the contents of the given palette into this one.
     *
     * @param source
     *            the source palette
     * @updates this, source
     * @requires source is not this
     * @ensures this = #source and source = {}
     */
    @Override
    public void transferFrom(ColorPalette source) {
        assert source != this : "Violation of: source is not this";

        this.clear();
        while (!source.isEmpty()) {
            this.addColor(source.removeColor());
        }
    }
}
