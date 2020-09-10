package com.jhw.swing.material.components.dashboard.smoot;

import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.dashboard.elements.MainPageElement;
import com.jhw.swing.material.components.dashboard.elements._MaterialButtonMainPage;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.components.button._MaterialButtonIconTransparent;
import com.jhw.swing.material.components.container.MaterialContainersFactory;
import com.jhw.swing.material.effects.RippleEffect;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.enums.GradientEnum;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _DashboardSmoot extends javax.swing.JPanel {

    private boolean in = true;
    private final PanelDual dual;
    private ArrayList<MainPageElement> mainElements = new ArrayList<>();

    public _DashboardSmoot() {
        initComponents();
        dual = new PanelDual(panelButtons, panelMiddle);
        addListeners();
        personalize();//no implementado por la interfaz para si el hijo lo sob
        collapse(!in);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//
    private void initComponents() {

        panelButtons = MaterialContainersFactory.buildPanelGradient();
        panelButtonsInside = MaterialContainersFactory.buildPanelTransparent();
        buttonCollapse = MaterialButtonsFactory.buildIconTransparent();
        panelMiddle = MaterialContainersFactory.buildPanelGradient();
        panelUp = MaterialContainersFactory.buildPanelGradient();
        panelUpperCornerRight = MaterialContainersFactory.buildPanelTransparent();
        panelUpperCornerLeft = MaterialContainersFactory.buildPanelTransparent();
        panelDown = MaterialContainersFactory.buildPanelGradient();
        panelDownCornerRight = MaterialContainersFactory.buildPanelTransparent();
        panelDownCornerLeft = MaterialContainersFactory.buildPanelTransparent();
        panelComponentToDual = MaterialContainersFactory.buildPanelComponentTransparent();

        panelButtons.setPreferredSize(new java.awt.Dimension(230, 400));
        ((_PanelGradient) panelButtons).setPrimaryColor(new java.awt.Color(255, 255, 255));
        ((_PanelGradient) panelButtons).setSecundaryColor(new java.awt.Color(204, 204, 204));

        panelButtonsInside.setLayout(new java.awt.GridLayout(0, 1));

        buttonCollapse.setText("_MaterialIconButtonTranspRect1");
        buttonCollapse.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ((RippleEffect) buttonCollapse).setPaintRipple(false);

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
                panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelButtonsInside, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addComponent(buttonCollapse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelButtonsLayout.setVerticalGroup(
                panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelButtonsLayout.createSequentialGroup()
                                .addComponent(panelButtonsInside, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 352, Short.MAX_VALUE)
                                .addComponent(buttonCollapse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMiddle.setBackground(new java.awt.Color(255, 255, 255));
        panelMiddle.setLayout(new java.awt.CardLayout());

        setPreferredSize(new java.awt.Dimension(675, 450));

        panelUp.setBackground(new java.awt.Color(255, 255, 255));
        panelUp.setPreferredSize(new java.awt.Dimension(384, 45));

        panelUpperCornerRight.setPreferredSize(new java.awt.Dimension(180, 45));
        panelUpperCornerRight.setLayout(new java.awt.GridLayout(1, 0));

        panelUpperCornerLeft.setPreferredSize(new java.awt.Dimension(230, 45));
        panelUpperCornerLeft.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout panelUpLayout = new javax.swing.GroupLayout(panelUp);
        panelUp.setLayout(panelUpLayout);
        panelUpLayout.setHorizontalGroup(
                panelUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelUpLayout.createSequentialGroup()
                                .addComponent(panelUpperCornerLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelUpperCornerRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelUpLayout.setVerticalGroup(
                panelUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelUpperCornerRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelUpperCornerLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelDown.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        panelDown.setPreferredSize(new java.awt.Dimension(384, 26));
        ((_PanelGradient) panelDown).setPrimaryColor(new java.awt.Color(204, 204, 204));
        ((_PanelGradient) panelDown).setSecundaryColor(new java.awt.Color(224, 224, 224));

        panelDownCornerRight.setPreferredSize(new java.awt.Dimension(180, 26));
        panelDownCornerRight.setLayout(new java.awt.GridLayout(1, 0));

        panelDownCornerLeft.setPreferredSize(new java.awt.Dimension(230, 45));
        panelDownCornerLeft.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout panelDownLayout = new javax.swing.GroupLayout(panelDown);
        panelDown.setLayout(panelDownLayout);
        panelDownLayout.setHorizontalGroup(
                panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDownLayout.createSequentialGroup()
                                .addGap(0, 493, Short.MAX_VALUE)
                                .addComponent(panelDownCornerRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelDownLayout.createSequentialGroup()
                                        .addComponent(panelDownCornerLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 445, Short.MAX_VALUE)))
        );
        panelDownLayout.setVerticalGroup(
                panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelDownCornerRight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addGroup(panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelDownCornerLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelComponentToDualLayout = new javax.swing.GroupLayout(panelComponentToDual);
        panelComponentToDual.setLayout(panelComponentToDualLayout);
        panelComponentToDualLayout.setHorizontalGroup(
                panelComponentToDualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        panelComponentToDualLayout.setVerticalGroup(
                panelComponentToDualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 379, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelUp, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                        .addComponent(panelDown, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                        .addComponent(panelComponentToDual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(panelComponentToDual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(panelDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify//:variables
    private JButton buttonCollapse;
    private JPanel panelButtons;
    private JPanel panelButtonsInside;
    private JPanel panelComponentToDual;
    private JPanel panelDown;
    private JPanel panelDownCornerLeft;
    private JPanel panelDownCornerRight;
    private JPanel panelMiddle;
    private JPanel panelUp;
    private JPanel panelUpperCornerLeft;
    private JPanel panelUpperCornerRight;
    // End of variables declaration                   

//-----------------------------MAIN---------------------------------------------------------
    /**
     * Add the parts of the MainPageElement to the main panel.<\br>
     * This method anly translate the alone info to the object and add it to the
     * panel.
     *
     * @param name
     * @param icon
     * @param panel
     */
    public void addMainElement(String name, ImageIcon icon, Component panel) {
        addMainElement(new MainPageElement(name, icon, panel), mainElements.size());
    }

    /**
     * Add an element to the main panel.
     *
     * @param element the element to be displayed.
     */
    public void addMainElement(MainPageElement element) {
        addMainElement(element, mainElements.size());
    }

    /**
     * Add an element to the main panel in an specified position.
     *
     * @param element the element to be displayed.
     * @param index the index of the element in the list.
     */
    public void addMainElement(MainPageElement element, int index) {
        mainElements.add(index, element);//add the button to the list

        panelButtonsInside.add(element.getButton(), index);//add the button to the panel
        panelMiddle.add(element.getName(), element.getPanel());

        element.getButton().addActionListener(new java.awt.event.ActionListener() {//set up the click button actionsss
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //set up and display the new panel 
                clearSelected();//clear the selected button

                ((CardLayout) panelMiddle.getLayout()).show(panelMiddle, element.getName());
                if (element.getPanel() instanceof Update) {//Actualiza if it's posible
                    ((Update) element.getPanel()).update();
                }
            }
        });
        collapse(false);
    }

//-----------------------------UP---------------------------------------------------------
    /**
     * Add an element to the upper left corner. Generally used to display
     * company name or things like that.
     *
     * @param element the element to be displayed.
     */
    public void setUpElementLeftCorner(Component element) {
        panelUpperCornerLeft.add(element);//add the element to the panel
        panelUpperCornerLeft.repaint();
    }

    /**
     * Add an element to the upper left corner. Generally used to put buttons to
     * config, user or things like that.
     *
     * @param element the element to be displayed.
     */
    public void addUpElementRightCorner(Component element) {
        addUpElementRightCorner(element, panelUpperCornerRight.getComponentCount());
    }

    /**
     * Add an element to the upper left corner. Generally used to put buttons to
     * config, user or things like that.
     *
     * @param element the element to be displayed.
     * @param index the index of the element in the list.
     */
    public void addUpElementRightCorner(Component element, int index) {
        int count = panelUpperCornerRight.getComponentCount() + 1;
        panelUpperCornerRight.setPreferredSize(new Dimension((int) (panelUpperCornerRight.getPreferredSize().getHeight() * count), (int) panelUpperCornerRight.getPreferredSize().getHeight()));
        panelUpperCornerRight.add(element, index);//add the button to the panel
        panelUpperCornerRight.repaint();
    }

//-----------------------------DOWN---------------------------------------------------------
    /**
     * Add an element to the down left corner. Generally used to display licence
     * or things like that.
     *
     * @param element the element to be displayed.
     */
    public void setDownElementLeftCorner(Component element) {
        panelDownCornerLeft.add(element);//add the element to the panel
        panelDownCornerLeft.repaint();
    }

    /**
     * Add an element to the down left corner. Generally used to display
     * tecnologies or things like that.
     *
     * @param element the element to be displayed.
     */
    public void addDownElementRightCorner(Component element) {
        addDownElementRightCorner(element, panelDownCornerRight.getComponentCount());
    }

    /**
     * Add an element to the down left corner. Generally used to display
     * tecnologies or things like that.
     *
     * @param element the element to be displayed.
     * @param index the index of the element in the list.
     */
    public void addDownElementRightCorner(Component element, int index) {
        int count = panelDownCornerRight.getComponentCount() + 1;
        panelDownCornerRight.setPreferredSize(new Dimension((int) (panelDownCornerRight.getPreferredSize().getHeight() * count), (int) panelDownCornerRight.getPreferredSize().getHeight()));
        panelDownCornerRight.add(element, index);//add the button to the panel
        panelDownCornerRight.repaint();
    }

//-----------------------------GENERAL---------------------------------------------------------
    public void clearAll() {
        panelUpperCornerLeft.removeAll();
        panelUpperCornerRight.removeAll();
        panelMiddle.removeAll();//remove previous panel
        mainElements.clear();
        panelButtons.removeAll();
        panelDownCornerRight.removeAll();
        panelDownCornerLeft.removeAll();
    }

    /**
     * Clear of selection the previous selected button
     */
    private void clearSelected() {
        for (MainPageElement element : mainElements) {
            element.getButton().deselect();
            element.getButton().repaint();
        }
    }

    /**
     * Set selected to a any button.
     *
     * @param index
     */
    public void setSelected(int index) {
        _MaterialButtonMainPage btn = mainElements.get(index).getButton();
        btn.doClick();
        btn.select();
    }

    public ArrayList<MainPageElement> getElements() {
        return mainElements;
    }

    public void setElements(ArrayList<MainPageElement> elements) {
        this.mainElements = elements;
    }

    public JPanel getPanelButtons() {
        return panelButtons;
    }

    public void setPanelButtons(_PanelGradient panelButtons) {
        this.panelButtons = panelButtons;
    }

    public JPanel getPanelUp() {
        return panelUp;
    }

    public void setPanelUp(_PanelGradient panelUp) {
        this.panelUp = panelUp;
    }

    public JPanel getPanelUpperCornerLeft() {
        return panelUpperCornerLeft;
    }

    public void setPanelUpperCornerLeft(_PanelTransparent panelUpperCornerLeft) {
        this.panelUpperCornerLeft = panelUpperCornerLeft;
    }

    public JPanel getPanelUpperCornerRight() {
        return panelUpperCornerRight;
    }

    public void setPanelUpperCornerRight(_PanelTransparent panelUpperCornerRight) {
        this.panelUpperCornerRight = panelUpperCornerRight;
    }

    public JPanel getTabbedPaneDisplay() {
        return panelMiddle;
    }

    public void setTabbedPaneDisplay(_PanelGradient tabbedPaneDisplay) {
        this.panelMiddle = tabbedPaneDisplay;
    }

    public JPanel getPanelDownCornerLeft() {
        return panelDownCornerLeft;
    }

    public void setPanelDownCornerLeft(_PanelTransparent panelDownCornerLeft) {
        this.panelDownCornerLeft = panelDownCornerLeft;
    }

    public JPanel getPanelDownCornerRight() {
        return panelDownCornerRight;
    }

    public void setPanelDownCornerRight(_PanelTransparent panelDownCornerRight) {
        this.panelDownCornerRight = panelDownCornerRight;
    }

    private void personalize() {
        Color sec = Utils.darken(PersonalizationHandler.getColor(Personalization.KEY_COLOR_SECUNDARY));

        ((_PanelGradient) panelUp).setPrimaryColor(PersonalizationHandler.getColor(Personalization.KEY_COLOR_MAIN));
        ((_PanelGradient) panelUp).setSecundaryColor(sec);
        ((_PanelGradient) panelUp).setGradient(GradientEnum.VERTICAL_3_4);

        panelUpperCornerRight.setBackground(sec);

        panelDown.setBackground(MaterialColors.BLUEGREY_100);

        ((_PanelGradient) panelButtons).setPrimaryColor(MaterialColors.WHITE);
        ((_PanelGradient) panelButtons).setSecundaryColor(MaterialColors.BLUEGREY_100);

        panelComponentToDual.add(dual);
        ((RippleEffect) buttonCollapse).setPaintRipple(false);
    }

    private void collapse(boolean in) {
        this.in = in;

        if (mainElements.isEmpty()) {
            return;
        }
        MainPageElement element = mainElements.get(0);

        int sizeIn = 2 * element.getButton().getIconID().getIconWidth();
        int sizeOut = mainElements.isEmpty() ? 0 : 250;
        int sizeFinal = in ? sizeIn + 10 : sizeOut;

        int height = (int) sizeIn * mainElements.size();
        Dimension dim = new Dimension(sizeFinal, height);

        panelButtonsInside.setPreferredSize(dim);
        panelButtonsInside.setMaximumSize(new Dimension(sizeOut, height));
        panelButtonsInside.setMinimumSize(new Dimension(sizeIn, height));

        dual.setLeftComponentSize(sizeFinal);
        buttonCollapse.setIcon(in ? MaterialIcons.ARROW_FORWARD : MaterialIcons.ARROW_BACK);

        for (MainPageElement mpe : mainElements) {
            mpe.getButton().setIn(in);
        }
    }

    private void addListeners() {
        buttonCollapse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collapse(!in);
            }
        });
    }
}
