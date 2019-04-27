package Ppf.common;

import java.util.List;

public class PageModel<T> {
	
	
	private int totalPage;//总页数
	private int currentPage;//当前页
	private boolean hasbefore;//是否有上一页
	private boolean hasnext;//是否有下一页
	private List<T> date;//本页数据                         //数据是泛型
	
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public boolean isHasbefore() {
		return hasbefore;
	}
	public void setHasbefore(boolean hasbefore) {
		this.hasbefore = hasbefore;
	}
	public boolean isHasnext() {
		return hasnext;
	}
	public void setHasnext(boolean hasnext) {
		this.hasnext = hasnext;
	}
	public List<T> getDate() {
		return date;
	}
	public void setDate(List<T> date) {
		this.date = date;
	}
	
	public String toString() {
		return "PageModel [totalPage=" + totalPage + ", currentPage=" + currentPage + ", hasbefore=" + hasbefore
				+ ", hasnext=" + hasnext + ", data=" + date + "]";
	}
	
}
