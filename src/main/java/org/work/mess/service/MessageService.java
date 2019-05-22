package org.work.mess.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.work.mess.model.Message;

import org.work.mess.database.DatabaseClass;

public class MessageService {
	
private static Map<Long, Message> messages = DatabaseClass.getMessages();
	
	static{
		messages.put(1L, new Message(1L,"message1","saket",new Date()));
		messages.put(2L, new Message(2L,"message2","krunal",new Date()));
		messages.put(3L, new Message(3L,"message3","amit",new Date()));
		messages.put(4L, new Message(4L,"message4","asha",new Date()));
	}

	public MessageService() {
		/*messages.put(1L, new Message(1L,"message1","saket",new Date()));
		messages.put(2L, new Message(2L,"message1","krunal",new Date()));*/
	}
	public List<Message> getAllMessages() {
		/*Message m1 = new Message(1,"message1","saket",new Date());
		Message m2 = new Message(2,"message2","krunal",new Date());
		List<Message> lst = new ArrayList<>();
		lst.add(m1);
		lst.add(m2);
		
		return lst;*/
		
		return new ArrayList<>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreationDate());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public Message getMessage(long id) {
	
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		System.out.println(message.getMessage());
		if(message.getId() <= 0)
			return null;
		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
