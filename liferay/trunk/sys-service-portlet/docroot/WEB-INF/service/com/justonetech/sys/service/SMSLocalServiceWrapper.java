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

package com.justonetech.sys.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SMSLocalService}.
 *
 * @author justonetech
 * @see SMSLocalService
 * @generated
 */
public class SMSLocalServiceWrapper implements SMSLocalService,
	ServiceWrapper<SMSLocalService> {
	public SMSLocalServiceWrapper(SMSLocalService smsLocalService) {
		_smsLocalService = smsLocalService;
	}

	/**
	* Adds the s m s to the database. Also notifies the appropriate model listeners.
	*
	* @param sms the s m s
	* @return the s m s that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.sys.model.SMS addSMS(
		com.justonetech.sys.model.SMS sms)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.addSMS(sms);
	}

	/**
	* Creates a new s m s with the primary key. Does not add the s m s to the database.
	*
	* @param smsId the primary key for the new s m s
	* @return the new s m s
	*/
	@Override
	public com.justonetech.sys.model.SMS createSMS(long smsId) {
		return _smsLocalService.createSMS(smsId);
	}

	/**
	* Deletes the s m s with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param smsId the primary key of the s m s
	* @return the s m s that was removed
	* @throws PortalException if a s m s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.sys.model.SMS deleteSMS(long smsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.deleteSMS(smsId);
	}

	/**
	* Deletes the s m s from the database. Also notifies the appropriate model listeners.
	*
	* @param sms the s m s
	* @return the s m s that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.sys.model.SMS deleteSMS(
		com.justonetech.sys.model.SMS sms)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.deleteSMS(sms);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.SMSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.SMSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.justonetech.sys.model.SMS fetchSMS(long smsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.fetchSMS(smsId);
	}

	/**
	* Returns the s m s with the primary key.
	*
	* @param smsId the primary key of the s m s
	* @return the s m s
	* @throws PortalException if a s m s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.sys.model.SMS getSMS(long smsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.getSMS(smsId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s m ses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.SMSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s m ses
	* @param end the upper bound of the range of s m ses (not inclusive)
	* @return the range of s m ses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.sys.model.SMS> getSMSs(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.getSMSs(start, end);
	}

	/**
	* Returns the number of s m ses.
	*
	* @return the number of s m ses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSMSsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.getSMSsCount();
	}

	/**
	* Updates the s m s in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sms the s m s
	* @return the s m s that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.sys.model.SMS updateSMS(
		com.justonetech.sys.model.SMS sms)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _smsLocalService.updateSMS(sms);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _smsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_smsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _smsLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SMSLocalService getWrappedSMSLocalService() {
		return _smsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSMSLocalService(SMSLocalService smsLocalService) {
		_smsLocalService = smsLocalService;
	}

	@Override
	public SMSLocalService getWrappedService() {
		return _smsLocalService;
	}

	@Override
	public void setWrappedService(SMSLocalService smsLocalService) {
		_smsLocalService = smsLocalService;
	}

	private SMSLocalService _smsLocalService;
}