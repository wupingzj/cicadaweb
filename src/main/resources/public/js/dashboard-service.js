'use strict';
// var phonecatServices = angular.module('phonecatServices', ['ngResource']);
//
// phonecatServices.factory('Phone', ['$resource',
// function($resource){
// return $resource('phones/:phoneId.json', {}, {
// query: {method:'GET', params:{phoneId:'phones'}, isArray:true}
// });
// }]);

// ********** services *******************
var dashboardServiceModule = angular.module('dashboardServiceModule',
		[ 'ngResource' ]);

dashboardServiceModule.factory('countryService', [ '$resource',
		function countryServiceFactory($resource) {
			return new Country($resource);
		} ]);

function Country(resource) {
	this.resource = resource;

	this.createCountry = function(country, scope) {
		// 
		// Save Action Method
		//
		var Country = resource('/countries/new');
		Country.save(country, function(response) {
			scope.message = response.message;
		});
	}

	this.getCountry = function(id, scope) {
		//
		// GET Action Method
		//
		var Country = resource('/countries/:countryId', {
			countryId : '@countryId'
		});
		Country.get({
			countryId : id
		}, function(country) {
			scope.country = country;
		})
	}

	// Both the following two methods work 
	this.getCountries = function(scope) {
		//
		// Query Action Method
		//
		// var Countries = resource('/countries/all');
		//var Countries = resource('testdata/countries.json');
		var Countries = resource('country/list');
		Countries.query(function(countries) {
			scope.countries = countries;
		});
	}

	this.getCountriesV2 = function() {
		//var Countries = resource('testdata/countries.json', {}, {
		var Countries = resource('country/list', {}, {
						// query: {method:'GET', params:{phoneId:'phones'}, isArray:true}
						   query : { method : 'GET', params : {}, isArray : true}
						});

		return Countries.query();
	}
}
