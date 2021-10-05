<%-- 
    Document   : Producto
    Created on : Sep 29, 2021, 7:25:42 AM
    Author     : Grupo Optimus
--%>
<%//El nombre de la pagina podria comenzar en minuscula%>
<%@page import="logica.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
                 String titulo;
                 titulo = "Bienvenidos Sistema Monitoreo Conos";
                 out.println(titulo);
            %>
        </h1>
            <%
                 Producto p = new Producto();
                 p.setNombreProducto("FLORINETA BANANA");
                 p.setIdTipoReferencia(1);
                 p.setIdEspecificaciones(1);
            %>
            <form>  
                <div class="row mb-3">
                    <label for="txtl" class="col-form-label col-sm-2">Nombre Producto</label>
                    <input type="text" class="col-form-control col-sm-10" id="txtl" name="txtl" value="<%= p.getNombreProducto() %>"></input>                    
                </div>
            </form> 
            <form>  
                <div class="row mb-3">
                    <label for="txtl" class="col-form-label col-sm-2">Tipo Referencia</label>
                    <input typ="text" class="col-form-control col-sm-10" id="txt1" name="txt1" value="<%= p.getIdTipoReferencia() %>"></input>                    
                </div>
            </form>
            </form> 
            <form>  
                <div class="row mb-3">
                    <label for="txtl" class="col-form-label col-sm-2">Especificaciones</label>
                    <input type="text" class="col-form-control col-sm-10" id="txt1" name="txt1" value="<%= p.getIdEspecificaciones() %>"></input>                    
                </div>
            </form>
    </body>
</html>
