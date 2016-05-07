package be.triberraar.lion.friends.animal.exception;

import be.triberraar.lion.friends.exception.NotFoundException;

public class AnimalNotFoundException extends NotFoundException {

	private String name;

	public AnimalNotFoundException(String name) {
		this.name = name;
	}

	@Override
	public String getMessage() {
		return "Animal '" + name + "' not found";
	}

}
