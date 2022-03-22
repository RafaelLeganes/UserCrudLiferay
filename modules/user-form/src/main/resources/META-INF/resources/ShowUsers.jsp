
<%@ include file="/init.jsp" %>
<%@page import="com.sinensia.utilities.UsersSingleton"%>
<%@page import="com.sinensia.model.User"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


<portlet:actionURL name="modifyUser" var="modifyUser"></portlet:actionURL>
<portlet:actionURL name="deleteUser" var="deleteUser"></portlet:actionURL>
<liferay-ui:success key="success" message="User modified successfully!"/>
<liferay-ui:error key="error" message="Sorry, this User Id Card is already in database" />
	
	<table class="table table-responsive table-borderless text-center">
		<thead>
			<tr>
				<th scope="col">userName</th>
      			<th scope="col">userSurname</th>
      			<th scope="col">address</th>
      			<th scope="col">userIdCard</th>
      			<th scope="col">modify</th>
      			<th scope="col">delete</th>
			</tr>
	    </thead>
			<c:forEach items="<%= UsersSingleton.getInstance().getArray()%>" var="usuario" varStatus="estado">
				<tr>
					<td>${usuario.userName}</td>
					<td>${usuario.userSurname}</td>
					<td>${usuario.userAddress}</td>
					<td>${usuario.userIdCard}</td>
					<td><button type="button" data-bs-toggle="modal" data-bs-target="#Editar${usuario.userIdCard}"
					 class="btn btn-sm btn-warning">Modify</button>
						<div class="modal" id="Editar${usuario.userIdCard}">
							<aui:form action="<%= modifyUser %>" id="frmUser" name="<portlet:namespace />fm">	
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
										<h4 class="modal-title" id="myModalLabael">${usuario.userName}</h4>
									</div>
									<div class="modal-body">
										<div class="mb-3 mb-3">
											<aui:input name="userName" type="text" label="Name" required="true"
											 style="background: white" value="${usuario.userName}">
		            							<aui:validator name="maxLength">20</aui:validator>
		            						</aui:input>
										</div>
										<div class="mb-3">
											<aui:input name="userSurname" type="text" label="Surname" required="true"
											 style="background: white" value="${usuario.userSurname}">
			    								<aui:validator name="maxLength">20</aui:validator>
		           	 						</aui:input>
										</div>
										<div class="mb-3">
											<aui:input name="address" type="text" label="Address" required="true"
											 style="background: white" value="${usuario.userAddress}">
			    								<aui:validator name="maxLength">20</aui:validator>
		            						</aui:input>
										</div>
										<div class="mb-3">
											<aui:input name="userIdCard" type="text" label="UserIdCard" required="true"
											 style="background: white" value="${usuario.userIdCard}">
			    								<aui:validator name="maxLength">20</aui:validator>
		            						</aui:input>
										</div>
											<aui:input type="hidden" name="numero" value="${estado.index}"></aui:input>
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
					<td><button type="button" data-bs-toggle="modal" data-bs-target="#Eliminar${usuario.userIdCard}"
					 class="btn btn-sm btn-warning">Delete</button>
						<div class="modal" id="Eliminar${usuario.userIdCard}">
							<aui:form action="<%= deleteUser %>" id="frmUser" name="<portlet:namespace />fm">	
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
										<h4 class="modal-title" id="myModalLabael">${usuario.userName}</h4>
									</div>
									<div class="modal-body">
										<div class="mb-3 mb-3">
											<aui:input name="userName" type="text" label="Name" required="true"
											 style="background: grey" value="${usuario.userName}" readonly="true">
		            						</aui:input>
										</div>
										<div class="mb-3">
											<aui:input name="userSurname" type="text" label="Surname" required="true"
											 style="background: grey" value="${usuario.userSurname}" readonly="true">
		           	 						</aui:input>
										</div>
										<div class="mb-3">
											<aui:input name="address" type="text" label="Address" required="true"
											 style="background: grey" value="${usuario.userAddress}" readonly="true">
		            						</aui:input>
										</div>
										<div class="mb-3">
											<aui:input name="userIdCard" type="text" label="UserIdCard" required="true"
											 style="background: grey" value="${usuario.userIdCard}" readonly="true">
		            						</aui:input>
										</div>
											<aui:input type="hidden" name="numero" value="${estado.index}"></aui:input>
									</div>
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
