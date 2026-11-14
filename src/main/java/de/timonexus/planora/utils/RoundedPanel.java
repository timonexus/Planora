package de.timonexus.planora.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.EnumSet;
import java.util.Set;

import javax.swing.JPanel;

public class RoundedPanel extends JPanel {

    // Sichtbare Panel-Größe
    private int panelWidth;
    private int panelHeight;

    // Eckenradien
    private double topLeftRadius;
    private double topRightRadius;
    private double bottomRightRadius;
    private double bottomLeftRadius;

    // Abgerundeter Rahmen
    private Color roundedBorderColor;
    private float roundedBorderWidth;
    private BorderPlacement roundedBorderPlacement =
            BorderPlacement.INSIDE;

    // Einzelne Seitenrahmen
    private Color sideBorderColor;
    private float sideBorderWidth;
    private final Set<Side> sideBorders =
            EnumSet.noneOf(Side.class);

    // Schatten
    private Color shadowColor = new Color(0, 0, 0, 100);
    private float shadowBlur = 12;
    private float shadowOffsetX = 0;
    private float shadowOffsetY = 4;
    private float shadowOpacity = 0.5f;
    private ShadowType shadowType = ShadowType.NONE;

    // Zusätzlicher Platz für den Schatten
    private int shadowPaddingLeft;
    private int shadowPaddingTop;
    private int shadowPaddingRight;
    private int shadowPaddingBottom;

    public enum BorderPlacement {
        INSIDE,
        OUTSIDE
    }

    public enum Side {
        TOP, RIGHT, BOTTOM, LEFT
    }

    public enum ShadowType {
        NONE,
        OUTLINE,
        INLINE
    }

    // Konstruktoren

    public RoundedPanel(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException(
                    "Breite und Höhe dürfen nicht negativ sein.");
        }

        panelWidth = width;
        panelHeight = height;

        setOpaque(false);
        updateShadowPadding();
    }

    public RoundedPanel() {
        this(0, 0);
    }

    // Panel-Größe ändern

    public void setPanelSize(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException(
                    "Breite und Höhe dürfen nicht negativ sein.");
        }

        panelWidth = width;
        panelHeight = height;

        updatePreferredSize();
    }

    public int getPanelWidth() {
        return panelWidth;
    }

    public int getPanelHeight() {
        return panelHeight;
    }

    private void updatePreferredSize() {
        int width = panelWidth > 0
                ? panelWidth
                : getWidth();

        int height = panelHeight > 0
                ? panelHeight
                : getHeight();

        setPreferredSize(new Dimension(
                width + shadowPaddingLeft + shadowPaddingRight,
                height + shadowPaddingTop + shadowPaddingBottom
        ));

        revalidate();
        repaint();
    }

    // Eckenradien

    public void setRadius(double radius) {
        setCornerRadii(radius, radius, radius, radius);
    }

    public void setCornerRadii(
            double topLeft,
            double topRight,
            double bottomRight,
            double bottomLeft) {

        topLeftRadius = Math.max(0, topLeft);
        topRightRadius = Math.max(0, topRight);
        bottomRightRadius = Math.max(0, bottomRight);
        bottomLeftRadius = Math.max(0, bottomLeft);

        repaint();
    }

    // Abgerundeter Rahmen

    public void setRoundedBorder(
            Color color,
            float width,
            BorderPlacement placement) {

        if (width < 0 || placement == null) {
            throw new IllegalArgumentException(
                    "Ungültige Rahmeneinstellung.");
        }

        roundedBorderColor = color;
        roundedBorderWidth = width;
        roundedBorderPlacement = placement;

        repaint();
    }

    public void removeRoundedBorder() {
        roundedBorderColor = null;
        roundedBorderWidth = 0;

        repaint();
    }

    // Einzelne Seitenrahmen

    public void setSideBorder(
            Color color,
            float width,
            Side... sides) {

        if (width < 0) {
            throw new IllegalArgumentException(
                    "Rahmenbreite darf nicht negativ sein.");
        }

        sideBorderColor = color;
        sideBorderWidth = width;
        sideBorders.clear();

        if (sides != null) {
            for (Side side : sides) {
                if (side != null) {
                    sideBorders.add(side);
                }
            }
        }

        repaint();
    }

    public void removeSideBorder() {
        sideBorders.clear();
        sideBorderColor = null;
        sideBorderWidth = 0;

        repaint();
    }

    // Schatten konfigurieren

    public void setShadow(
            ShadowType type,
            Color color,
            float blur,
            float offsetX,
            float offsetY,
            float opacity) {

        if (type == null
                || blur < 0
                || opacity < 0
                || opacity > 1) {

            throw new IllegalArgumentException(
                    "Ungültige Schatteneinstellung.");
        }

        shadowType = type;
        shadowColor = color == null ? Color.BLACK : color;
        shadowBlur = blur;
        shadowOffsetX = offsetX;
        shadowOffsetY = offsetY;
        shadowOpacity = opacity;

        updateShadowPadding();
    }

    public void removeShadow() {
        shadowType = ShadowType.NONE;
        updateShadowPadding();
    }

    private void updateShadowPadding() {
        if (shadowType != ShadowType.OUTLINE) {
            shadowPaddingLeft = 0;
            shadowPaddingTop = 0;
            shadowPaddingRight = 0;
            shadowPaddingBottom = 0;
        } else {
            int blurPadding = (int) Math.ceil(shadowBlur * 2);

            shadowPaddingLeft = blurPadding
                    + (int) Math.ceil(Math.max(0, -shadowOffsetX));

            shadowPaddingRight = blurPadding
                    + (int) Math.ceil(Math.max(0, shadowOffsetX));

            shadowPaddingTop = blurPadding
                    + (int) Math.ceil(Math.max(0, -shadowOffsetY));

            shadowPaddingBottom = blurPadding
                    + (int) Math.ceil(Math.max(0, shadowOffsetY));
        }

        updatePreferredSize();
    }

    // Form mit vier unterschiedlichen Radien

    private Path2D createShape(
            double x,
            double y,
            double width,
            double height) {

        Path2D path = new Path2D.Double();

        if (width <= 0 || height <= 0) {
            return path;
        }

        double maxRadius = Math.min(width, height) / 2.0;

        double tl = Math.min(topLeftRadius, maxRadius);
        double tr = Math.min(topRightRadius, maxRadius);
        double br = Math.min(bottomRightRadius, maxRadius);
        double bl = Math.min(bottomLeftRadius, maxRadius);

        // Verhindern, dass benachbarte Radien überlappen
        double scale = 1.0;

        scale = Math.min(scale, ratio(width, tl + tr));
        scale = Math.min(scale, ratio(width, bl + br));
        scale = Math.min(scale, ratio(height, tl + bl));
        scale = Math.min(scale, ratio(height, tr + br));

        tl *= scale;
        tr *= scale;
        br *= scale;
        bl *= scale;

        path.moveTo(x + tl, y);

        path.lineTo(x + width - tr, y);
        path.quadTo(
                x + width, y,
                x + width, y + tr
        );

        path.lineTo(x + width, y + height - br);
        path.quadTo(
                x + width, y + height,
                x + width - br, y + height
        );

        path.lineTo(x + bl, y + height);
        path.quadTo(
                x, y + height,
                x, y + height - bl
        );

        path.lineTo(x, y + tl);
        path.quadTo(
                x, y,
                x + tl, y
        );

        path.closePath();

        return path;
    }

    private double ratio(double available, double requested) {
        return requested <= 0
                ? 1.0
                : Math.min(1.0, available / requested);
    }

    // Zeichnen

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setRenderingHint(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY
        );

        /*
         * WICHTIG:
         * Wenn keine feste Panel-Größe gesetzt wurde, verwenden wir
         * die tatsächliche Größe der Swing-Komponente.
         *
         * Dadurch funktioniert auch:
         * new RoundedPanel();
         * roundedPanel.setBounds(20, 70, 500, 300);
         */
        boolean usesComponentSize =
                panelWidth <= 0 || panelHeight <= 0;

        double x = usesComponentSize ? 0 : shadowPaddingLeft;
        double y = usesComponentSize ? 0 : shadowPaddingTop;

        double width = panelWidth > 0
                ? panelWidth
                : getWidth();

        double height = panelHeight > 0
                ? panelHeight
                : getHeight();

        /*
         * Bei Verwendung von setBounds() muss der Schatten innerhalb
         * der verfügbaren Komponentengröße bleiben, da Swing die
         * Zeichenfläche nicht automatisch vergrößert.
         */
        if (usesComponentSize) {
            width = Math.max(0,
                    getWidth() - shadowPaddingLeft - shadowPaddingRight);

            height = Math.max(0,
                    getHeight() - shadowPaddingTop - shadowPaddingBottom);

            x = shadowPaddingLeft;
            y = shadowPaddingTop;
        }

        if (width <= 0 || height <= 0) {
            g2.dispose();
            return;
        }

        Path2D shape = createShape(x, y, width, height);

        // Outline-Schatten hinter dem Panel
        if (shadowType == ShadowType.OUTLINE) {
            paintOutlineShadow(g2, x, y, width, height);
        }

        // Hintergrund
        if (getBackground() != null) {
            g2.setColor(getBackground());
            g2.fill(shape);
        }

        // Inline-Schatten
        if (shadowType == ShadowType.INLINE) {
            paintInlineShadow(g2, x, y, width, height, shape);
        }

        // Abgerundeter Rahmen
        if (roundedBorderColor != null && roundedBorderWidth > 0) {
            g2.setColor(roundedBorderColor);
            g2.setStroke(new BasicStroke(roundedBorderWidth));

            double inset = roundedBorderWidth / 2.0;

            double borderX = x + inset;
            double borderY = y + inset;
            double borderWidth = Math.max(0, width - 2 * inset);
            double borderHeight = Math.max(0, height - 2 * inset);

            if (roundedBorderPlacement == BorderPlacement.OUTSIDE) {
                /*
                 * Die Linie wird auf der Außenkante zentriert.
                 * Ein Teil der Linie kann deshalb außerhalb der
                 * Form liegen. Die Zeichenfläche bleibt begrenzt.
                 */
                borderX = x + inset;
                borderY = y + inset;
            }

            g2.draw(createShape(
                    borderX,
                    borderY,
                    borderWidth,
                    borderHeight
            ));
        }

        // Einzelne Seitenrahmen
        if (sideBorderColor != null && sideBorderWidth > 0) {
            g2.setColor(sideBorderColor);
            g2.setStroke(new BasicStroke(sideBorderWidth));

            double half = sideBorderWidth / 2.0;

            if (sideBorders.contains(Side.TOP)) {
                g2.draw(new Line2D.Double(
                        x, y + half,
                        x + width, y + half
                ));
            }

            if (sideBorders.contains(Side.RIGHT)) {
                g2.draw(new Line2D.Double(
                        x + width - half, y,
                        x + width - half, y + height
                ));
            }

            if (sideBorders.contains(Side.BOTTOM)) {
                g2.draw(new Line2D.Double(
                        x, y + height - half,
                        x + width, y + height - half
                ));
            }

            if (sideBorders.contains(Side.LEFT)) {
                g2.draw(new Line2D.Double(
                        x + half, y,
                        x + half, y + height
                ));
            }
        }

        g2.dispose();
    }

    // Outline-Schatten

    private void paintOutlineShadow(
            Graphics2D g2,
            double x,
            double y,
            double width,
            double height) {

        int layers = Math.max(1, (int) Math.ceil(shadowBlur * 2));

        for (int i = layers; i >= 1; i--) {
            double spread = shadowBlur * i / layers;

            int alpha = Math.min(
                    255,
                    Math.round(255f * shadowOpacity / layers)
            );

            g2.setColor(new Color(
                    shadowColor.getRed(),
                    shadowColor.getGreen(),
                    shadowColor.getBlue(),
                    alpha
            ));

            g2.fill(createShape(
                    x + shadowOffsetX - spread,
                    y + shadowOffsetY - spread,
                    width + 2 * spread,
                    height + 2 * spread
            ));
        }
    }

    // Inline-Schatten

    private void paintInlineShadow(
            Graphics2D g2,
            double x,
            double y,
            double width,
            double height,
            Path2D shape) {

        Graphics2D shadowGraphics = (Graphics2D) g2.create();

        // Schatten bleibt innerhalb der abgerundeten Fläche
        shadowGraphics.clip(shape);

        int layers = Math.max(1, (int) Math.ceil(shadowBlur * 2));

        for (int i = layers; i >= 1; i--) {
            float spread = shadowBlur * i / layers;

            int alpha = Math.min(
                    255,
                    Math.round(255f * shadowOpacity / layers)
            );

            shadowGraphics.setColor(new Color(
                    shadowColor.getRed(),
                    shadowColor.getGreen(),
                    shadowColor.getBlue(),
                    alpha
            ));

            shadowGraphics.setStroke(new BasicStroke(
                    spread * 2,
                    BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND
            ));

            shadowGraphics.draw(createShape(
                    x + shadowOffsetX,
                    y + shadowOffsetY,
                    Math.max(0, width - shadowOffsetX),
                    Math.max(0, height - shadowOffsetY)
            ));
        }

        shadowGraphics.dispose();
    }
}