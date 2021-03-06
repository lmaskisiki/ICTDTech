'use strict';

var app = angular.module("InfoWeb", [ "ngRoute", "InfoWeb.controllers",
		"appService" ]);
app.config(function($routeProvider, $locationProvider) {
	$routeProvider.when("/woman", {
		templateUrl : "app/pages/woman.html"
	}).when("/homeaffairs", {
		templateUrl : "app/pages/homeaffairs.html",
		controller : "LizoCntrl"
	}).when("/homeaffairs/status", {
		templateUrl : "app/pages/homeaffairs.html",
		controller : "haCntrl"
	}).when("/homeaffairs/applicationlist", {
		templateUrl : "app/pages/homeaffairs.html",
		controller : "haCntrl"
	}).when("/search", {
		templateUrl : "app/pages/basic.html"
	}).when("/showprofile", {
		templateUrl : "app/pages/showprofile.html",
		controller : "profileController"
	}).when("/usergate", {
		templateUrl : "app/pages/usergate.html",
		controller : "usergateCntrl"
	}).when("/login", {
		templateUrl : "http://localhost:8080/userGate/spring_security_login",
		controller : "accessCntrl"
	});
});
