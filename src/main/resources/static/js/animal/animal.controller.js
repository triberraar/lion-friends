'use strict';

angular.module('animal.controller', ['animal.repository', 'friend.repository'])
    .controller('AnimalController', function (AnimalRepository, FriendRepository) {
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
            var friends = FriendRepository.getFriend(animal);
            if(friends) {
                return friends.join(', ');
            }

        };

        init();


    });