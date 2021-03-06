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
package com.root101.swing.material.components.combobox;

import com.root101.swing.material.components.scrollpane.MaterialScrollFactory;
import com.root101.swing.material.effects.DefaultLine;
import com.root101.swing.material.effects.DefaultFloatingLabel;
import java.awt.*;
import java.awt.event.FocusEvent;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import com.root101.swing.material.standards.MaterialFontRoboto;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.material.effects.DefaultWrong;
import com.root101.swing.material.effects.FloatingLabel;
import com.root101.swing.material.effects.Line;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.util.Utils;
import com.root101.swing.derivable_icons.DerivableIcon;
import java.awt.event.ActionEvent;
import com.root101.swing.material.effects.Wrong;
import static com.root101.swing.material.standards.Utils.*;
import com.root101.utils.refraction.FiltrableRefraction;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * A Material Design combo box.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html#buttons-dropdown-buttons">Dropdown
 * buttons (Google design guidelines)</a>
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialComboBox<T> extends MaterialComboBox<T> {

    public static MaterialComboBox from() {
        return new _MaterialComboBox();
    }

    private FloatingLabel floatingLabel;//no se puede iniciar aqui xq da null pionter con el foreground
    private Line line = new DefaultLine(this);
    private final Wrong wrong = new DefaultWrong(this);

    private ImageIcon iconArrow = MaterialIcons.ARROW_DROP_DOWN;

    public _MaterialComboBox() {
        floatingLabel = new DefaultFloatingLabel(this);

        this.setPreferredSize(new Dimension(145, 65));
        this.setRenderer(new FieldRenderer<>(this));
        this.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup popupAct = new Popup(comboBox);
                popupAct.getAccessibleContext().setAccessibleParent(comboBox);
                return popupAct;
            }

            @Override
            protected JButton createArrowButton() {
                return null;
            }
        });

        this.addKeyListener(FilterListener.from(this));

        this.addActionListener((ActionEvent e) -> {
            clearWrong();
        });

        this.setOpaque(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));
        this.setHint("Select...");

        this.setModel(new ArrayList<>());
    }

    @Override
    public void setModel(java.util.List<T> aModel) {
        super.setModel(new DefaultComboBoxModel(aModel.toArray(new Object[aModel.size()])));
        this.setSelectedIndex(-1);
    }

    @Override
    public void addElement(T element) {
        ((DefaultComboBoxModel<T>) getModel()).addElement(element);
    }
//-------------------LINE-------------------------

    @Override
    public void paintLine(Graphics g2) {
        line.paintLine(g2);
    }

    @Override
    public int getYLine(Graphics g2) {
        return line.getYLine(g2);
    }
//-------------------FLOATING_LABEL-------------------------

    @Override
    public Color getAccentFloatingLabel() {
        return floatingLabel.getAccentFloatingLabel();
    }

    @Override
    public void setAccentFloatingLabel(Color accentColor) {
        floatingLabel.setAccentFloatingLabel(accentColor);
    }

    @Override
    public String getLabel() {
        return floatingLabel.getLabel();
    }

    @Override
    public void setLabel(String label) {
        floatingLabel.setLabel(label);
    }

    @Override
    public String getHint() {
        return floatingLabel.getHint();
    }

    @Override
    public void setHint(String hint) {
        floatingLabel.setHint(hint);
    }

    @Override
    public void paintLabel(Graphics g) {
        floatingLabel.paintLabel(g);
    }

    @Override
    public void paintHint(Graphics g) {
        floatingLabel.paintHint(g);
    }
//-------------------WRONG-------------------------

    @Override
    public void wrong() {
        wrong.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        wrong.wrong(wrongText);
    }

    @Override
    public Color getWrongColor() {
        return wrong.getWrongColor();
    }

    @Override
    public void setWrongColor(Color wrongColor) {
        wrong.setWrongColor(wrongColor);
    }

    @Override
    public void clearWrong() {
        wrong.clearWrong();
    }

    @Override
    public void paintWrong(Graphics g2, int y) {
        wrong.paintWrong(g2, y);
    }

//-------------------WRONG-------------------------
    @Override
    protected void processFocusEvent(FocusEvent e) {
        super.processFocusEvent(e);
        firePropertyChange("processFocusEvent", null, null);
    }

    protected ImageIcon getIconArrow() {
        return iconArrow;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        int yMid = getSize().height / 2;

        paintLabel(g2);

        FontMetrics metrics = g2.getFontMetrics(g2.getFont());
        g2.setFont(getFont());
        if (getSelectedItem() == null && isFocusOwner()) {
            paintHint(g2);
        } else if (getSelectedItem() != null) {
            if (isEnabled()) {
                g2.setColor(getForeground());
            } else {
                g2.setColor(Utils.applyAlphaMask(getForeground(), HINT_OPACITY_MASK));
            }
            g2.drawString(getSelectedItem().toString(), 0, metrics.getAscent() + yMid - metrics.getAscent() / 2);
        }
        paintLine(g2);

        paintWrong(g2, getYLine(g2) + 15);

        //paint the arrow
        if (iconArrow != null) {
            Color iconColor;
            if (isFocusOwner()) {
                iconColor = getAccentFloatingLabel();
            } else {
                iconColor = Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK);
            }
            if (iconArrow instanceof DerivableIcon) {
                iconArrow = ((DerivableIcon) iconArrow).deriveIcon(iconColor);
            }
            iconArrow.paintIcon(this, g2, (int) (this.getSize().getWidth() - iconArrow.getIconHeight()), yMid - iconArrow.getIconHeight() / 2);
        }

    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

    @Override
    public T getObject() {
        return (T) getSelectedItem();
    }

    @Override
    public void setObject(T object) {
        setSelectedItem(object);
        firePropertyChange("text", null, null);//hacer un fire para que el floating label se entere que algo cambio y se tiene que actualizar
    }

    public static class FieldRenderer<T> extends JComponent implements ListCellRenderer<T> {

        private final MaterialComboBox comboBox;
        private String text;
        private boolean mouseOver = false;
        private boolean selected = false;

        public FieldRenderer(MaterialComboBox comboBox) {
            this.comboBox = comboBox;
        }

        @Override
        public Component getListCellRendererComponent(JList jList, Object o, int index, boolean isSelected, boolean cellHasFocus) {
            text = o != null ? o.toString() : "";
            setSize(jList.getWidth(), 56);
            setPreferredSize(new Dimension(jList.getWidth(), 32));
            setOpaque(true);
            mouseOver = isSelected;
            selected = comboBox.getSelectedIndex() == index;
            return this;
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
            super.paint(g2);

            if (mouseOver) {
                g2.setColor(Utils.isDark(comboBox.getBackground()) ? Utils.brighten(comboBox.getBackground()) : Utils.darken(comboBox.getBackground()));
            } else {
                g2.setColor(comboBox.getBackground());
            }
            g2.fillRect(0, 0, getWidth(), getHeight());

            g2.setFont(comboBox.getFont());
            if (selected) {
                g2.setColor(comboBox.getAccentFloatingLabel());
            } else {
                g2.setColor(comboBox.getForeground());
            }
            FontMetrics metrics = g2.getFontMetrics(g2.getFont());
            g2.drawString(text, 24, metrics.getAscent() + (getHeight() - metrics.getHeight()) / 2);
        }
    }

    public static class Popup extends BasicComboPopup {

        public Popup(JComboBox combo) {
            super(combo);
            setBackground(combo.getBackground());
            setOpaque(true);
            setBorderPainted(true);
        }

        @Override
        protected JScrollPane createScroller() {
            JScrollPane scroller = MaterialScrollFactory.buildPane();
            scroller.setViewportView(super.getList());
            return scroller;
        }

        @Override
        protected Rectangle computePopupBounds(int px, int py, int pw, int ph) {
            FontMetrics metrics = Utils.fontMetrics(super.comboBox.getFont());
            int yMid = super.comboBox.getSize().height / 2;
            int yLine = yMid + metrics.getAscent() / 2 + 5;
            return super.computePopupBounds(px, py - comboBox.getHeight() + yLine + 3,
                    (int) Math.max(comboBox.getPreferredSize().getWidth(), pw), ph);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(MaterialDrawingUtils.getAliasedGraphics(g));
        }
    }

    private static class FilterListener extends KeyAdapter {

        public static FilterListener from(MaterialComboBox combo) {
            return new FilterListener(combo);
        }

        public static int TIME_RESET_SEARCH = 2 * 1000;

        private String key = "";
        private long last = -1;
        private final MaterialComboBox combo;

        public FilterListener(MaterialComboBox combo) {
            this.combo = combo;
        }

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                key = "";
                return;
            }

            if (System.currentTimeMillis() - last > TIME_RESET_SEARCH) {
                key = "";
            }
            last = System.currentTimeMillis();

            key += e.getKeyChar();
            DefaultComboBoxModel model = ((DefaultComboBoxModel) combo.getModel());

            Object selectedItem = model.getSelectedItem();
            int i, c;
            int currentSelection = -1;

            if (selectedItem != null) {
                for (i = 0, c = model.getSize(); i < c; i++) {
                    if (selectedItem == model.getElementAt(i)) {
                        currentSelection = i;
                        break;
                    }
                }
            }
            for (i = ++currentSelection, c = model.getSize(); i < c; i++) {
                Object elem = model.getElementAt(i);
                if (elem != null && elem.toString() != null) {
                    if (elem.toString().toLowerCase().contains(key.toLowerCase())) {
                        combo.setSelectedIndex(i);
                        break;
                    }
                }
            }

            for (i = 0; i < currentSelection; i++) {
                Object elem = model.getElementAt(i);
                if (elem != null && elem.toString() != null) {
                    if (elem.toString().toLowerCase().contains(key.toLowerCase())) {
                        combo.setSelectedIndex(i);
                        break;
                    }
                }
            }

        }
    }

}
