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

package com.justonetech.expert.model.impl;

import com.justonetech.expert.model.Zqtzjkrzqk;
import com.justonetech.expert.model.ZqtzjkrzqkModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Zqtzjkrzqk service. Represents a row in the &quot;expert_Zqtzjkrzqk&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.justonetech.expert.model.ZqtzjkrzqkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ZqtzjkrzqkImpl}.
 * </p>
 *
 * @author fanqi
 * @see ZqtzjkrzqkImpl
 * @see com.justonetech.expert.model.Zqtzjkrzqk
 * @see com.justonetech.expert.model.ZqtzjkrzqkModel
 * @generated
 */
public class ZqtzjkrzqkModelImpl extends BaseModelImpl<Zqtzjkrzqk>
	implements ZqtzjkrzqkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a zqtzjkrzqk model instance should use the {@link com.justonetech.expert.model.Zqtzjkrzqk} interface instead.
	 */
	public static final String TABLE_NAME = "expert_Zqtzjkrzqk";
	public static final Object[][] TABLE_COLUMNS = {
			{ "zqtzjkrzqkId", Types.BIGINT },
			{ "expertId", Types.VARCHAR },
			{ "zjkxtlsdw", Types.VARCHAR },
			{ "sqzy", Types.VARCHAR },
			{ "pzrq", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table expert_Zqtzjkrzqk (zqtzjkrzqkId LONG not null primary key,expertId VARCHAR(75) null,zjkxtlsdw VARCHAR(75) null,sqzy VARCHAR(75) null,pzrq DATE null)";
	public static final String TABLE_SQL_DROP = "drop table expert_Zqtzjkrzqk";
	public static final String ORDER_BY_JPQL = " ORDER BY zqtzjkrzqk.zqtzjkrzqkId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY expert_Zqtzjkrzqk.zqtzjkrzqkId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.justonetech.expert.model.Zqtzjkrzqk"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.justonetech.expert.model.Zqtzjkrzqk"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.justonetech.expert.model.Zqtzjkrzqk"));

	public ZqtzjkrzqkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _zqtzjkrzqkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setZqtzjkrzqkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _zqtzjkrzqkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Zqtzjkrzqk.class;
	}

	@Override
	public String getModelClassName() {
		return Zqtzjkrzqk.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("zqtzjkrzqkId", getZqtzjkrzqkId());
		attributes.put("expertId", getExpertId());
		attributes.put("zjkxtlsdw", getZjkxtlsdw());
		attributes.put("sqzy", getSqzy());
		attributes.put("pzrq", getPzrq());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long zqtzjkrzqkId = (Long)attributes.get("zqtzjkrzqkId");

		if (zqtzjkrzqkId != null) {
			setZqtzjkrzqkId(zqtzjkrzqkId);
		}

		String expertId = (String)attributes.get("expertId");

		if (expertId != null) {
			setExpertId(expertId);
		}

		String zjkxtlsdw = (String)attributes.get("zjkxtlsdw");

		if (zjkxtlsdw != null) {
			setZjkxtlsdw(zjkxtlsdw);
		}

		String sqzy = (String)attributes.get("sqzy");

		if (sqzy != null) {
			setSqzy(sqzy);
		}

		Date pzrq = (Date)attributes.get("pzrq");

		if (pzrq != null) {
			setPzrq(pzrq);
		}
	}

	@Override
	public long getZqtzjkrzqkId() {
		return _zqtzjkrzqkId;
	}

	@Override
	public void setZqtzjkrzqkId(long zqtzjkrzqkId) {
		_zqtzjkrzqkId = zqtzjkrzqkId;
	}

	@Override
	public String getExpertId() {
		if (_expertId == null) {
			return StringPool.BLANK;
		}
		else {
			return _expertId;
		}
	}

	@Override
	public void setExpertId(String expertId) {
		_expertId = expertId;
	}

	@Override
	public String getZjkxtlsdw() {
		if (_zjkxtlsdw == null) {
			return StringPool.BLANK;
		}
		else {
			return _zjkxtlsdw;
		}
	}

	@Override
	public void setZjkxtlsdw(String zjkxtlsdw) {
		_zjkxtlsdw = zjkxtlsdw;
	}

	@Override
	public String getSqzy() {
		if (_sqzy == null) {
			return StringPool.BLANK;
		}
		else {
			return _sqzy;
		}
	}

	@Override
	public void setSqzy(String sqzy) {
		_sqzy = sqzy;
	}

	@Override
	public Date getPzrq() {
		return _pzrq;
	}

	@Override
	public void setPzrq(Date pzrq) {
		_pzrq = pzrq;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Zqtzjkrzqk.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Zqtzjkrzqk toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Zqtzjkrzqk)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ZqtzjkrzqkImpl zqtzjkrzqkImpl = new ZqtzjkrzqkImpl();

		zqtzjkrzqkImpl.setZqtzjkrzqkId(getZqtzjkrzqkId());
		zqtzjkrzqkImpl.setExpertId(getExpertId());
		zqtzjkrzqkImpl.setZjkxtlsdw(getZjkxtlsdw());
		zqtzjkrzqkImpl.setSqzy(getSqzy());
		zqtzjkrzqkImpl.setPzrq(getPzrq());

		zqtzjkrzqkImpl.resetOriginalValues();

		return zqtzjkrzqkImpl;
	}

	@Override
	public int compareTo(Zqtzjkrzqk zqtzjkrzqk) {
		int value = 0;

		if (getZqtzjkrzqkId() < zqtzjkrzqk.getZqtzjkrzqkId()) {
			value = -1;
		}
		else if (getZqtzjkrzqkId() > zqtzjkrzqk.getZqtzjkrzqkId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof Zqtzjkrzqk)) {
			return false;
		}

		Zqtzjkrzqk zqtzjkrzqk = (Zqtzjkrzqk)obj;

		long primaryKey = zqtzjkrzqk.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Zqtzjkrzqk> toCacheModel() {
		ZqtzjkrzqkCacheModel zqtzjkrzqkCacheModel = new ZqtzjkrzqkCacheModel();

		zqtzjkrzqkCacheModel.zqtzjkrzqkId = getZqtzjkrzqkId();

		zqtzjkrzqkCacheModel.expertId = getExpertId();

		String expertId = zqtzjkrzqkCacheModel.expertId;

		if ((expertId != null) && (expertId.length() == 0)) {
			zqtzjkrzqkCacheModel.expertId = null;
		}

		zqtzjkrzqkCacheModel.zjkxtlsdw = getZjkxtlsdw();

		String zjkxtlsdw = zqtzjkrzqkCacheModel.zjkxtlsdw;

		if ((zjkxtlsdw != null) && (zjkxtlsdw.length() == 0)) {
			zqtzjkrzqkCacheModel.zjkxtlsdw = null;
		}

		zqtzjkrzqkCacheModel.sqzy = getSqzy();

		String sqzy = zqtzjkrzqkCacheModel.sqzy;

		if ((sqzy != null) && (sqzy.length() == 0)) {
			zqtzjkrzqkCacheModel.sqzy = null;
		}

		Date pzrq = getPzrq();

		if (pzrq != null) {
			zqtzjkrzqkCacheModel.pzrq = pzrq.getTime();
		}
		else {
			zqtzjkrzqkCacheModel.pzrq = Long.MIN_VALUE;
		}

		return zqtzjkrzqkCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{zqtzjkrzqkId=");
		sb.append(getZqtzjkrzqkId());
		sb.append(", expertId=");
		sb.append(getExpertId());
		sb.append(", zjkxtlsdw=");
		sb.append(getZjkxtlsdw());
		sb.append(", sqzy=");
		sb.append(getSqzy());
		sb.append(", pzrq=");
		sb.append(getPzrq());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.expert.model.Zqtzjkrzqk");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>zqtzjkrzqkId</column-name><column-value><![CDATA[");
		sb.append(getZqtzjkrzqkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expertId</column-name><column-value><![CDATA[");
		sb.append(getExpertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjkxtlsdw</column-name><column-value><![CDATA[");
		sb.append(getZjkxtlsdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sqzy</column-name><column-value><![CDATA[");
		sb.append(getSqzy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pzrq</column-name><column-value><![CDATA[");
		sb.append(getPzrq());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Zqtzjkrzqk.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Zqtzjkrzqk.class
		};
	private long _zqtzjkrzqkId;
	private String _expertId;
	private String _zjkxtlsdw;
	private String _sqzy;
	private Date _pzrq;
	private Zqtzjkrzqk _escapedModel;
}