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
//		String query = request().getQueryString();
//		path = request().getServletPath();
		System.out.println(path+"?page="+page);
		if(pageMax == 0){
			pageMax = 1;
			System.out.println("pageMax没有赋值");
		}
		if(page > pageMax){
			page = pageMax;
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
	/**
	 * 方法
1、getAuthType
public   String   getAuthType();
返回这个请求的身份验证模式。
2、getCookies
public   Cookie[]   getCookies();
返回一个数组，该数组包含这个请求中当前的所有cookie。如果这个请求中没有cookie，返回一个空数组。
3、getDateHeader
public   long   getDateHeader(String   name);
返回指定的请求头域的值，这个值被转换成一个反映自1970-1-1日（GMT）以来的精确到毫秒的长整数。
如果头域不能转换，抛出一个IllegalArgumentException。如果这个请求头域不存在，这个方法返回-1。
4、getHeader
public   String   getHeader(String   name);
返回一个请求头域的值。（译者注：与上一个方法不同的是，该方法返回一个字符串）
如果这个请求头域不存在，这个方法返回-1。
5、getHeaderNames
public   Enumeration   getHeaderNames();
该方法返回一个String对象的列表，该列表反映请求的所有头域名。
有的引擎可能不允许通过这种方法访问头域，在这种情况下，这个方法返回一个空的列表。
6、getIntHeader
public   int   getIntHeader(String   name);
返回指定的请求头域的值，这个值被转换成一个整数。
如果头域不能转换，抛出一个IllegalArgumentException。如果这个请求头域不存在，这个方法返回-1。
7、getMethod
public   String   getMethod();
返回这个请求使用的HTTP方法（例如：GET、POST、PUT）
8、getPathInfo
public   String   getPathInfo();
这个方法返回在这个请求的URL的Servlet路径之后的请求URL的额外的路径信息。如果这个请求URL包括一个查询字符串，在返回值内将不包括这个查询字符串。这个路径在返回之前必须经过URL解码。如果在这个请求的URL的Servlet路径之后没有路径信息。这个方法返回空值。
9、getPathTranslated
public   String   getPathTranslated();
这个方法获得这个请求的URL的Servlet路径之后的额外的路径信息，并将它转换成一个真实的路径。在进行转换前，这个请求的URL必须经过URL解码。如果在这个URL的Servlet路径之后没有附加路径信息。这个方法返回空值。
10、getQueryString
public   String   getQueryString();
返回这个请求URL所包含的查询字符串。一个查询字串符在一个URL中由一个“？”引出。如果没有查询字符串，这个方法返回空值。
11、getRemoteUser
public   String   getRemoteUser
返回作了请求的用户名，这个信息用来作HTTP用户论证。
如果在请求中没有用户名信息，这个方法返回空值。
12、getRequestedSessionId
public   String   getRequestedSessionId();
返回这个请求相应的session   id。如果由于某种原因客户端提供的session   id是无效的，这个session   id将与在当前session中的session   id不同，与此同时，将建立一个新的session。
如果这个请求没与一个session关联，这个方法返回空值。
13、getRequestURI
public   String   getRequestURI();
从HTTP请求的第一行返回请求的URL中定义被请求的资源的部分。如果有一个查询字符串存在，这个查询字符串将不包括在返回值当中。例如，一个请求通过/catalog/books?id=1这样的URL路径访问，这个方法将返回/catalog/books。这个方法的返回值包括了Servlet路径和路径信息。
如果这个URL路径中的的一部分经过了URL编码，这个方法的返回值在返回之前必须经过解码。
14、getServletPath
public   String   getServletPath();
这个方法返回请求URL反映调用Servlet的部分。例如，一个Servlet被映射到/catalog/summer这个URL路径，而一个请求使用了/catalog/summer/casual这样的路径。所谓的反映调用Servlet的部分就是指/catalog/summer。
如果这个Servlet不是通过路径匹配来调用。这个方法将返回一个空值。
15、getSession
public   HttpSession   getSession();
public   HttpSession   getSession(boolean   create);
返回与这个请求关联的当前的有效的session。如果调用这个方法时没带参数，那么在没有session与这个请求关联的情况下，将会新建一个session。如果调用这个方法时带入了一个布尔型的参数，只有当这个参数为真时，session才会被建立。
为了确保session能够被完全维持。Servlet开发者必须在响应被提交之前调用该方法。
如果带入的参数为假，而且没有session与这个请求关联。这个方法会返回空值。
16、isRequestedSessionIdValid
public   boolean   isRequestedSessionIdValid();
这个方法检查与此请求关联的session当前是不是有效。如果当前请求中使用的session无效，它将不能通过getSession方法返回。
17、isRequestedSessionIdFromCookie
public   boolean   isRequestedSessionIdFromCookie();
如果这个请求的session   id是通过客户端的一个cookie提供的，该方法返回真，否则返回假。
18、isRequestedSessionIdFromURL
public   boolean   isRequestedSessionIdFromURL();
如果这个请求的session   id是通过客户端的URL的一部分提供的，该方法返回真，否则返回假。请注意此方法与isRequestedSessionIdFromUrl在URL的拼写上不同。
以下方法将被取消
19、isRequestedSessionIdFromUrl
public   boolean   isRequestedSessionIdFromUrl();
该方法被isRequestedSessionIdFromURL代替。
	 */
}
