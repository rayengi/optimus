<%-- 
    Document   : producto_lista
    Author     : Grupo Optimus
--%>

<%@page import="logica.LogicaProductos"%> 
<%@page import="logica.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
	<title>Lista de Productos</title>								
    </head>
    
    <body>
	<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #00004d;">
            <div class="container">
              <%--   <a class="navbar-brand" href="#">
                    <img src="img/logo.png" alt="Optimus" width="180" height="48">
                </a>--%>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="true" href="producto_lista.jsp"><i class="bi bi-box-seam"></i> Producto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="usuarios_lista.jsp"><i class="bi bi-person-lines-fill"></i> Usuarios</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
                
        <div class="container mt-5"> 
            <h3 class="mb-3">Lista de Productos</h3>
            <hr>
                    
            <div id="toolbar">
                <a href="producto_form.jsp?accion=nuevo" class="col-sm-2"><button type="submit" class="btn btn-primary" id="btnNuevo">Nuevo Producto</button></a>
            </div>
                    
            <table id="tablaproductos" class="table" data-toolbar="#toolbar" data-toggle="table" data-search="true" data-show-columns="true" data-show-export="true" data-pagination="true" data-page-list="[10, 25, 50]" data-locale="es-SP">
                <thead>
                    <tr>
                        <th scope="col" data-sortable="true">idProducto</th>
                        <th scope="col" data-sortable="true">NombreProducto</th>
                        <th scope="col" data-sortable="true">idTipoReferencia</th>
                        <th scope="col" data-sortable="true">diametromin</th>
                        <th scope="col" data-sortable="true">diametromax</th>
                        <th scope="col" data-sortable="true">largomin</th>
                        <th scope="col" data-sortable="true">largomax</th>
                        <th scope="col" data-sortable="true">alto</th>
                        <th scope="col" data-sortable="true">pesomin</th>
                        <th scope="col" data-sortable="true">pesomax</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
					
                <%
                    LogicaProductos logicaProductos = new LogicaProductos();
                    boolean hayDatos = logicaProductos.cargarTodosLosProductos();
                %>
                <tbody>
                    <% if (hayDatos) { %>
                        <%  for (Producto p : logicaProductos.getLista()) {%>
                            <tr>
                                <td scope="row"><%= p.getIdProducto()%></td>
                                <td><%= p.getNombreProducto()%></td>
                                <td><%= logicaProductos.getIdTipoReferencia(p.getIdTipoReferencia())%></td>
                                <td><%= p.getDiametromin()%></td>
                                <td><%= p.getDiametromax()%></td>
                                <td><%= p.getLargomin()%></td>
                                <td><%= p.getLargomax()%></td>
                                <td><%= p.getAlto()%></td>
                                <td><%= p.getPesomin()%></td>
                                <td><%= p.getPesomax()%></td>
                                
                                <td>
                                    <a href="producto_form.jsp?accion=editar&id=<%= p.getIdProducto()%>"><button type="button" class="btn btn-success btn-sm"><i class="bi bi-pencil-fill"></i></button></a>
                                </td>
                            </tr>
			} 
                    }    
                    else {
                        %>         
                        <tr>
                            <td colspan="5">No se han encontrado registros.</td>
                        </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.js"></script>
        <script src="https://unpkg.com/tableexport.jquery.plugin/tableExport.min.js"></script>
        <script src="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.js"></script>
        <script src="https://unpkg.com/bootstrap-table@1.18.3/dist/extensions/export/bootstrap-table-export.min.js"></script>
        <script src="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table-locale-all.min.js"></script>
    </body>
</html>		