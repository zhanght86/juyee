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

package com.justonetech.cp.project.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author fanqi
 * @generated
 */
public class ProjectSoap implements Serializable {
	public static ProjectSoap toSoapModel(Project model) {
		ProjectSoap soapModel = new ProjectSoap();

		soapModel.setProjectId(model.getProjectId());
		soapModel.setZzjgdm(model.getZzjgdm());
		soapModel.setBjrq(model.getBjrq());
		soapModel.setBjWebid(model.getBjWebid());
		soapModel.setXmmc(model.getXmmc());
		soapModel.setBjwcbj(model.getBjwcbj());
		soapModel.setJsdwmc(model.getJsdwmc());

		return soapModel;
	}

	public static ProjectSoap[] toSoapModels(Project[] models) {
		ProjectSoap[] soapModels = new ProjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectSoap[][] toSoapModels(Project[][] models) {
		ProjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectSoap[] toSoapModels(List<Project> models) {
		List<ProjectSoap> soapModels = new ArrayList<ProjectSoap>(models.size());

		for (Project model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectSoap[soapModels.size()]);
	}

	public ProjectSoap() {
	}

	public String getPrimaryKey() {
		return _projectId;
	}

	public void setPrimaryKey(String pk) {
		setProjectId(pk);
	}

	public String getProjectId() {
		return _projectId;
	}

	public void setProjectId(String projectId) {
		_projectId = projectId;
	}

	public String getZzjgdm() {
		return _zzjgdm;
	}

	public void setZzjgdm(String zzjgdm) {
		_zzjgdm = zzjgdm;
	}

	public Date getBjrq() {
		return _bjrq;
	}

	public void setBjrq(Date bjrq) {
		_bjrq = bjrq;
	}

	public String getBjWebid() {
		return _bjWebid;
	}

	public void setBjWebid(String bjWebid) {
		_bjWebid = bjWebid;
	}

	public String getXmmc() {
		return _xmmc;
	}

	public void setXmmc(String xmmc) {
		_xmmc = xmmc;
	}

	public String getBjwcbj() {
		return _bjwcbj;
	}

	public void setBjwcbj(String bjwcbj) {
		_bjwcbj = bjwcbj;
	}

	public String getJsdwmc() {
		return _jsdwmc;
	}

	public void setJsdwmc(String jsdwmc) {
		_jsdwmc = jsdwmc;
	}

	private String _projectId;
	private String _zzjgdm;
	private Date _bjrq;
	private String _bjWebid;
	private String _xmmc;
	private String _bjwcbj;
	private String _jsdwmc;
}