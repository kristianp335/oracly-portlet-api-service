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

package com.liferay.oracly.accounts.payable.data.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Payable service. Represents a row in the &quot;Oracly_Payable&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PayableModel
 * @see com.liferay.oracly.accounts.payable.data.model.impl.PayableImpl
 * @see com.liferay.oracly.accounts.payable.data.model.impl.PayableModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.oracly.accounts.payable.data.model.impl.PayableImpl")
@ProviderType
public interface Payable extends PayableModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.oracly.accounts.payable.data.model.impl.PayableImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Payable, Long> PAYABLE_ID_ACCESSOR = new Accessor<Payable, Long>() {
			@Override
			public Long get(Payable payable) {
				return payable.getPayableId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Payable> getTypeClass() {
				return Payable.class;
			}
		};
}