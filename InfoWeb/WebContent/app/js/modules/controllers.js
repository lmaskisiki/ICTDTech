angular
		.module("InfoWeb.controllers", [])
		.controller("LizoCntrl", function(profileService) {
			alert(profileService("basic", "admin").isValid);
		})
		.controller(
				'loginCntrl',
				function($rootScope, $scope, $location, $http) {
					var self = this;

					var authenticate = function(credentials) {
						$scope.test = function() {
							alert("tested");
						}
						var headers = credentials ? {
							authorization : "Basic "
									+ btoa(credentials.username + ":"
											+ credentials.password)
						} : {};
						$http.post('http://localhost:8080/userGate/user', {
							headers : headers
						}).then(function(response) {
							alert(JSON.stringify(response));
							if (response.data) {

								$rootScope.authenticated = true;
							} else {

								$rootScope.authenticated = false;
							}

						}, function() {
							$rootScope.authenticated = false;

						});

					}
					self.credentials = {};
					self.credentials.username = "admins";
					self.credentials.password = "lizo@200903375";
					authenticate(self.credentials);
					self.login = function() {
						alert("mxm1");
						authenticate(self.credentials);
					}

				})
		.controller('accessCntrl', function($rootScope, $scope, $location) {

			$scope.user = {};
			$rootScope.authenticated = false;
			$scope.login = function() {
				if ($scope.user.username && $scope.user.password) {
					$rootScope.authenticated = true;
					$location.path("/search");
				}
			};

		})
		.controller(
				'haCntrl',
				function($rootScope, $scope, $http) {
					$scope.userId;
					$scope.statusinfo = {};
					$scope.statusCheck = {};
					$scope.statusCheck.hideForm = false;
					$scope.checkstatus = function() {
						$http(
								{
									Method : "GET",
									url : "http://localhost:8181/cxf/bcservice/application/status/"
											+ $scope.userId,
									headers : {
										'Accept' : 'application/json'
									}
								}).success(function(data) {
							showstatusdata(data);
						}).error(function(status) {
							$scope.statusinfo.message = status;
						});
					}
					$scope.applicationstatus = function() {
						$scope.statusCheck.showForm = !$scope.statusCheck.showForm;
						$scope.statusCheck.hideForm = $scope.statusCheck.hideForm ? false
								: true;
						console.log(" Changes :" + $scope.statusCheck.showForm);

					}
					showstatusdata = function(data) {
						if (data["org.apache.cxf.message.MessageContentsList"]) {
							if (data["org.apache.cxf.message.MessageContentsList"]["list"]) {
								if (data["org.apache.cxf.message.MessageContentsList"]["list"]["birthcertificate.ews.soap.CollectionStatus"]) {
									var datas = data["org.apache.cxf.message.MessageContentsList"]["list"]["birthcertificate.ews.soap.CollectionStatus"];
									$scope.statusinfo.message = datas["message"];
								}

							}
						}
					}

				})
		.controller(
				'martenityCntrl',
				function($rootScope, $scope, $http) {
					$scope.checkups = [];
					$scope.showcheckups = false;
					$scope.userId = ""
					$scope.showCheckList = false;
					$scope.loadCheckups = function() {
						$scope.checkups = [];
						$scope.showcheckups = $scope.userId.length > 5 ? true
								: false;
						$http(
								{
									Method : "GET",
									url : "http://localhost:8181/cxf/healthservice/checkups/"
											+ $scope.userId,
									headers : {
										'Accept' : 'application/json'
									}
								}).success(function(data) {
							loadWomanData(data);

						});
					};
					loadWomanData = function(data) {
						if (data["list"]) {
							if (data["list"]["birthtech.entities.Checkup"]) {
								var datas = data["list"]["birthtech.entities.Checkup"];
								for (var x = 0; x < datas.length; x++) {
									var checkup = {};
									checkup.id = datas[x]["checkupId"];
									checkup.date = datas[x]["date"];
									checkup.comments = datas[x]["comments"];
									$scope.checkups.push(checkup);

								}

							}
						}
					}
				}).controller('profileController',
				function($scope, $rootScope) {
					$scope.profile = $rootScope.profile;
					$scope.hasdocuments = $rootScope.hasdocuments;
					$scope.profile.documents = [];
					$scope.showprofile = $rootScope.showprofile;
					alert($scope.profile.name);
					alert($scope.profile.documents);

				}).controller('homeController', function($scope) {
			$scope.message = "Welcome to Infosource Web";
			$scope.showappform = false;
			$scope.applyform = function() {
				$scope.showappform = $scope.showappform ? false : true;
			};

		}).controller(
				"searchCntrl",
				function($scope, $location, $rootScope, profileService) {
					$scope.modeOptions = [ "Select", "Basic", "Docs", "Full" ];
					$scope.pmode = $scope.modeOptions[0];
					$scope.showprofile = true;
					$scope.user = "";
					$scope.profile = {};
					$scope.searchuser = function() {
						$scope.profile = profileService.profile($scope.pmode
								.toLowerCase(), $scope.user.toLowerCase());
						//	alert(JSON.stringify($scope.profile["$state"]["value"]["personalDetails"]));

					}

				});