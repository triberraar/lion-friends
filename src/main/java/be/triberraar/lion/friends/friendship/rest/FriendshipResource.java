package be.triberraar.lion.friends.friendship.rest;

import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.triberraar.lion.friends.day.domain.api.DayRepository;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipChange;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipChangeRepository;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipService;

@RestController
@RequestMapping("/friendship")
public class FriendshipResource {

	@Inject
	private FriendshipService friendshipService;
	@Inject
	private FriendshipChangeRepository friendshipChangeRepository;
	@Inject
	private DayRepository dayRepository;

	@RequestMapping(value = "/live", method = RequestMethod.PUT, produces = "application/json")
	public Set<FriendshipChangeToJsonAdapter> live() {
		friendshipService.live();
		Set<? extends FriendshipChange> friendshipChanges = friendshipChangeRepository.getByDay(dayRepository.getCurrentDay());
		return friendshipChanges.parallelStream().map(friendshipChange -> new FriendshipChangeToJsonAdapter(friendshipChange)).collect(Collectors.toSet());
	}
}
