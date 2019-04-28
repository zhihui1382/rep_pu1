<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html style="font-size: 62.5%;padding:0;margin:0;" >
<head>
<meta charset="utf8">
<script type="text/javascript" src='${pageContext.request.contextPath}/static/web/js/lib/jq.js'></script>
<script type="text/javascript" src='${pageContext.request.contextPath}/static/web/js/lib/rem.js'></script>
<link rel="stylesheet" type="text/css" href='${pageContext.request.contextPath}/static/web/css/login/login.css'/>
<link rel="stylesheet" type="text/css" href='${pageContext.request.contextPath}/static/web/css/common/common.css'/>
<script type="text/javascript" src='${pageContext.request.contextPath}/static/web/js/login/login.js'></script>
</head>
<body>
	<div class='left'>
		<div class='login_box'>
	
		</div>
	</div>
	<div class='right'>

	</div>
	<form 	action='${pageContext.request.contextPath}/showLogin.do' mothed='post'>
				<table>
					<tr>
						<td><text>手机号</text></td>
						<td><input name='tel' placeholder='请输入手机号'/></td>
						<td></td>
					</tr>
					<tr>
						<td><text>验证码</text></td>
						<td>
							<input name='code' placeholder='请输入验证码' style='width:150px;margin-right:14px;' />
							<div onclick="xds_submit();" style='
								width:90px;
								height:28px;
								background: -prefix-linear-gradient(left, #3304b4, #639bf4); 
								background: linear-gradient(to right,#3304b4, #639bf4);
								display:inline-block;
								text-align:center;
								line-height:30px;
								color:white;
								font-size:12px;
								border-radius:3px;
						'>获取验证码</div>
						</td>
					</tr>
					<tr>
						<td><text>密&nbsp;&nbsp;&nbsp;&nbsp;码</text></td>
						<td><input name='password' placeholder='请输入密码'/></td>
						<td></td>
					</tr>
				</table>
				<input type='submit' value='登陆' />
			</form>
		<script type="text/javascript">
			xds_submit=function(){

		    wx.request({//等同ajax

		      url: 'https://open.ucpaas.com/ol/sms/sendsms',//接口地址

		      data: {//参数

		        "sid": "af50998dbff17c09ea5a4a4db4efb741",

		        "token": "e388fe118047113e6e94f21a5cc84441",

		        "appid": "a6ec14ce1b3a438d8b464062a1c02f00",

		        "templateid": "447426",

		        "mobile": "18310701720",//目标电话号码

		        "param": "豪哥帅气,帅气豪哥",//内容，在模板中接受几个参数传几个，以逗号分隔

		        "uid": "2d92c6132139467b989d087c84a365d8"//自己写的返回，可用来检测状态

		      },

		      method:"POST", 

		      success:function(res){

		        console.log(res)   //返回状态码

		      }

		    })

		  },
		</script>	
</body>
</html>