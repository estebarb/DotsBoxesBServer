'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', ['myApp.filters', 'myApp.services', 'myApp.directives', 'myApp.controllers']).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/home', {templateUrl: 'app/partials/home.html', controller: 'AppController'});
    $routeProvider.when('/newgame', {templateUrl: 'app/partials/newgame.html', controller: 'AppController'});
    $routeProvider.otherwise({redirectTo: '/view1'});
  }]);
