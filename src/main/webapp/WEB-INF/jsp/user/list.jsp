<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
	<div>
		<div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
            <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper" role="grid"><div class=""><div id="DataTables_Table_0_length" class="dataTables_length"><label>Show <div class="select2-container" id="s2id_autogen1">    <a href="#" onclick="return false;" class="select2-choice" tabindex="0">   <span>10</span><abbr class="select2-search-choice-close" style="display:none;"></abbr>   <div><b></b></div></a><div class="select2-drop select2-with-searchbox select2-drop-active select2-offscreen" style="display: block;">   <div class="select2-search">       <input type="text" autocomplete="off" class="select2-input" tabindex="0">   </div>   <ul class="select2-results"></ul></div>    </div><select size="1" name="DataTables_Table_0_length" aria-controls="DataTables_Table_0" style="display: none;"><option value="10" selected="selected">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select> entries</label></div></div><table class="table table-bordered data-table dataTable" id="DataTables_Table_0">
              <thead>
                <tr role="row"><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 241px;" aria-label="Rendering engine: activate to sort column ascending"><div class="DataTables_sort_wrapper">Rendering engine<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 330px;" aria-sort="ascending" aria-label="Browser: activate to sort column descending"><div class="DataTables_sort_wrapper">Browser<span class="DataTables_sort_icon css_right ui-icon ui-icon-triangle-1-n"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 301px;" aria-label="Platform(s): activate to sort column ascending"><div class="DataTables_sort_wrapper">Platform(s)<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th><th class="ui-state-default" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" style="width: 205px;" aria-label="Engine version: activate to sort column ascending"><div class="DataTables_sort_wrapper">Engine version<span class="DataTables_sort_icon css_right ui-icon ui-icon-carat-2-n-s"></span></div></th></tr>
              </thead>
              
            <tbody role="alert" aria-live="polite" aria-relevant="all"><tr class="gradeU odd">
                  <td class="">Other browsers</td>
                  <td class=" sorting_1">All others</td>
                  <td class=" ">-</td>
                  <td class="center ">-</td>
                </tr><tr class="gradeA even">
                  <td class="">Trident</td>
                  <td class=" sorting_1">AOL browser (AOL desktop)</td>
                  <td class=" ">Win XP</td>
                  <td class="center ">6</td>
                </tr><tr class="gradeA odd">
                  <td class="">Gecko</td>
                  <td class=" sorting_1">Camino 1.0</td>
                  <td class=" ">OSX.2+</td>
                  <td class="center ">1.8</td>
                </tr><tr class="gradeA even">
                  <td class="">Gecko</td>
                  <td class=" sorting_1">Camino 1.5</td>
                  <td class=" ">OSX.3+</td>
                  <td class="center ">1.8</td>
                </tr><tr class="gradeX odd">
                  <td class="">Misc</td>
                  <td class=" sorting_1">Dillo 0.8</td>
                  <td class=" ">Embedded devices</td>
                  <td class="center ">-</td>
                </tr><tr class="gradeA even">
                  <td class="">Gecko</td>
                  <td class=" sorting_1">Epiphany 2.20</td>
                  <td class=" ">Gnome</td>
                  <td class="center ">1.8</td>
                </tr><tr class="gradeA odd">
                  <td class="">Gecko</td>
                  <td class=" sorting_1">Firefox 1.0</td>
                  <td class=" ">Win 98+ / OSX.2+</td>
                  <td class="center ">1.7</td>
                </tr><tr class="gradeA even">
                  <td class="">Gecko</td>
                  <td class=" sorting_1">Firefox 1.5</td>
                  <td class=" ">Win 98+ / OSX.2+</td>
                  <td class="center ">1.8</td>
                </tr><tr class="gradeA odd">
                  <td class="">Gecko</td>
                  <td class=" sorting_1">Firefox 2.0</td>
                  <td class=" ">Win 98+ / OSX.2+</td>
                  <td class="center ">1.8</td>
                </tr><tr class="gradeA even">
                  <td class="">Gecko</td>
                  <td class=" sorting_1">Firefox 3.0</td>
                  <td class=" ">Win 2k+ / OSX.3+</td>
                  <td class="center ">1.9</td>
                </tr></tbody></table><div class="fg-toolbar ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix"><div class="dataTables_filter" id="DataTables_Table_0_filter"><label>Search: <input type="text" aria-controls="DataTables_Table_0"></label></div><div class="dataTables_paginate fg-buttonset ui-buttonset fg-buttonset-multi ui-buttonset-multi paging_full_numbers" id="DataTables_Table_0_paginate"><a tabindex="0" class="first ui-corner-tl ui-corner-bl fg-button ui-button ui-state-default ui-state-disabled" id="DataTables_Table_0_first">First</a><a tabindex="0" class="previous fg-button ui-button ui-state-default ui-state-disabled" id="DataTables_Table_0_previous">Previous</a><span><a tabindex="0" class="fg-button ui-button ui-state-default ui-state-disabled">1</a><a tabindex="0" class="fg-button ui-button ui-state-default">2</a><a tabindex="0" class="fg-button ui-button ui-state-default">3</a><a tabindex="0" class="fg-button ui-button ui-state-default">4</a><a tabindex="0" class="fg-button ui-button ui-state-default">5</a></span><a tabindex="0" class="next fg-button ui-button ui-state-default" id="DataTables_Table_0_next">Next</a><a tabindex="0" class="last ui-corner-tr ui-corner-br fg-button ui-button ui-state-default" id="DataTables_Table_0_last">Last</a></div></div></div>
          </div>
        </div>
	</div>
	
	<form name="tableForm" action="/spmvc/pager/list">
		<mytag:pager pagination="5"></mytag:pager>
	</form>
</body>
</html>