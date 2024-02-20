<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>LE MIE PRENOTAZIONI</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="/webjars/font-awesome/6.5.1/css/all.css"/>
	<link rel="stylesheet" href="/css/main.css">
</head>
<body>

	<header class="alert alert-info text-center"><h1>Lista libri Prenotati</h1></header>
	<jsp:include page="fragments/navbar.jsp"></jsp:include>
	<table class="table table-success table-striped table-hover">
			<tr>
				<th>Id Assegnazione</th>
				<th>Numero Tessera</th>
				<th>Data Prenotazione</th>
				<th>Data Consegna</th>
				<th>Data Restituzione</th>
				<th>Codice Libro</th>		
			</tr>
			<c:forEach var="libro" items="${listPrenotazioni}">			
				<tr>
					<td><c:out value="${libro.idAssegnazione}" /></td>
					<td><c:out value="${libro.numeroTessera}" /></td>
					<td><c:out value="${libro.dataPrenotazione}" /></td>
					<td>
						<c:if test="${!libro.dataConsegna.toString().equals('1970-01-01')}">
							<c:out value="${libro.dataConsegna}" />
						</c:if>
						<c:if test="${libro.dataConsegna.toString().equals('1970-01-01')}">
							
						</c:if>
					</td>
					<td>
						<c:if test="${!libro.dataRestituzione.toString().equals('1970-01-01')}">
							<c:out value="${libro.dataRestituzione}" />
						</c:if>
						<c:if test="${libro.dataRestituzione.toString().equals('1970-01-01')}">
							
						</c:if>
					</td>
					<td><c:out value="${libro.codiceLibro}" /></td>
				</tr>
			</c:forEach>
		</table>
		
	<script src="/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>

</body>
</html>