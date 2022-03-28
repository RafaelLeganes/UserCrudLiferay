package com.sinensia.web.portlet;

import com.sinensia.web.constants.CrudWebPortletKeys;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import com.sinenssia.business.service.LibroLocalServiceUtil;

/**
 * @author Administrador
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CrudWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CrudWebPortletKeys.CRUDWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CrudWebPortlet extends MVCPortlet {
	
	@ProcessAction(name = "addLibro")
	public void addEscritor(ActionRequest request, ActionResponse response) {

	ThemeDisplay themeDisplay =
	(ThemeDisplay) request.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
	Long companyId = themeDisplay.getCompanyId();
	Long groupId = themeDisplay.getScopeGroupId();
	Long userId = themeDisplay.getUserId();
	User user = themeDisplay.getUser();
	String userName = user.getFirstName();
	String nombre = user.getFullName();
	String titulo = "El mentalista";

	System.out.println(userName + " " + nombre);
	//Cuando se realize un cambio en el servicio
	//tenemos que hacer un deploy para refrescar
	//las librería del servicio
	//compile project(":modules:crud:crud-api")
	//crud-service, crud-api, crud, crud-web

	LibroLocalServiceUtil.addNewLibro(groupId, companyId, userId, userName, nombre, titulo);
	SessionMessages.add(request, "success");


	}
}