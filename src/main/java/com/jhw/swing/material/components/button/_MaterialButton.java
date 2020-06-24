package com.jhw.swing.material.components.button;

import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import com.jhw.swing.material.standars.MaterialShadow;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.util.icons.icon_ttf.IconTTF;
import com.jhw.swing.material.effects.ElevationEffect;
import com.jhw.swing.material.effects.RippleEffect;
import com.jhw.swing.util.interfaces.MaterialComponent;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.effects.ColorFadeInto;
import com.jhw.swing.material.effects.ColorFadeInto.ColorChangeTo;
import com.jhw.swing.util.icons.DerivableIcon;

/**
 * A Material Design button.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html">Buttons
 * (Google design guidelines)</a>
 */
public class _MaterialButton extends JButton implements MaterialComponent {

    private final int DISTANCE_ICON_TEXT = 2;

    private ColorFadeInto fadeinto;
    private RippleEffect ripple = RippleEffect.applyTo(this);
    private ElevationEffect elevation = ElevationEffect.applyTo(this, MaterialShadow.ELEVATION_NONE);
    private Type type = Type.DEFAULT;
    private boolean isMousePressed = false;
    private boolean isMouseOver = false;
    private Color rippleColor = Color.WHITE;
    private Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    private int borderRadius = 5;

    /**
     * Creates a new button.
     */
    public _MaterialButton() {
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
        this.setCursor(cursor);
        this.setPreferredSize(new Dimension(145, 65));
        this.setFocusable(false);

        this.setOpaque(false);

        this.setBackground(MaterialColors.RED_500);
        fadeinto = new ColorFadeInto(this, ColorFadeInto.ColorChangeTo.DARKEN);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                isMousePressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                isMousePressed = false;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseOver = false;
                repaint();
            }
        });

        this.setUI(new BasicButtonUI() {
            @Override
            public boolean contains(JComponent c, int x, int y) {
                return x > MaterialShadow.OFFSET_LEFT && y > MaterialShadow.OFFSET_TOP
                        && x < getWidth() - MaterialShadow.OFFSET_RIGHT && y < getHeight() - MaterialShadow.OFFSET_BOTTOM;
            }
        });

    }

    public void setElevation(ElevationEffect elevation) {
        this.elevation = elevation;
        repaint();
    }

    public void setIcon(ImageIcon icon) {
        if (icon instanceof DerivableIcon) {
            icon = ((DerivableIcon) icon).deriveIcon(getForeground());
        }
        super.setIcon(icon);
    }

    /**
     * Set the color where the fadeinto color will fade.
     *
     * @param to Color to fade into.
     */
    public void setColorChangeTo(ColorChangeTo to) {
        fadeinto = new ColorFadeInto(this, to);
    }

    /**
     * Flag to the property when the mouse is over the element.
     *
     * @return true if mouse is over, false otherwise.
     */
    public boolean isMouseOver() {
        return isMouseOver;
    }

    /**
     * Gets the type of this button.
     *
     * @return the type of this button
     * @see Type
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the type of this button.
     *
     * @param type the type of this button
     * @see Type
     */
    public void setType(Type type) {
        this.type = type;
        setEnabled(true);//para que pinte la sombra
        repaint();
    }

    /**
     * Sets the Background color of this button.
     * <p>
     * Keep on mind that setting a background color in a Material component like
     * this will also set the foreground color to either white or black and the
     * ripple color to white or darker shade of the color, depending of how
     * bright or dark is the chosen backgroundReal color. If you want to use a
     * custom foreground color and ripple color, ensure the background color has
     * been set first.
     * <p>
     * <b>NOTE:</b> It is up to the look and feel to honor this property, some
     * may choose to ignore it. To avoid any conflicts, using the
     * <a
     * href="https://docs.oracle.com/javase/7/docs/api/javax/swing/plaf/metal/package-summary.html">
     * Metal Look and Feel</a> is recommended.
     */
    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        setForeground(Utils.getForegroundAccording(bg));
        setRippleColor(Utils.getForegroundAccording(bg));
        fadeinto = new ColorFadeInto(this, ColorFadeInto.ColorChangeTo.DARKEN);
    }

    /**
     * Gets the ripple color.
     *
     * @return the ripple color
     */
    public Color getRippleColor() {
        return rippleColor;
    }

    /**
     * Sets the ripple color. You should only do this for flat buttons.
     *
     * @param rippleColor the ripple color
     */
    public void setRippleColor(Color rippleColor) {
        this.rippleColor = rippleColor;
    }

    /**
     * Gets the current border radius of this button.
     *
     * @return the current border radius of this button, in pixels.
     */
    public int getBorderRadius() {
        return borderRadius;
    }

    /**
     * Sets the border radius of this button. You can define a custom radius in
     * order to get some rounded corners in your button, making it look like a
     * pill or even a circular action button.
     *
     * @param borderRadius the new border radius of this button, in pixels.
     */
    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
        elevation.setBorderRadius(borderRadius);
    }

    /**
     * Set the button enable. Include changing the elevation and the curson
     * according.
     *
     * @param b Boolean whit the enability.
     */
    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        elevation.setLevel(getElevation());
        super.setCursor(b ? cursor : Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    /**
     * Set the cursor of the component.
     *
     * @param cursor Cursor of the component.
     */
    @Override
    public void setCursor(Cursor cursor) {
        super.setCursor(cursor);
        this.cursor = cursor;
    }

    @Override
    protected void processFocusEvent(FocusEvent focusEvent) {
        super.processFocusEvent(focusEvent);
        elevation.setLevel(getElevation());
        fadeinto.update();
    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent) {
        super.processMouseEvent(mouseEvent);
        elevation.setLevel(getElevation());
        fadeinto.update();
    }

    protected ElevationEffect getElevationEffect() {
        return elevation;
    }

    public RippleEffect getRippleEffect() {
        return ripple;
    }

    public ColorFadeInto getFadeinto() {
        return fadeinto;
    }

    protected int getElevation() {
        if (isMousePressed) {
            return 2;
        } else if (type == Type.RAISED || isFocusOwner() || isMouseOver) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        if (type != Type.FLAT && isEnabled()) {
            elevation.paint(g2);
        }
        g2.translate(MaterialShadow.OFFSET_LEFT, MaterialShadow.OFFSET_TOP);

        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;

        if (isEnabled()) {
            //fadeinto.update();
            g2.setColor(fadeinto.getColor());
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, borderRadius * 2, borderRadius * 2));

            g2.setColor(new Color(rippleColor.getRed() / 255f, rippleColor.getBlue() / 255f, rippleColor.getBlue() / 255f, 0.12f));
            if ((type == Type.FLAT && isMouseOver) || isFocusOwner()) {
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, borderRadius * 2, borderRadius * 2));
            }
        } else {
            Color bg = getBackground();
            g2.setColor(new Color(bg.getRed() / 255f, bg.getGreen() / 255f, bg.getBlue() / 255f, 0.6f));
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, borderRadius * 2, borderRadius * 2));
        }

        if (this.isEnabled()) {//el ripple por debajo de las letras e iconos
            g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, Math.max(borderRadius * 2 - 4, 0), Math.max(borderRadius * 2 - 4, 0)));
            g2.setColor(rippleColor);
            ripple.paint(g2);
        }

        int iconWidth = 0;
        if (getIcon() != null) {
            iconWidth = getIcon().getIconWidth();
        }

        FontMetrics metrics = g2.getFontMetrics(getFont());
        int y = (getHeight() - offset_td - metrics.getHeight()) / 2 + metrics.getAscent();

        int xText = 0;
        int xIcon = 0;
        int widthReal = getWidth() - offset_lr;
        int strWidth = metrics.stringWidth(getText());
        int align = getHorizontalAlignment();

        if (align == SwingConstants.TRAILING || align == SwingConstants.RIGHT) {
            xText = widthReal - strWidth - 2 * DISTANCE_ICON_TEXT;
            xIcon = xText - iconWidth - 2 * DISTANCE_ICON_TEXT;
        } else if (align == SwingConstants.LEADING || align == SwingConstants.LEFT) {
            xIcon = DISTANCE_ICON_TEXT;
            xText = iconWidth + DISTANCE_ICON_TEXT;
        } else {
            xText = (widthReal - strWidth) / 2 + DISTANCE_ICON_TEXT / 2 + iconWidth / 2;
            xIcon = xText - iconWidth - DISTANCE_ICON_TEXT;
        }

        Color fg = this.getForeground();
        if (!this.isEnabled()) {
            g2.setColor(new Color(fg.getRed() / 255f, fg.getGreen() / 255f, fg.getBlue() / 255f, 0.6f));
        }
        g2.setColor(fg);
        g2.setFont(getFont());
        g2.drawString(this.getText(), xText, y);

        if (this.getIcon() != null) {
            this.getIcon().paintIcon(this, g2, xIcon, (getHeight() - offset_td - getIcon().getIconHeight()) / 2);
        }

        g2.translate(-MaterialShadow.OFFSET_LEFT, -MaterialShadow.OFFSET_TOP);
    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

    /**
     * Button types.
     */
    public enum Type {

        /**
         * A default button.
         */
        DEFAULT,
        /**
         * A raised button. Raised buttons have a shadow even if they are not
         * focused.
         */
        RAISED,
        /**
         * A flat button. Flat buttons don't have shadows and are typically
         * transparent.
         */
        FLAT
    }
}
