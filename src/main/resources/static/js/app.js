var tempModule = angular.module('testApp', ['ui.bootstrap']);

tempModule.controller('testController', function ($scope,$http) {

    var urlBase = "";
    $scope.items = [{}];
    $scope.toggle = false;
    var requestString = "";
    $http.defaults.headers.post["Content-Type"] = "application/json";
    $scope.resumeTable = false;
    $scope.resumeStat = false;

    $scope.searchStr = function searchStr() {

        $scope.objList = '';
        requestString = "";
        $scope.stat = '';
        $scope.resumeTable = false;
        $scope.resumeStat = false;
        $scope.toggle = false;

        angular.forEach($scope.items, function(item) {
            if (item.tex != undefined){
                requestString += item.tex + ";";
            }
        });

        $http.post(urlBase + '/index', {requestStr: requestString})
        .success(function (data, status, headers) {
                if (data.respEmList.length > 0) {
                    $scope.objList = data.respEmList;
                    $scope.resumeTable = true;
                }
                else {
                    $scope.stat = 'Информации не найдено';
                    $scope.resumeStat = true;
                }
        })
        .error(function(data, status, headers, config) {
            alert( "failure message: " + JSON.stringify({data: data, status: status, headers: headers, config: config}));
        });
        $scope.toggle = true;
        var element = document.getElementById('ID'+($scope.items.length-1));
        if (element) element.focus();
    };

//    $scope.reloadRoute = function () {
//        $scope.items = [{}];
//        $scope.emObjList = '';
//        $scope.goodObjList = '';
//        $scope.saleObjList = '';
//        requestString = "";
//        $scope.statEm = '';
//        $scope.statGood = '';
//        $scope.statSale = '';
//        $scope.toggle = false;
//        $scope.emTable = false;
//        $scope.emStat = false;
//        $scope.goodTable = false;
//        $scope.goodStat = false;
//        $scope.saleTable = false;
//        $scope.saleStat = false;
//    }

//    $scope.keyPress = function (eve) {
//        if (eve.which === 9) {
//            $scope.autofocus = true;
//            $scope.items.push({tex:''});
//            eve.preventDefault();
//        }
//        if (eve.which === 13) {
//            $scope.searchStr();
//        }
//    }
});

tempModule.directive('setfocus', function() {
      return{
             restrict: 'A',
              link: function(scope, element, attrs){
                 var focus=!!attrs.setfocus && !attrs.setfocus.replace(/true/,'');
                 if (focus === true){
                     element[0].focus();
                 }
             }
         };
    })