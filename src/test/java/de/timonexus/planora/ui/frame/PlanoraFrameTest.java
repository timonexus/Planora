package de.timonexus.planora.ui.frame;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.timonexus.planora.ui.Component;
import de.timonexus.planora.utils.enums.Colors;

class PlanoraFrameTest {

    private PlanoraFrame frame;

    @BeforeEach
    void setUp() {
        this.frame = new PlanoraFrame();
    }

    @AfterEach
    void tearDown() {
        if (this.frame != null) {
            this.frame.dispose();
        }
    }

    @Test
    void testSkinFrame() {
        this.frame.skinFrame();

        assertEquals("Planora", this.frame.getTitle());
        assertEquals(new Dimension(1500, 800), this.frame.getSize());
        assertEquals(JFrame.EXIT_ON_CLOSE, this.frame.getDefaultCloseOperation());
        assertEquals(Colors.BASE.getColor(), this.frame.getContentPane().getBackground());
        assertNotNull(this.frame.getIconImage());
        assertTrue(this.frame.isUndecorated());
        assertEquals(new Color(0, 0, 0, 0), this.frame.getBackground());
        assertInstanceOf(BorderLayout.class, this.frame.getLayout());
    }

    @Test
    void testPrepareComponents() {
        assertDoesNotThrow(() -> this.frame.prepareComponents());
    }

    @Test
    void testAddComponents() {
        assertDoesNotThrow(() -> this.frame.addComponents());
    }

    @Test
    void testSetPage() {
        assertDoesNotThrow(() -> this.frame.setPage(null));
    }

    @Test
    void testRefresh() {
        assertDoesNotThrow(() -> this.frame.refresh());
    }

    @Test
    void testGetLayeredPage() {
        assertNull(this.frame.getLayeredPage());
    }

    @Test
    void testSetVisible() {
        this.frame.setVisible(true);

        assertTrue(this.frame.isVisible());

        this.frame.setVisible(false);

        assertFalse(this.frame.isVisible());
    }

    @Test
    void testMaximize() {
        this.frame.maximize();

        assertEquals(JFrame.MAXIMIZED_BOTH, this.frame.getExtendedState());

        this.frame.maximize();

        assertEquals(JFrame.NORMAL, this.frame.getExtendedState());
    }

    @Test
    void testMinimize() {
        this.frame.minimize();

        assertEquals(JFrame.ICONIFIED, this.frame.getExtendedState() & JFrame.ICONIFIED);
    }

    @Test
    void testClose() {
        this.frame.close();

        assertFalse(this.frame.isDisplayable());
    }

    @Test
    void testAdd() {
        TestComponent component = new TestComponent();

        ((Frame) this.frame).add(component, BorderLayout.CENTER);

        assertEquals(1, this.frame.getContentPane().getComponentCount());
        assertSame(component, this.frame.getContentPane().getComponent(0));
    }

    @Test
    void testIsMaximized() {
        assertFalse(this.frame.isMaximized());

        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        assertTrue(this.frame.isMaximized());
    }

    @Test
    void testGetLocation() {
        Point expectedLocation = new Point(100, 150);

        this.frame.setLocation(expectedLocation);

        assertEquals(expectedLocation, this.frame.getLocation());
    }

    @Test
    void testSetLocation() {
        Point expectedLocation = new Point(200, 250);

        this.frame.setLocation(expectedLocation);

        assertEquals(expectedLocation, this.frame.getLocation());
    }

    private static class TestComponent extends JPanel implements Component {

        @Override
        public void designComponent() {}

        @Override
        public void skinParts() {}

        @Override
        public void addParts() {}

        @Override
        public void prepareComponents() {}

        @Override
        public void addComponents() {}

        @Override
        public void refresh() {}
    }
}