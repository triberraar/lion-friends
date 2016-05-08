package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.animal.domain.api.AnimalRepository;
import be.triberraar.lion.friends.day.domain.api.DayRepository;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFriendshipServiceLiveTest {

	private static final int CURRENT_DAY = 2;

	@InjectMocks
	private DefaultFriendshipService defaultFriendshipService;

	@Mock
	private AnimalRepository animalRepository;
	@Mock
	private FriendsCalculator friendsCalculator;
	@Mock
	private DefaultFriendshipChangeRepository defaultFriendshipChangeRepository;
	@Mock
	private DayRepository dayRepository;
	@Mock
	private DefaultFriendshipChangeFactory defaultFriendshipChangeFactory;
	@Mock
	private Animal animal1, animal2, gainedFriendAnimal1, lostFriendAnimal1;
	@Mock
	private DefaultFriendshipChange friendshipChange1, friendshipChange2;
	@Mock
	private DefaultFriendshipRepository defaultFriendshipRepository;
	@Captor
	private ArgumentCaptor<DefaultFriendship> gainedFriendshipCaptor, lostFriendshipCaptor;

	@Before
	public void setUp() {
		doReturn(new HashSet<>(Arrays.asList(animal1, animal2, animal2))).when(animalRepository).all();
		when(dayRepository.getCurrentDay()).thenReturn(CURRENT_DAY);
		when(friendsCalculator.calculateGainedFriend(animal1)).thenReturn(Optional.of(gainedFriendAnimal1));
		when(friendsCalculator.calculateLostFriend(animal1)).thenReturn(Optional.of(lostFriendAnimal1));
		when(friendsCalculator.calculateGainedFriend(animal2)).thenReturn(Optional.empty());
		when(friendsCalculator.calculateLostFriend(animal2)).thenReturn(Optional.empty());
		when(defaultFriendshipChangeFactory.create(animal1, Optional.of(lostFriendAnimal1), Optional.of(gainedFriendAnimal1))).thenReturn(friendshipChange1);
		when(defaultFriendshipChangeFactory.create(animal2, Optional.empty(), Optional.empty())).thenReturn(friendshipChange2);
	}

	@Test
	public void advancesWithADay() {
		defaultFriendshipService.live();

		verify(dayRepository).advance();
	}

	@Test
	public void calculatesGainedAndLostFriendForEachAnimalAndSavesChanges() {
		defaultFriendshipService.live();

		verify(defaultFriendshipChangeRepository).addFriendshipChange(CURRENT_DAY, friendshipChange1);
		verify(defaultFriendshipChangeRepository).addFriendshipChange(CURRENT_DAY, friendshipChange2);
		verify(defaultFriendshipRepository, times(1)).addFriendship(gainedFriendshipCaptor.capture());
		assertThat(gainedFriendshipCaptor.getValue().getFriend1()).isEqualTo(animal1);
		assertThat(gainedFriendshipCaptor.getValue().getFriend2()).isEqualTo(gainedFriendAnimal1);
		verify(defaultFriendshipRepository, times(1)).deleteFriendship(lostFriendshipCaptor.capture());
		assertThat(lostFriendshipCaptor.getValue().getFriend1()).isEqualTo(animal1);
		assertThat(lostFriendshipCaptor.getValue().getFriend2()).isEqualTo(lostFriendAnimal1);
	}
}
