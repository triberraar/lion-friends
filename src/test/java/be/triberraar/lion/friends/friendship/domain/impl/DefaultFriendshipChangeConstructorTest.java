package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFriendshipChangeConstructorTest {

	@Mock
	private Animal animal;
	@Mock
	private Animal animal1, animal2;

	@Test
	public void constructsCorrectly() {
		DefaultFriendshipChange result = new DefaultFriendshipChange(animal, Optional.of(animal1), Optional.of(animal2));

		assertThat(result.getSubject()).isEqualTo(animal);
		assertThat(result.getLostFriend()).isEqualTo(Optional.of(animal1));
		assertThat(result.getGainedFriend()).isEqualTo(Optional.of(animal2));
	}
}
