<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List BAIVIET ALL</title>
</head>
<body>
	<c:forEach items="${baiViets}" var="baiViet">
		TieuDe: <br /> <c:out value="${baiViet.tieuDe}" /> <br />
		DanhMuc: <br /> <c:out value="${baiViet.danhMuc}" /> <br />
		ChiTiet: <br /> <c:out value="${baiViet.chiTiet}" /> <br />
		LichDang: <br /> <fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${baiViet.lichDang}" /> <br />
		TrangThai: <br /> <c:out value="${baiViet.trangThai}" /> <br />
		Nhan: <br /> <c:out value="${baiViet.nhan}" /> <br />
	<p>---</p>
	</c:forEach>
</body>
</html>