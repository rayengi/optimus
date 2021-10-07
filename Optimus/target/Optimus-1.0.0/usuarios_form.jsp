<%-- 
    Document   : usuarios_form
    Created on : Oct 7, 2021, 12:17:58 AM
    Author     : Optimus
--%>

<%@page import="logica.Usuario"%>
<%@page import="logica.LogicaUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>Formulario de usuaros</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="container mt-5"> 
            <h3 class="mb-3">Formulario de usuarios</h3>
            <hr>
            <%
                String accion = request.getParameter("accion");
                int id;
                String nombreCompleto = "";
                String usuario = "";
                String passw = "";
                String fechaNacimiento = "";
                String parentesco = "";
                String rol = "";
                
                if (accion.equals("editar")) {
                    id = Integer.parseInt(request.getParameter("id"));
                    LogicaUsuario logicaUsuarios = new LogicaUsuario();
                    Usuario u = logicaUsuarios.cargarUnUsuario(id);
                    nombreCompleto = u.getNombrecompleto();
                    usuario = u.getUsuario();
                    passw = u.getPassw();
                    fechaNacimiento = u.getFechanacimiento();
                    parentesco = u.getParentesco();
                    rol = u.getRol();
                }
                else {
                    id = 0;
                }
            %>
            <form method="post" action="----">
                <div class="row mb-3">
                    <input type="hidden" class="col-form-control col-sm-10" id="txtId" name="txtId" value="<%= id %>" readonly>
                </div>
                <div class="row mb-3">
                    <label for="txtNombreCompleto" class="col-form-label col-sm-2">Nombre completo</label>
                    <input type="text" class="col-form-control col-sm-10" id="txtNombreCompleto" name="txtNombreCompleto" value="<%= nombreCompleto %>" required>
                </div>
                <div class="row mb-3">
                    <label for="txtUsuario" class="col-form-label col-sm-2">Usuario</label>
                    <input type="text" class="col-form-control col-sm-10" id="txtUsuario" name="txtUsuario" value="<%= usuario %>" required>
                </div>
                <div class="row mb-3">
                    <label for="txtPassw" class="col-form-label col-sm-2">Contraseña</label>
                    <input type="password" class="col-form-control col-sm-10" id="txtPassw" name="txtPassw" value="<%= passw %>" required>
                </div>
                <div class="row mb-3">
                    <label for="dtpFechaNacimiento" class="col-form-label col-sm-2">Fecha de nacimiento</label>
                    <input type="date" class="col-form-control col-sm-10" id="dtpFechaNacimiento" name="dtpFechaNacimiento" value="<%= fechaNacimiento %>">
                </div>
                <div class="row mb-3">
                    <label for="txtParentesco" class="col-form-label col-sm-2">Parentesco</label>
                    <input type="text" class="col-form-control col-sm-10" id="txtParentesco" name="txtParentesco" value="<%= parentesco %>" required>
                </div>
		<div class="row mb-3">
                    <label for="selEstado" class="col-form-label col-sm-2">Rol</label>
                    <select class="col-form-control col-sm-10" id="selEstado" name="selEstado" required>
		        <option selected value=""></option>
                        <option <%= rol.equals("Administrador") ? "selected" : "" %> value="Administrador">Administrador</option>
		        <option <%= rol.equals("Solicitante") ? "selected" : "" %> value="Solicitante">Solicitante</option>
		    </select>
                </div>
		
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button type="submit" class="btn btn-primary" id="btnSubmit" name="btnSubmit" value="<%= accion %>">Guardar</button>
                <a href="usuarios_lista.jsp"><button type="button" class="btn btn-secondary" id="btnSubmit" name="btnCancelar">Cancelar</button></a>
                </div>
            </form>
        </div>
    </body>
</html>