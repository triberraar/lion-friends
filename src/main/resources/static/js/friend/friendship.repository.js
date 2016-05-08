'use strict';


angular.module('friendship.repository', ['animal.repository', 'friend.repository'])
    .factory('FriendshipRepository', function($q, $http, $log, AnimalRepository, FriendRepository) {
        var FriendshipRepository = {};
        FriendshipRepository.changes = [];
        FriendshipRepository.live = function() {
            var deferred = $q.defer();
            $http.put('/friendship/live').then(function(response) {
                FriendshipRepository.changes = response.data;
                var promises = [];
                angular.forEach(AnimalRepository.animals, function(animal) {
                    promises.push( FriendRepository.queryFriend(animal));
                });
                $q.all(promises).then(function() {
                    deferred.resolve();
                });
            }, function() {
                $log.error('Could not get animals');
            });
            return deferred.promise;
        };

        return FriendshipRepository;
    });