'use strict';


angular.module('animal.repository', ['friend.repository'])
    .factory('AnimalRepository', function($http, $log, FriendRepository) {
        var AnimalRepository = {};
        AnimalRepository.animals = [];
        AnimalRepository.all = function() {
            return $http.get('/animal').then(function(response) {
                AnimalRepository.animals = response.data;
                angular.forEach(AnimalRepository.animals, function(animal) {
                    FriendRepository.queryFriend(animal);
                });
            }, function() {
                $log.error('Could not get animals');
            });
        };

        return AnimalRepository;
    });