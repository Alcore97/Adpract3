<%@page import="org.me.image.Image"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="org.me.image.Image"%>"
<%@page import="org.me.image.ImageWS_Service"%>"


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Llistar imatges</title>
    </head>
    <link rel="stylesheet" href="css/styles.css">
    <body>
        
     <h1>Llistat d'imatges</h1> 
        <%
            List<java.lang.Object> list = new ArrayList<java.lang.Object>();
            try {
                org.me.image.ImageWS_Service service = new org.me.image.ImageWS_Service();
                org.me.image.ImageWS port = service.getImageWSPort();
                // TODO process result here
                list = port.listImages();
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
             //necessitem id, nom i autor de les imatges a la DB
                %>
                            <table style="width:60%">
                            <tr>
                            <th>Nom imatge</th>
                            <th>Visualitzar imatge</th>
                            <th>Modificar</th>
                            <th>Eliminar imatge</th>
                            </tr>
                <%            
            
            %>
            
            </table>
            <br><br>
            <a href='menu.jsp'><h4>Tornar a menu!</h4></a>      
        </body>
</html>
           
