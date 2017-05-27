/**
 * Created by zproo on 2017/5/24.
 */
var express = require("express");
var path = require('path');
var serveStatic = require('serve-static');
var bodyParser = require('body-parser');

// 可以从命令行获取
var port = process.env.PORT || 3000;
var app = express();
app.use(bodyParser.urlencoded());
app.set('views', './views/pages');
app.set('view engine', 'pug');
app.use(serveStatic(path.join(__dirname, "bower_components")));
app.listen(port);

console.log('imovie started on' + port);

// index
app.get('/', function (req, res) {
    res.render('index', {
        title: 'imovie 首页',
        movies: [{
            title: "加勒比海盗5",
            _id: 1,
            poster: 'https://img3.doubanio.com/view/photo/raw/public/p2459723975.jpg'
        }, {
            title: "加勒比海盗5",
            _id: 1,
            poster: 'https://img3.doubanio.com/view/photo/raw/public/p2459723975.jpg'
        }, {
            title: "加勒比海盗5",
            _id: 1,
            poster: 'https://img3.doubanio.com/view/photo/raw/public/p2459723975.jpg'
        }, {
            title: "加勒比海盗5",
            _id: 1,
            poster: 'https://img3.doubanio.com/view/photo/raw/public/p2459723975.jpg'
        }, {
            title: "加勒比海盗5",
            _id: 1,
            poster: 'https://img3.doubanio.com/view/photo/raw/public/p2459723975.jpg'
        }, {
            title: "加勒比海盗5",
            _id: 1,
            poster: 'https://img3.doubanio.com/view/photo/raw/public/p2459723975.jpg'
        }, {
            title: "加勒比海盗5",
            _id: 1,
            poster: 'https://img3.doubanio.com/view/photo/raw/public/p2459723975.jpg'
        }
        ]
    });
});

// detail
app.get('/movie/:id', function (req, res) {
    res.render('detail', {
        title: 'imovie 详情页',
        movie: {
            title: '机械战警',
            doctor: '帕迪里亚',
            country: '美国',
            year: 2014,
            flash: 'http://player.youku.com/player.php/sid/XMjU2MzI2OTI0NA==/v.swf',
            summary: 'testtesttesttesttesttesttesttesttesttesttesttesttesttesttest' +
            +'testtesttesttesttesttesttesttesttesttesttesttesttesttest' +
            +'testtesttesttesttesttesttesttesttesttesttesttesttesttest',
            language: '英语',
        }
    });
});

// admin
app.get('/admin/movie', function (req, res) {
    res.render('admin', {
        title: 'imovie 后台录入页',
        movie: {
            title: '',
            doctor: '',
            country: '',
            year: '',
            flash: '',
            summary: '',
            language: ''
        }
    });
});

// list
app.get('/admin/list', function (req, res) {
    res.render('list', {
        title: 'imovie 列表',
        movies:[{
            title: '加勒比海盗5',
            _id:1,
            doctor: '乔阿吉姆·罗恩尼',
            country: '美国',
            year: 2014,
            flash: 'http://player.youku.com/player.php/sid/XMjU2MzI2OTI0NA==/v.swf',
            language: '英语'
        }]
    });
});