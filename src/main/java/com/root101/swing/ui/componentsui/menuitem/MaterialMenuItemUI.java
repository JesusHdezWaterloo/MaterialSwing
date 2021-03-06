package com.root101.swing.ui.componentsui.menuitem;

import com.root101.swing.util.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuItemUI;
import java.awt.*;

public class MaterialMenuItemUI extends BasicMenuItemUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialMenuItemUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JMenuItem menuItem = (JMenuItem) c;
        menuItem.setFont(UIManager.getFont("MenuItem.font"));
        menuItem.setBackground(UIManager.getColor("MenuItem.background"));
        menuItem.setForeground(UIManager.getColor("MenuItem.foreground"));
        menuItem.setHorizontalAlignment(SwingConstants.LEFT);
        menuItem.setVerticalAlignment(SwingConstants.CENTER);
        menuItem.setBorder(UIManager.getBorder("MenuItem.border"));
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }
}
