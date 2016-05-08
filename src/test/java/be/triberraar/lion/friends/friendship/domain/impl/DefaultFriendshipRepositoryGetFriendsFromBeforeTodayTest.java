package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.day.domain.api.DayRepository;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFriendshipRepositoryGetFriendsFromBeforeTodayTest {

	private static final int CURRENT_DAY = 3;
	@Mock
	private Animal animal1, animal2, animal3, animal4;
	@Mock
	private DayRepository dayRepository;

	@InjectMocks
	private DefaultFriendshipRepository defaultFriendshipRepository;

	@Test
	public void retunrsFriendOfAnimalEstablishedBeforeToday() {
		when(dayRepository.getCurrentDay()).thenReturn(CURRENT_DAY);
		defaultFriendshipRepository.addFriendship(new DefaultFriendship(animal1, animal2, 1));
		defaultFriendshipRepository.addFriendship(new DefaultFriendship(animal3, animal1, 2));
		defaultFriendshipRepository.addFriendship(new DefaultFriendship(animal2, animal3, 1));
		defaultFriendshipRepository.addFriendship(new DefaultFriendship(animal2, animal4, 3));

		assertThat(defaultFriendshipRepository.getFriendsFromBeforeToday(animal1)).hasSize(2);
		assertThat(defaultFriendshipRepository.getFriendsFromBeforeToday(animal1)).contains(new DefaultFriendship(animal1, animal2, 1), new DefaultFriendship(animal3, animal1, 2));
	}

}
