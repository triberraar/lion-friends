package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFriendshipChangeRepositoryAddFriendshipChangeTest {

	private DefaultFriendshipChangeRepository defaultFriendshipChangeRepository = new DefaultFriendshipChangeRepository();
	@Mock
	private DefaultFriendshipChange friendshipChange1, friendshipChange2;

	@Test
	public void addsFriendshipChangeWhenAFriendshipChangeAlreadyExistsForDay() {
		defaultFriendshipChangeRepository.addFriendshipChange(1, friendshipChange1);
		defaultFriendshipChangeRepository.addFriendshipChange(1, friendshipChange2);

		Set<DefaultFriendshipChange> friendshipChanges = defaultFriendshipChangeRepository.getFriendshipChanges().get(1);
		assertThat(friendshipChanges).hasSize(2).contains(friendshipChange1, friendshipChange2);

	}

	@Test
	public void addsFriendshipChangeWhenNoFriendshipChangeAlreadyExistsForDay() {
		defaultFriendshipChangeRepository.addFriendshipChange(1, friendshipChange1);

		Set<DefaultFriendshipChange> friendshipChanges = defaultFriendshipChangeRepository.getFriendshipChanges().get(1);
		assertThat(friendshipChanges).hasSize(1).contains(friendshipChange1);
	}
}
