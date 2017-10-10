<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form BAIVIET</title>
</head>
<body>
	<form method="POST" action='BaiVietController' name="frmAddBaiViet">
		MaBV : <input type="text" readonly="readonly" name="maBV" value="<c:out value="${baiViet.maBV}" />" /> <br /> 
		Tieu De : <input type="text" name="tieuDe" value="<c:out value="${baiViet.tieuDe}" />" /> <br />
		Danh Muc : <input type="text" name="danhMuc" value="<c:out value="${baiViet.danhMuc}" />" /> <br />
		Chi Tiet : <input type="text" name="chiTiet" value="<c:out value="${baiViet.chiTiet}" />" /> <br />
		Lich Dang : <input type="text" name="lichDang" value="<fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${baiViet.lichDang}" />" /> <br />
		Trang Thai :
			<select id="trangThai" name="trangThai">
			<option>Duyệt</option>
			<option>Đặt lịch</option>
			<option>Chặn</option>
			</select> <br />
		Nhan : <input type="text" name="nhan" value="<c:out value="${baiViet.nhan}" />" /> <br />
		<input type="submit" value="Xac Nhan" />
	</form>
</body>
</html>