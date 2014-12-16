package com.tz.travel.dao.jpa.impl;

import com.tz.travel.dao.jpa.Interface.UserExtDao;
import com.tz.travel.kernel.model.rest.request.AbstractRequest;
import com.tz.travel.model.UserExt;
import com.tz.travel.model.UserInfo;
import org.springframework.stereotype.Component;

/**
 * Created by tzjeefjalft on 12/16/2014.
 */
@Component
public class UserExtDaoImpl extends AbstractGenericDao<UserExt, Integer> implements UserExtDao {
    public UserExtDaoImpl() {
        super(UserExt.class, Integer.class);
    }
}
