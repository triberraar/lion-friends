package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.Optional;

import be.triberraar.lion.friends.animal.domain.api.Animal;

public class DefaultFriendshipChangeFactory {

	public DefaultFriendshipChange create(Animal subject, Optional<Animal> lostFriend, Optional<Animal> gainedFriend) {
		return new DefaultFriendshipChange(subject, lostFriend, gainedFriend);
	}
}
