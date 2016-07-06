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

package com.justonetech.oa.model;

import com.justonetech.oa.service.ClpSerializer;
import com.justonetech.oa.service.OfficeSupplyApplicationLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author justonetech
 */
public class OfficeSupplyApplicationClp extends BaseModelImpl<OfficeSupplyApplication>
	implements OfficeSupplyApplication {
	public OfficeSupplyApplicationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return OfficeSupplyApplication.class;
	}

	@Override
	public String getModelClassName() {
		return OfficeSupplyApplication.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _officeSupplyApplicationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOfficeSupplyApplicationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _officeSupplyApplicationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeSupplyApplicationId",
			getOfficeSupplyApplicationId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("deptId", getDeptId());
		attributes.put("deptName", getDeptName());
		attributes.put("introductions", getIntroductions());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long officeSupplyApplicationId = (Long)attributes.get(
				"officeSupplyApplicationId");

		if (officeSupplyApplicationId != null) {
			setOfficeSupplyApplicationId(officeSupplyApplicationId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createTime = (Date)attributes.get("createTime");

		if (createTime != null) {
			setCreateTime(createTime);
		}

		Date modifiedTime = (Date)attributes.get("modifiedTime");

		if (modifiedTime != null) {
			setModifiedTime(modifiedTime);
		}

		Long deptId = (Long)attributes.get("deptId");

		if (deptId != null) {
			setDeptId(deptId);
		}

		String deptName = (String)attributes.get("deptName");

		if (deptName != null) {
			setDeptName(deptName);
		}

		String introductions = (String)attributes.get("introductions");

		if (introductions != null) {
			setIntroductions(introductions);
		}
	}

	@Override
	public long getOfficeSupplyApplicationId() {
		return _officeSupplyApplicationId;
	}

	@Override
	public void setOfficeSupplyApplicationId(long officeSupplyApplicationId) {
		_officeSupplyApplicationId = officeSupplyApplicationId;

		if (_officeSupplyApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSupplyApplicationId",
						long.class);

				method.invoke(_officeSupplyApplicationRemoteModel,
					officeSupplyApplicationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_officeSupplyApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_officeSupplyApplicationRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_officeSupplyApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_officeSupplyApplicationRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateTime() {
		return _createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		_createTime = createTime;

		if (_officeSupplyApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateTime", Date.class);

				method.invoke(_officeSupplyApplicationRemoteModel, createTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedTime() {
		return _modifiedTime;
	}

	@Override
	public void setModifiedTime(Date modifiedTime) {
		_modifiedTime = modifiedTime;

		if (_officeSupplyApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedTime", Date.class);

				method.invoke(_officeSupplyApplicationRemoteModel, modifiedTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDeptId() {
		return _deptId;
	}

	@Override
	public void setDeptId(long deptId) {
		_deptId = deptId;

		if (_officeSupplyApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setDeptId", long.class);

				method.invoke(_officeSupplyApplicationRemoteModel, deptId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeptName() {
		return _deptName;
	}

	@Override
	public void setDeptName(String deptName) {
		_deptName = deptName;

		if (_officeSupplyApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setDeptName", String.class);

				method.invoke(_officeSupplyApplicationRemoteModel, deptName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIntroductions() {
		return _introductions;
	}

	@Override
	public void setIntroductions(String introductions) {
		_introductions = introductions;

		if (_officeSupplyApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setIntroductions", String.class);

				method.invoke(_officeSupplyApplicationRemoteModel, introductions);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOfficeSupplyApplicationRemoteModel() {
		return _officeSupplyApplicationRemoteModel;
	}

	public void setOfficeSupplyApplicationRemoteModel(
		BaseModel<?> officeSupplyApplicationRemoteModel) {
		_officeSupplyApplicationRemoteModel = officeSupplyApplicationRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _officeSupplyApplicationRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_officeSupplyApplicationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OfficeSupplyApplicationLocalServiceUtil.addOfficeSupplyApplication(this);
		}
		else {
			OfficeSupplyApplicationLocalServiceUtil.updateOfficeSupplyApplication(this);
		}
	}

	@Override
	public OfficeSupplyApplication toEscapedModel() {
		return (OfficeSupplyApplication)ProxyUtil.newProxyInstance(OfficeSupplyApplication.class.getClassLoader(),
			new Class[] { OfficeSupplyApplication.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OfficeSupplyApplicationClp clone = new OfficeSupplyApplicationClp();

		clone.setOfficeSupplyApplicationId(getOfficeSupplyApplicationId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateTime(getCreateTime());
		clone.setModifiedTime(getModifiedTime());
		clone.setDeptId(getDeptId());
		clone.setDeptName(getDeptName());
		clone.setIntroductions(getIntroductions());

		return clone;
	}

	@Override
	public int compareTo(OfficeSupplyApplication officeSupplyApplication) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedTime(),
				officeSupplyApplication.getModifiedTime());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeSupplyApplicationClp)) {
			return false;
		}

		OfficeSupplyApplicationClp officeSupplyApplication = (OfficeSupplyApplicationClp)obj;

		long primaryKey = officeSupplyApplication.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{officeSupplyApplicationId=");
		sb.append(getOfficeSupplyApplicationId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", modifiedTime=");
		sb.append(getModifiedTime());
		sb.append(", deptId=");
		sb.append(getDeptId());
		sb.append(", deptName=");
		sb.append(getDeptName());
		sb.append(", introductions=");
		sb.append(getIntroductions());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.OfficeSupplyApplication");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>officeSupplyApplicationId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyApplicationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createTime</column-name><column-value><![CDATA[");
		sb.append(getCreateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedTime</column-name><column-value><![CDATA[");
		sb.append(getModifiedTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deptId</column-name><column-value><![CDATA[");
		sb.append(getDeptId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deptName</column-name><column-value><![CDATA[");
		sb.append(getDeptName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>introductions</column-name><column-value><![CDATA[");
		sb.append(getIntroductions());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _officeSupplyApplicationId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private long _deptId;
	private String _deptName;
	private String _introductions;
	private BaseModel<?> _officeSupplyApplicationRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.oa.service.ClpSerializer.class;
}