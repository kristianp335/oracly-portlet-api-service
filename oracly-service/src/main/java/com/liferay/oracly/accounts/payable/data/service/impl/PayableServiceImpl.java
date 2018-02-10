/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.oracly.accounts.payable.data.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.List;

import com.liferay.oracly.accounts.payable.data.model.Payable;
import com.liferay.oracly.accounts.payable.data.service.base.PayableServiceBaseImpl;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

/**
 * The implementation of the payable remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.oracly.accounts.payable.data.service.PayableService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PayableServiceBaseImpl
 * @see com.liferay.oracly.accounts.payable.data.service.PayableServiceUtil
 */
@ProviderType
public class PayableServiceImpl extends PayableServiceBaseImpl {
	
	@JSONWebService(value = "get-payables")
	public List<Payable> getJSONPayables() {
		List<Payable> payables = payableLocalService.getPayables(0, 1000);
		return payables;
		
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.oracly.accounts.payable.data.service.PayableServiceUtil} to access the payable remote service.
	 */
}