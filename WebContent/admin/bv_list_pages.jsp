<%@ page import="java.util.*,vn.its.ex07.dao.*,vn.its.ex07.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List BAIVIET PAGE</title>
</head>
<body>
	<%
		BaiVietDAOImp baiVietDAOImp = new BaiVietDAOImp();
		String spageid = request.getParameter("page");
		int firstResult = Integer.parseInt(spageid);
		int total = baiVietDAOImp.countAllBaiViet();
		int maxResult = 0;
		if (firstResult == 1) {
			maxResult = 5;
		} else {
			firstResult = (firstResult - 1) * 5 + 1;
		    maxResult = firstResult + 4;
		}
		ArrayList<BaiViet> list =  baiVietDAOImp.getAllByPages(firstResult, maxResult);
		for (BaiViet baiViet : list) {
	%>
	TieuDe: <br /> <%=baiViet.getTieuDe()%> <br />
	DanhMuc: <br /> <%=baiViet.getDanhMuc()%> <br />
	ChiTiet: <br /> <%=baiViet.getChiTiet()%> <br />
	LichDang: <br /> <%=baiViet.getLichDang()%> <br />
	TrangThai: <br /> <%=baiViet.getTrangThai()%> <br />
	Nhan: <br /> <%=baiViet.getNhan()%> <br />
	<p>---</p>
	<%
		}
		for(int i=1;i<=(total/5)+1;i++){
	%>
    <a href="/Ex08/BaiVietController?action=baiVietPagination&page=<%=i%>"><%=i%></a>
    <%
    	}
    %>
</body>
</html>