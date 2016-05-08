'use strict';

angular.module('animal.controller', ['animal.repository'])
    .controller('AnimalController', function (AnimalRepository) {
        var vm = this;

        var init = function () {
            AnimalRepository.all();
        };

        vm.animals = function() {
            return AnimalRepository.animals;
        };

        vm.getMetadata = function(animal) {
            if(animal && animal.metaData) {
                return animal.metaData.join(', ');
            }
        };

        vm.getFriends = function(animal) {
            return AnimalRepository.getFriends(animal);
        };

        init();


    });