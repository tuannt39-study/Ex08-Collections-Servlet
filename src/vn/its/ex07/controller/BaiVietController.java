package vn.its.ex07.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.its.ex07.dao.BaiVietDAOImp;
import vn.its.ex07.model.BaiViet;

@WebServlet("/BaiVietController")
public class BaiVietController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String BV_FROM = "/admin/bv_form.jsp";
	private static String BV_LIST = "/admin/bv_list.jsp";
	private static String BV_LIST_ALL = "/admin/bv_list_pagination.jsp";
	private static String BV_PAGES = "/admin/bv_list_pages.jsp";
	private static String BV_DETAIL = "/admin/bv_detail.jsp";
	private BaiVietDAOImp baiVietDAOImp;
	private BaiViet baiViet;

	public BaiVietController() {
		super();
		baiVietDAOImp = new BaiVietDAOImp();
		baiViet = new BaiViet();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String forward = "";
		String action = request.getParameter("action");
		String id = request.getParameter("maBV");
		try {
			if (action.equalsIgnoreCase("delete")) {
				int maBV = Integer.parseInt(id);
				baiVietDAOImp.delete(maBV);
				forward = BV_LIST;
				request.setAttribute("baiViets", baiVietDAOImp.getAllBaiViet());
			} else if (action.equalsIgnoreCase("updateDuyet")) {
				int maBV = Integer.parseInt(id);
				baiVietDAOImp.duyet(maBV);
				forward = BV_LIST;
				request.setAttribute("baiViets", baiVietDAOImp.getAllBaiViet());
			} else if (action.equalsIgnoreCase("updateChan")) {
				int maBV = Integer.parseInt(id);
				baiVietDAOImp.chan(maBV);
				forward = BV_LIST;
				request.setAttribute("baiViets", baiVietDAOImp.getAllBaiViet());
			} else if (action.equalsIgnoreCase("update")) {
				forward = BV_FROM;
				int maBV = Integer.parseInt(id);
				baiViet = baiVietDAOImp.getBaiVietByMaBV(maBV);
				request.setAttribute("baiViet", baiViet);
			} else if (action.equalsIgnoreCase("detail")) {
				forward = BV_DETAIL;
				int maBV = Integer.parseInt(id);
				baiViet = baiVietDAOImp.getBaiVietByMaBV(maBV);
				request.setAttribute("baiViet", baiViet);
			} else if (action.equalsIgnoreCase("baiVietList")) {
				forward = BV_LIST;
				request.setAttribute("baiViets", baiVietDAOImp.getAllBaiViet());
			} else if (action.equalsIgnoreCase("baiVietListPagination")) {
				forward = BV_LIST_ALL;
				request.setAttribute("baiViets", baiVietDAOImp.getAllBaiViet());
			} else if (action.equalsIgnoreCase("baiVietPagination")) {
				forward = BV_PAGES;
				request.setAttribute("baiViets", baiVietDAOImp.getAllBaiViet());
			} else {
				forward = BV_FROM;
			}
		} catch (Exception ex) {
			forward = BV_LIST;
			Logger.getLogger(BaiVietController.class.getName()).log(Level.SEVERE, null, ex);
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String forward = "";
		String tieuDe = request.getParameter("tieuDe");
		String danhMuc = request.getParameter("danhMuc");
		String chiTiet = request.getParameter("chiTiet");
		String lich = request.getParameter("lichDang");
		String trangThai = request.getParameter("trangThai");
		String nhan = request.getParameter("nhan");
		String id = request.getParameter("maBV");
		baiViet.setTieuDe(tieuDe);
		baiViet.setDanhMuc(danhMuc);
		baiViet.setChiTiet(chiTiet);
		try {
			Date lichDang = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(lich);
			baiViet.setLichDang(lichDang);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		baiViet.setTrangThai(trangThai);
		baiViet.setNhan(nhan);
		try {
			if (id == null || id.isEmpty()) {
				baiVietDAOImp.create(baiViet);
				forward = BV_LIST;
			} else {
				int maBV = Integer.parseInt(id);
				baiViet.setMaBV(maBV);
				baiVietDAOImp.update(baiViet);
				forward = BV_LIST;
			}
		} catch (Exception ex) {
			Logger.getLogger(BaiVietController.class.getName()).log(Level.SEVERE, null, ex);
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		request.setAttribute("baiViets", baiVietDAOImp.getAllBaiViet());
		rd.forward(request, response);
	}
}
