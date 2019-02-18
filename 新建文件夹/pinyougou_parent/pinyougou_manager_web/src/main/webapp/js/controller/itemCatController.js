 //控制层 
app.controller('itemCatController' ,function($scope,$controller   ,itemCatService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		itemCatService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		itemCatService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		itemCatService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	//查询实体
	$scope.findParent=function(id){
		itemCatService.findOne(id).success(
			function(response){
				$scope.entityparent= response;
			}
		);
	}
	
	//保存 
	$scope.save=function(){

		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID

			serviceObject=itemCatService.update( $scope.entity ); //修改  
		}else{

			serviceObject=itemCatService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询
		        	$scope.findParentId($scope.parenId);//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}

	//  把新添加的夫id存进去
	$scope.joinEntity=function(){
		$scope.entity.parentId=$scope.entityparent.id;
	}

	// 新添加的置为空
	$scope.clearEntity=function(){
		$scope.entity.name={};
		$scope.entity.typeId={};
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框

		itemCatService.dele( $scope.selectIds ).success(
			function(response){

				if(response.success){
					$scope.findParentId($scope.parenId);//重新加载
					$scope.selectIds=[];
				}else {
					alert("删除失败")
				}
			}		
		);				
	}


	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		itemCatService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}


	$scope.findParentId=function(parentid){
		itemCatService.findParentId(parentid).success(
			function(response){
				$scope.list=response;
			}
		);
	}

	$scope.findNameId=function(id){
		itemCatService.findParentId(parentid).success(
			function(response){
				$scope.list=response;
			}
		);
	}

	$scope.grade=1;

	$scope.setGrade=function (value) {
		$scope.grade=value;
	}

	// 读取列表
	$scope.selectList=function (p_entity) {
		if($scope.grade==1){
			$scope.entity_1=null;
			$scope.entity_2=null;
		}
		if($scope.grade==2){
			$scope.entity_1=p_entity;
			$scope.entity_2=null;
		}
		if($scope.grade==3){
			$scope.entity_2=p_entity;
		}
		$scope.findParentId(p_entity.id); // 查询此级下级列表
	}

	// 查询上级的名字
	$scope.parenId=0;
	$scope.updateParentId=function (parentId) {
		$scope.parenId=parentId;
	}



});	
