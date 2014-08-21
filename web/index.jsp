<%-- 
    Document   : index
    Created on : 20.08.2014, 15:09:42
    Author     : Helena.Grouk
--%>


    <body>
        <h1 id="header">Enter parser name: </h1>
        <form action="ParsServlet" method="POST">
            <div id="parserName">  
                <input  type="text" name="parser" value="${parsername}" size="20" />   
                <div id="er">${errors.parsername}</div
            </div>
            <div id="categoryButton">
                <input type="submit" value="Parse">  
                <div id="er">${errors.parser}</div>
            </div>

        </form>
    </body>


