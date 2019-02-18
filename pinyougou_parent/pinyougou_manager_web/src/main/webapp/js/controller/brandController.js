
  app.controller("brandController",function ($scope,brandService,$controller) {

      $controller("baseController",{$scope:$scope}); // 继承

    //读取列表数据绑定到表单中

    $scope.findAll= function () {

        brandService.findAll().success(function (response) {
            $scope.list = response;
        })
    };


//分页
    $scope.findPage = function (page,rows) {
        brandService.findPage(page,rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    //保存
    $scope.save=function(){

        var objeck=null;//方法名称

        if($scope.entity.id!=null){//如果有 ID
            objeck=brandService.update($scope.entity);//则执行修改方法
        }else {
            objeck=brandService.add($scope.entity);//则执行修改方法
        }

        objeck.success(
            function(response){
                if(response.success){
                    //重新查询
                    $scope.reloadList();//重新加载
                }else{
                    alert(response.message);
                }


            })
    };

    // 根据id查询
    $scope.finOne=function(id){

        brandService.finOne(id).success(
            function(response){
                alert("aaaa")
                $scope.entity= response;
            }
        );
    };



    // 批量删除

    $scope.dele=function () {

        brandService.dele($scope.selectIds).success(function (response) {

            if(response.success){
                $scope.reloadList();//重新加载
            }else {
                alert("删除失败！请稍后再试。")
            }

        })
    };

    // 按条件查询

    $scope.searchEntity={};//定义搜索对象

    $scope.search=function(page,rows){
        brandService.search(page,rows,$scope.searchEntity ).success(
            function(response){
                $scope.paginationConf.totalItems=response.total;//总记录数
                $scope.list=response.rows;//给列表变量赋值
            }
        );
    };


});