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
        $urlRouterProvider.otherwise('/animal');
        $stateProvider.state('animal', {
            url: '/animal',
            template: '<friendship></friendship><animals></animals>'
        });

    });
