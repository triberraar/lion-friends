package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.Optional;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipChange;

public class DefaultFriendshipChange implements FriendshipChange {

	private Animal subject;
	private Optional<Animal> lostFriend;
	private Optional<Animal> gainedFriend;

	public DefaultFriendshipChange(Animal subject, Optional<Animal> lostFriend, Optional<Animal> gainedFriend) {
		this.subject = subject;
		this.lostFriend = lostFriend;
		this.gainedFriend = gainedFriend;
	}

	@Override
	public Animal getSubject() {
		return subject;
	}

	@Override
	public Optional<Animal> getLostFriend() {
		return lostFriend;
	}

	@Override
	public Optional<Animal> getGainedFriend() {
		return gainedFriend;
	}
}
