<%-- 
    Document   : producto_lista
										  
	Author     : Bizagi
--%>

<%@page import="logica.LogicaProductos"%>
<%@page import="logica.Producto"%>
<%@page import="logica.ColeccionProductos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

		<title>Lista de Productos</title>								
    </head>
    <body>
        <div class="container mt-5"> 
            <h3 class="mb-3">Lista de Productos</h3>
            <hr>
            <%
                String filtro = (request.getParameter("txtFiltro") == null) ? "" : request.getParameter("txtFiltro");
            %>			  
			<div class="row">
                <form class="col-sm-10">
				<form method="GET" class="col-sm-10">	
					<div class="row mb-3">
                        <label for="txt1" class="col-form-label col-sm-2">Filtrar por nombre</label>
                        <input type="text" class="col-form-control col-sm-9" id="txt1" name="txt1" value="">
                        <button type="button" class="btn btn-light col-sm-1"><i class="bi bi-search"></i></button>                    
                        <label for="txt1" class="col-form-label col-sm-2">Filtrar</label>
                        <input type="text" class="col-form-control col-sm-9" id="txtFiltro" name="txtFiltro" value="<%= filtro %>" placeholder="por nombreProducto, tipoRerencia, Especificaciones">
                        <button type="submit" class="btn btn-light col-sm-1"><i class="bi bi-search"></i></button>                    
                    </div>
                </form>
				<a href="producto_form.jsp?accion=nuevo" class="col-sm-2"><button type="submit" class="btn btn-primary" id="btnNuevo">Nuevo Produto</button></a>
            </div>				 
            <form>
				<table class="table">
                    <thead>
                        <tr>
                            <th scope="col">idProducto</th>
							<th scope="col">NombreProducto</th>
                            <th scope="col">idTipoReferencia</th>
                            <th scope="col">idEspecificaciones</th>
															   
							<th scope="col">Acciones</th>
						</tr>
                    </thead>
					<%
                        LogicaProductos logicaProductos = new LogicaProductos();
                        boolean hayDatos = logicaProductos.cargarTodosLosProducto();
                        if (filtro.equals("") ) {
                            hayDatos = logicaProductos.cargarTodosLosProductos();
                        }
                        else {
                            hayDatos = logicaProductos.cargarProductosPorFiltro(filtro);
                        }
                    %>   
                    <tbody>
                        <% if (hayDatos) { %>
						<%  for (Producto p : logicaProductos.getLista()) {%>
						<tr>
                            <td scope="row"><%= p.getIdProducto() %></td>
							<td><%= p.getNombreProducto()%></td>
                            <td><%= logicaProductos.getIdTipoReferencia(p.getIdTipoReferencia()) %></td>
                            <td><%= logicaProductos.getIdEspecificaciones(p.getIdEspecificaciones()) %></td>
                            <td><%= p.getIdTipoReferencia() %></td>
                            <td><%= p.getIdEspecificaciones() %></td>
						     <a href="producto_form.jsp?accion=editar&id=<%= j.getId() %>"><button type="button" class="btn btn-success"><i class="bi bi-pencil-fill"></i></button></a>
							<button type="button" class="btn btn-danger"><i class="bi bi-trash"></i></button>
                            </td>
                        </tr>
                        <% } %>
                        <% } else { %>
                        <tr>
                            <td colspan="5">No hay datos</td>
                        </tr>
                        <% } %>							  
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>