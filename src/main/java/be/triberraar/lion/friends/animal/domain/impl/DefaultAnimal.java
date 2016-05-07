package be.triberraar.lion.friends.animal.domain.impl;

import java.util.HashSet;
import java.util.Set;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.animal.domain.api.AnimalType;

public class DefaultAnimal implements Animal {

	private String name;
	private AnimalType animalType;
	private String favoriteFood;
	private Set<String> metaData;

	public DefaultAnimal(String name, AnimalType animalType, String favoriteFood) {
		this.name = name;
		this.animalType = animalType;
		this.favoriteFood = favoriteFood;
		this.metaData = new HashSet<>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public AnimalType getAnimalType() {
		return animalType;
	}

	@Override
	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void addMetaData(String metaData) {
		this.metaData.add(metaData);
	}

	public Set<String> getMetaData() {
		return metaData;
	}
}
