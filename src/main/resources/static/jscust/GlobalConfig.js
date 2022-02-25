require.config({
    paths:{
        jquery:['https://cdn.bootcss.com/jquery/3.4.1/jquery.min','https://cdn.staticfile.org/jquery/3.4.1/jquery.min'],
        bootstrap:['https://cdn.bootcss.com/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min'],
        bootstrap3:['https://cdn.bootcss.com/twitter-bootstrap/3.4.1/js/bootstrap.min'],
        custom:['/jslib/GAAdmin/custom.min'],
        bootstrap_table:['https://cdn.bootcss.com/bootstrap-table/1.15.4/bootstrap-table.min'],
        bootstrap_table_CN:['https://cdn.bootcss.com/bootstrap-table/1.15.4/locale/bootstrap-table-zh-CN.min'],
        layer:['https://cdn.bootcss.com/layer/2.3/layer'],
        bootstrap_validator:['https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min'],
        bootstrap_validator_CN:['https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/language/zh_CN.min'],
        jqueryform:['https://cdn.bootcss.com/jquery.form/4.2.2/jquery.form.min']
    },
    map:{
        '*':{css:['https://cdn.bootcss.com/require-css/0.1.10/css.min.js']}
    },
    shim:{
        bootstrap:{
            deps:['jquery','css!https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css','css!https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css']
        },
        custom:{
            deps:['jquery','bootstrap','css!/jslib/GAAdmin/custom.min.css']
        },
        bootstrap_table:{
            deps:['jquery','bootstrap','css!https://cdn.bootcss.com/bootstrap-table/1.15.4/bootstrap-table.min.css']
        },
        bootstrap_table_CN:{
            deps:['jquery','bootstrap','bootstrap_table']
        },
        layer:{
            deps:['css!https://cdn.bootcss.com/layer/2.3/skin/layer.css']
        },
        bootstrap_validator:{
            deps:['jquery','bootstrap3','css!https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css']
        },
        bootstrap_validator_CN:{
            deps:['jquery','bootstrap3','bootstrap_validator']
        },
        jqueryform:{
            deps:['jquery']
        },
        bootstrap3:{
            deps:['jquery','css!https://cdn.bootcss.com/twitter-bootstrap/3.4.1/css/bootstrap.min.css','css!https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css']
        }
    }
})