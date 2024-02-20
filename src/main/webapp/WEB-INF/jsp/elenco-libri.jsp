<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title> Biblioteca Quartiere </title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="/webjars/font-awesome/6.5.1/css/all.css"/>
	<link rel="stylesheet" href="/css/main.css">
</head>
<body>

<!--  *******************************	CSS 	***************************************************** -->
	<style>
        .container {
          border: 1px solid black;
          overflow: hidden;
        }
      
        .button {
          float: right;
          margin-right: 50px;
          margin-top: -60px;
          margin-bottom: 20px;
          padding: 30px;
                }
      </style>
      
 <!--  *******************************		 	***************************************************** -->
     
<header class="alert alert-info text-center" style="background-color: darkgoldenrod; color: black;"><h1>BENVENUTO CITTADINO</h1><br><h3>Lista libri</h3></header>
	
	
		<jsp:include page="fragments/navbar.jsp"></jsp:include>
		<div style="max-width: 1270px; margin: 0 auto;">
		<table class="table table-success table-striped table-hover table-dark">
			
			<tr>
				<th>Codice Libro</th>
				<th>Titolo</th>
				<th>Autore</th>
				<th>Editore</th>
				<th>Genere</th>
				<th>Stato</th>
				<th>Anno</th>
				<th>Descrizione</th>
				<th>Numero Pagine</th>
				<th>  </th>
			</tr>



			<c:forEach var="libro" items="${listLibri}">
				<tr>
					<td><c:out value="${libro.codiceLibro}" />   </td>
					<td><c:out value="${libro.titolo}" /></td>
					<td><c:out value="${libro.autore}" /></td>
					<td><c:out value="${libro.editore}" /></td>
					<td><c:out value="${libro.genere}" /></td>
					<td><c:out value="${libro.stato}" /></td>
					<td><c:out value="${libro.anno}" /></td>
					<td><c:out value="${libro.descrizione}" /></td>
					<td><c:out value="${libro.numeroPagine}" /></td>
					<td>
						<a href="assegna-libro?codice-libro=<c:out value='${libro.codiceLibro}'/>&numero-tessera=<c:out value='${utente.id}'/>&stato=PR" > <button type="button" class="btn btn-warning">Prenota Libro</button> </a>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<script src="/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>