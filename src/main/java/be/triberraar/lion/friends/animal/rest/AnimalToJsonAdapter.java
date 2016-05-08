package be.triberraar.lion.friends.animal.rest;

import java.util.Set;

import be.triberraar.lion.friends.animal.domain.api.Animal;

public class AnimalToJsonAdapter {

	private Animal animal;

	public AnimalToJsonAdapter(Animal animal) {
		this.animal = animal;
	}

	public String getName() {
		return animal.getName();
	}

	public String getType() {
		return animal.getAnimalType().getDescription();
	}

	public String getFavoriteFood() {
		return animal.getFavoriteFood();
	}

	public Set<String> getMetaData() {
		return animal.getMetaData();
	}
}