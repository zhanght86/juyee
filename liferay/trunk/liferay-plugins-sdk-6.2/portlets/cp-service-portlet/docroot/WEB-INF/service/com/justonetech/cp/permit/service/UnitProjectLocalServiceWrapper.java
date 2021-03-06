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

package com.justonetech.cp.permit.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UnitProjectLocalService}.
 *
 * @author fanqi
 * @see UnitProjectLocalService
 * @generated
 */
public class UnitProjectLocalServiceWrapper implements UnitProjectLocalService,
	ServiceWrapper<UnitProjectLocalService> {
	public UnitProjectLocalServiceWrapper(
		UnitProjectLocalService unitProjectLocalService) {
		_unitProjectLocalService = unitProjectLocalService;
	}

	/**
	* Adds the unit project to the database. Also notifies the appropriate model listeners.
	*
	* @param unitProject the unit project
	* @return the unit project that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.UnitProject addUnitProject(
		com.justonetech.cp.permit.model.UnitProject unitProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitProjectLocalService.addUnitProject(unitProject);
	}

	/**
	* Creates a new unit project with the primary key. Does not add the unit project to the database.
	*
	* @param projectId the primary key for the new unit project
	* @return the new unit project
	*/
	@Override
	public com.justonetech.cp.permit.model.UnitProject createUnitProject(
		long projectId) {
		return _unitProjectLocalService.createUnitProject(projectId);
	}

	/**
	* Deletes the unit project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the unit project
	* @return the unit project that was removed
	* @throws PortalException if a unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.UnitProject deleteUnitProject(
		long projectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _unitProjectLocalService.deleteUnitProject(projectId);
	}

	/**
	* Deletes the unit project from the database. Also notifies the appropriate model listeners.
	*
	* @param unitProject the unit project
	* @return the unit project that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.UnitProject deleteUnitProject(
		com.justonetech.cp.permit.model.UnitProject unitProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitProjectLocalService.deleteUnitProject(unitProject);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _unitProjectLocalService.dynamicQuery();
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
		return _unitProjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.UnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _unitProjectLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.UnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _unitProjectLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _unitProjectLocalService.dynamicQueryCount(dynamicQuery);
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
		return _unitProjectLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.cp.permit.model.UnitProject fetchUnitProject(
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitProjectLocalService.fetchUnitProject(projectId);
	}

	/**
	* Returns the unit project with the primary key.
	*
	* @param projectId the primary key of the unit project
	* @return the unit project
	* @throws PortalException if a unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.UnitProject getUnitProject(
		long projectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _unitProjectLocalService.getUnitProject(projectId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _unitProjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the unit projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.UnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of unit projects
	* @param end the upper bound of the range of unit projects (not inclusive)
	* @return the range of unit projects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.cp.permit.model.UnitProject> getUnitProjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitProjectLocalService.getUnitProjects(start, end);
	}

	/**
	* Returns the number of unit projects.
	*
	* @return the number of unit projects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUnitProjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitProjectLocalService.getUnitProjectsCount();
	}

	/**
	* Updates the unit project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param unitProject the unit project
	* @return the unit project that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.UnitProject updateUnitProject(
		com.justonetech.cp.permit.model.UnitProject unitProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitProjectLocalService.updateUnitProject(unitProject);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _unitProjectLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_unitProjectLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _unitProjectLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.justonetech.cp.permit.model.UnitProject> findByPermitId(
		long permitId, int start, int end) {
		return _unitProjectLocalService.findByPermitId(permitId, start, end);
	}

	@Override
	public int countByPermitId(long permitId) {
		return _unitProjectLocalService.countByPermitId(permitId);
	}

	@Override
	public java.util.List<com.justonetech.cp.permit.model.UnitProject> findByBjbh(
		java.lang.String bjbh, int start, int end) {
		return _unitProjectLocalService.findByBjbh(bjbh, start, end);
	}

	@Override
	public java.util.List<com.justonetech.cp.permit.model.UnitProject> findByBjbhAndPermitUnitProjectIds(
		java.lang.String bjbh, java.lang.Long[] permitUnitProjectIds,
		int start, int end) {
		return _unitProjectLocalService.findByBjbhAndPermitUnitProjectIds(bjbh,
			permitUnitProjectIds, start, end);
	}

	@Override
	public int countByBjbh(java.lang.String bjbh) {
		return _unitProjectLocalService.countByBjbh(bjbh);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery createDynamicQuery(
		java.lang.String bjbh, java.lang.Long[] permitUnitProjectIds) {
		return _unitProjectLocalService.createDynamicQuery(bjbh,
			permitUnitProjectIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UnitProjectLocalService getWrappedUnitProjectLocalService() {
		return _unitProjectLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUnitProjectLocalService(
		UnitProjectLocalService unitProjectLocalService) {
		_unitProjectLocalService = unitProjectLocalService;
	}

	@Override
	public UnitProjectLocalService getWrappedService() {
		return _unitProjectLocalService;
	}

	@Override
	public void setWrappedService(
		UnitProjectLocalService unitProjectLocalService) {
		_unitProjectLocalService = unitProjectLocalService;
	}

	private UnitProjectLocalService _unitProjectLocalService;
}