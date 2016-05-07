package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;

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
	private DefaultFriendship friendship1, friendship2;

	@Test
	public void constructsCorrectly() {
		DefaultFriendshipChange result = new DefaultFriendshipChange(animal, new HashSet<>(Arrays.asList(friendship1)), new HashSet<>(Arrays.asList(friendship2)));

		assertThat(result.getSubject()).isEqualTo(animal);
		assertThat(result.getLostFriends()).isEqualTo(new HashSet<>(Arrays.asList(friendship1)));
		assertThat(result.getGainedFriends()).isEqualTo(new HashSet<>(Arrays.asList(friendship2)));
	}
}
