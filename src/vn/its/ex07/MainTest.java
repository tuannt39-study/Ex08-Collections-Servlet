package vn.its.ex07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import vn.its.ex07.dao.BaiVietDAOImp;
import vn.its.ex07.dao.OtoDAOImp;
import vn.its.ex07.model.BaiViet;
import vn.its.ex07.model.Oto;

public class MainTest {
	public static void main(String[] args) throws ParseException {
		BaiVietDAOImp bv = new BaiVietDAOImp();
		
		for (BaiViet bbb : bv.getAllBaiViet()) {
			System.out.println(bbb.getChiTiet());
		}
		
		System.out.println(bv.getBaiVietByMaBV(4).getChiTiet());

		String lich = "15-09-2017 10:02:44";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		BaiViet baiViet = new BaiViet();
		Date abc = sdf.parse(lich);
		
		Date lichDang = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(lich);
		baiViet.setLichDang(lichDang);
		System.out.println(baiViet.getLichDang());
		System.out.println(abc);
		
		OtoDAOImp oto = new OtoDAOImp();
		for (Oto ttt : oto.getDoiCu()) {
			System.out.println(ttt.getMaXe());
		}
		
		System.out.println(bv.countAllBaiViet());
		
		System.out.println(bv.getAllByPages(3, 8));
		
	}
}
