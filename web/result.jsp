<%-- 
    Document   : result
    Created on : 20.08.2014, 19:43:31
    Author     : Helena.Grouk
--%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <body>
        <h1 id="header">RESULT of ${parsername} parser:</h1>
        
        
        
        <table id ="equipTable" border="1">
             <tbody>
                <c:forEach items="${equip}" var="cell">
                    <tr>
                        <td>${cell.id}</td>
                        <td>${cell.getClass().getSimpleName()}</td>
                        <td>${cell.name}</td>
                        <td>${cell.price}</td>
                        
                    </tr>
                </c:forEach>
           </tbody>
        </table>
        
    </body>

