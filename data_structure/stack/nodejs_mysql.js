const mysql  = require('mysql');
const http   = require('http');
// var data = http.get('http://pv.sohu.com/cityjson?ie=utf-8');
 
const connection = mysql.createConnection({     
  host     : '94.191.106.240',       
  user     : 'root',              
  password : 'zhapeng213.',       
  port: '3306',                   
  database: 'blog_ip' 
}); 
//模拟发送http请求
const request = require("request");
//用户数据
let data = null;

//get请求
request('http://pv.sohu.com/cityjson?ie=utf-8', function (error, response, body) {
    if (!error && response.statusCode == 200) {
        eval(body.toString());
        //console.log(returnCitySN);
        data = [returnCitySN.cip,returnCitySN.cname];
        //console.log(data);
        let  addSql = 'INSERT INTO blog_ip(ip,city) VALUES(?,?)';
        connection.query(addSql,data,function (err, result) {
            if(err){
            console.log('[INSERT ERROR] - ',err.message);
            return;
            }        
    
       console.log('--------------------------INSERT----------------------------');  
       console.log('INSERT ID:',result);        
       console.log('-----------------------------------------------------------------\n\n');  
        });
      connection.end();
          }
});
