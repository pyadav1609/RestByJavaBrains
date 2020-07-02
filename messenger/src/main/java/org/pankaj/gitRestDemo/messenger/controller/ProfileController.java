package org.pankaj.gitRestDemo.messenger.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.pankaj.gitRestDemo.messenger.model.Profile;
import org.pankaj.gitRestDemo.messenger.service.MessageService;
import org.pankaj.gitRestDemo.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileController {

	ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles() {
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profile-name}")
	public Profile getProfileByName(@PathParam("profile-name") String profileName) {
		return profileService.getProfileByName(profileName);
	}
	
	@POST
	public Profile addNewProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profile-name}")
	public Profile updateMessage(Profile profile,@PathParam("profile-name") String firstName) {
		profile.setFirstName(firstName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profile-name}")
	public Profile deleteMessage(@PathParam("profile-name") String firstName) {
		return profileService.deleteProfile(firstName);
	}
}
