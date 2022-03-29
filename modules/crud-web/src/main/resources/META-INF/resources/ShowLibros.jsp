
<%@ include file="/init.jsp" %>
<%@page import="com.sinenssia.business.service.LibroLocalServiceUtil"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


<portlet:actionURL name="modifyLibro" var="modifyLibro"></portlet:actionURL>
<portlet:actionURL name="deleteLibro" var="deleteLibro"></portlet:actionURL>
<liferay-ui:success key="success" message="Libro modified successfully!"/>
<liferay-ui:error key="error" message="Sorry, We had an Error" />
	
	<table class="table table-responsive table-borderless text-center">
		<thead>
			<tr>
				<th scope="col">Título</th>
      			<th scope="col">Género</th>
			</tr>
	    </thead>
			<c:forEach items="<%= LibroLocalServiceUtil.getLibros(0,LibroLocalServiceUtil.getLibrosCount())%>" var="libro" varStatus="estado">
				<tr>
					<td>${libro.titulo}</td>
					<td>${libro.genero}</td>
					<td><button type="button" data-bs-toggle="modal" data-bs-target="#Editar${libro.libroId}"
					 class="btn btn-sm btn-warning">Modify</button>
						<div class="modal" id="Editar${libro.libroId}">
							<aui:form action="<%= modifyLibro %>" id="frmUser" name="<portlet:namespace />fm">	
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
										<h4 class="modal-title" id="myModalLabael">${libro.titulo}</h4>
									</div>
									<div class="modal-body">
										<div class="mb-3 mb-3">
											<aui:input name="titulo" type="text" label="Título" required="true"
											 style="background: white" value="${libro.titulo}">
		            							<aui:validator name="maxLength">200</aui:validator>
		            						</aui:input>
										</div>
										<div class="mb-3">
											<aui:input name="genero" type="text" label="Genero" required="true"
											 style="background: white" value="${libro.genero}">
			    								<aui:validator name="maxLength">75</aui:validator>
		           	 						</aui:input>
										</div>
											<aui:input type="hidden" name="libroId" value="${libro.libroId}"></aui:input>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-primary" name="action"
											value="Modificar">Modify<button>
										<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close<button>
									</div>
							    </div>
							</div>
							</aui:form>
						</div>
					</td>
					<td><button type="button" data-bs-toggle="modal" data-bs-target="#Eliminar${libro.libroId}"
					 class="btn btn-sm btn-warning">Delete</button>
						<div class="modal" id="Eliminar${libro.libroId}">
							<aui:form action="<%= deleteLibro %>" id="frmUser" name="<portlet:namespace />fm">	
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
										<h4 class="modal-title" id="myModalLabael">${libro.titulo}</h4>
									</div>
									<div class="modal-body">
										<div class="mb-3 mb-3">
											<aui:input name="titulo" type="text" label="Título" required="true"
											 style="background: white" value="${libro.titulo}">
		            							<aui:validator name="maxLength">200</aui:validator>
		            						</aui:input>
										</div>
										<div class="mb-3">
											<aui:input name="genero" type="text" label="Genero" required="true"
											 style="background: white" value="${libro.genero}">
			    								<aui:validator name="maxLength">75</aui:validator>
		           	 						</aui:input>
										</div>
									</div>
									<aui:input type="hidden" name="libroId" value="${libro.libroId}"></aui:input>
									<div class="modal-footer">
										<button type="submit" class="btn btn-primary" name="action"
											value="Eliminar">Delete<button>
										<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close<button>
									</div>
							    </div>
							</div>
							</aui:form>
						</div>
					</td>
				</tr>
			</c:forEach>
	</table>
