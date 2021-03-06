/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.container.panel;

import com.root101.module.util.personalization.core.domain.Personalization;
import com.root101.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.effects.DefaultMaterialLineBorder;
import com.root101.swing.material.effects.MaterialLineBorder;
import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.util.enums.GradientEnum;
import com.root101.swing.material.standards.MaterialColors;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Stroke;

/**
 * Componente extraido su logica de edisoncorSX.
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _PanelGradient extends MaterialPanelBorder {

    public static _PanelGradient from() {
        return MaterialSwingInjector.getImplementation(_PanelGradient.class);
    }

    private final MaterialLineBorder border = DefaultMaterialLineBorder.builder().borderRadius(5).listeners(this).build();

    protected Color primaryColor = MaterialColors.BLUE_600;
    protected Color secundaryColor = MaterialColors.BLACK;

    protected GradientEnum gradient = GradientEnum.HORIZONTAL;

    private Icon icon;

    /**
     * Use _PanelGradient.from() para proy y AOP
     *
     * @deprecated
     */
    @Deprecated
    public _PanelGradient() {
        this(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BACKGROUND_PANEL));
    }

    /**
     * Use _PanelGradient.from() para proy y AOP
     *
     * @deprecated
     */
    @Deprecated
    public _PanelGradient(Color back) {
        this.setBackground(back);
        setBorderRadius(0);
        this.setLayout(new BorderLayout());
    }
//-----------------LINE_BORDER------------------------

    @Override
    public float getBorderThickness() {
        return border.getBorderThickness();
    }

    @Override
    public void setBorderThickness(float thickness) {
        border.setBorderThickness(thickness);
    }

    @Override
    public Color getBorderColor() {
        return border.getBorderColor();
    }

    @Override
    public void setBorderColor(Color color) {
        border.setBorderColor(color);
    }

    @Override
    public int getBorderRadius() {
        return border.getBorderRadius();
    }

    @Override
    public void setBorderRadius(int borderRadius) {
        this.border.setBorderRadius(borderRadius);
    }

    @Override
    public Stroke getBorderStroke() {
        return border.getBorderStroke();
    }

    @Override
    public void setBorderStroke(Stroke stroke) {
        border.setBorderStroke(stroke);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        border.paintBorder(c, g, x, y, width, height);
    }
//-----------------LINE_BORDER------------------------

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        this.setPrimaryColor(bg);
        this.setSecundaryColor(bg);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        g2.translate(getBorderThickness() / 2, getBorderThickness() / 2);

        if (this.icon != null) {
            if (icon instanceof ImageIcon) {//si es image icon lo pinto completo de todo el tamanno
                g2.drawImage(((ImageIcon) this.icon).getImage(), 0, 0, getWidth(), getHeight(), null);
            } else {//si no lo pinto como un simple icon
                icon.paintIcon(this, g2, (getWidth() - icon.getIconWidth()) / 2, (getHeight() - icon.getIconHeight()) / 2);
            }
        } else {
            g2.setPaint(getGradientePaint());
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - getBorderThickness(), getHeight() - getBorderThickness(), getBorderRadius() * 2, getBorderRadius() * 2));
            g2.setColor(getForeground());

            paintBorder(this, g2, 0, 0, (int) (getWidth()), (int) (getHeight()));
        }
        g2.translate(-getBorderThickness(), -getBorderThickness());

    }

    public Paint getGradientePaint() {
        int x2 = getWidth();
        int y2 = getHeight();
        switch (this.gradient) {
            case HORIZONTAL:
                return new GradientPaint((float) (getWidth() / 2), (float) 0, this.primaryColor, (float) (getWidth() / 2), (float) getHeight(), this.secundaryColor);
            case HORIZONTAL_3_4:
                return new GradientPaint((float) (getWidth() / 2), (float) getHeight() / 4, this.primaryColor, (float) (getWidth() / 2), (float) getHeight(), this.secundaryColor);
            case VERTICAL:
                return new GradientPaint((float) 0, (float) (getHeight() / 2), this.primaryColor, (float) getWidth(), (float) (getHeight() / 2), this.secundaryColor);
            case VERTICAL_3_4:
                return new GradientPaint((float) getWidth() / 4, (float) (getHeight() / 2), this.primaryColor, (float) getWidth(), (float) (getHeight() / 2), this.secundaryColor);
            case ESQUINA_1:
                return new RadialGradientPaint((float) 0, (float) 0, (float) getWidth(), new float[]{0.0f, 1.0f}, new Color[]{this.primaryColor, this.secundaryColor});
            case ESQUINA_2:
                return new RadialGradientPaint((float) getWidth(), (float) 0, (float) getWidth(), new float[]{0.0f, 1.0f}, new Color[]{this.primaryColor, this.secundaryColor});
            case ESQUINA_3:
                return new RadialGradientPaint((float) getWidth(), (float) getHeight(), (float) getWidth(), new float[]{0.0f, 1.0f}, new Color[]{this.primaryColor, this.secundaryColor});
            case ESQUINA_4:
                return new RadialGradientPaint((float) 0, (float) getHeight(), (float) getWidth(), new float[]{0.0f, 1.0f}, new Color[]{this.primaryColor, this.secundaryColor});
            case CIRCULAR:
                return new RadialGradientPaint((float) (getWidth() / 2), (float) (getHeight() / 2), (float) getWidth(), new float[]{0.0f, 0.5f}, new Color[]{this.primaryColor, this.secundaryColor});
            case CENTRAL:
                return new LinearGradientPaint((float) (getWidth() / 2), (float) 0, (float) (getWidth() / 2), (float) getHeight(), new float[]{0.0f, 0.5f, 1.0f}, new Color[]{this.primaryColor, this.secundaryColor, this.primaryColor});
            case AQUA:
                return new LinearGradientPaint(0.0f, 0.0f, 0.0f, (float) getHeight(), new float[]{0.0f, 0.3f, 0.5f, 1.0f}, new Color[]{this.primaryColor.brighter().brighter(), this.primaryColor.brighter(), this.secundaryColor.darker().darker(), this.secundaryColor.darker()});
            default:
                return new GradientPaint(0.0f, 0.0f, this.primaryColor, (float) x2, (float) y2, this.secundaryColor);
        }
    }

    public Color getPrimaryColor() {
        return this.primaryColor;
    }

    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
        repaint();
    }

    public Color getSecundaryColor() {
        return this.secundaryColor;
    }

    public void setSecundaryColor(Color colorSecundario) {
        this.secundaryColor = colorSecundario;
        repaint();
    }

    public GradientEnum getGradient() {
        return this.gradient;
    }

    public void setGradient(GradientEnum gradient) {
        this.gradient = gradient;
        repaint();
    }

    @Override
    public Icon getIcon() {
        return this.icon;
    }

    @Override
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

}
