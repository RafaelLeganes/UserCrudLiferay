<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
  <portlet:renderURL var="view">
	  <portlet:param name="mvcPath" value="/view.jsp" />
  </portlet:renderURL>
  <portlet:renderURL var="showLibrosUrl">
	  <portlet:param name="mvcPath" value="/ShowLibros.jsp" />
  </portlet:renderURL>
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	  <a class="navbar-brand" href="<%= view %>">Libros Crud</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" 
	  		  data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
	  		  aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	  </button>

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="<%= view %>">Add</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="<%= showLibrosUrl %>">Show</a>
	      </li>
	  </div>
  </nav>