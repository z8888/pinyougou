 //控制层 
app.controller('goodsController' ,function($scope,$controller   ,goodsService,uploadFileService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		goodsService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存


	$scope.add=function(){
		$scope.entity.goodsDesc.introduction=editor.html(); //保存内容简介
		goodsService.add( $scope.entity  ).success(
			function(response){
				if(response.success){
					//重新查询 
		        	alert("添加成功")
					$scope.entity={};
					editor.html("");
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		goodsService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		goodsService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

	// 文件上传
	$scope.entityImage={url:[]}
	$scope.uploadFile=function () {
		uploadFileService.uploadfile().success(function (response) {
			if(response.success){
				$scope.entityImage.url=response.message;
			}else{
				alert(response.message)
			}
		})
	}

	// 保存图片到状态栏
	$scope.entity={goodsDesc:{itemImages:[]}};//定义页面实体结构
	$scope.addImage=function () {
		$scope.entity.goodsDesc.itemImages.push({color:$scope.entityImage.color,url:$scope.entityImage.url});
	}

	// 移除图片
	$scope.spliceImage=function(index){
		$scope.entity.goodsDesc.itemImages.splice(index,1);
	}

	// 清空图片和url
	$scope.clearEntityImage=function () {
		$scope.entityImage=[];
	}
    
});	
