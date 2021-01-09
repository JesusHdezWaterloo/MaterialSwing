package com.root101.swing.ui.componentsui.tooltip;

import com.root101.swing.util.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToolTipUI;
import java.awt.*;

public class MaterialToolTipUI extends BasicToolTipUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialToolTipUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }
}