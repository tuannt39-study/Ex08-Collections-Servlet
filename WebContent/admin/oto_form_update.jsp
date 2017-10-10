<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form OTO Update</title>
</head>
<body>
	<form method="POST" action='OtoController' name="frmEditOto">
		<input type="hidden" readonly="readonly" name="maXe" value="<c:out value="${oto.maXe}" />" /> <br />
		Bien Kiem Soat : <input type="text" name="bienKiemSoat" value="<c:out value="${oto.bienKiemSoat}" />" /> <br />
		Ten Xe : <input type="text" name="tenXe" value="<c:out value="${oto.tenXe}" />" /> <br />
		Nam San Xuat : <input type="text" name="namSanXuat" value="<fmt:formatDate pattern="dd-MM-yyyy" value="${oto.namSanXuat}" />" /> <br />
		Hang San Xuat :
			<select id="hangSanXuat" name="hangSanXuat">
				<option>BMW</option>
				<option>TOYOTA</option>
				<option>HYUNDAI</option>
			</select> <br />
		Bao Hiem :
			<select id="baoHiem" name="baoHiem">
				<option>NO</option>
				<option>A</option>
				<option>B</option>
				<option>C</option>
			</select> <br />
		Ghi Chu : <input type="text" name="ghiChu" value="<c:out value="${oto.ghiChu}" />" /> <br />
		<input type="hidden" name="action" value="updatePost">
		<input type="submit" value="Xac Nhan" />
	</form>
</body>
</html>