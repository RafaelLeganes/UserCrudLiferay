<%@ include file="/init.jsp" %>

<b><liferay-ui:message key="crudweb.caption"/></b>
<portlet:actionURL name="addLibro" var="addLibro"></portlet:actionURL>
<liferay-ui:success key="success" message="Greeting saved successfully!"/>

<div style="position:relative; margin: 30px 0 0 0;">
	<aui:form action="<%= addLibro %>" id="frmUser" name="<portlet:namespace />fm" method="post">	
		<aui:fieldset>		
			<aui:input name="titulo" type="text" label="Título" required="true" style="background: white">
				<aui:validator name="maxLength">200</aui:validator>
		    </aui:input>
			<aui:input name="genero" type="text" label="Genero" required="true" style="background: white">
				<aui:validator name="maxLength">75</aui:validator>
		    </aui:input>
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit"></aui:button>
			<aui:button type="reset" value="clear"/>
		</aui:button-row>
		</aui:form>
	</div>