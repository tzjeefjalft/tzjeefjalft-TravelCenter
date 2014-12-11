package com.tz.travel.dao.jpa.impl;

import com.tz.travel.dao.jpa.Interface.UserInfoDao;
import com.tz.travel.model.UserInfo;
import org.springframework.stereotype.Component;

/**
 * Created by tzjeefjalft on 12/10/2014.
 */
@Component
public class UserInfoDaoImpl extends AbstractGenericDao<UserInfo, Integer> implements UserInfoDao {
    public UserInfoDaoImpl() {
        super(UserInfo.class, Integer.class);
    }
}
