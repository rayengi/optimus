<%-- 
    Document   : inicio
    Created on : Oct 7, 2021, 6:43:02 AM
    Author     : bizagi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <title>Productos - Página de inicio</title>
    </head>
    <body>
        <div class="container mt-5">
            <center>
                <img src="img/logo.png" alt="Optimus" width="240" height="240">
                <h3 class="mb-4">Menú General</h3>
            </center>
        </div>
        <div class="container" id="hanging-icons">
            <div class="row g-4 py-5 row-cols-1 row-cols-md-2 row-cols-lg-4">
                <div class="col d-flex align-items-start">
                    <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                        <i class="bi bi-box-seam fs-3 px-2"></i>
                    </div>
                    <div>
                        <h2>Productos</h2>
                        <p>Desde aquí se accede al módulo de Productos, con el cual se pueden visualizar, filtrar, imgresar y modificar datos.</p>
                        <a href=Producto_lista.jsp" class="btn btn-primary">Ir al módulo</a>
                    </div>
                </div>
                <div class="col d-flex align-items-start">
                    <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                        <i class="bi bi-person-lines-fill fs-3 px-2"></i>
                    </div>
                    <div>
                        <h2>Usuarios</h2>
                        <p>Se accede desde aquí al módulo de usuarios, donde se puede visualizar, filtrar, ingresar y modificar datos.</p>
                        <a href="usuarios_lista.jsp" class="btn btn-primary">Ir al módulo</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>