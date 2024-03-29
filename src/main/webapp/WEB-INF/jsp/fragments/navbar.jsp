<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg bg-light bg-body-tertiary">
		  <div class="container-fluid">
		    <a class="navbar-brand " href="/servlet/cittadino/">Biblioteca Quartiere</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="nav nav-pills">
		        <li class="nav-item">
		          <a class="nav-link ${pagina eq 'elencoLibri' ? 'active' : 'text-secondary'}" aria-current="page" href="/servlet/cittadino/elenco-libri">Elenco Libri</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link ${pagina eq 'libriPrenotati' ? 'active' : 'text-secondary'}" aria-current="page" href="/servlet/cittadino/libri-prenotati">Libri Prenotati</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link text-align=right" aria-current="page" href="/logout">Logout</a>
		        </li>       
		      </ul>
		    </div>
		  </div>
</nav>