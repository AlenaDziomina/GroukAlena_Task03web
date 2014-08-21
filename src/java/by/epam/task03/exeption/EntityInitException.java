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
public class EntityInitException extends ProjectException {

    public EntityInitException(){}
    
    public EntityInitException(String msg) {
        super(msg);
        localLog.error("NullInitException " + msg);
        localLog.info(this.getStackTrace());
    }
    
}
