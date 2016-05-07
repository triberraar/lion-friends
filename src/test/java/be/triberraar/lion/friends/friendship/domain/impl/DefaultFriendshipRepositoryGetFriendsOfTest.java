package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFriendshipRepositoryGetFriendsOfTest {

	@Mock
	private Animal animal1, animal2, animal3;

	private DefaultFriendshipRepository defaultFriendshipRepository = new DefaultFriendshipRepository();

	@Test
	public void returnsAllFriendsOfPassedAnimal() {
		defaultFriendshipRepository.addFriendship(new DefaultFriendship(animal1, animal2));
		defaultFriendshipRepository.addFriendship(new DefaultFriendship(animal3, animal1));
		defaultFriendshipRepository.addFriendship(new DefaultFriendship(animal2, animal3));

		assertThat(defaultFriendshipRepository.getFriendsOf(animal1)).hasSize(2);
		assertThat(defaultFriendshipRepository.getFriendsOf(animal1)).contains(new DefaultFriendship(animal1, animal2), new DefaultFriendship(animal3, animal1));
	}

}
