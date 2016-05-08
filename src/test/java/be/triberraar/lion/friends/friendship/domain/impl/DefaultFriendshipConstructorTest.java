package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFriendshipConstructorTest {

	private static final int ESTABLISHED = 2;
	@Mock
	private Animal animal1, animal2;

	@Test
	public void constructsCorrectly() {
		DefaultFriendship result = new DefaultFriendship(animal1, animal2, ESTABLISHED);

		assertThat(result.getFriend1()).isEqualTo(animal1);
		assertThat(result.getFriend2()).isEqualTo(animal2);
		assertThat(result.getEstablished()).isEqualTo(ESTABLISHED);
	}
}
