package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.clean.swing.app.dashboard.DashboardConstants;
import com.clean.swing.app.dashboard.MapeableContainer;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.components.button._MaterialButtonIconTransparent;
import com.jhw.swing.material.components.button._MaterialButtonHiperlink;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.utils.icons.DerivableIcon;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class UpPanel extends MapeableContainer {

    private final int HEIGHT_FINAL = 36;

    public UpPanel() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        this.background = new _PanelGradient();
        this.add(background, BorderLayout.CENTER);

        this.background.setLayout(new BorderLayout());

        this.components = new _PanelTransparent();
        this.components.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.background.add(this.components, BorderLayout.EAST);
    }

    private _PanelGradient background;
    private JButton company;
    private _PanelTransparent components;

    @Override
    public void update(HashMap<String, Object> hm) {
        components.removeAll();
        for (String key : hm.keySet()) {
            Object component = hm.get(key);
            switch (key) {
                case DashboardConstants.UP_COMPANY:
                    setCompany(component);
                    break;
                case DashboardConstants.UP_ELEMENT:
                    addElement(component);
                    break;
            }
        }
        this.revalidate();
    }

    public void format(Consumer<UpPanel> formatter) {
        formatter.accept(this);
    }

    private void addElement(Object component) {
        if (component instanceof Component) {
            addComponentGeneral((Component) component);
        } else if (component instanceof Action) {
            addComponentGeneral((Action) component);
        } else if (component instanceof List) {
            for (Object single : (List) component) {
                if (single instanceof Component) {
                    addComponentGeneral((Component) single);
                } else if (single instanceof Action) {
                    addComponentGeneral((Action) single);
                }
            }
        } else {
            String logMSG = "Component " + component + " not supperted for up element.";
            Logger.getLogger(DashBoardTaskPane.class.getName()).log(Level.WARNING, logMSG);
        }
    }

    private void setCompany(Object component) {
        if (component instanceof Action) {
            setCompany((Action) component);
        } else {
            String logMSG = "Component " + component + " not supperted for company.";
            Logger.getLogger(DashBoardTaskPane.class.getName()).log(Level.WARNING, logMSG);
        }
    }

    public void setCompany(Action action) {
        if (this.company != null) {
            this.background.remove(this.company);
        }
        this.company = new CompanyButton();
        this.company.setAction(action);
        this.company.setPreferredSize(new Dimension((int) company.getPreferredSize().getWidth(), HEIGHT_FINAL));
        this.background.add(this.company, BorderLayout.WEST);
    }

    public void addComponentGeneral(Action action) {
        JButton component = MaterialButtonsFactory.buildIconTransparent();
        component.setAction(action);

        if (action.getValue(Action.SMALL_ICON) instanceof DerivableIcon) {
            component.setForeground(((DerivableIcon) action.getValue(Action.SMALL_ICON)).getColor());
        }

        component.setPreferredSize(new Dimension(HEIGHT_FINAL, HEIGHT_FINAL));
        components.add(component);
    }

    public void addComponentGeneral(Component component) {
        component.setPreferredSize(new Dimension((int) component.getPreferredSize().getWidth(), HEIGHT_FINAL));
        components.add(component);
    }

    public _PanelGradient getBackgroundPanel() {
        return background;
    }

    private class CompanyButton extends _MaterialButtonHiperlink {

        public CompanyButton() {
            setText("");
            float h = HEIGHT_FINAL;
            this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(h * 0.65f));
            this.setIconTextGap(8);
        }
    }
}
