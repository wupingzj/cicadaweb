var phonecatServices = angular.module('phonecatServices', ['ngResource']);

phonecatServices.factory('Phone', ['$resource',
  function($resource){
    return $resource('phones/:phoneId.json', {}, {
      query: {method:'GET', params:{phoneId:'phones'}, isArray:true}
    });
  }]);



//********** services *******************
dashboardApp.factory( 'countryService', [ '$resource', function( $resource ){
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
 
