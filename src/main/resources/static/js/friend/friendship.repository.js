'use strict';


angular.module('friendship.repository', ['animal.repository', 'friend.repository'])
    .factory('FriendshipRepository', function($http, $log, AnimalRepository, FriendRepository) {
        var FriendshipRepository = {};
        FriendshipRepository.changes = [];
        FriendshipRepository.live = function() {
            return $http.put('/friendship/live').then(function(response) {
                FriendshipRepository.changes = response.data;
                angular.forEach(AnimalRepository.animals, function(animal) {
                    FriendRepository.queryFriend(animal);
                });
            }, function() {
                $log.error('Could not get animals');
            });
        };

        return FriendshipRepository;
    });