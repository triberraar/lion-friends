package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFriendshipEqualsTest {

	@Mock
	private Animal animal1, animal2, animal3;

	@Test
	public void equalWhenFriendsAreEqual() {
		DefaultFriendship defaultFriendship1 = new DefaultFriendship(animal1, animal2, 2);
		DefaultFriendship defaultFriendship2 = new DefaultFriendship(animal1, animal2, 3);

		assertThat(defaultFriendship1).isEqualTo(defaultFriendship2);

		defaultFriendship2 = new DefaultFriendship(animal2, animal1, 4);

		assertThat(defaultFriendship1).isEqualTo(defaultFriendship2);

	}

	@Test
	public void notEqualWhenFriend1Different() {
		DefaultFriendship defaultFriendship1 = new DefaultFriendship(animal1, animal2, 2);
		DefaultFriendship defaultFriendship2 = new DefaultFriendship(animal3, animal2, 3);

		assertThat(defaultFriendship1).isNotEqualTo(defaultFriendship2);
	}

	@Test
	public void notEqualWhenFriend2Different() {
		DefaultFriendship defaultFriendship1 = new DefaultFriendship(animal1, animal2, 2);
		DefaultFriendship defaultFriendship2 = new DefaultFriendship(animal1, animal3, 3);

		assertThat(defaultFriendship1).isNotEqualTo(defaultFriendship2);
	}
}
