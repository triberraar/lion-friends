package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.friendship.domain.exception.InvalidFriendException;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFriendshipGetFriendOfTest {

	@Mock
	private Animal friend1, friend2, friend3;

	@Test
	public void returnsFriend1IfNotAnimal() {
		DefaultFriendship defaultFriendship = new DefaultFriendship(friend1, friend2);

		assertThat(defaultFriendship.getFriendOf(friend2)).isEqualTo(friend1);
	}

	@Test
	public void returnsFriend2IfNotAnimal() {
		DefaultFriendship defaultFriendship = new DefaultFriendship(friend1, friend2);

		assertThat(defaultFriendship.getFriendOf(friend1)).isEqualTo(friend2);

	}

	@Test(expected = InvalidFriendException.class)
	public void failsWhenAnimalNotPartOfTheFriendship() {
		DefaultFriendship defaultFriendship = new DefaultFriendship(friend1, friend2);

		defaultFriendship.getFriendOf(friend3);
	}
}
