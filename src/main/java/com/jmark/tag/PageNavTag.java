package com.jmark.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.jmark.utils.PageUtil;
import com.jmark.utils.Pager;


public class PageNavTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	//传递要显示的页码数目
	private int pagination;
	
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter writer = this.pageContext.getOut();
		Pager pager = (Pager)pageContext.getRequest().getAttribute("pager");
		if(pager == null) {
			return SKIP_BODY;
		}
		try {
			writer.println(PageUtil.pageNavUtil(pager,pagination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	

	public int getPagination() {
		return pagination;
	}


	public void setPagination(int pagination) {
		this.pagination = pagination;
	}
}