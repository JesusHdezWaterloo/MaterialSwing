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
package com.root101.swing.material.effects;

import com.root101.swing.util.SafePropertySetter;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.util.Utils;
import java.awt.Color;
import com.root101.module.util.personalization.core.domain.Personalization;
import com.root101.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.util.MouseAdapterInfo;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;

/**
 * A floating label of a text field.
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class DefaultColorFadeInto<T extends JComponent & MouseAdapterInfo> implements ColorFadeInto, PropertyChangeListener, Serializable {

    private final T target;
    private Animator animator;
    private final SafePropertySetter.Property<Color> color;
    private Color backgroundColor;
    private Color accentColor;

    /*public static DefaultColorFadeInto from(T target) {//T no se puede referir desde un contexto estatico
        return null;
    }*/
    public DefaultColorFadeInto(T target) {
        this.target = target;

        backgroundColor = target.getBackground();
        accentColor = Utils.darken(backgroundColor);

        color = SafePropertySetter.animatableProperty(target, target.getBackground());
        updateColorFadeInto();

        target.addPropertyChangeListener(this);
    }

    @Override
    public Color getAccentColorFadeInto() {
        return accentColor;
    }

    @Override
    public void setAccentColorFadeInto(Color accentColor) {
        this.accentColor = accentColor;
        updateColorFadeInto();
    }

    private void updateColorFadeInto() {
        if (animator != null) {
            animator.stop();
        }
        if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_ANIMATIONS)) {
            setColorAnimated();
        } else {
            color.setValue(getTargetColor());
        }
    }

    private Color getTargetColor() {
        if (accentColor.getAlpha() == 0 || target.getBackground().getAlpha() == 0) {
            return MaterialColors.TRANSPARENT;
        }
        if (target.isFocusOwner() || target.isMouseOver()) {
            return accentColor;
        } else {
            return backgroundColor;
        }
    }

    @Override
    public Color getColorFadeInto() {
        return color.getValue();
    }

    private void setColorAnimated() {
        Animator.Builder builder = new Animator.Builder(Utils.getSwingTimerTimingSource())
                .setDuration(DefaultElevationEffect.DURATION, TimeUnit.MILLISECONDS)
                .setEndBehavior(Animator.EndBehavior.HOLD)
                .setInterpolator(new SplineInterpolator(0.4, 0, 0.2, 1));

        Color targetColor = getTargetColor();
        if (!targetColor.equals(color.getValue())) {
            builder.addTarget(SafePropertySetter.getTarget(color, color.getValue(), targetColor));
        }
        animator = builder.build();
        animator.start();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "background":
                this.backgroundColor = (Color) evt.getNewValue();
                this.accentColor = Utils.darken(backgroundColor);
                updateColorFadeInto();
                break;
            case "processMouseEvent":
                updateColorFadeInto();
                break;
            case "processFocusEvent":
                updateColorFadeInto();
                break;
        }
    }

}
