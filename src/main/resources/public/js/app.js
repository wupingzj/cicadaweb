
cicadaApp = angular.module("cicadaApp", ["ngRoute", "ngResource"]);
//var cicada = cicada || {};
//cicada.app = cicadaApp
 
cicadaApp.config(function ($routeProvider) {
    $routeProvider
        .when("/request/publish", {
        	controller: "/requestPublishController",
        	templateUrl: "/request/publish",
        })
        .when("/request/followup", {
        	controller: "requestFollowUpController",
        	templateUrl: "request/followup"
        })
        .when("/request/test", {
        	controller: "requestTestController",
        	templateUrl: "/request/cicada.html"
        })
        .when("/dashboard", {
        	controller: "dashboardController",
        	templateUrl: "/dashboard/dashboard.html"
        })
        .otherwise({
        	controller: "requestTestController",
            templateUrl: "home/notfound"
        });
    
    // .otherwise({redirectTo: '/'})
    
    // Route tutorial: https://www.youtube.com/watch?v=ziUelciLL5Q
});


//********** services *******************
cicadaApp.factory( 'countryService', [ '$resource', function( $resource ){
	return new Country( $resource );
}] );
 
function Country( resource ) {
	this.resource = resource; 
 
	this.createCountry = function ( country, scope ) {
		// 
		// Save Action Method
		//
		var Country = resource('/countries/new');		
		Country.save(country, function(response){
			scope.message = response.message;
		});		
	}
 
	this.getCountry = function ( id, scope ) {
		//
		// GET Action Method
		//
		var Country = resource('/countries/:countryId', {countryId:'@countryId'});
		Country.get( {countryId:id}, function(country){
			scope.country = country;
		})
	}
 
	this.getCountries = function( scope ) {
		//
		// Query Action Method
		//
		var Countries = resource('/countries/all');
		Countries.query(function(countries){
			scope.countries = countries;
		});
	}
}
 
//******************
//Controller when the main page/view loads
cicadaApp.controller("SpaCtrl", [ '$scope', function($scope) {			
} ]);
// Controller for All Countries View
cicadaApp.controller("dashboardController", [ '$scope','countryService', function($scope, countryService) {	
	alert('Dashboard controller called');
	//countryService.getCountries( $scope );		
} ]);
// Controller for New Country View
cicadaApp.controller("NewUserCtrl", [ '$scope','countryService', function($scope, countryService) {				
 
	countryService.getCountries( $scope );	
 
	$scope.createNewUser = function(){
		var newuser = { 'firstname':$scope.firstname, 'lastname': $scope.lastname, 'address':$scope.address, 'email':$scope.email };
		// Call UserService to create a new country
		//
		countryService.createCountry ( newuser, $scope );
 
		// Push new country to existing table column
		//
		$scope.countries.push( newuser );
		// Reset fields values
		//
		$scope.firstname='';
		$scope.lastname='';
		$scope.address='';
		$scope.email='';
	};		
} ]);
// Controller for Individual Country View
cicadaApp.controller("UsersByIdCtrl", [ '$scope','countryService', '$routeParams', function($scope, countryService, $routeParams) {	
	countryService.getCountry($routeParams.countryId, $scope);	
} ]);
