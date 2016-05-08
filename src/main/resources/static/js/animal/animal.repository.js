'use strict';


angular.module('animal.repository', [])
    .factory('AnimalRepository', function($http, $log) {
        var AnimalRepository = {};
        AnimalRepository.animals = [];
        AnimalRepository.all = function() {
            return $http.get('/animal').then(function(response) {
                AnimalRepository.animals = response.data;
            }, function() {
                $log.error('Could not get animals');
            });
        };

        return AnimalRepository;
    });