package org.pankaj.gitRestDemo.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.pankaj.gitRestDemo.messenger.database.DatabaseClass;
import org.pankaj.gitRestDemo.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Pankaj", new Profile(1, "Pankaj", "Yadav"));
	}
	
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	} 
	
	public Profile getProfileByName(String name){
		return profiles.get(name);
	} 
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getFirstName(), profile);
		return null;
	} 
	
	public Profile updateProfile(Profile profile){
		if(profile.getFirstName().isEmpty()) {
			return null;
		}
		return profiles.put(profile.getFirstName(), profile);
	}
	
	public Profile deleteProfile(String name){
		return profiles.remove(name);
	}
	
}
