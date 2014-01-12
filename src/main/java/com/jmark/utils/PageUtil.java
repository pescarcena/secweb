package com.jmark.utils;

public class PageUtil {
	/**  eg：<div class="pagination alternate">
	    <ul>
	      <li class="disabled"><a href="#">Prev</a></li>
	      <li class="active"> <a href="#">1</a> </li>
	      <li><a href="#">2</a></li>
	      <li><a href="#">3</a></li>
	      <li><a href="#">4</a></li>
	      <li><a href="#">Next</a></li>
	    </ul>
	  </div>
	*/
	/**
	 * pager  分页类
	 * pagination 要显示的页码数目
	 */
	public static String pageNavUtil(Pager pager,int pagination) {
			
		StringBuilder pageNavHtml = new StringBuilder();
		String js = "<script language='javascript'>"
						+"function gotoPage(pageNo) {"
							+"if(pageNo>0)"
							+"document.getElementsByName('goPage')[0].value = pageNo;"
							+"document.tableForm.submit();"
						+"}"
					+"</script>";
		pageNavHtml.append(js);
		pageNavHtml.append("<div class='pagination alternate'>");
		pageNavHtml.append("	<input name='goPage' style='display: none;'/>");
		pageNavHtml.append("	<ul>");

		if(pagination < 1 ) {
			pagination = 5;   //默认是显示五页码
		}
		
		//计算中间页码数字
		int midNum = (int)Math.floor(pagination / 2);
		int currentPage = pager.getCurrentPage();
		int beginNum =  currentPage <= midNum ? 1 : currentPage - midNum;
		int endNum = beginNum + pagination-1;
		int totalPage = pager.getTotalPage();
		if (endNum > totalPage) { 
			endNum = totalPage;
			beginNum = endNum - pagination+1; 
		}
		if (totalPage > 1) {
			//前一页
			if(!pager.getHasPrevious()) {
				pageNavHtml.append("<li class='disabled'><a href='javascript:void(0)'>Prev</a></li>");
			}else {
				pageNavHtml.append("<li><a href='javascript:void(0)' onclick='gotoPage("+(currentPage - 1)+")'>Prev</a></li>");
			}
			//显示页码
            for (int i = beginNum; i <= endNum; i++) {
                if (i == currentPage) {
                	pageNavHtml.append("<li class='active'> <a href='javascript:void(0)'>"+currentPage+"</a> </li>");
                	
                }
                else {
                	pageNavHtml.append("<li><a href='javascript:void(0)' onclick='gotoPage("+i+")'>"+i+"</a></li>");
                	
                }
            }
            //后一页
            if (!pager.getHasNext()) {
				pageNavHtml.append("<li class='disabled'><a href='javascript:void(0)'>Next</a></li>");
			}else{
				pageNavHtml.append("<li><a href='javascript:void(0)' onclick='gotoPage("+(currentPage  + 1)+")'>Next</a></li>");
			}
            
		}
		
		return pageNavHtml.toString();
	}
}
