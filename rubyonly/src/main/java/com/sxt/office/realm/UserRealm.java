package com.sxt.office.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxt.office.common.ActiverUser;
import com.sxt.office.domain.User;
import com.sxt.office.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author tanghua
 * @Date: 2020/5/25 15:12
 * @Version 1.0
 */
public class UserRealm extends AuthorizingRealm {

    /**
     *  重写getName方法
     * @return
     */
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Autowired
    private UserService userService;

    /**
     *  授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     *  认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginname", token.getPrincipal().toString());

        User user = userService.getOne(queryWrapper);

        if (user != null) {

            ActiverUser activerUser = new ActiverUser();

            activerUser.setUser(user);

            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());

            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activerUser, user.getPwd(), credentialsSalt, this.getName());

            return info;
        }

        return null;
    }
}
