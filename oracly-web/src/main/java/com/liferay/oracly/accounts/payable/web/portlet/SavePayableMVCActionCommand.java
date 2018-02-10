package com.liferay.oracly.accounts.payable.web.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.oracly.accounts.payable.data.model.Payable;
import com.liferay.oracly.accounts.payable.data.service.PayableLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;


@Component(
		immediate = true,
		property = {
				"javax.portlet.name=com_liferay_oracly_accounts_payable_web",
				"mvc.command.name=/save/savePayable"
	},
		service = MVCActionCommand.class)
public class SavePayableMVCActionCommand implements MVCActionCommand {
	
	
	@Reference(unbind = "-")
	 protected void payableLocalService(PayableLocalService payableLocalService) {
		_payableLocalService = payableLocalService;
	 }
	private PayableLocalService _payableLocalService;



	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		ThemeDisplay themeDisplay= (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId= themeDisplay.getSiteGroupId();
		long companyId = themeDisplay.getCompanyId();
		//important shows a way of getting parameters when the form in te jsp is multipart
		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(
			        Group.class.getName(), actionRequest);
			serviceContext.setScopeGroupId(groupId);
			// permissions for group (site)
			serviceContext.setAddGroupPermissions(true);
		} catch (PortalException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadPortletRequest.getFile("invoice");
		String mimeType = MimeTypesUtil.getContentType(file);
		String description = "This file was uploaded by the Cara Manage Jobs Portlet";
		Date today = new Date();
		long fileEntryId = 0;
		String title = "Invoice_File_" + today.getDay() + (today.getMonth() + 1) + today.getYear() + today.getHours() + today.getSeconds() + today.getSeconds();
		long fileSize = file.length();
		String downloadURL = "";
		String changeLog = "Programatical change";
		InputStream is = null;
		try {
			is = new FileInputStream( file );
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String fileName = file.getName();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		try {
			Folder folderId = DLAppServiceUtil.getFolder(groupId, parentFolderId , "Payable");
			long folderIdId = folderId.getFolderId();
			DLAppServiceUtil.addFileEntry(groupId, folderIdId, fileName, mimeType, title, description, changeLog, is, fileSize, serviceContext);			
			
			
			FileEntry thisFileEntry = DLAppServiceUtil.getFileEntry(groupId, folderIdId, title);
			fileEntryId = thisFileEntry.getFileEntryId();			
		
			// Get last version of the file entry
			FileVersion fileVersion = thisFileEntry.getFileVersion();
			 
			// If you want to add additional GET parameters you can modify this var
			String queryString = "";
			 
			// Append the requested file version as GET parameter
			boolean appendFileEntryVersion = true;
			 
			// Choose to prefix or not the URL by the portal URL
			boolean useAbsoluteURL = true;
			 
			// Compute the download URL of the file entry 
			String dlURL = DLUtil.getPreviewURL(thisFileEntry, fileVersion, themeDisplay, queryString, appendFileEntryVersion, useAbsoluteURL);
			System.out.println(dlURL);
			downloadURL = dlURL;
			
			Payable payable = _payableLocalService.createPayable(CounterLocalServiceUtil.increment("taskDetails"));
			long userId = themeDisplay.getUserId();
			User user = UserLocalServiceUtil.getUserById(userId);
			String fullname = user.getFullName();			
			payable.setUserId(userId);
			payable.setUserName(fullname);
			payable.setCompanyId(companyId);
			payable.setGroupId(groupId);
			payable.setCreateDate(today);
			payable.setModifiedDate(today);
			
			//set file and file path
			
			payable.setPath(downloadURL);
			payable.setDocumentId(fileEntryId);
			
			
			Double amount = Double.parseDouble(uploadPortletRequest.getParameter("amount"));
			payable.setAmount(amount);
			payable.setDescription(uploadPortletRequest.getParameter("description"));
			payable.setSupplierName(uploadPortletRequest.getParameter("supplier"));
			if (amount > 999)
			{
				payable.setFlag(1);
			}
			else
			{
				payable.setFlag(0);
			}
			
			int dueDay = ParamUtil.getInteger(uploadPortletRequest, "dueDay");
			int dueMonth = ParamUtil.getInteger(uploadPortletRequest, "dueMonth");
			int dueYear = ParamUtil.getInteger(uploadPortletRequest, "dueYear");
			Date dueDate = new Date();
			dueDate.setDate(dueDay);
			dueDate.setMonth(dueMonth);
			dueDate.setYear(dueYear - 1900);
			
			payable.setDueDate(dueDate);
			_payableLocalService.addPayable(payable);
								
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return false;
	}

}

