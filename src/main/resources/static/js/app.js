var tempModule = angular.module('testApp', ['ui.bootstrap']);

tempModule.controller('testController', function ($scope,$http,$sce) {

    $scope.textSearch = "";

    $scope.oneAtATime = true;
    $scope.groups = [{},{}];
    $scope.status = {
        isFirstOpen: false,
        isFirstDisabled: false
    };
    $scope.loader = {
        loading: false
    };

    $scope.maxSize = 5;
    $scope.bigCurrentPage = 1;

    $scope.fieldSearch = {};

    var urlBase = "";
    $scope.toggle = false;
    var requestString = "";
    $http.defaults.headers.post["Content-Type"] = "application/json";
    $scope.resumeAccordion = false;
    $scope.resumeStat = false;

    $scope.searchStr = function searchStr() {

        $scope.loader.loading = true ;

        $scope.objList = '';
        requestString = "";
        $scope.stat = '';
        $scope.resumeAccordion = false;
        $scope.resumeStat = false;
        $scope.toggle = false;


        var dataObj = {
            requestStr: $scope.textSearch
        };

        $http.post(urlBase + '/search', dataObj)
        .success(function (data, status, headers) {
                if (data.respList.length > 0) {
                    $scope.loader.loading = false ;
                    $scope.bigTotalItems  = data.countPage;
                    $scope.objList = data.respList;
                    $scope.resumeAccordion = true;
                    $scope.stat = 'Найдено ' + data.respList.length + ' штук';
                    $scope.toggle = true;
                    $scope.resumeStat = true;
                    $scope.pageNumberShow = false;
                }
                else {
                    $scope.stat = 'Информации не найдено';
                    $scope.resumeStat = true;
                }
        })
        .error(function(data, status, headers, config) {
                $scope.stat = 'Ошибка';
//            alert( "failure message: " + JSON.stringify({data: data, status: status, headers: headers, config: config}));
        });
        $scope.toggle = true;
    };

    $scope.clear = function () {
        $scope.toggle = false;
        $scope.textSearch = "";
        requestString = "";
    }

    $scope.loadRoute = function () {
        $scope.loader.loading = true ;

        $scope.objList = '';
        requestString = "";
        $scope.stat = '';
        $scope.resumeAccordion = false;
        $scope.resumeStat = false;
        $scope.toggle = false;
        $http.get(urlBase + '/load')
            .success(function (data, status, headers) {
                if (data.respList.length > 0) {
                    $scope.loader.loading = false ;
                    $scope.bigTotalItems  = data.countPage;
                    $scope.objList = data.respList;
                    $scope.resumeAccordion = true;
                    $scope.stat = 'Резюме в базе ' + data.countPage + ' штук';
                    $scope.toggle = true;
                    $scope.resumeStat = true;
                    $scope.pageNumberShow = true;
                }
                else {
                    $scope.stat = 'Информации не найдено';
                    $scope.resumeStat = true;
                }
            })
            .error(function(data, status, headers, config) {
                $scope.stat = 'Ошибка';
//                alert( "failure message: " + JSON.stringify({data: data, status: status, headers: headers, config: config}));
            });
            $scope.toggle = true;
    }

    $scope.page = function () {
//        $scope.loader.loading = true ;
//
//        $scope.objList = '';
//        requestString = "";
//        $scope.stat = '';
//        $scope.resumeAccordion = false;
//        $scope.resumeStat = false;
//        $scope.toggle = false;

        $http.get(urlBase + '/page' + '/' + $scope.bigCurrentPage)
            .success(function (data, status, headers) {
                if (data.respList.length > 0) {
//                    $scope.loader.loading = false ;

                    $scope.objList = data.respList;
//                    $scope.resumeAccordion = true;
                    $scope.stat = 'Резюме ' + data.respList.length + ' штук';
//                    $scope.toggle = true;
                    $scope.resumeStat = true;
                }
                else {
                    $scope.stat = 'Информации не найдено';
                    $scope.resumeStat = true;
                }
            })
            .error(function(data, status, headers, config) {
                $scope.stat = 'Ошибка';
            });
//        $scope.toggle = true;
    }

});

//tempModule.filter('newlines', function ($sce) {
//    return function (text) {
//        return text ? $sce.trustAsHtml(text.replace(/\n/g, '<br/>')) : '';
//    };
//})

