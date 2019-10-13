import { deleteTable, updateTable, addTable, getTable, postTableList, postTableListAndId } from "../../api/api";

var SIGN_REGEXP = /([yMdhsm])(\1*)/g;
var DEFAULT_PATTERN = 'yyyy-MM-dd';
function padding (s, len) {
    var len = len - (s + '').length;
    for (var i = 0; i < len; i++) { s = '0' + s; }
    return s;
};

export default {
    getQueryStringByName: function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        var context = "";
        if (r != null)
            context = r[2];
        reg = null;
        r = null;
        return context == null || context == "" || context == "undefined" ? "" : context;
    },
    formatDate: {


        format: function (date, pattern) {
            pattern = pattern || DEFAULT_PATTERN;
            return pattern.replace(SIGN_REGEXP, function ($0) {
                switch ($0.charAt(0)) {
                    case 'y': return padding(date.getFullYear(), $0.length);
                    case 'M': return padding(date.getMonth() + 1, $0.length);
                    case 'd': return padding(date.getDate(), $0.length);
                    case 'w': return date.getDay() + 1;
                    case 'h': return padding(date.getHours(), $0.length);
                    case 'm': return padding(date.getMinutes(), $0.length);
                    case 's': return padding(date.getSeconds(), $0.length);
                }
            });
        },
        parse: function (dateString, pattern) {
            var matchs1 = pattern.match(SIGN_REGEXP);
            var matchs2 = dateString.match(/(\d)+/g);
            if (matchs1.length == matchs2.length) {
                var _date = new Date(1970, 0, 1);
                for (var i = 0; i < matchs1.length; i++) {
                    var _int = parseInt(matchs2[i]);
                    var sign = matchs1[i];
                    switch (sign.charAt(0)) {
                        case 'y': _date.setFullYear(_int); break;
                        case 'M': _date.setMonth(_int - 1); break;
                        case 'd': _date.setDate(_int); break;
                        case 'h': _date.setHours(_int); break;
                        case 'm': _date.setMinutes(_int); break;
                        case 's': _date.setSeconds(_int); break;
                    }
                }
                return _date;
            }
            return null;
        }

    },

    fillPath: function (obj, pathName) {
        obj['path'] = pathName;
        return obj;
    },

    getImageUrl: function (imageId) {

    },


    //删除
    handleDel: function (page, index, row, refreshFunc) {
        page.$confirm('确认删除该记录吗?', '提示', {
            type: 'warning'
        }).then(() => {
            page.listLoading = true;
            let para = { id: row.id };
            page.getTransferObject(para);
            deleteTable(para).then((res) => {
                page.listLoading = false;
                page.$message({
                    message: '删除成功',
                    type: 'success'
                });
                refreshFunc();
            });
        }).catch(function (error) {
            page.addLoading = false;
            page.$message({
                message: '删除失败',
                type: 'error'
            });
            console.log(error);
        });
    },

    //编辑
    editSubmit: function (page, transferFunc, refreshFunc) {
        page.$refs.editForm.validate((valid) => {
            if (valid) {
                page.$confirm('确认提交吗？', '提示', {}).then(() => {
                    page.editLoading = true;
                    let para = Object.assign({}, page.editForm);
                    page.getTransferObject(para);
                    transferFunc(para);
                    updateTable(para).then((res) => {
                        var result = res.data;
                        page.editLoading = false;
                        if (result.code == '00000000') {
                            page.$message({
                                message: '提交成功',
                                type: 'success'
                            });
                            page.$refs['editForm'].resetFields();
                            page.editFormVisible = false;
                            refreshFunc();
                        } else {
                            page.$message({
                                message: result.msg,
                                type: 'error'
                            });
                        }
                    }).catch(function (error) {
                        page.addLoading = false;
                        page.$message({
                            message: '提交失败',
                            type: 'error'
                        });
                        console.log(error);
                    });
                });
            }
        });
    },

    //新增
    addSubmit: function (page, transferFunc, refreshFunc) {
        page.$refs.addForm.validate((valid) => {
            if (valid) {
                page.$confirm('确认提交吗？', '提示', {}).then(() => {
                    page.addLoading = true;
                    let para = Object.assign({}, page.addForm);
                    page.getTransferObject(para);
                    transferFunc(para);
                    addTable(para).then((res) => {
                        var result = res.data;
                        page.addLoading = false;
                        if (result.code == '00000000') {
                            page.$message({
                                message: '提交成功',
                                type: 'success'
                            });
                            page.$refs['addForm'].resetFields();
                            page.addFormVisible = false;
                            refreshFunc();
                        } else {
                            page.$message({
                                message: result.msg,
                                type: 'error'
                            });
                        }
                    }).catch(function (error) {
                        page.addLoading = false;
                        page.$message({
                            message: '提交失败',
                            type: 'error'
                        });
                        console.log(error);
                    });
                });
            }
        });
    },

    // 表格数据
    getRightTableData (page, queryObject) {
        let para = {
            pageNo: page.page,
            pageSize: page.pageSize
        };
        if (!!queryObject.searchName) {
            para['searchName'] = queryObject.searchName;
            para['searchValue'] = page.filters.name;
        }
        var tableFunc = postTableList;
        if (!!queryObject.id) {
            para['id'] = queryObject.id;
            tableFunc = postTableListAndId;
        }
        page.listLoading = true;
        tableFunc(page.getTransferObject(para)).then((res) => {
            var result = res.data;
            page.total = result.totalCount;
            page[queryObject.dataSetName] = result.data;
            page.listLoading = false;
        }).catch(function (error) {
            page.listLoading = false;
            page.$message({
                message: '加载失败',
                type: 'error'
            });
            console.log(error);
        });
    },

};
