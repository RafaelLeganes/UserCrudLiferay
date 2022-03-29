<%@ include file="/init.jsp" %>


  <div style="position:relative; margin: 30px 0 0 0;">
			    	<aui:input name="titulo" type="text" label="Título" style="background: white" placeholder="<%=renderRequest.getParameter("titulo")%>" readonly="true">
		            </aui:input>
			    	<aui:input name="genero" type="text" label="Género" style="background: white" placeholder="<%=renderRequest.getParameter("genero")%>" readonly="true">
		            </aui:input>
	</div>
