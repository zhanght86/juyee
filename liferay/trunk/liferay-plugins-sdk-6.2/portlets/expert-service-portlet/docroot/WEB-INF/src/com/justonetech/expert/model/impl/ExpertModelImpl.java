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

import com.justonetech.expert.model.Expert;
import com.justonetech.expert.model.ExpertModel;

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
 * The base model implementation for the Expert service. Represents a row in the &quot;expert_Expert&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.justonetech.expert.model.ExpertModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ExpertImpl}.
 * </p>
 *
 * @author fanqi
 * @see ExpertImpl
 * @see com.justonetech.expert.model.Expert
 * @see com.justonetech.expert.model.ExpertModel
 * @generated
 */
public class ExpertModelImpl extends BaseModelImpl<Expert>
	implements ExpertModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a expert model instance should use the {@link com.justonetech.expert.model.Expert} interface instead.
	 */
	public static final String TABLE_NAME = "expert_Expert";
	public static final Object[][] TABLE_COLUMNS = {
			{ "expertId", Types.BIGINT },
			{ "xm", Types.VARCHAR },
			{ "xb", Types.VARCHAR },
			{ "sfzh", Types.VARCHAR },
			{ "csny", Types.TIMESTAMP },
			{ "gzdw", Types.VARCHAR },
			{ "dzyx", Types.VARCHAR },
			{ "txdz", Types.VARCHAR },
			{ "yzbm", Types.VARCHAR },
			{ "xrzw", Types.VARCHAR },
			{ "zc", Types.VARCHAR },
			{ "zyzg", Types.VARCHAR },
			{ "cszy", Types.VARCHAR },
			{ "zygznx", Types.VARCHAR },
			{ "sjhm", Types.VARCHAR },
			{ "lxdh", Types.VARCHAR },
			{ "cz", Types.VARCHAR },
			{ "sqbz", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table expert_Expert (expertId LONG not null primary key,xm VARCHAR(75) null,xb VARCHAR(75) null,sfzh VARCHAR(75) null,csny DATE null,gzdw VARCHAR(75) null,dzyx VARCHAR(75) null,txdz VARCHAR(75) null,yzbm VARCHAR(75) null,xrzw VARCHAR(75) null,zc VARCHAR(75) null,zyzg VARCHAR(75) null,cszy VARCHAR(75) null,zygznx VARCHAR(75) null,sjhm VARCHAR(75) null,lxdh VARCHAR(75) null,cz VARCHAR(75) null,sqbz INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table expert_Expert";
	public static final String ORDER_BY_JPQL = " ORDER BY expert.expertId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY expert_Expert.expertId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.justonetech.expert.model.Expert"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.justonetech.expert.model.Expert"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.justonetech.expert.model.Expert"));

	public ExpertModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _expertId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setExpertId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _expertId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Expert.class;
	}

	@Override
	public String getModelClassName() {
		return Expert.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("expertId", getExpertId());
		attributes.put("xm", getXm());
		attributes.put("xb", getXb());
		attributes.put("sfzh", getSfzh());
		attributes.put("csny", getCsny());
		attributes.put("gzdw", getGzdw());
		attributes.put("dzyx", getDzyx());
		attributes.put("txdz", getTxdz());
		attributes.put("yzbm", getYzbm());
		attributes.put("xrzw", getXrzw());
		attributes.put("zc", getZc());
		attributes.put("zyzg", getZyzg());
		attributes.put("cszy", getCszy());
		attributes.put("zygznx", getZygznx());
		attributes.put("sjhm", getSjhm());
		attributes.put("lxdh", getLxdh());
		attributes.put("cz", getCz());
		attributes.put("sqbz", getSqbz());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long expertId = (Long)attributes.get("expertId");

		if (expertId != null) {
			setExpertId(expertId);
		}

		String xm = (String)attributes.get("xm");

		if (xm != null) {
			setXm(xm);
		}

		String xb = (String)attributes.get("xb");

		if (xb != null) {
			setXb(xb);
		}

		String sfzh = (String)attributes.get("sfzh");

		if (sfzh != null) {
			setSfzh(sfzh);
		}

		Date csny = (Date)attributes.get("csny");

		if (csny != null) {
			setCsny(csny);
		}

		String gzdw = (String)attributes.get("gzdw");

		if (gzdw != null) {
			setGzdw(gzdw);
		}

		String dzyx = (String)attributes.get("dzyx");

		if (dzyx != null) {
			setDzyx(dzyx);
		}

		String txdz = (String)attributes.get("txdz");

		if (txdz != null) {
			setTxdz(txdz);
		}

		String yzbm = (String)attributes.get("yzbm");

		if (yzbm != null) {
			setYzbm(yzbm);
		}

		String xrzw = (String)attributes.get("xrzw");

		if (xrzw != null) {
			setXrzw(xrzw);
		}

		String zc = (String)attributes.get("zc");

		if (zc != null) {
			setZc(zc);
		}

		String zyzg = (String)attributes.get("zyzg");

		if (zyzg != null) {
			setZyzg(zyzg);
		}

		String cszy = (String)attributes.get("cszy");

		if (cszy != null) {
			setCszy(cszy);
		}

		String zygznx = (String)attributes.get("zygznx");

		if (zygznx != null) {
			setZygznx(zygznx);
		}

		String sjhm = (String)attributes.get("sjhm");

		if (sjhm != null) {
			setSjhm(sjhm);
		}

		String lxdh = (String)attributes.get("lxdh");

		if (lxdh != null) {
			setLxdh(lxdh);
		}

		String cz = (String)attributes.get("cz");

		if (cz != null) {
			setCz(cz);
		}

		Integer sqbz = (Integer)attributes.get("sqbz");

		if (sqbz != null) {
			setSqbz(sqbz);
		}
	}

	@Override
	public long getExpertId() {
		return _expertId;
	}

	@Override
	public void setExpertId(long expertId) {
		_expertId = expertId;
	}

	@Override
	public String getXm() {
		if (_xm == null) {
			return StringPool.BLANK;
		}
		else {
			return _xm;
		}
	}

	@Override
	public void setXm(String xm) {
		_xm = xm;
	}

	@Override
	public String getXb() {
		if (_xb == null) {
			return StringPool.BLANK;
		}
		else {
			return _xb;
		}
	}

	@Override
	public void setXb(String xb) {
		_xb = xb;
	}

	@Override
	public String getSfzh() {
		if (_sfzh == null) {
			return StringPool.BLANK;
		}
		else {
			return _sfzh;
		}
	}

	@Override
	public void setSfzh(String sfzh) {
		_sfzh = sfzh;
	}

	@Override
	public Date getCsny() {
		return _csny;
	}

	@Override
	public void setCsny(Date csny) {
		_csny = csny;
	}

	@Override
	public String getGzdw() {
		if (_gzdw == null) {
			return StringPool.BLANK;
		}
		else {
			return _gzdw;
		}
	}

	@Override
	public void setGzdw(String gzdw) {
		_gzdw = gzdw;
	}

	@Override
	public String getDzyx() {
		if (_dzyx == null) {
			return StringPool.BLANK;
		}
		else {
			return _dzyx;
		}
	}

	@Override
	public void setDzyx(String dzyx) {
		_dzyx = dzyx;
	}

	@Override
	public String getTxdz() {
		if (_txdz == null) {
			return StringPool.BLANK;
		}
		else {
			return _txdz;
		}
	}

	@Override
	public void setTxdz(String txdz) {
		_txdz = txdz;
	}

	@Override
	public String getYzbm() {
		if (_yzbm == null) {
			return StringPool.BLANK;
		}
		else {
			return _yzbm;
		}
	}

	@Override
	public void setYzbm(String yzbm) {
		_yzbm = yzbm;
	}

	@Override
	public String getXrzw() {
		if (_xrzw == null) {
			return StringPool.BLANK;
		}
		else {
			return _xrzw;
		}
	}

	@Override
	public void setXrzw(String xrzw) {
		_xrzw = xrzw;
	}

	@Override
	public String getZc() {
		if (_zc == null) {
			return StringPool.BLANK;
		}
		else {
			return _zc;
		}
	}

	@Override
	public void setZc(String zc) {
		_zc = zc;
	}

	@Override
	public String getZyzg() {
		if (_zyzg == null) {
			return StringPool.BLANK;
		}
		else {
			return _zyzg;
		}
	}

	@Override
	public void setZyzg(String zyzg) {
		_zyzg = zyzg;
	}

	@Override
	public String getCszy() {
		if (_cszy == null) {
			return StringPool.BLANK;
		}
		else {
			return _cszy;
		}
	}

	@Override
	public void setCszy(String cszy) {
		_cszy = cszy;
	}

	@Override
	public String getZygznx() {
		if (_zygznx == null) {
			return StringPool.BLANK;
		}
		else {
			return _zygznx;
		}
	}

	@Override
	public void setZygznx(String zygznx) {
		_zygznx = zygznx;
	}

	@Override
	public String getSjhm() {
		if (_sjhm == null) {
			return StringPool.BLANK;
		}
		else {
			return _sjhm;
		}
	}

	@Override
	public void setSjhm(String sjhm) {
		_sjhm = sjhm;
	}

	@Override
	public String getLxdh() {
		if (_lxdh == null) {
			return StringPool.BLANK;
		}
		else {
			return _lxdh;
		}
	}

	@Override
	public void setLxdh(String lxdh) {
		_lxdh = lxdh;
	}

	@Override
	public String getCz() {
		if (_cz == null) {
			return StringPool.BLANK;
		}
		else {
			return _cz;
		}
	}

	@Override
	public void setCz(String cz) {
		_cz = cz;
	}

	@Override
	public int getSqbz() {
		return _sqbz;
	}

	@Override
	public void setSqbz(int sqbz) {
		_sqbz = sqbz;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Expert.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Expert toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Expert)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ExpertImpl expertImpl = new ExpertImpl();

		expertImpl.setExpertId(getExpertId());
		expertImpl.setXm(getXm());
		expertImpl.setXb(getXb());
		expertImpl.setSfzh(getSfzh());
		expertImpl.setCsny(getCsny());
		expertImpl.setGzdw(getGzdw());
		expertImpl.setDzyx(getDzyx());
		expertImpl.setTxdz(getTxdz());
		expertImpl.setYzbm(getYzbm());
		expertImpl.setXrzw(getXrzw());
		expertImpl.setZc(getZc());
		expertImpl.setZyzg(getZyzg());
		expertImpl.setCszy(getCszy());
		expertImpl.setZygznx(getZygznx());
		expertImpl.setSjhm(getSjhm());
		expertImpl.setLxdh(getLxdh());
		expertImpl.setCz(getCz());
		expertImpl.setSqbz(getSqbz());

		expertImpl.resetOriginalValues();

		return expertImpl;
	}

	@Override
	public int compareTo(Expert expert) {
		int value = 0;

		if (getExpertId() < expert.getExpertId()) {
			value = -1;
		}
		else if (getExpertId() > expert.getExpertId()) {
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

		if (!(obj instanceof Expert)) {
			return false;
		}

		Expert expert = (Expert)obj;

		long primaryKey = expert.getPrimaryKey();

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
	public CacheModel<Expert> toCacheModel() {
		ExpertCacheModel expertCacheModel = new ExpertCacheModel();

		expertCacheModel.expertId = getExpertId();

		expertCacheModel.xm = getXm();

		String xm = expertCacheModel.xm;

		if ((xm != null) && (xm.length() == 0)) {
			expertCacheModel.xm = null;
		}

		expertCacheModel.xb = getXb();

		String xb = expertCacheModel.xb;

		if ((xb != null) && (xb.length() == 0)) {
			expertCacheModel.xb = null;
		}

		expertCacheModel.sfzh = getSfzh();

		String sfzh = expertCacheModel.sfzh;

		if ((sfzh != null) && (sfzh.length() == 0)) {
			expertCacheModel.sfzh = null;
		}

		Date csny = getCsny();

		if (csny != null) {
			expertCacheModel.csny = csny.getTime();
		}
		else {
			expertCacheModel.csny = Long.MIN_VALUE;
		}

		expertCacheModel.gzdw = getGzdw();

		String gzdw = expertCacheModel.gzdw;

		if ((gzdw != null) && (gzdw.length() == 0)) {
			expertCacheModel.gzdw = null;
		}

		expertCacheModel.dzyx = getDzyx();

		String dzyx = expertCacheModel.dzyx;

		if ((dzyx != null) && (dzyx.length() == 0)) {
			expertCacheModel.dzyx = null;
		}

		expertCacheModel.txdz = getTxdz();

		String txdz = expertCacheModel.txdz;

		if ((txdz != null) && (txdz.length() == 0)) {
			expertCacheModel.txdz = null;
		}

		expertCacheModel.yzbm = getYzbm();

		String yzbm = expertCacheModel.yzbm;

		if ((yzbm != null) && (yzbm.length() == 0)) {
			expertCacheModel.yzbm = null;
		}

		expertCacheModel.xrzw = getXrzw();

		String xrzw = expertCacheModel.xrzw;

		if ((xrzw != null) && (xrzw.length() == 0)) {
			expertCacheModel.xrzw = null;
		}

		expertCacheModel.zc = getZc();

		String zc = expertCacheModel.zc;

		if ((zc != null) && (zc.length() == 0)) {
			expertCacheModel.zc = null;
		}

		expertCacheModel.zyzg = getZyzg();

		String zyzg = expertCacheModel.zyzg;

		if ((zyzg != null) && (zyzg.length() == 0)) {
			expertCacheModel.zyzg = null;
		}

		expertCacheModel.cszy = getCszy();

		String cszy = expertCacheModel.cszy;

		if ((cszy != null) && (cszy.length() == 0)) {
			expertCacheModel.cszy = null;
		}

		expertCacheModel.zygznx = getZygznx();

		String zygznx = expertCacheModel.zygznx;

		if ((zygznx != null) && (zygznx.length() == 0)) {
			expertCacheModel.zygznx = null;
		}

		expertCacheModel.sjhm = getSjhm();

		String sjhm = expertCacheModel.sjhm;

		if ((sjhm != null) && (sjhm.length() == 0)) {
			expertCacheModel.sjhm = null;
		}

		expertCacheModel.lxdh = getLxdh();

		String lxdh = expertCacheModel.lxdh;

		if ((lxdh != null) && (lxdh.length() == 0)) {
			expertCacheModel.lxdh = null;
		}

		expertCacheModel.cz = getCz();

		String cz = expertCacheModel.cz;

		if ((cz != null) && (cz.length() == 0)) {
			expertCacheModel.cz = null;
		}

		expertCacheModel.sqbz = getSqbz();

		return expertCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{expertId=");
		sb.append(getExpertId());
		sb.append(", xm=");
		sb.append(getXm());
		sb.append(", xb=");
		sb.append(getXb());
		sb.append(", sfzh=");
		sb.append(getSfzh());
		sb.append(", csny=");
		sb.append(getCsny());
		sb.append(", gzdw=");
		sb.append(getGzdw());
		sb.append(", dzyx=");
		sb.append(getDzyx());
		sb.append(", txdz=");
		sb.append(getTxdz());
		sb.append(", yzbm=");
		sb.append(getYzbm());
		sb.append(", xrzw=");
		sb.append(getXrzw());
		sb.append(", zc=");
		sb.append(getZc());
		sb.append(", zyzg=");
		sb.append(getZyzg());
		sb.append(", cszy=");
		sb.append(getCszy());
		sb.append(", zygznx=");
		sb.append(getZygznx());
		sb.append(", sjhm=");
		sb.append(getSjhm());
		sb.append(", lxdh=");
		sb.append(getLxdh());
		sb.append(", cz=");
		sb.append(getCz());
		sb.append(", sqbz=");
		sb.append(getSqbz());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.expert.model.Expert");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>expertId</column-name><column-value><![CDATA[");
		sb.append(getExpertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xm</column-name><column-value><![CDATA[");
		sb.append(getXm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xb</column-name><column-value><![CDATA[");
		sb.append(getXb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfzh</column-name><column-value><![CDATA[");
		sb.append(getSfzh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>csny</column-name><column-value><![CDATA[");
		sb.append(getCsny());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gzdw</column-name><column-value><![CDATA[");
		sb.append(getGzdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dzyx</column-name><column-value><![CDATA[");
		sb.append(getDzyx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>txdz</column-name><column-value><![CDATA[");
		sb.append(getTxdz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yzbm</column-name><column-value><![CDATA[");
		sb.append(getYzbm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xrzw</column-name><column-value><![CDATA[");
		sb.append(getXrzw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zc</column-name><column-value><![CDATA[");
		sb.append(getZc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zyzg</column-name><column-value><![CDATA[");
		sb.append(getZyzg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cszy</column-name><column-value><![CDATA[");
		sb.append(getCszy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zygznx</column-name><column-value><![CDATA[");
		sb.append(getZygznx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjhm</column-name><column-value><![CDATA[");
		sb.append(getSjhm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxdh</column-name><column-value><![CDATA[");
		sb.append(getLxdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cz</column-name><column-value><![CDATA[");
		sb.append(getCz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sqbz</column-name><column-value><![CDATA[");
		sb.append(getSqbz());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Expert.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Expert.class };
	private long _expertId;
	private String _xm;
	private String _xb;
	private String _sfzh;
	private Date _csny;
	private String _gzdw;
	private String _dzyx;
	private String _txdz;
	private String _yzbm;
	private String _xrzw;
	private String _zc;
	private String _zyzg;
	private String _cszy;
	private String _zygznx;
	private String _sjhm;
	private String _lxdh;
	private String _cz;
	private int _sqbz;
	private Expert _escapedModel;
}