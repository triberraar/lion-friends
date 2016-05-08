package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;

@RunWith(MockitoJUnitRunner.class)
public class FriendsCalculatorCalculateLostFriendTest {

	@InjectMocks
	private FriendsCalculator friendsCalculator;
	@Mock
	private Animal animal, yesterdaysFriend;
	@Mock
	private DefaultFriendshipRepository defaultFriendshipRepository;
	private DefaultFriendship yesterdaysFriendship;

	@Test
	public void returnsEmptyWhenFriendless() {
		doReturn(new HashSet<>()).when(defaultFriendshipRepository).getFriendsFromBeforeToday(animal);

		Optional<Animal> lostFriend = friendsCalculator.calculateLostFriend(animal);

		assertThat(lostFriend).isEmpty();
	}

	@Test
	public void returnsFriendWhenNotFriendless() {
		yesterdaysFriendship = new DefaultFriendship(animal, yesterdaysFriend, 2);
		doReturn(new HashSet<>(Arrays.asList(yesterdaysFriendship))).when(defaultFriendshipRepository).getFriendsFromBeforeToday(animal);

		Optional<Animal> lostFriend = friendsCalculator.calculateLostFriend(animal);

		assertThat(lostFriend).isPresent().hasValue(yesterdaysFriend);
	}
}
