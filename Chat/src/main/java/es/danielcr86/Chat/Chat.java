package es.danielcr86.Chat;

import java.util.ArrayList;
import java.util.List;

public class Chat {
	
	private String roomName;
	private List<User> users;
	private MediaServer server;
	
	public Chat(String name, MediaServer server) {
		this.roomName = name;
		users = new ArrayList<User>();
		this.server = server;
	}

	public void addUser(User user1) throws NotEnoughResourcesException {
		if(!server.hasCapacity()) {
			throw new NotEnoughResourcesException();
		}
		for(User u : users) {
			u.userJoined(roomName, user1.getName());
		}
		users.add(user1);
	}

	public void removeUser(User user1) {
		users.remove(users.indexOf(user1));
		for(User u : users) {
			u.userLeftChat(roomName, user1.getName());
		}
	}

}
