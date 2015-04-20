package com.vidoo.cloudoe.controllers;

import java.net.UnknownHostException;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vidoo.cloudoe.models.User;

import org.json.*;

@Path("/user")
public class UserController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public Response getAll() throws JSONException, UnknownHostException
	{	
		JSONObject object = new JSONObject();
		object.put("results", User.all());
		
		return Response.ok(object.toString()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response postCreate() throws JSONException, UnknownHostException
	{
	
		User user = new User("1", "Pradyumna", "12345");
		
		JSONObject object = new JSONObject();
		object.put("message", User.insert(user).toString());
		
		return Response.ok(object.toString()).build();
	}
}
