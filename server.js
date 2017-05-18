/**
 * Created by zproo on 2017/5/18.
 */
var http = require("http");
var url = require('url');

function start(route, handle) {
    function onRequest(request, response) {
        var postData = '';
        var pathname = url.parse(request.url).pathname;
        console.log("Request for" + pathname + "  received.");

        request.setEncoding('utf8');

        request.addListener('data', function (postDataChunk) {
            postData += postDataChunk;
            console.log('recive postDataChunk' + postDataChunk + ',');

        });

        // 接受完成
        request.addListener('end', function () {
            // 在数据接受完成时触发路由分发到处理程序，仅触发一次
            route(pathname, handle, response,postData);    // index中的回调函数
        });
    }

    http.createServer(onRequest).listen(8888);
    console.log("Server  has  started.");
}

exports.start = start;