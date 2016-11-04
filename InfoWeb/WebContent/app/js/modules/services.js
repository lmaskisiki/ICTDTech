var appService = angular.module("appService", []);
appService.factory("taskService", function() {
	var me = {};
	me.name = "lizo massiksiiki";
	return me;
});
appService.factory("profileService",
		function($http, $q) {
			var profile = {};
			var deferred = $q.defer();
			profile.isValid = false;
			profile.hasDocs = false;
			return {
				profile : function(mode, uid) {

					var url = 'http://localhost:8181/cxf/upservice/' + mode
							+ '/' + uid;
					$http.get(url).success(function(data) {
						console.log("\n "+JSON.stringify(data["personalDetails"]));
						deferred.resolve(data);

					});
					console.log("\n promise :"+JSON.stringify(deferred.promise));

					return deferred.promise;
				}
			}
		});
