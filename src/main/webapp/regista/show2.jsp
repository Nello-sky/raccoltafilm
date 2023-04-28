<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="it" class="h-100" >
	 <head>

	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	 	
	   <title>Visualizza Elemento</title>
	   
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Visualizza dettaglio</h5>
					    </div>
					    
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Id:</dt>
							  <dd class="col-sm-9">${show_regista_attr.id}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">nome:</dt>
							  <dd class="col-sm-9">${show_regista_attr.nome}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">cognome:</dt>
							  <dd class="col-sm-9">${show_regista_attr.cognome}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">nickname:</dt>
							  <dd class="col-sm-9">${show_regista_attr.nickName}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di Nascita:</dt>
							  <dd class="col-sm-9">
							  	<fmt:parseDate value="${show_regista_attr.dataDiNascita}" pattern="yyyy-MM-dd" var="localDateToBeParsed" type="date"/>
								<fmt:formatDate pattern="dd/MM/yyyy" value="${localDateToBeParsed}" />
							  </dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">sesso:</dt>
							  <dd class="col-sm-9">${show_regista_attr.sesso}</dd>
					    	</dl>
					    	
					    	<!-- info Regista -->
					    	<p>
							  <a class="btn btn-primary btn-sm" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
							    Info Films
							  </a>
							</p>
								
							
							<div class="collapse" id="collapseExample">
							  <div class="card card-body">
							  	
										    <div class='table-responsive'>
							            <table class='table table-striped ' >
							                <thead>
							                    <tr>
						                         	<th>Titolo</th>
							                        <th>Genere</th>
							                        <th>Data di pubblicazione</th>
							                        <th>Minuti di durata</th>
							                    </tr>
							                </thead>
							                <tbody>
							                	<c:forEach items="${show_regista_attr.films  }" var="filmsItem">
													<tr>
														<td>${filmsItem.titolo}</td>
														<td>${filmsItem.genere }</td>
														<td>
															<fmt:parseDate value="${filmsItem.dataPubblicazione}" pattern="yyyy-MM-dd" var="localDateToBeParsed" type="date"/>
															<fmt:formatDate pattern="dd/MM/yyyy" value="${localDateToBeParsed}" />
														</td>
														<td>${filmsItem.minutiDurata }</td>
													</tr>
												</c:forEach>
							                </tbody>
							            </table>
							        </div>
							    
							  </div>
							<!-- end info Regista -->
							</div>
					    	
					    <!-- end card body -->
					    </div>
					    
					    <div class='card-footer'>
					        <a href="ExecuteListRegistaServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
					    </div>
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>