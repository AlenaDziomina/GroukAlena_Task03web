/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.exeption;

import static by.epam.task03web.controller.ParsServlet.localLog;

/**
 *
 * @author Helena.Grouk
 */
public class ValidatingException extends ProjectException {
    
    public ValidatingException(){}
    public ValidatingException(String msg) {
        this.msg = msg;
        localLog.error("ValidatingException " + msg);
    }
    
}
