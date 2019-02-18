app.controller("indexController",function ($scope, loginService) {

    // 显示当前用户名
    $scope.showName=function () {
        loginService.loginName().success(function(response){

            $scope.loginName=response.loginNane;
        })
    }
})