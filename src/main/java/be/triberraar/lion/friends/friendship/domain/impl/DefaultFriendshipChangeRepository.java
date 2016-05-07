package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;

@Named
public class DefaultFriendshipChangeRepository {

	private Map<Integer, Set<DefaultFriendshipChange>> friendshipChanges = new HashMap<>();

	public void addFriendshipChange(Integer day, DefaultFriendshipChange friendshipChange) {
		if (!friendshipChanges.containsKey(day)) {
			friendshipChanges.put(day, new HashSet<>());
		}
		friendshipChanges.get(day).add(friendshipChange);
	}

	Map<Integer, Set<DefaultFriendshipChange>> getFriendshipChanges() {
		return friendshipChanges;
	}
}
