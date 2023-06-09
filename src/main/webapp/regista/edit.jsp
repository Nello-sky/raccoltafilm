<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Modifica Regista</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Modifica Regista</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteEditRegistaServlet" class="row g-3" novalidate="novalidate" onSubmit="return validateRegista()">
							
							<c:set var="RegistaInPagina" value="${requestScope.update_regista_attr}" />
							
								<div class="col-md-6">
									<label for="nome" class="form-label">Nome <span class="text-danger">*</span></label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome"
									 value="<c:out value="${not empty RegistaInPagina.nome ? RegistaInPagina.nome : ''}" />" required>
									 <p id="checkNome" style="color:red;"> </p>	
								</div>
								
								<div class="col-md-6">
									<label for="cognome" class="form-label">Cognome <span class="text-danger">*</span></label>
									<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Inserire il cognome"
									 value="<c:out value="${not empty RegistaInPagina.cognome ? RegistaInPagina.cognome : ''}" />" required>
									 <p id="checkCognome" style="color:red;"> </p>
								</div>
							
								<div class="col-md-6">
									<label for="nickName" class="form-label">Nickname <span class="text-danger">*</span></label>
									<input type="text" class="form-control" name="nickName" id="nickName" placeholder="Inserire il nickname"
									 value="<c:out value="${not empty RegistaInPagina.nickName ? RegistaInPagina.nickName : ''}" />" required>
									 <p id="checkNickName" style="color:red;"> </p>
								</div>
								
								
								<fmt:parseDate value="${RegistaInPagina.dataDiNascita}" pattern="yyyy-MM-dd" var="localDateToBeParsed"
								 type="date"/>
								<fmt:formatDate pattern="yyyy-MM-dd" value="${localDateToBeParsed}" var="parsedDate"/>
								<div class="col-md-3">
									<label for="dataDiNascita" class="form-label">Data di Nascita <span class="text-danger">*</span></label>
                        			<input class="form-control" id="dataDiNascita" type="date" placeholder="dd/MM/yy"
                            			title="formato : gg/mm/aaaa"  name="dataDiNascita" required 
                            			value="<c:out value="${not empty RegistaInPagina.dataDiNascita ? RegistaInPagina.dataDiNascita : ''}" />">
                            			<p id="checkDataNascita" style="color:red;"> </p>
								</div>
								
								
								
								<div class="col-md-3">
									<label for="sesso" class="form-label">Sesso <span class="text-danger">*</span></label>
								    <select class="form-select" id="sesso" name="sesso" required>
								    	<option value="" selected>
								    	- select sex -
								    	   </option>
								      	<option value="MASCHIO" ${RegistaInPagina.sesso == 'MASCHIO'?'selected':''} >M</option>
								      	<option value="FEMMINA" ${RegistaInPagina.sesso == 'FEMMINA'?'selected':''} >F</option>
								    </select>
								    <p id="checkSesso" style="color:red;"> </p>
								</div>
								
								
							<div class="col-12">
								<input type="hidden" name="idRegistaUpdate" value="<c:out value="${RegistaInPagina.id}" />">
								<button type="submit" name="insertSubmit" value="insertSubmit" id="insertSubmit" class="btn btn-primary">Conferma</button>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				</div>		
					  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
			<script src="${pageContext.request.contextPath }/regista/validateFormRegista.js"></script>
	  </body>
</html>