package org.pankaj.gitRestDemo.messenger.resource;

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

import org.pankaj.gitRestDemo.messenger.model.Message;
import org.pankaj.gitRestDemo.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getAllMessages() {
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageID}")
	public Message getMessageById(@PathParam("messageID") long messageId) {
		return messageService.getMessageById(messageId);
	}
	
	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageID}")
	public Message updateMessage(Message message,@PathParam("messageID") long messageId) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageID}")
	public Message deleteMessage(@PathParam("messageID") long messageId) {
		return messageService.deleteMessage(messageId);
	}
}
