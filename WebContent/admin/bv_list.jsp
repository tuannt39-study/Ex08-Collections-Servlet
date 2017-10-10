<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List BAIVIET</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>MaBV</th>
				<th>Tieu De</th>
				<th>Danh Muc</th>
				<th>Chi Tiet</th>
				<th>Lich Dang</th>
				<th>Trang Thai</th>
				<th>Nhan</th>
				<th colspan=5>Thao Tac</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${baiViets}" var="baiViet">
				<tr>
					<td><c:out value="${baiViet.maBV}" /></td>
					<td><c:out value="${baiViet.tieuDe}" /></td>
					<td><c:out value="${baiViet.danhMuc}" /></td>
					<td><c:out value="${baiViet.chiTiet}" /></td>
					<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${baiViet.lichDang}" /></td>
					<td><c:out value="${baiViet.trangThai}" /></td>
					<td><c:out value="${baiViet.nhan}" /></td>
					<td><button onclick="location.href='BaiVietController?action=updateDuyet&maBV=<c:out value="${baiViet.maBV}"/>'">Duyet</button></td>
					<td><button onclick="location.href='BaiVietController?action=updateChan&maBV=<c:out value="${baiViet.maBV}"/>'">Chan</button></td>
					<td><button onclick="location.href='BaiVietController?action=detail&maBV=<c:out value="${baiViet.maBV}"/>'">Chi Tiet</button></td>
					<td><button onclick="location.href='BaiVietController?action=update&maBV=<c:out value="${baiViet.maBV}"/>'">Cap Nhat</button></td>
					<td><button onclick="location.href='BaiVietController?action=delete&maBV=<c:out value="${baiViet.maBV}"/>'">Xoa</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<button onclick="location.href='BaiVietController?action=insert'">Them Bai Viet</button>
	</p>
	<p><a href="/Ex08/BaiVietController?action=baiVietListPagination">Tat Ca Bai Viet</a></p>
	<p><a href="/Ex08/BaiVietController?action=baiVietPagination&page=1">Bai Viet Phan Trang</a></p>
</body>
</html>