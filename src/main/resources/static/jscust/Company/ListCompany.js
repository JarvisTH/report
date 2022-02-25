require(
    ['/jscust/GlobalConfig.js'],
    function () {
        requirejs(
            ['jquery', 'bootstrap', 'custom', 'bootstrap_table', 'bootstrap_table_CN'],
            function ($) {
                //start 该处定义我们自己的脚本
                // 绑定列表中的修改和删除图标对应事件
                window.cellEvents = {
                    'click .modify':function(e,value,row,index){
                        //执行修改操作
                        alert("点击了修改图标:"+row.comname);
                    },
                    'click .delete':function(e,value,row,index){
                        //执行删除操作
                        alert("点击了删除图标："+row.uuid);
                    }
                }

                // 数据列表展示
                $('#tb_company').bootstrapTable({
                    url: '/CompanyModule/findAllSimplePage', // 后台请求url
                    method: 'post', // 请求方式
                    // striped: true,  // 是否显示行间隔色
                    classes: "table table-bordered table-condensed table-hover", // 启用bootstrap表格样式
                    cache: false,   // 是否使用缓存，默认true
                    pagination: true, // 是否显示分页
                    sortable: true, // 是否启用排序
                    sortOrder: "asc",  // 排序方式
                    sidePagination: "server", // 分页方式：server服务端分页，client客户端分页
                    // queryParamsType: '', // ’limit‘：默认RESTful风格，包括limit，offset，search，sort，order。为空：包括pageSize，pageHeader，searchText，sortName，sortOrder
                    pageNumber: 1,   // 初始化加载第一页，默认第一页
                    pageSize: 3,    // 每页记录
                    pageList: [3, 10, 20],    // 可供选择的每页行数
                    search: false,  // 是否显示表格搜索，客户端搜索，不请求服务器
                    strictSearch: true, // 默认false，true为全匹配搜索，否则为模糊搜索
                    showColumns: false, // 是否显示所有列
                    showRefresh: false, // 是否显示刷新按钮
                    minimumCountColumns: 10,    // 最少允许行数
                    clickToSelect: true,    // 是否启用点击选择行
                    // height: 500,    // 行高，没有设置则自动调整高度
                    uniqueId: "uuid",   // 每行的唯一标识，一般为主键列
                    showToggle: false,  // 是否显示详细视图和列表视图的切换按钮
                    cardView: false,    // 是否显示详细视图
                    detailView: false,  // 是否显示父子表
                    rowStyle: function (row, index) {  // 根据行中的某列的值，动态渲染整行文字颜色
                        if (row.employeenumber < 60) {
                            return {
                                css: {color: 'blue'}, // 文字颜色
                                classes: 'table-warning'
                            };
                        } else if (row.employeenumber > 1000) { // 利用bootstrap的颜色体系
                            return {css: {backgroud: '#7ba392'}}; //行背景色
                        } else {
                            return {};  // 保持原色
                        }
                    },
                    onClickRow: function (row, $element) {   //行单击事件
                        var detail = "<h2><strong>" + row.comname + "详细信息</strong></h2>";
                        detail += "<p>UUID：<b>" + row.uuid + "</b></p>";
                        detail += "<p>公司名称：<b>" + row.comname + "</b></p>";
                        detail += "<p>公司地址：<b>" + row.comaddress + "</b></p>";
                        detail += "<p>公司网址：<b>" + row.comurl + "</b></p>";
                        detail += "<p>公司座机：<b>" + row.comtelephone + "</b></p>";
                        detail += "<p>成立日期：<b>" + row.establishdate + "</b></p>";
                        detail += "<p>员工人数：<b>" + row.employeenumber + "</b></p>";
                        detail += "<p>总产值：<b>" + row.totaloutput + "</b></p>";
                        detail += "<p>营运状态：<b>" + row.comstatus + "</b></p>";
                        detail += "<p>联系人姓名：<b>" + row.contactname + "</b></p>";
                        detail += "<p>联系人手机号：<b>" + row.contactmobile + "</b></p>";
                        detail += "<p>联系人邮箱：<b>" + row.contactemail + "</b></p>";

                        //赋值给页面ID为detail_Company的元素
                        $("#detail_company").html(detail);
                    },
                    queryParams: function (params) {
                        // 重写参数，这样方便后期增加查询条件
                        var params = {
                            size: params.limit, //页面大小
                            page: (params.offset / params.limit)    // 页码
                        };
                        return params;
                    },
                    columns: [{
                        title: '编号',
                        formatter: function (value, row, index) {
                            var pageSize = $('#tb_company').bootstrapTable('getOptions').pageSize;
                            var pageNumber = $('#tb_company').bootstrapTable('getOptions').pageNumber;
                            return pageSize * (pageNumber - 1) + index + 1;
                        },
                        align: 'center',
                        width: 50
                    }, {
                        field: 'uuid',
                        title: 'UUID',
                        visible: false
                    }, {
                        field: 'comname',
                        title: '公司名称'
                    }, {
                        field: 'comaddress',
                        title: '公司地址'
                    }, {
                        field: 'comurl',
                        title: '公司网址'
                    }, {
                        field: 'comtelephone',
                        title: '公司座机'
                    }, {
                        field: 'establishdate',
                        title: '成立日期'
                    }, {
                        field: 'employeenumber',
                        title: '员工人数'
                    }, {
                        field: 'totaloutput',
                        title: '总产值',
                        cellStyle: function (value, row, index) {
                            if (value > 500 && value < 1000) {
                                return {classes: 'table-success'}
                            } else {
                                return {};
                            }
                        }
                    }, {
                        field: 'comdesc',
                        title: '公司简介',
                        visible: false
                    }, {
                        field: 'comstatus',
                        title: '营运状态',
                        formatter: function indexFormatter(value, row, index) {
                            var newvalue = "";
                            if (value == "正常运营") {
                                newvalue = '<span class="badge badge-success">' + value + '</span>';
                            } else if (value == "正在注销") {
                                newvalue = '<span class="badge badge-warning">' + value + '</span>';
                            } else {
                                newvalue = '<span class="badge badge-danger">' + value + '</span>';
                            }
                            return newvalue;
                        }
                    }, {
                        field: 'contactname',
                        title: '联系人姓名',
                        visible: false
                    }, {
                        field: 'contactmobile',
                        title: '联系人手机号',
                        visible: false
                    }, {
                        field: 'contactemail',
                        title: '联系人邮箱',
                        visible: false
                    }, {
                        field: '',
                        title: '操 作',
                        events: cellEvents,
                        formatter: function (value, row, index) {
                            return '<i class="modify fa fa-edit fa-lg text-warning" title="修改记录"></i>&nbsp;&nbsp;&nbsp;' + '<i class="delete fa fa-close fa-lg text-danger" title="删除记录"></i>'
                        }
                    }]
                })
                //end 该处定义我们自己的脚本
            }
        )
    }
);
