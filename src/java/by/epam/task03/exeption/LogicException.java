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
public class LogicException extends ProjectException {
    
    Exception ex;
    
    public LogicException(){}
    
    public LogicException(String msg) {
        this.msg = msg;
        localLog.error("LogicException " + msg);
        localLog.info(this.getStackTrace());
    }
    
    public LogicException(String msg, Exception ex) {
        this.ex = ex;
        this.msg = msg;
        localLog.error("LogicException " + msg);
        localLog.info(this.getStackTrace());
        localLog.info(ex.getMessage(), ex);
    }
    
    
}
