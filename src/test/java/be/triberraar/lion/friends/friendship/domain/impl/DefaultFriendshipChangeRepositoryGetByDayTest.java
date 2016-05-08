package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFriendshipChangeRepositoryGetByDayTest {
	private DefaultFriendshipChangeRepository defaultFriendshipChangeRepository = new DefaultFriendshipChangeRepository();
	@Mock
	private DefaultFriendshipChange friendshipChange1, friendshipChange2;

	@Test
	public void returnsFriendshipChangeForDay() {
		defaultFriendshipChangeRepository.addFriendshipChange(1, friendshipChange1);
		defaultFriendshipChangeRepository.addFriendshipChange(2, friendshipChange2);

		Set<DefaultFriendshipChange> result = defaultFriendshipChangeRepository.getByDay(1);

		assertThat(result).hasSize(1).contains(friendshipChange1);
	}
}
