package be.triberraar.lion.friends.animal.domain.impl;

import javax.inject.Named;

import be.triberraar.lion.friends.animal.domain.api.AnimalType;

@Named
public class DefaultAnimalFactory {

	public DefaultAnimal create(String name, AnimalType animalType, String favoriteFood, String... metaData) {
		DefaultAnimal animal = new DefaultAnimal(name, animalType, favoriteFood);
		for (String data : metaData) {
			animal.addMetaData(data);
		}
		return animal;
	}
}
