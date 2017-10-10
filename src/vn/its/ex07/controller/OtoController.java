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

import vn.its.ex07.dao.OtoDAOImp;
import vn.its.ex07.model.Oto;
import vn.its.ex07.model.Oto.BaoHiem;
import vn.its.ex07.model.Oto.HangSanXuat;

@WebServlet("/OtoController")
public class OtoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String OTO_FROM = "/admin/oto_form.jsp";
	private static String OTO_FROM_UPDATE = "/admin/oto_form_update.jsp";
	private static String OTO_LIST = "/admin/oto_list.jsp";
	private static String OTO_DETAIL = "/admin/oto_detail.jsp";
	private Oto oto;
	private OtoDAOImp otoDAOImp;

	public OtoController() {
		super();
		oto = new Oto();
		otoDAOImp = new OtoDAOImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String forward = "";
		String action = request.getParameter("action");
		String id = request.getParameter("maXe");
		try {
			if (action.equalsIgnoreCase("delete")) {
				int maXe = Integer.parseInt(id);
				otoDAOImp.delete(maXe);
				forward = OTO_LIST;
				request.setAttribute("otos", otoDAOImp.getAllOto());
			} else if (action.equalsIgnoreCase("updateGet")) {
				forward = OTO_FROM_UPDATE;
				int maXe = Integer.parseInt(id);
				oto = otoDAOImp.getOtoByBKS(maXe);
				request.setAttribute("oto", oto);
			} else if (action.equalsIgnoreCase("insuranceA")) {
				int maXe = Integer.parseInt(id);
				otoDAOImp.insuranceA(maXe);
				;
				forward = OTO_LIST;
				request.setAttribute("otos", otoDAOImp.getAllOto());
			} else if (action.equalsIgnoreCase("insuranceB")) {
				int maXe = Integer.parseInt(id);
				otoDAOImp.insuranceB(maXe);
				;
				forward = OTO_LIST;
				request.setAttribute("otos", otoDAOImp.getAllOto());
			} else if (action.equalsIgnoreCase("insuranceC")) {
				int maXe = Integer.parseInt(id);
				otoDAOImp.insuranceC(maXe);
				;
				forward = OTO_LIST;
				request.setAttribute("otos", otoDAOImp.getAllOto());
			} else if (action.equalsIgnoreCase("detail")) {
				forward = OTO_DETAIL;
				int maXe = Integer.parseInt(id);
				oto = otoDAOImp.getOtoByBKS(maXe);
				request.setAttribute("oto", oto);
			} else if (action.equalsIgnoreCase("otoList")) {
				forward = OTO_LIST;
				request.setAttribute("otos", otoDAOImp.getAllOto());
			} else if (action.equalsIgnoreCase("otoListDoiMoi")) {
				forward = OTO_LIST;
				request.setAttribute("otos", otoDAOImp.getDoiMoi());
			} else if (action.equalsIgnoreCase("otoListDoiTrung")) {
				forward = OTO_LIST;
				request.setAttribute("otos", otoDAOImp.getDoiTrung());
			} else if (action.equalsIgnoreCase("otoListDoiCu")) {
				forward = OTO_LIST;
				request.setAttribute("otos", otoDAOImp.getDoiCu());
			} else {
				forward = OTO_FROM;
			}
		} catch (Exception ex) {
			forward = OTO_LIST;
			Logger.getLogger(OtoController.class.getName()).log(Level.SEVERE, null, ex);
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String forward = "";
		String action = request.getParameter("action");
		String bks = request.getParameter("bienKiemSoat");
		String tenXe = request.getParameter("tenXe");
		String nsx = request.getParameter("namSanXuat");
		String hangSanXuat = request.getParameter("hangSanXuat");
		String baoHiem = request.getParameter("baoHiem");
		String ghiChu = request.getParameter("ghiChu");
		String id = request.getParameter("maXe");
		int bienKiemSoat = Integer.parseInt(bks);
		oto.setBienKiemSoat(bienKiemSoat);
		oto.setTenXe(tenXe);
		try {
			Date namSanXuat = new SimpleDateFormat("dd-MM-yyyy").parse(nsx);
			oto.setNamSanXuat(namSanXuat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		oto.setHangSanXuat(HangSanXuat.valueOf(hangSanXuat));
		oto.setBaoHiem(BaoHiem.valueOf(baoHiem));
		oto.setGhiChu(ghiChu);
		try {
			switch (action) {
			case "createPost":
				if (id == null || id.isEmpty()) {
					otoDAOImp.create(oto);
					forward = OTO_LIST;
				}
				break;
			case "updatePost":
				int maXe3 = Integer.parseInt(id);
				oto.setMaXe(maXe3);
				otoDAOImp.update(oto);
				forward = OTO_LIST;
				break;
			}
			switch (action) {
			case "createPost":
				forward = OTO_FROM;
				break;
			case "updatePost":
				forward = OTO_FROM_UPDATE;
				break;
			}

		} catch (Exception ex) {
			Logger.getLogger(OtoController.class.getName()).log(Level.SEVERE, null, ex);
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		request.setAttribute("otos", otoDAOImp.getAllOto());
		rd.forward(request, response);
	}
}
