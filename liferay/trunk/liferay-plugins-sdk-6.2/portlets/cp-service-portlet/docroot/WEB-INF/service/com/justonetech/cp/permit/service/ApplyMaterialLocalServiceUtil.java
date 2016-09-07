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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ApplyMaterial. This utility wraps
 * {@link com.justonetech.cp.permit.service.impl.ApplyMaterialLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author fanqi
 * @see ApplyMaterialLocalService
 * @see com.justonetech.cp.permit.service.base.ApplyMaterialLocalServiceBaseImpl
 * @see com.justonetech.cp.permit.service.impl.ApplyMaterialLocalServiceImpl
 * @generated
 */
public class ApplyMaterialLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.justonetech.cp.permit.service.impl.ApplyMaterialLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the apply material to the database. Also notifies the appropriate model listeners.
	*
	* @param applyMaterial the apply material
	* @return the apply material that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial addApplyMaterial(
		com.justonetech.cp.permit.model.ApplyMaterial applyMaterial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addApplyMaterial(applyMaterial);
	}

	/**
	* Creates a new apply material with the primary key. Does not add the apply material to the database.
	*
	* @param materialId the primary key for the new apply material
	* @return the new apply material
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial createApplyMaterial(
		long materialId) {
		return getService().createApplyMaterial(materialId);
	}

	/**
	* Deletes the apply material with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param materialId the primary key of the apply material
	* @return the apply material that was removed
	* @throws PortalException if a apply material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial deleteApplyMaterial(
		long materialId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteApplyMaterial(materialId);
	}

	/**
	* Deletes the apply material from the database. Also notifies the appropriate model listeners.
	*
	* @param applyMaterial the apply material
	* @return the apply material that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial deleteApplyMaterial(
		com.justonetech.cp.permit.model.ApplyMaterial applyMaterial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteApplyMaterial(applyMaterial);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.justonetech.cp.permit.model.ApplyMaterial fetchApplyMaterial(
		long materialId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchApplyMaterial(materialId);
	}

	/**
	* Returns the apply material with the primary key.
	*
	* @param materialId the primary key of the apply material
	* @return the apply material
	* @throws PortalException if a apply material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial getApplyMaterial(
		long materialId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getApplyMaterial(materialId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the apply materials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of apply materials
	* @param end the upper bound of the range of apply materials (not inclusive)
	* @return the range of apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ApplyMaterial> getApplyMaterials(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getApplyMaterials(start, end);
	}

	/**
	* Returns the number of apply materials.
	*
	* @return the number of apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static int getApplyMaterialsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getApplyMaterialsCount();
	}

	/**
	* Updates the apply material in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param applyMaterial the apply material
	* @return the apply material that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial updateApplyMaterial(
		com.justonetech.cp.permit.model.ApplyMaterial applyMaterial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateApplyMaterial(applyMaterial);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.justonetech.cp.permit.model.ApplyMaterial> findByPermitId(
		long permitId, int start, int end) {
		return getService().findByPermitId(permitId, start, end);
	}

	public static int countByPermitId(long permitId) {
		return getService().countByPermitId(permitId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ApplyMaterialLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ApplyMaterialLocalService.class.getName());

			if (invokableLocalService instanceof ApplyMaterialLocalService) {
				_service = (ApplyMaterialLocalService)invokableLocalService;
			}
			else {
				_service = new ApplyMaterialLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ApplyMaterialLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ApplyMaterialLocalService service) {
	}

	private static ApplyMaterialLocalService _service;
}