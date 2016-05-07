package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.HashSet;
import java.util.Set;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.friendship.domain.api.Friendship;

public class DefaultFriendshipRepository {

	private Set<Friendship> friendships = new HashSet<>();

	public Set<Friendship> getFriendOf(Animal animal) {
		Set<Friendship> result = new HashSet<>();
		for (Friendship friendship : friendships) {
			if (friendship.getFriend1().equals(animal) || friendship.getFriend2().equals(animal)) {
				result.add(friendship);
			}
		}
		return result;
	}

	public void addFriendship(Friendship friendship) {
		friendships.add(friendship);
	}

	public void deleteFriendship(Friendship friendship) {
		friendships.remove(friendship);
	}

	Set<Friendship> getAll() {
		return friendships;
	}

}
