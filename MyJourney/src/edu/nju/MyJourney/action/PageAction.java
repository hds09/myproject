package edu.nju.MyJourney.action;
/**
 * 处理分页显示
 * @author softwware
 *
 */
public class PageAction extends BaseAction{
	protected int page;
	protected int pageMax;
	protected String path;
	@Override
	public String execute() throws Exception {
		String result = SUCCESS;
		path = request().getRequestURI()+"?page=";
		System.out.println(path+"?page="+page);
		if(pageMax == 0){
			pageMax = 1;
			System.out.println("pageMax没有赋值");
		}
		if(page > pageMax-1){
			page = pageMax-1;
		}
		return result;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageMax() {
		return pageMax;
	}
	public void setPageMax(int pageMax) {
		this.pageMax = pageMax;
	}
	public String getPath() {
		//path = request().getRequestURI()+"?page=";
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
