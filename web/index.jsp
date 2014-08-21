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
                <span class="error">${errors.parsername}</span>
            </div>
            <div id="categoryButton">
                <input type="submit" value="Parse">  
                <span class="error">${errors.parser}</span>
            </div>

        </form>
    </body>


