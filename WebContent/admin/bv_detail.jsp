<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DETAIL BAIVIET</title>
</head>
<body>
		MaBV : <c:out value="${baiViet.maBV}" /> <br />
		Tieu De : <c:out value="${baiViet.tieuDe}" /> <br />
		Danh Muc : <c:out value="${baiViet.danhMuc}" /> <br />
		Chi Tiet : <c:out value="${baiViet.chiTiet}" /> <br />
		Lich Dang : <fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${baiViet.lichDang}" /> <br />
		Trang Thai : <c:out value="${baiViet.trangThai}" /> <br />
		Nhan : <c:out value="${baiViet.nhan}" />
		
</body>
</html>