package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.Optional;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipChange;

public class DefaultFriendshipChange implements FriendshipChange {

	private Animal subject;
	private Optional<DefaultFriendship> lostFriend;
	private Optional<DefaultFriendship> gainedFriend;

	public DefaultFriendshipChange(Animal subject, Optional<DefaultFriendship> lostFriend, Optional<DefaultFriendship> gainedFriend) {
		this.subject = subject;
		this.lostFriend = lostFriend;
		this.gainedFriend = gainedFriend;
	}

	@Override
	public Animal getSubject() {
		return subject;
	}

	@Override
	public Optional<DefaultFriendship> getLostFriend() {
		return lostFriend;
	}

	@Override
	public Optional<DefaultFriendship> getGainedFriend() {
		return gainedFriend;
	}
}
