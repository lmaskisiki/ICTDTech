var appService = angular.module("appService", []);
appService.factory("taskService", function() {
	var me = {};
	me.name = "lizo massiksiiki";
	return me;
});
appService.factory("profileService", function($http, $q) {
	var profile = {};
	profile.isValid = false;
	profile.hasDocs = false;
	return {
		profile : function(mode, uid, cb) {
			var url = 'http://192.168.43.12:8181/cxf/upservice/' + mode + '/'
					+ uid;
			$http.get(url).then(function(promise) {
				profile.data = promise.data;
				if (promise.data["personalDetails"]) {
					profile.isValid = true;
					if (promise.data["documents"]) {
						profile.hasDocs = true;
					}
					profile
				}
				cb();
			}, function() {
			});

			return profile;
		}
	}
});

appService
		.factory(
				"HomeAffairsApplicationService",
				function($http) {
					var baseUrl = "http://192.168.43.12:8181/cxf/bcservice/";
					var result = {};
					return {
						checkstatus : function(userId, cb) {
							$http
									.get(
											baseUrl + "application/status/"
													+ userId)
									.then(
											function(promise) {
												result = promise.data;
												if (promise.data) {
													var data = promise.data
													if (data["org.apache.cxf.message.MessageContentsList"]) {
														if (data["org.apache.cxf.message.MessageContentsList"]["list"]) {
															if (data["org.apache.cxf.message.MessageContentsList"]["list"]["birthcertificate.ews.soap.CollectionStatus"]) {
																var msg = data["org.apache.cxf.message.MessageContentsList"]["list"]["birthcertificate.ews.soap.CollectionStatus"];
																var temp = {}
																temp.id = msg["parentId"];
																temp.message = msg["message"];
																result = temp;
															}

														}
													}
												}
												cb(result);
											},
											function() {
												console
														.log("Oh oh! something is not right");
											});
							return result;
						}
					};

				});

appService
		.factory(
				"HomeAffairsNoticBoardService",
				function($http) {
					var baseUrl = "http://192.168.43.12:8181/cxf/bcservice/";
					var result = {};
					console.log("hello from the servie");

					return {
						notices : function(cb) {
							$http
									.get(baseUrl + "application/list")
									.then(
											function(promise) {
												var data = promise.data;
												if (data["org.apache.cxf.message.MessageContentsList"]) {
													if (data["org.apache.cxf.message.MessageContentsList"]["list"]["list"]) {
														data = data["org.apache.cxf.message.MessageContentsList"]["list"]["list"];
														result = data["birthcertificate.ews.soap.CollectionStatus"];
														cb(result);
													}
												} else {
													console
															.log("unexpected result returned"
																	+ JSON
																			.stringify(promise.data));
												}

											},
											function(error) {
												console
														.log("Oh Noo!! something is not right");
											});

							return result;
						}
					};

				});

appService.factory("UserDetialsService", function($rootScope, $http) {
	$rootScope.user = {};
	$rootScope.authenticated = false;
	return {
		getUser : function() {
			return $rootScope.user;
		},
		create : function(account) {
			alert("servce called");
			$http({
				url:"http://192.168.43.12:8181/cxf/upservice/createaccount",
				method: "POST",
				headers:{
					"Conent-Type":"application/json"
				},
				data:account

			});
			return {};
		}
	};

});
appService.factory("AuthService", function($rootScope, $http,
		UserDetialsService) {
	var self = this;
	self.user = {};
	self.authorities = [];
	self.credentials = {};
	return {
		login : function(username, password, cb) {
			var headers = self.credentials ? {
				authorization : "Basic " + btoa(username + ":" + password)
			} : {};
			$http.get('http://192.168.43.12:8080/userGate/user', {
				headers : headers
			}).then(function(response) {
				console.log(JSON.stringify(response));
				if (response.data) {
					self.user = response.data["principal"];
					$rootScope.user = self.user;
					self.authorities = response.data["authorities"];
					$rootScope.authenticated = true;
					cb(self.user);
				}
			}, function() {
				console.log("noooo");
				$rootScope.authenticated = false;

			});
			return self.user;
		},
		logout : function() {

		},
		isAdmin : function() {
			var isadmin = false;
			if (self.user) {
				if (self.authorities.indexOf("ROLE_Admin") !== 1) {
					isadmin = true;
				}
			}
			return isadmin;
		}

	};

});
