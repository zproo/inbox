/**
 * Created by zproo on 2017/5/18.
 */
function route(pathname, handle) {
    console.log("About to route a request for " + pathname);
    if (typeof handle[pathname] === 'function') {
        handle[pathname]();
    } else {
        console.log("No request handler found for " + pathname);
    }

}

exports.route = route;