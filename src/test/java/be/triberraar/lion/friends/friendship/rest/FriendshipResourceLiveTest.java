package be.triberraar.lion.friends.friendship.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.day.domain.api.DayRepository;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipChange;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipChangeRepository;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipService;

@RunWith(MockitoJUnitRunner.class)
public class FriendshipResourceLiveTest {

	private static final int CURRENT_DAY = 2;

	@InjectMocks
	private FriendshipResource friendshipResource;

	@Mock
	private FriendshipService friendshipService;
	@Mock
	private FriendshipChangeRepository friendshipChangeRepository;
	@Mock
	private DayRepository dayRepository;
	@Mock
	private FriendshipChange friendshipChange;
	@Mock
	private Animal subject, gainedFriend, lostFriend;

	@Before
	public void setUp() {
		when(dayRepository.getCurrentDay()).thenReturn(CURRENT_DAY);
		doReturn(new HashSet<>(Arrays.asList(friendshipChange))).when(friendshipChangeRepository).getByDay(CURRENT_DAY);
		when(friendshipChange.getSubject()).thenReturn(subject);
		when(friendshipChange.getGainedFriend()).thenReturn(Optional.of(gainedFriend));
		when(friendshipChange.getLostFriend()).thenReturn(Optional.of(lostFriend));
		when(gainedFriend.getName()).thenReturn("gained");
		when(subject.getName()).thenReturn("subject");
		when(lostFriend.getName()).thenReturn("lost");
	}

	@Test
	public void shouldLiveAndReturnFriendshipChanges() {
		Set<FriendshipChangeToJsonAdapter> result = friendshipResource.live();

		assertThat(result).hasSize(1);
		FriendshipChangeToJsonAdapter friendshipChangeToJsonAdapter = result.iterator().next();
		assertThat(friendshipChangeToJsonAdapter.getSubject()).isEqualTo("subject");
		assertThat(friendshipChangeToJsonAdapter.getGainedFriend()).isEqualTo("gained");
		assertThat(friendshipChangeToJsonAdapter.getLostFriend()).isEqualTo("lost");
	}

}
