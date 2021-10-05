<%-- 
    Document   : producto_form
    Created on : Oct 3, 2021, 2:24:23 AM
    Author     : bizagi
--%>

<%@page import="logica.LogicaJuguetes"%>
<%@page import="logica.Juguete"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-5"> 
            <h3 class="mb-3">Formulario de Productos</h3>
            <hr>
			  
                String accion = request.getParameter("accion");
                int idProducto;
                String NombreProducto = "";
                int idTipoReferecia = 0;
                int idEspecificaciones = 0;						   
                
                if (accion.equals("editar")) {
                    id = Integer.parseInt(request.getParameter("id"));
                    LogicaProductos logicaProductos = new LogicaProductos();
                    Producto p = logicaProductos.cargarUnProducto(id);
                    nombre = p.getNombreProducto()
                    idTipo = p.getIdTipoReferencia();
                    fechaCompra = p.getIdEspecificaciones()
				}
                else {
                    id = 0;
                }
            %>  
			<form method="post" action="producto_ctrl.jsp">
				<div class="row mb-3">
					<label for="txtId" class="col-form-label col-sm-2">Id</label>
					<input type="text" class="col-form-control col-sm-10" id="txtId" name="txtId" value="<%= id %>" readonly>
				</div>
				<div class="row mb-3">
					<label for="txtNombre" class="col-form-label col-sm-2">Nombre</label>
					<input type="text" class="col-form-control col-sm-10" id="txtNombre" name="txtNombre" value="<%= nombreProducto %>">
                    <input type="text" class="col-form-control col-sm-10" id="txtNombre" name="txtNombre" value="<%= nombre %>" required>
				</div>
				<div class="row mb-3">
					<label for="selTipoRef" class="col-form-label col-sm-2">Tipo</label>
					<% 
						LogicaProductos logicaProductos = new LogicaProductos(); 
						TreeMap<Integer, String> tipos = logicaProductos.
						getTiposProductos();
					%>	   
					<select class="col-form-control col-sm-10" id="selTipoRef" name="selTipoRef">
                                            <select class="col-form-control col-sm-10" id="selTipoRef" name="selTipoRef" required>
						<option selected value=""></option>
						<% for (Map.Entry<Integer, String> entrada : tiporeferencia.entrySet() ) { %>
						<option <%= entrada.getKey()== IdTipoReferecia ? "selected" : "" %> value="<%= entrada.getKey() %>"><%= entrada.getValue() %></option>
						<% } %>
                                            </select>
                                        </select>
				</div>				  		 
				<div class="row mb-3">
					<label for="SelEspecif" class="col-form-label col-sm-2">Especificaciones</label>
                        TreeMap<Integer, String> Especificaciones = logicaProductos.getEspecificaciones();
                    %>
                    <select class="col-form-control col-sm-10" id="SelEspecif" name="SelEspecif">
                    <select class="col-form-control col-sm-10" id="SelEspecif" name="SelEspecif" required>   
				</div>
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button type="submit" class="btn btn-primary" id="btnSubmit" name="btnSubmit" value="<%= accion %>">Guardar</button>
                <button type="submit" class="btn btn-secondary" id="btnSubmit" name="btnSubmit" value="cancelar">Cancelar</button>
                </div>
            </form>
        </div>
    </body>
</html>