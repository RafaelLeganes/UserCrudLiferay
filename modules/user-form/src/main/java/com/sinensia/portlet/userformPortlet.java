package com.sinensia.portlet;

import com.sinensia.constants.userformPortletKeys;
import com.sinensia.model.User;
import com.sinensia.utilities.UsersSingleton;

import java.io.IOException;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

/**
 * @author Administrador
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.Rafa",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=userform",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + userformPortletKeys.USERFORM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class userformPortlet extends MVCPortlet {
	
	@ProcessAction(name="addUser")
	public void addUser(ActionRequest actionRequest,
			ActionResponse actionResponse)  throws IOException, PortletException {
			 
			String userName = ParamUtil.getString(actionRequest,"userName");
			String userSurname = ParamUtil.getString(actionRequest,"userSurname");
			String userAddress = ParamUtil.getString(actionRequest,"address");
			String userIdCard = ParamUtil.getString(actionRequest,"userIdCard");
			
			System.out.println("User name is " +  userName + " and surname is " + userSurname +
					            ", address is " + userAddress + " and userIdCard is " + userIdCard);

			if (userIdCard.contentEquals("38115062a")) {
				SessionErrors.add(actionRequest, "error");
			}
			SessionMessages.add(actionRequest, "success");
			//Deprecated
			//actionResponse.setRenderParameter("jspPage","/whatevername.jsp")
			User user = new User();
			user.setUserName(userName);
			user.setUserSurname(userSurname);
			user.setUserAddress(userAddress);
			user.setUserIdCard(userIdCard);
			UsersSingleton.getInstance().addToArray(user);
			actionResponse.getRenderParameters().setValue("jspPage","/RegistryForm.jsp");
	}
	
	@ProcessAction(name="modifyUser")
	public void modifyUser(ActionRequest actionRequest,
			ActionResponse actionResponse)  throws IOException, PortletException {
		
			String userName = ParamUtil.getString(actionRequest,"userName");
			String userSurname = ParamUtil.getString(actionRequest,"userSurname");
			String userAddress = ParamUtil.getString(actionRequest,"address");
			String userIdCard = ParamUtil.getString(actionRequest,"userIdCard");
			
			int index = Integer.valueOf(ParamUtil.getString(actionRequest,"numero"));
			UsersSingleton.getInstance().getArray().get(index).setUserName(userName);
			UsersSingleton.getInstance().getArray().get(index).setUserSurname(userSurname);
			UsersSingleton.getInstance().getArray().get(index).setUserAddress(userAddress);
			UsersSingleton.getInstance().getArray().get(index).setUserIdCard(userIdCard);
			actionResponse.getRenderParameters().setValue("jspPage","/ShowUsers.jsp");
	}
	
	@ProcessAction(name="deleteUser")
	public void deleteUser(ActionRequest actionRequest,
			ActionResponse actionResponse)  throws IOException, PortletException {
		
			
			int index = Integer.valueOf(ParamUtil.getString(actionRequest,"numero"));
			UsersSingleton.getInstance().getArray().remove(index);
			actionResponse.getRenderParameters().setValue("jspPage","/ShowUsers.jsp");
	}
}