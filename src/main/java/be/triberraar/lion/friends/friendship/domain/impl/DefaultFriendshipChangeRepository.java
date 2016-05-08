package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;

import be.triberraar.lion.friends.friendship.domain.api.FriendshipChangeRepository;
import be.triberraar.lion.friends.friendship.exception.DayNotFoundException;

@Named
public class DefaultFriendshipChangeRepository implements FriendshipChangeRepository {

	private Map<Integer, Set<DefaultFriendshipChange>> friendshipChanges = new HashMap<>();

	public void addFriendshipChange(Integer day, DefaultFriendshipChange friendshipChange) {
		if (!friendshipChanges.containsKey(day)) {
			friendshipChanges.put(day, new HashSet<>());
		}
		friendshipChanges.get(day).add(friendshipChange);
	}

	@Override
	public Set<DefaultFriendshipChange> getByDay(Integer day) {
		if (!friendshipChanges.containsKey(day)) {
			throw new DayNotFoundException(day);
		}
		return friendshipChanges.get(day);
	}

	Map<Integer, Set<DefaultFriendshipChange>> getFriendshipChanges() {
		return friendshipChanges;
	}
}
