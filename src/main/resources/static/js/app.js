
cicadaApp = angular.module("cicadaApp", ["ngRoute", "ngResource"]);
//var cicada = cicada || {};
//cicada.app = cicadaApp
 
cicadaApp.config(function ($routeProvider) {
    $routeProvider
        .when("/request/publish", {
            templateUrl: "/request/publish",
            controller: "/requestPublishController"
        })
        .when("/request/followup", {
            templateUrl: "request/followup",
            controller: "requestFollowUpController"
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
