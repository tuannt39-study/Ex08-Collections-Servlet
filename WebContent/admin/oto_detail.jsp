<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DETAIL OTO</title>
</head>
<body>
		Ma Xe : <c:out value="${oto.maXe}" /> <br />
		Bien Kiem Soat : <c:out value="${oto.bienKiemSoat}" /> <br />
		Ten Xe : <c:out value="${oto.tenXe}" /> <br />
		Nam San Xuat : <fmt:formatDate pattern="dd-MM-yyyy" value="${oto.namSanXuat}" /> <br />
		Hang San Xuat : <c:out value="${oto.hangSanXuat}" /> <br />
		Bao Hiem : <c:out value="${oto.baoHiem}" /> <br />
		Ghi Chu : <c:out value="${oto.ghiChu}" />
</body>
</html>