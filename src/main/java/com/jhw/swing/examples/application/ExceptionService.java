package com.jhw.swing.examples.application;

import com.clean.core.app.services.ExceptionHandlerService;
import com.jhw.swing.util.JOP;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ExceptionService implements ExceptionHandlerService {

    @Override
    public void handleException(Exception excptn) {
        JOP.error("EXCEPTION RRRRRUUUUUUNNNNN");
    }

}
