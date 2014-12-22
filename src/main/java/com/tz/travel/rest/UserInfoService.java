package com.tz.travel.rest;

import com.tz.travel.dao.jpa.Interface.UserInfoDao;
import com.tz.travel.kernel.model.entity.UserEntity;
import com.tz.travel.model.UserInfo;
import com.tz.travel.service.TransferInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

import com.tz.travel.kernel.model.rest.request.InfoRequest;

/**
 * Created by tzjeefjalft on 12/15/2014.
 */
@Path("/userInfo")
@Component
@Configurable
public class UserInfoService {
    private static Logger LOGGER = LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private TransferInfo transferInfo;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@QueryParam("id") Integer id){
        try {
            return Response.ok().entity(userInfoDao.find(id)).build();
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

//    @POST
//    @Path("/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response createUser(InfoRequest<UserEntity> infoRequest){
//        try {
//            UserInfo userInfo = transferInfo.UserInfoRequestToUserInfo(infoRequest);
//            userInfoDao.create(userInfo);
//            return Response.ok().entity(null).build();
//        } catch (Exception e){
//            LOGGER.error(e.getMessage(), e);
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
//        }
//    }

}
