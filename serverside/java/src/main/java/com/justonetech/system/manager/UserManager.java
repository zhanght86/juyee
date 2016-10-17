package com.justonetech.system.manager;

import com.justonetech.system.daoservice.SysPrivilegeService;
import com.justonetech.system.daoservice.SysUserService;
import com.justonetech.system.domain.SysPrivilege;
import com.justonetech.system.domain.SysUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 * 暂不用此类，改用SysUserManager
 * User: <a href="mailto:hzxia2002@gmail.com">Jackie</a> Date: 2009-11-21 Time:
 * 19:44:17 Version: 1.0
 */
@Service
public class UserManager {
	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysPrivilegeService sysPrivilegeService;

    public final String USERTYPE_KEY = "USER_TYPE";    //用户类型
    public final String USERTYPE_NET = "NET_PROJECT";    //用户类型--网上报建用户
    public final String USERTYPE_SYS = "SYS_USER";    //用户类型--系统用户

	public final String USERTYPE_SITE = "SITE_UNIT";    //用户类型--企业用户
	public final String SITE_USERNAME_KEY = "SITE_USERNAME";    //用户类型--企业用户，放置登录名

	/**
	 * 通过属性进行查询
	 *
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @return 用戶列表
	 */
	protected List<SysUser> findByProperty(String propertyName, String value) {
		return sysUserService.findByProperty(propertyName, value);
	}

	/**
	 * 取得用户角色授权权限
	 *
	 * @param user
	 *            登录用户
	 * @param isDeny
	 *            是否拒绝
	 * @return 权限列表
	 */
	protected List<SysPrivilege> getUserRolePrivileges(SysUser user, String isDeny) {
		String sql = "from SysPrivilege t"
				+ " where t.id in (select privilege "
				+ " from SysRolePrivilege "
				+ " where role in (select role from SysUserRole where user = "
				+ user.getId() + ")) ";

		if (StringUtils.isNotEmpty(isDeny)) {
			sql += " and t.id not in (select privilege from SysUserPrivilege where user = "
					+ user.getId() + " and isDeny = " + isDeny + ")";
		}

		List<SysPrivilege> list = sysPrivilegeService.find(sql);
		List<SysPrivilege> ret = new ArrayList<SysPrivilege>();

		for (SysPrivilege tmp : list) {
			// tmp.setPrivilegeType();

			ret.add(tmp);
		}

		return ret;
	}

	/**
	 * 取得用户拥有的权限
	 *
	 * @param user
	 *            登录用户
	 * @param isDeny
	 *            是否拒绝
	 * @return 权限列表
	 */
	@SuppressWarnings("unchecked")
	protected List<SysPrivilege> getUserPrivileges(SysUser user, String isDeny) {
		List<SysPrivilege> ret = new ArrayList();
		String sql = "from SysPrivilege t, SysUserPrivilege t2 "
				+ "where t.id = t2.privilege ";

		if (StringUtils.isNotEmpty(isDeny)) {
			sql += " and t2.isDeny = " + isDeny;
		}

		sql += " and t2.user in (select id from SysUser "
				+ "where loginName = '" + user.getLoginName() + "')";

		List list = sysPrivilegeService.find(sql);

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				SysPrivilege p = (SysPrivilege) obj[0];
				// p.setPrivilegeType();

				ret.add(p);
			}
		}

		return ret;
	}
}
