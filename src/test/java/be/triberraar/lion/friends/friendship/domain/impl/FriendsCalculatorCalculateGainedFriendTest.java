package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.animal.domain.api.AnimalRepository;

@RunWith(MockitoJUnitRunner.class)
public class FriendsCalculatorCalculateGainedFriendTest {

	@InjectMocks
	private FriendsCalculator friendsCalculator;
	@Mock
	private Animal animal, currentFriend, newFriend;
	@Mock
	private AnimalRepository animalRepository;
	@Mock
	private DefaultFriendshipRepository defaultFriendshipRepository;
	private DefaultFriendship currentFriendship;

	@Before
	public void setUp() {
		currentFriendship = new DefaultFriendship(animal, currentFriend);
		doReturn(new HashSet<>(Arrays.asList(animal, currentFriend, newFriend))).when(animalRepository).all();
		doReturn(new HashSet<>(Arrays.asList(currentFriendship))).when(defaultFriendshipRepository).getFriendsOf(animal);
	}

	@Test
	public void returnsEmptyWhenAlreadyFriendOfAllAnimals() {
		doReturn(new HashSet<>(Arrays.asList(animal, currentFriend))).when(animalRepository).all();

		Optional<Animal> gainedFriend = friendsCalculator.calculateGainedFriend(animal);

		assertThat(gainedFriend).isEmpty();
	}

	@Test
	public void returnsNewFriendIfNotFriendOfAllAnimals() {
		doReturn(new HashSet<>(Arrays.asList(animal, currentFriend, newFriend))).when(animalRepository).all();

		Optional<Animal> gainedFriend = friendsCalculator.calculateGainedFriend(animal);

		assertThat(gainedFriend).isPresent().hasValue(newFriend);

	}
}
