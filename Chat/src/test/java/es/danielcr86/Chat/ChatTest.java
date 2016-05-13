package es.danielcr86.Chat;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit test for simple App.
 */
public class ChatTest {
	
	@Test
	public void  givenChat_whenUserJoins_thenOtherUsersAreNotified() throws NotEnoughResourcesException {
		User user1 = mock(User.class);
		User user2 = mock(User.class);
		MediaServer server = mock(MediaServer.class);
		when(server.hasCapacity()).thenReturn(true);
		
		when(user2.getName()).thenReturn("Dani");
		
		Chat chat = new Chat("ChatRoom", server);
		chat.addUser(user1);
		chat.addUser(user2);
		
		verify(user1).userJoined("ChatRoom", "Dani");
	}
	
	@Test
	public void givenChat_whenUserLeaves_thenOtherUsersAreNotified() throws NotEnoughResourcesException {
		User user1 = mock(User.class);
		User user2 = mock(User.class);
		MediaServer server = mock(MediaServer.class);
		when(server.hasCapacity()).thenReturn(true);
		
		when(user1.getName()).thenReturn("Dani");
		when(user2.getName()).thenReturn("Sara");
		
		Chat chat = new Chat("ChatRoom", server);
		chat.addUser(user1);
		chat.addUser(user2);
		
		chat.removeUser(user1);
		
		verify(user2).userLeftChat("ChatRoom", "Dani");
	}
	
	@Test
	public void givenChat_whenUserJoinsAndMediaServerHasNoCapacity_thenExceptionIsThrown () {
		MediaServer server = mock(MediaServer.class);
		final User user = mock(User.class);
		
		when(server.hasCapacity()).thenReturn(false);
		
		final Chat chat = new Chat("ChatRoom", server);
		
		assertThatThrownBy(()->{chat.addUser(user);})
			.isInstanceOf(NotEnoughResourcesException.class);
	}
	
	@Test
	public void givenChat_whenUserJoinsAndMediaServerHasCapacity_thenUserIsAddedToMediaServer() throws NotEnoughResourcesException {
		MediaServer server = mock(MediaServer.class);
		User user = mock(User.class);
		
		when(server.hasCapacity()).thenReturn(true);
		
		Chat chat = new Chat("ChatRoom", server);
		chat.addUser(user);
		
		verify(server).hasCapacity();
	}

}
