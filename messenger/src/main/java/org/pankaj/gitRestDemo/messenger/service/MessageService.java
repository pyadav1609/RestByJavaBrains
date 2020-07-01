package org.pankaj.gitRestDemo.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.pankaj.gitRestDemo.messenger.database.DatabaseClass;
import org.pankaj.gitRestDemo.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "hello world!", "Pankaj"));
		messages.put(2L, new Message(2, "hello Jersey", "Pankaj"));
	}
	
	public List<Message> getAllMessagesDemo(){
		Message m1= new Message(1L, "Hello Pankaj!", "Pankaj");
		Message m2= new Message(2L, "Hello World!", "Pankaj");
		
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	} 
	
	public Message getMessageById(long id){
		return messages.get(id);
	} 
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return null;
	} 
	
	public Message updateMessage(Message message){
		if(message.getId()<=0) {
			return null;
		}
		return messages.put(message.getId(), message);
	}
	
	public Message deleteMessage(long id){
		return messages.remove(id);
	}
	
}
