package com.imagesrecognition.server.controller;

import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Yevgeniy_Vtulkin on 5/13/2016.
 */
@Path("/test")
@Produces("application/json")
@Controller
public class TestController {

    @GET
    @Path("/sayHello")
    public String sayHello() {
        return "hello";
    }

}
