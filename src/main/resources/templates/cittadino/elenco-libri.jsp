<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title> Biblioteca Quartiere </title>

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
     
      <div class="container">
      
        <p ><h1 style="margin-left: 500px;">         BENVENUTO CITTADINO</h1></p>
        
        <button a=href="http://localhost:8082/QuartiereBibliotecaServlet/libri-prenotati"> PRENOTA LIBRO </button> 
        
      </div> 

	<div style="margin-left= 30px"></div>
	
	
	
	<div align="center">
	
		<table border="1" cellpadding="5">
		
			<caption>
			
				<h1>Lista libri </h1>
				
			</caption>
			
			<tr>
				<th>Codice Libro</th>
				<th>Titolo</th>
				<th>Autore</th>
				<th>editore</th>
				<th>genere</th>
				<th>stato</th>
				<th>anno</th>
				<th>descrizione</th>
				<th>Numero Pagine</th>
				<th>  </th>
			</tr>



<%-- 			<c:forEach var="libro" items="${listLibri}"> --%>
<!-- 				<tr> -->
<%-- 					<td><c:out value="${libro.codiceLibro}" />   </td> --%>
<%-- 					<td><c:out value="${libro.titolo}" /></td> --%>
<%-- 					<td><c:out value="${libro.autore}" /></td> --%>
<%-- 					<td><c:out value="${libro.editore}" /></td> --%>
<%-- 					<td><c:out value="${libro.genere}" /></td> --%>
<%-- 					<td><c:out value="${libro.stato}" /></td> --%>
<%-- 					<td><c:out value="${libro.anno}" /></td> --%>
<%-- 					<td><c:out value="${libro.descrizione}" /></td> --%>
<%-- 					<td><c:out value="${libro.numeroPagine}" /></td> --%>
<!-- 					<td> -->
<!-- 					<button> -->
<%-- 					<a href="assegna-libro?codice-libro=<c:out value='${libro.codiceLibro}'/>&numero-tessera=1&stato=TC" > Prenota Libro </a>  --%>
<!-- 					</button>  -->
<!-- 					</td> -->

<!-- 				</tr> -->
<%-- 			</c:forEach> --%>

		</table>
	</div>
</body>



<!--  <button type="button" onclick="prenota(book)">Prenota</button>
<script>
  function prenota(book) {
    // qui inserisci il codice per verificare la disponibilità del libro
    if (book.status == "libero") {
      book.status = "prenotato"; // cambia lo stato del libro a prenotato
      // qui inserisci il codice per aggiornare il database e la vista
    } else {
      // qui inserisci il codice per gestire il caso in cui il libro non sia disponibile
    }
  }
</script>  -->





</body>
</html>