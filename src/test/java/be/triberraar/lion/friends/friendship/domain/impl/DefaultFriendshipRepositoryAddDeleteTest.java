package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFriendshipRepositoryAddDeleteTest {

	@Mock
	private Animal animal1, animal2;

	private DefaultFriendshipRepository defaultFriendshipRepository = new DefaultFriendshipRepository();

	@Test
	public void addsAndRemovesFriendship() {
		assertThat(defaultFriendshipRepository.getAll()).hasSize(0);

		defaultFriendshipRepository.addFriendship(new DefaultFriendship(animal1, animal2, 2));

		assertThat(defaultFriendshipRepository.getAll()).hasSize(1);
		assertThat(defaultFriendshipRepository.getAll()).contains(new DefaultFriendship(animal1, animal2, 3));

		defaultFriendshipRepository.deleteFriendship(new DefaultFriendship(animal1, animal2, 4));

		assertThat(defaultFriendshipRepository.getAll()).hasSize(0);
	}
}
