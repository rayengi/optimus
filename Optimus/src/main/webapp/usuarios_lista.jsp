<%-- 
    Document   : usuarios_lista
    Created on : Oct 3, 2021, 3:03:43 AM
    Author     : @author Grupo Optimus
--%>

<%@page import="logica.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.LogicaUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <title>Lista de usuarios</title>
    </head>
    
    <body>
        <div class="container mt-5"> 
            <h3 class="mb-3">Lista de usuarios</h3>
            <hr>
            <div class="row">
                <form class="col-sm-10">
                    <div class="row mb-3">
                        <label for="txt1" class="col-form-label col-sm-2">Filtrar</label>
                        <input type="text" class="col-form-control col-sm-9" id="txt1" name="txt1" value="">
                        <button type="button" class="btn btn-light col-sm-1"><i class="bi bi-search"></i></button>                    
                    </div>
                </form>
                <a href="" class="col-sm-2"><button type="submit" class="btn btn-primary" id="btnNuevo">Nuevo usuario</button></a>
            </div>
            <form>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Usuario</th>
                            <th scope="col">Parentesco</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <%
                        LogicaUsuario logica = new LogicaUsuario();
                        boolean hayDatos = logica.cargarTodosLosUsuarios();
                    %>
                    <tbody>
                        <% 
                            if (hayDatos) { 
                               ArrayList<Usuario> lista = logica.getListaUsuarios(); 
                               for (Usuario u : lista) {
                        %>
                        <tr>
                            <td scope="row"><%= u.getId() %></td>
                            <td><%= u.getNombrecompleto() %></td>
                            <td><%= u.getUsuario() %></td>
                            <td><%= u.getParentesco() %></td>
                            <td>
                                <a href=""><button type="button" class="btn btn-success"><i class="bi bi-pencil-fill"></i></button></a>
                            </td>
                        </tr>
                        <%      
                               } 
                           } else { 
                        %>
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