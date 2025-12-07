package components.colorpalette;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.Test;

/**
 * JUnit test fixture for {@code ColorPalette}'s kernel methods.
 *
 * Tests all kernel operations such as addColor, removeColor, contains, clear,
 * size, newInstance, and transferFrom.
 *
 * author Amanda Lan
 */
public abstract class ColorPaletteTest {

    /**
     * @return a new ColorPalette for testing
     */
    protected abstract ColorPalette constructorTest();

    /**
     * @return a new reference ColorPalette
     */
    protected abstract ColorPalette constructorRef();

    /**
     * Test the constructor creates an empty palette.
     */
    @Test
    public final void testConstructor() {
        ColorPalette test = this.constructorTest();
        ColorPalette ref = this.constructorRef();
        assertEquals(ref, test);
    }

    /**
     * Test adding a single color.
     */
    @Test
    public final void testAddOneColor() {
        ColorPalette p = this.constructorTest();
        Color c = new Color(10, 20, 30);
        p.addColor(c);
        assertEquals(1, p.size());
        assertTrue(p.contains(c));
    }

    /**
     * Test adding two colors.
     */
    @Test
    public final void testAddTwoColors() {
        ColorPalette p = this.constructorTest();
        Color c1 = new Color(100, 0, 0);
        Color c2 = new Color(0, 50, 0);
        p.addColor(c1);
        p.addColor(c2);
        assertEquals(2, p.size());
        assertTrue(p.contains(c1));
        assertTrue(p.contains(c2));
    }

    /**
     * Test removing one color.
     */
    @Test
    public final void testRemoveColor_One() {
        ColorPalette p = this.constructorTest();
        Color c = new Color(0, 0, 255);
        p.addColor(c);
        Color removed = p.removeColor();
        assertEquals(c, removed);
        assertTrue(p.isEmpty());
    }

    /**
     * Test removing from multiple colors.
     */
    @Test
    public final void testRemoveColor_Multiple() {
        ColorPalette p = this.constructorTest();
        Color c1 = new Color(10, 10, 10);
        Color c2 = new Color(20, 20, 20);
        p.addColor(c1);
        p.addColor(c2);
        Color removed = p.removeColor();
        assertEquals(c2, removed);
        assertTrue(p.contains(c1));
        assertFalse(p.contains(c2));
        assertEquals(1, p.size());
    }

    /**
     * Test contains on an empty palette.
     */
    @Test
    public final void testContains_FalseEmpty() {
        ColorPalette p = this.constructorTest();
        Color c = new Color(200, 100, 0);
        assertFalse(p.contains(c));
    }

    /**
     * Test contains when color is present.
     */
    @Test
    public final void testContains_True() {
        ColorPalette p = this.constructorTest();
        Color c = new Color(5, 5, 5);
        p.addColor(c);
        assertTrue(p.contains(c));
    }

    /**
     * Test size after adding colors.
     */
    @Test
    public final void testSize_AfterAdds() {
        ColorPalette p = this.constructorTest();
        p.addColor(new Color(0, 0, 0));
        p.addColor(new Color(1, 1, 1));
        assertEquals(2, p.size());
    }

    /**
     * Test isEmpty on a new palette.
     */
    @Test
    public final void testIsEmpty_True() {
        ColorPalette p = this.constructorTest();
        assertTrue(p.isEmpty());
    }

    /**
     * Test isEmpty when palette has colors.
     */
    @Test
    public final void testIsEmpty_False() {
        ColorPalette p = this.constructorTest();
        p.addColor(new Color(10, 20, 30));
        assertFalse(p.isEmpty());
    }

    /**
     * Test clearing a palette.
     */
    @Test
    public final void testClear() {
        ColorPalette p = this.constructorTest();
        p.addColor(new Color(10, 10, 10));
        p.addColor(new Color(20, 20, 20));
        p.clear();
        assertTrue(p.isEmpty());
        assertEquals(0, p.size());
    }

    /**
     * Test newInstance creates an empty palette.
     */
    @Test
    public final void testNewInstance() {
        ColorPalette p = this.constructorTest();
        ColorPalette n = p.newInstance();
        assertTrue(n.isEmpty());
        assertEquals(0, n.size());
    }

    /**
     * Test transferring colors from another palette.
     */
    @Test
    public final void testTransferFrom() {
        ColorPalette dest = this.constructorTest();
        ColorPalette src = this.constructorTest();
        Color c1 = new Color(5, 5, 5);
        Color c2 = new Color(10, 10, 10);

        src.addColor(c1);
        src.addColor(c2);

        dest.transferFrom(src);

        assertTrue(dest.contains(c1));
        assertTrue(dest.contains(c2));
        assertEquals(2, dest.size());
        assertTrue(src.isEmpty());
    }
}
