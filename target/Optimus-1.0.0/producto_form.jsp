<%-- 
    Document   : usuarios_lista
    Created on : Oct 3, 2021, 3:03:43 AM
    Author     : @author Grupo Optimus
--%>

<%@page import="logica.LogicaProductos"%>
<%@page import="logica.Producto"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<title>Formulario de Productos</title>									 
    </head>
    <body>
        <div class="container mt-5"> 
            <h3 class="mb-3">Formulario de Productos</h3>
                <hr>
                <%  
                    String accion = request.getParameter("accion");
                    int idProducto;
                    String NombreProducto = "";
                    int idTipoReferecia = 0;	
                    float diametromin = 0;
                    float diametromax = 0;
                    float largomin  = 0;
                    float largomax = 0;
                    float alto  = 0;
                    float pesomin = 0;
                    float pesomax = 0;
                
                    if (accion.equals("editar")) {
                        idProducto = Integer.parseInt(request.getParameter("id"));
                        LogicaProductos logicaProductos = new LogicaProductos();
                        Producto p = logicaProductos.cargarUnProducto(idProducto);
                        NombreProducto = p.getNombreProducto();
                        idTipoReferecia = p.getIdTipoReferencia();
                        diametromin = p.getDiametromin();
                        diametromax = p.getDiametromax();
                        largomin = p.getLargomin();
                        largomax = p.getLargomax();
                        alto = p.getAlto();
                        pesomin = p.getPesomin();
                        pesomax = p.getPesomax();
                    }
                    else {
                        idProducto = 0;
                    }
                %>  
		<form method="post" action="producto_ctrl.jsp">
                    <div class="row mb-3">
			<input type="hidden" class="col-form-control col-sm-10" id="txtId" name="txtId" value="<%= idProducto %>" readonly>		
                    </div>
                    
                    <div class="row mb-3">
    			<label for="txtNombre" class="col-form-label col-sm-2">Nombre Producto</label>
                        <input type="text" class="col-form-control col-sm-10" id="txtNombre" name="txtNombre" value="<%= NombreProducto %>" required>
                    </div>
                    
                    <div class="row mb-3">
                        <label for="selTipoRef" class="col-form-label col-sm-2">Tipo Referencia</label>
                        <%  LogicaProductos logicaProductos = new LogicaProductos(); %>
                            TreeMap<Integer, String> tiporef = logicaProductos.getIdTipoReferencia();
                        %>
                        <select class="col-form-control col-sm-10" id="selTipo" name="selTipo" required>
                            <option selected value=""></option>
                                <% for (Map.Entry<Integer, String> entrada : tiporef.entrySet() ) { %>
                            <option <%= entrada.getKey()== idTipoReferecia ? "selected" : "" %> value="<%= entrada.getKey() %>"><%= entrada.getValue() %></option>
                            <% } %>
                        </select>
                    </div>
                       
                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                        <button type="submit" class="btn btn-primary" id="btnSubmit" name="btnSubmit" value="<%= accion %>">Guardar</button>
                        <a href="Productos_lista.jsp"><button type="button" class="btn btn-secondary" id="btnSubmit" name="btnCancelar">Cancelar</button></a>
                    </div>
                        
            </form>
        </div>
    </body>
</html>													