package be.triberraar.lion.friends.friendship.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.animal.domain.api.AnimalRepository;
import be.triberraar.lion.friends.animal.rest.AnimalToJsonAdapter;
import be.triberraar.lion.friends.friendship.domain.api.Friendship;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipRepository;

@RunWith(MockitoJUnitRunner.class)
public class FriendResourceGetFriendsTest {

	private static final String NAME = "name";
	private static final String FRIEND2 = "friend2";
	private static final String FRIEND1 = "friend1";
	@InjectMocks
	private FriendResource friendResource;
	@Mock
	private FriendshipRepository friendshipRepository;
	@Mock
	private AnimalRepository animalRepository;
	@Mock
	private Animal animal, friend1, friend2;
	@Mock
	private Friendship friendship1, friendship2;

	@Before
	public void setUp() {
		when(animalRepository.getByName(NAME)).thenReturn(animal);
		doReturn(new HashSet<>(Arrays.asList(friendship1, friendship2))).when(friendshipRepository).getFriendsOf(animal);
		when(friendship1.getFriendOf(animal)).thenReturn(friend1);
		when(friendship2.getFriendOf(animal)).thenReturn(friend2);
		when(friend1.getName()).thenReturn(FRIEND1);
		when(friend2.getName()).thenReturn(FRIEND2);
	}

	@Test
	public void returnsAllFriendsOfAnimal() {
		Set<AnimalToJsonAdapter> result = friendResource.getFriends(NAME);

		assertThat(result).hasSize(2);
		assertThat(assertcontians(result, FRIEND1)).isTrue();
		assertThat(assertcontians(result, FRIEND2)).isTrue();
	}

	private boolean assertcontians(Set<AnimalToJsonAdapter> adapters, String name) {
		for (AnimalToJsonAdapter adapter : adapters) {
			if (adapter.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
