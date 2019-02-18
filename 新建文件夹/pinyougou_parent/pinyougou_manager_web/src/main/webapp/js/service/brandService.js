
    app.service("brandService",function ($http) {
    this.findAll=function () {
        return $http.get("/brand/findall.do");
    }
    this.findPage=function (page,rows) {
        return $http.get('/brand/findpage.do?page=' + page + '&rows=' + rows);
    }
    this.update=function (save) {
        return $http.post("/brand/update.do",save);
    }
    this.add=function (add) {
        return $http.post("/brand/add.do",add );
    }
    this.finOne=function (id) {
        return $http.get("/brand/findOne.do?id="+id+"");
    }
    this.dele=function (ids) {
        return $http.get("/brand/delete.do?ids="+ids);
    }
    this.search=function (page,rows,searchEntity) {
            return $http.post("../brand/search.do?page="+page+"&rows="+rows,searchEntity);
    }
        this.selectOptionList=function () {
            return $http.get("/brand/selectOptionList.do");
        }
});