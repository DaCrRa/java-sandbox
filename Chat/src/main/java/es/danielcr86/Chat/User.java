package es.danielcr86.Chat;

public interface User {

	String getName();
	void userJoined(String chatRoom, String userName);
	void userLeftChat(String roomName, String name);
}
