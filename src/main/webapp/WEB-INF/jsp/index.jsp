<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Demo系统</title>
<base href="<%=basePath%>">
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
</head>
<style>
.ztree.showIcon li a span.button.switch {
	visibility: visible
}

ul.ztree {
	background: #2E363F;
}

.ztree li a span.button.switch {
	visibility: hidden
}

.ztree li a.curSelectedNode {
	background-color: #2DC4D1;
	border: 0;
}

.ztree li span.button {
	background-image: url("ztree/left_menuForOutLook.png");
	*background-image: url("ztree/left_menuForOutLook.gif")
}

.ztree li span.button.noline_open {
	background-position: 0 0;
}

.ztree li span.button.noline_close {
	background-position: -18px 0;
}
</style>
<body style="overflow-y: hidden">

	<!--Header-part-->
	<div id="header">
		<h1>
			<a href="dashboard.html">Matrix Admin</a>
		</h1>
	</div>
	<!--close-Header-part-->


	<!--top-Header-menu-->
	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav">
			<li class="dropdown" id="profile-messages"><a title="" href="#"
				data-toggle="dropdown" data-target="#profile-messages"
				class="dropdown-toggle"><i class="icon icon-user"></i> <span
					class="text">Welcome User</span><b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#"><i class="icon-user"></i> My Profile</a></li>
					<li class="divider"></li>
					<li><a href="#"><i class="icon-check"></i> My Tasks</a></li>
					<li class="divider"></li>
					<li><a href="/logout.do"><i class="icon-key"></i> Log Out</a></li>
				</ul></li>
			<li class="dropdown" id="menu-messages"><a href="#"
				data-toggle="dropdown" data-target="#menu-messages"
				class="dropdown-toggle"><i class="icon icon-envelope"></i> <span
					class="text">Messages</span> <span class="label label-important">5</span>
					<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a class="sAdd" title="" href="#"><i class="icon-plus"></i>
							new message</a></li>
					<li class="divider"></li>
					<li><a class="sInbox" title="" href="#"><i
							class="icon-envelope"></i> inbox</a></li>
					<li class="divider"></li>
					<li><a class="sOutbox" title="" href="#"><i
							class="icon-arrow-up"></i> outbox</a></li>
					<li class="divider"></li>
					<li><a class="sTrash" title="" href="#"><i
							class="icon-trash"></i> trash</a></li>
				</ul></li>
			<li class=""><a title="" href="#"><i class="icon icon-cog"></i>
					<span class="text">Settings</span></a></li>
			<li class=""><a title="" href="logout.do"><i
					class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
		</ul>
	</div>
	<!--close-top-Header-menu-->
	<!--start-top-serch-->
	<!--  
<div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
-->
	<!--close-top-serch-->
	<!--sidebar-menu-->
	<div id="sidebar">
		<ul id="treeDemo" class="ztree showIcon"></ul>
	</div>
	<!--sidebar-menu-->

	<!--main-container-part-->
	<div id="content">
		<iframe id="iframe" name="main" src="home.do" width="100%"
			height="100%" frameborder="0" marginwidth="0" marginheight="0" frameborder="0"  scrolling="no" ></iframe>
	</div>

	<!--end-main-container-part-->

	<!--Footer-part-->
	<!-- 
<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in/">Themedesigner.in</a> </div>
</div>
 -->
	<!--end-Footer-part-->

	<script src="js/excanvas.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="ztree/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript">	
	var curMenu = null, zTree_Menu = null;
	var setting = {
		view: {
			showLine: false,
			showIcon: false,
			selectedMulti: false,
			dblClickExpand: false,
			addDiyDom: addDiyDom
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			beforeClick: beforeClick
		}
	};

	var zNodes =[];
	<c:forEach items="${list}" var="module">
	zNodes.push({id:${module.id},pId:
	<c:choose>
	   <c:when test="${module.parent.id == null}">0
	   </c:when>			   
	   <c:otherwise>${module.parent.id}
	   </c:otherwise>		  
	</c:choose>,name:'${module.name}',priority:${module.priority},level:${module.level},url:'<%=basePath%>${module.action}',target:'main'});
	</c:forEach>

	function addDiyDom(treeId, treeNode) {
		var aObj = $("#"+treeNode.tId+"_a"),
			switchObj = $("#" + treeNode.tId + "_switch"),
			icoObj = $("#" + treeNode.tId + "_ico");
		switchObj.remove();
		icoObj.before(switchObj);
		var step = 10;
		if(treeNode.level > 1) {
			$("#"+treeNode.tId).addClass('submenu');
			var spaceStr = "<span style='display: inline-block;width:" + (step * treeNode.level)+ "px'></span>";
			switchObj.before(spaceStr);
		}
		if(treeNode.children != undefined) {
			var num = treeNode.children.length;
			var numSpan = '<span class="label label-important">'+num+'</span>';
			aObj.append(numSpan);
		}
	}
	function beforeClick(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.expandNode(treeNode);
	}

	$(document).ready(function(){
		var treeObj = $("#treeDemo");
		$.fn.zTree.init(treeObj, setting, zNodes);
		/* zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
		curMenu = zTree_Menu.getNodes()[0].children[0].children[0];
		zTree_Menu.selectNode(curMenu);	 */	
	});
</script>
</body>
</html>
