package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.Optional;

import javax.inject.Named;

import be.triberraar.lion.friends.animal.domain.api.Animal;

@Named
public class DefaultFriendshipChangeFactory {

	public DefaultFriendshipChange create(Animal subject, Optional<Animal> lostFriend, Optional<Animal> gainedFriend) {
		return new DefaultFriendshipChange(subject, lostFriend, gainedFriend);
	}
}
