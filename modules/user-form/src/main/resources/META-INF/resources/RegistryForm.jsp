<%@ include file="/init.jsp" %>


  <div style="position:relative; margin: 30px 0 0 0;">
		            <aui:input name="userName" type="text" label="Name" style="background: white" placeholder="<%=renderRequest.getParameter("userName")%>" readonly="true">
		            </aui:input>
			    	<aui:input name="userSurname" type="text" label="Surname" style="background: white" placeholder="<%=renderRequest.getParameter("userSurname")%>" readonly="true">
		            </aui:input>
			    	<aui:input name="address" type="text" label="Address" style="background: white" placeholder="<%=renderRequest.getParameter("address")%>" readonly="true">
		            </aui:input>
			    	<aui:input name="userIdCard" type="text" label="UserIdCard" style="background: white" placeholder="<%=renderRequest.getParameter("UserIdCard")%>" readonly="true">
		            </aui:input>
	</div>
