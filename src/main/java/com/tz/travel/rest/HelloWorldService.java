package com.tz.travel.rest;
 
import com.tz.travel.dao.jpa.Interface.UserInfoDao;
import com.tz.travel.dao.jpa.impl.UserInfoDaoImpl;
import com.tz.travel.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/hello")
@Component
@Configurable
public class HelloWorldService {
    @Autowired
    private UserInfoDao userInfoDao;

    @GET
	@Path("/{id}")
	public Response getMsg(@PathParam("id") Integer id) {
        UserInfo userInfo = userInfoDao.find(id);
 
		return Response.status(200).entity(userInfo.getUserName()).build();
 
	}

 
}