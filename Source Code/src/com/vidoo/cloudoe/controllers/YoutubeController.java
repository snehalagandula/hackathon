package com.vidoo.cloudoe.controllers;

import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.vidoo.cloudoe.models.User;

public class YoutubeController {

	
	@Path("/Search")
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
		
}
}
