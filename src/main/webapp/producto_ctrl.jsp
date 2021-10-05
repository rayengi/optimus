<%-- 
    Document   : producto_ctrl
    Created on : Oct 3, 2021, 1:57:56 AM
    Author     : bizagi
--%>								 

<%@page import="logica.ColeccionProductos"%>
<%@page import="logica.Producto"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
    <body>
        <%
            String idProducto = request.getParameter("txtId");
            String NombreProducto = request.getParameter("txtNombre");
            String idTipoReferencia = request.getParameter("selTipoRef");
            String idEspecificaciones = request.getParameter("SelEspecif");
            String accion = request.getParameter("btnSubmit");

            if (accion.equals("nuevo")) {
                Producto p = new Producto(NombreProducto, idTipoReferencia, IdEspecificaciones);
                ColeccionProductos coleccion = new ColeccionProductos();
                boolean guardado = coleccion.guardarProducto(p);
                if (guardado == true) {
                    out.println("Producto guardado exitosamente");
                } else {
                    out.println("Información de Producto no se guardó.");
                }
            }
        %>
        <a href="Producto_lista.jsp"><button type="submit" class="btn btn-primary" id="btnSubmit">Volver a la lista</button></a>
    </body>
</html>