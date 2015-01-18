
cicadaApp = angular.module("cicadaApp", ["ngRoute", "ngResource"]);
//var cicada = cicada || {};
//cicada.app = cicadaApp
 
cicadaApp.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "client/list",
            controller: "clientListController"
        })
        .when("/client/list", {
            templateUrl: "client/list",
            controller: "clientListController"
        })
        .when("/client/create", {
            templateUrl: "client/create",
            controller: "clientCreateController"
        })
        .when("/client/edit/:id", {
            templateUrl: "client/edit",
            controller: "clientEditController"
        })
        .otherwise({
            templateUrl: "home/notfound"
        });
});
 
userApp.config(function($routeProvider) {
	$routeProvider.when('/users/new', {
		controller : 'NewUserCtrl',
		templateUrl : 'views/newuser.html'
	}).when('/users/:userId', {
		controller : 'UsersByIdCtrl',
		templateUrl : 'views/userbyid.html'	
	}).when('/users', {
		controller : 'UsersCtrl',
		templateUrl : 'views/users.html'	
	}).otherwise({
		controller : 'SpaCtrl',
		templateUrl: 'views/spahome.html'
    });
});

userApp.controller("UsersCtrl", [ '$scope','userservice', function($scope, userservice) {  
	userservice.getUsers( $scope );    
} ]);
