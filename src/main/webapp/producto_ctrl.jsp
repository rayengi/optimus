<%-- 
    Document   : producto_ctrl
    Created on : Oct 3, 2021, 1:57:56 AM
    Author     : bizagi
--%>								 							 

<%@page import="logica.LogicaProductos"%>
<%@page import="logica.Producto"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    </head>
    <body>
        <%
            int idProducto = Integer.parseInt(request.getParameter("intIdProducto"));
            String NombreProducto = request.getParameter("txtNombreProducto");
            int idTipoReferencia = Integer.parseInt(request.getParameter("selTipoRef"));
            float diametromin = Float.parseFloat(request.getParameter("txtdiametromin"));
            float diametromax = Float.parseFloat(request.getParameter("txtdiametromax"));
            float largomin = Float.parseFloat(request.getParameter("txtlargomin"));
            float largomax = Float.parseFloat(request.getParameter("txtlargomax"));
            float alto = Float.parseFloat(request.getParameter("txtalto"));
            float pesomin = Float.parseFloat(request.getParameter("txtpesomin"));
            float pesomax = Float.parseFloat(request.getParameter("txtpesomax"));
            String accion = request.getParameter("btnSubmit");
            
            Producto p = null;
            
            if (accion.equals("nuevo")) {
                p = new Producto(NombreProducto, idTipoReferencia, diametromin, diametromax, largomin, largomax , alto, pesomin, pesomax);
            }
            else if (accion.equals("editar")){
                p = new Producto(idProducto, NombreProducto, idTipoReferencia, diametromin, diametromax, largomin, largomax , alto, pesomin, pesomax);	 
            }
            LogicaProductos logicaProductos = new LogicaProductos();
            boolean guardado = logicaProductos.guardarProducto(p);
            if (guardado == true) {
                out.println("Producto guardado exitosamente");
            } else {
                out.println("Información de Producto no se guardó.");
            }	 
        %>
        <a href="Producto_lista.jsp"><button type="submit" class="btn btn-primary" id="btnSubmit">Volver a la lista</button></a>
    </body>
</html>