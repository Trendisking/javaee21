/**
 * Created by 20330 on 2016/6/20.
 */
var Ajax=(function(){
    function createXmlHttp(){
        var xmlHttp=null;
        if(window.ActiveXObject){
            xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }else{
            xmlHttp=new XMLHttpRequest();
        }
        return xmlHttp;
    }

    function builderQueryParam(isPost,objectParam){
        var queryParam="";
        if(!isPost){
            queryParam="?";
        }
        for(var index in objectParam){
            var key=index;
            var value=objectParam[index];
            queryParam += (key+"="+value+"&");
        }
        if(!isPost){
            queryParam +="_="+new Date().getTime();
        }else{
            if(queryParam.lastIndexOf("&")==queryParam.length-1){
                queryParam=queryParam.substring(0,queryParam.length-1);
            }
        }

        return queryParam;
    }



    function sendGetRequest(url,queryParam,callback){
        var args=arguments;
        var xmlHttp=createXmlHttp();
        xmlHttp.open("get",url+builderQueryParam(false,queryParam),true);
        xmlHttp.onreadystatechange=function(){
            var readyState=xmlHttp.readyState;
            if(readyState==4){
                var status=xmlHttp.status;
                if(status==200){
                    var result=xmlHttp.responseText;
                    if(args.length==2){
                        args[1](result);
                    }else if(args.length==3){
                        args[2](result);
                    }

                }else{
                    alert("服务器请求异常: "+status);
                }
            }

        };
        xmlHttp.send();

    }

    function sendPostRequest(url,queryParam,callback){
        var args=arguments;
        var xmlHttp=createXmlHttp();
        xmlHttp.open("post",url,true);
        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoden");
        xmlHttp.onreadystatechange=function(){
            var readyState=xmlHttp.readyState;
            if(readyState==4){
                var status=xmlHttp.status;
                if(status==200){
                    var result=xmlHttp.responseText;
                    if(args.length==2){
                        args[1](result);
                    }else if(args.length==3){
                        args[2](result);
                    }
                    //callback(result);
                }else{
                    alert("服务器请求异常: "+status);
                }
            }

        };
        xmlHttp.send(builderQueryParam(true,queryParam));

    }


    return {
        getText:sendGetRequest,
        postText:sendPostRequest
    }

})();