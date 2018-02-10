package com.liferay.oracly.accounts.payable.web.portlet;

import com.liferay.oracly.accounts.payable.data.model.Payable;
import com.liferay.oracly.accounts.payable.data.service.PayableLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author kpatefield
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Accounts Payable",
		"javax.portlet.name=com_liferay_oracly_accounts_payable_web",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PayablePortlet extends MVCPortlet {
	
	@Reference(unbind = "-")
	 protected void payableLocalService(PayableLocalService payableLocalService) {
		_payableLocalService = payableLocalService;
	 }
	private PayableLocalService _payableLocalService;
	
	
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
		
	DynamicQuery payableDynamicQuery = _payableLocalService.dynamicQuery();
	String pagingString = renderRequest.getParameter("cur1");
	int start = 0;
	int end = 10;
	int pagingVal = 0;
	if (pagingString != null)
	{
		pagingVal = Integer.valueOf(pagingString);
	
	}
	if (pagingVal > 1)
	{
		end = pagingVal * 10;
		start = (pagingVal * 10) - 10;
	}
	
	List<Payable> payableList = _payableLocalService.dynamicQuery(payableDynamicQuery, start, end);
	int payableCount = (int) _payableLocalService.dynamicQueryCount(payableDynamicQuery);
	renderRequest.setAttribute("payableList", payableList);
	renderRequest.setAttribute("payableCount", payableCount);
	
	
	super.doView(renderRequest, renderResponse);
	
	}
	
}