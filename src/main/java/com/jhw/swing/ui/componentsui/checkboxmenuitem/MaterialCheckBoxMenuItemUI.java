package com.jhw.swing.ui.componentsui.checkboxmenuitem;

import com.jhw.swing.util.MaterialDrawingUtils;

import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialCheckBoxMenuItemUI extends BasicCheckBoxMenuItemUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialCheckBoxMenuItemUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        c.setBackground(UIManager.getColor("CheckBoxMenuItem.background"));
        c.setForeground(UIManager.getColor("CheckBoxMenuItem.foreground"));
        c.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }

    @Override
    protected void paintMenuItem(Graphics g, JComponent c, Icon checkIcon, Icon arrowIcon, Color background, Color foreground, int defaultTextIconGap) {
        JCheckBoxMenuItem checkBoxMenuItem = (JCheckBoxMenuItem) c;
        if (checkBoxMenuItem.isSelected()) {
            super.paintMenuItem(MaterialDrawingUtils.getAliasedGraphics(g), checkBoxMenuItem, UIManager.getIcon("CheckBoxMenuItem.selectedCheckIcon"), arrowIcon, background, foreground, defaultTextIconGap);
            return;
        }
        super.paintMenuItem(MaterialDrawingUtils.getAliasedGraphics(g), checkBoxMenuItem, UIManager.getIcon("CheckBoxMenuItem.checkIcon"), arrowIcon, background, foreground, defaultTextIconGap);
    }
}
