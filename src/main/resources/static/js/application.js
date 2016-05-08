'use strict';

var dependencies = [
    'ui.router',
    'ngMessages',
    'ngResource',
    'ngAnimate',
    'animal.component',
    'friendship.component'];

angular.module('lion-friends', dependencies)
    .config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/animals');
        $stateProvider.state('animal', {
            url: '/friends',
            template: '<friendship></friendship><animals></animals>'
        });

    });
