package vn.its.ex07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import vn.its.ex07.connect.DatabaseConnect;
import vn.its.ex07.model.Oto;
import vn.its.ex07.model.Oto.BaoHiem;
import vn.its.ex07.model.Oto.HangSanXuat;

public class OtoDAOImp implements OtoDAO {

	private Connection conn;

	public OtoDAOImp() {
		super();
		this.conn = DatabaseConnect.getConnection();
	}

	@Override
	public ArrayList<Oto> getAllOto() {
		ArrayList<Oto> list = new ArrayList<Oto>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String getAllOto = "SELECT MAXE, BIENKIEMSOAT, TENXE, NAMSANXUAT, HANGSANXUAT, BAOHIEM, GHICHU "
					+ "FROM ITSOL.OTO ORDER BY MAXE";
			pstm = conn.prepareStatement(getAllOto);
			rs = pstm.executeQuery();
			while (rs.next()) {
				int maXe = rs.getInt("maXe");
				int bienKiemSoat = rs.getInt("bienKiemSoat");
				String tenXe = rs.getString("tenXe");
				Date namSanXuat = rs.getDate("namSanXuat");
				HangSanXuat hangSanXuat = HangSanXuat.valueOf(rs.getString("hangSanXuat"));
				BaoHiem baoHiem = BaoHiem.valueOf(rs.getString("baoHiem"));
				String ghiChu = rs.getString("ghiChu");
				Oto oto = new Oto();
				oto.setMaXe(maXe);
				oto.setBienKiemSoat(bienKiemSoat);
				oto.setTenXe(tenXe);
				oto.setNamSanXuat(namSanXuat);
				oto.setHangSanXuat(hangSanXuat);
				oto.setBaoHiem(baoHiem);
				oto.setGhiChu(ghiChu);
				list.add(oto);
			}
		} catch (SQLException ex) {
			Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return list;
	}

	@Override
	public ArrayList<Oto> getDoiMoi() {
		ArrayList<Oto> list = new ArrayList<Oto>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String getDoiMoi = "SELECT MAXE, BIENKIEMSOAT, TENXE, NAMSANXUAT, HANGSANXUAT, BAOHIEM, GHICHU "
					+ "FROM ITSOL.OTO " + "WHERE NAMSANXUAT >= TO_DATE('01-01-2005', 'dd-MM-yyyy')";
			pstm = conn.prepareStatement(getDoiMoi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				int maXe = rs.getInt("maXe");
				int bienKiemSoat = rs.getInt("bienKiemSoat");
				String tenXe = rs.getString("tenXe");
				Date namSanXuat = rs.getDate("namSanXuat");
				HangSanXuat hangSanXuat = HangSanXuat.valueOf(rs.getString("hangSanXuat"));
				BaoHiem baoHiem = BaoHiem.valueOf(rs.getString("baoHiem"));
				String ghiChu = rs.getString("ghiChu");
				Oto oto = new Oto();
				oto.setMaXe(maXe);
				oto.setBienKiemSoat(bienKiemSoat);
				oto.setTenXe(tenXe);
				oto.setNamSanXuat(namSanXuat);
				oto.setHangSanXuat(hangSanXuat);
				oto.setBaoHiem(baoHiem);
				oto.setGhiChu(ghiChu);
				list.add(oto);
			}
		} catch (SQLException ex) {
			Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return list;
	}

	@Override
	public ArrayList<Oto> getDoiTrung() {
		ArrayList<Oto> list = new ArrayList<Oto>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String getDoiMoi = "SELECT MAXE, BIENKIEMSOAT, TENXE, NAMSANXUAT, HANGSANXUAT, BAOHIEM, GHICHU "
					+ "FROM ITSOL.OTO " + "WHERE NAMSANXUAT >= TO_DATE('01-01-1996', 'dd-MM-yyyy') "
					+ "AND NAMSANXUAT <= TO_DATE('31-12-2004','dd-MM-yyyy')";
			pstm = conn.prepareStatement(getDoiMoi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				int maXe = rs.getInt("maXe");
				int bienKiemSoat = rs.getInt("bienKiemSoat");
				String tenXe = rs.getString("tenXe");
				Date namSanXuat = rs.getDate("namSanXuat");
				HangSanXuat hangSanXuat = HangSanXuat.valueOf(rs.getString("hangSanXuat"));
				BaoHiem baoHiem = BaoHiem.valueOf(rs.getString("baoHiem"));
				String ghiChu = rs.getString("ghiChu");
				Oto oto = new Oto();
				oto.setMaXe(maXe);
				oto.setBienKiemSoat(bienKiemSoat);
				oto.setTenXe(tenXe);
				oto.setNamSanXuat(namSanXuat);
				oto.setHangSanXuat(hangSanXuat);
				oto.setBaoHiem(baoHiem);
				oto.setGhiChu(ghiChu);
				list.add(oto);
			}
		} catch (SQLException ex) {
			Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return list;
	}

	@Override
	public ArrayList<Oto> getDoiCu() {
		ArrayList<Oto> list = new ArrayList<Oto>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String getDoiMoi = "SELECT MAXE, BIENKIEMSOAT, TENXE, NAMSANXUAT, HANGSANXUAT, BAOHIEM, GHICHU "
					+ "FROM ITSOL.OTO " + "WHERE NAMSANXUAT <= TO_DATE('31-12-1995', 'dd-MM-yyyy')";
			pstm = conn.prepareStatement(getDoiMoi);
			rs = pstm.executeQuery();
			while (rs.next()) {
				int maXe = rs.getInt("maXe");
				int bienKiemSoat = rs.getInt("bienKiemSoat");
				String tenXe = rs.getString("tenXe");
				Date namSanXuat = rs.getDate("namSanXuat");
				HangSanXuat hangSanXuat = HangSanXuat.valueOf(rs.getString("hangSanXuat"));
				BaoHiem baoHiem = BaoHiem.valueOf(rs.getString("baoHiem"));
				String ghiChu = rs.getString("ghiChu");
				Oto oto = new Oto();
				oto.setMaXe(maXe);
				oto.setBienKiemSoat(bienKiemSoat);
				oto.setTenXe(tenXe);
				oto.setNamSanXuat(namSanXuat);
				oto.setHangSanXuat(hangSanXuat);
				oto.setBaoHiem(baoHiem);
				oto.setGhiChu(ghiChu);
				list.add(oto);
			}
		} catch (SQLException ex) {
			Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return list;
	}

	@Override
	public Oto getOtoByBKS(int maXe) {
		Oto oto = new Oto();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String getOtoByBKS = "SELECT MAXE, BIENKIEMSOAT, TENXE, NAMSANXUAT, HANGSANXUAT, BAOHIEM, GHICHU FROM ITSOL.OTO "
					+ "WHERE MAXE = ?";
			pstm = conn.prepareStatement(getOtoByBKS);
			pstm.setInt(1, maXe);
			rs = pstm.executeQuery();
			if (rs.next()) {
				maXe = rs.getInt("maXe");
				int bienKiemSoat = rs.getInt("bienKiemSoat");
				String tenXe = rs.getString("tenXe");
				Date namSanXuat = rs.getDate("namSanXuat");
				HangSanXuat hangSanXuat = HangSanXuat.valueOf(rs.getString("hangSanXuat"));
				BaoHiem baoHiem = BaoHiem.valueOf(rs.getString("baoHiem"));
				String ghiChu = rs.getString("ghiChu");
				oto.setMaXe(maXe);
				oto.setBienKiemSoat(bienKiemSoat);
				oto.setTenXe(tenXe);
				oto.setNamSanXuat(namSanXuat);
				oto.setHangSanXuat(hangSanXuat);
				oto.setBaoHiem(baoHiem);
				oto.setGhiChu(ghiChu);
			}
		} catch (SQLException ex) {
			Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				rs.close();
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return oto;
	}

	@Override
	public void create(Oto oto) {
		PreparedStatement pstm = null;
		try {
			String create = "INSERT INTO ITSOL.OTO (BIENKIEMSOAT, TENXE, NAMSANXUAT, HANGSANXUAT, BAOHIEM, GHICHU) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			pstm = conn.prepareStatement(create);
			int bienKiemSoat = oto.getBienKiemSoat();
			String tenXe = oto.getTenXe();
			HangSanXuat hangSanXuat = oto.getHangSanXuat();
			BaoHiem baoHiem = oto.getBaoHiem();
			String ghiChu = oto.getGhiChu();
			pstm.setInt(1, bienKiemSoat);
			pstm.setString(2, tenXe);
			pstm.setDate(3, new java.sql.Date(oto.getNamSanXuat().getTime()));
			pstm.setString(4, hangSanXuat.name());
			pstm.setString(5, baoHiem.name());
			pstm.setString(6, ghiChu);
			pstm.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public void update(Oto oto) {
		PreparedStatement pstm = null;
		try {
			String update = "UPDATE ITSOL.OTO "
					+ "SET BIENKIEMSOAT = ?, TENXE = ?, NAMSANXUAT = ?, HANGSANXUAT = ?, BAOHIEM = ?, GHICHU = ? "
					+ "WHERE MAXE = ?";
			pstm = conn.prepareStatement(update);
			int bienKiemSoat = oto.getBienKiemSoat();
			String tenXe = oto.getTenXe();
			HangSanXuat hangSanXuat = oto.getHangSanXuat();
			BaoHiem baoHiem = oto.getBaoHiem();
			String ghiChu = oto.getGhiChu();
			int maXe = oto.getMaXe();
			pstm.setInt(1, bienKiemSoat);
			pstm.setString(2, tenXe);
			pstm.setDate(3, new java.sql.Date(oto.getNamSanXuat().getTime()));
			pstm.setString(4, hangSanXuat.name());
			pstm.setString(5, baoHiem.name());
			pstm.setString(6, ghiChu);
			pstm.setInt(7, maXe);
			pstm.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public void delete(int maXe) {
		PreparedStatement pstm = null;
		try {
			String delete = "DELETE FROM ITSOL.OTO " + "WHERE MAXE = ?";
			pstm = conn.prepareStatement(delete);
			pstm.setInt(1, maXe);
			pstm.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(OtoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public void insuranceA(int maXe) {
		PreparedStatement pstm = null;
		try {
			String duyet = "UPDATE ITSOL.OTO " + "SET BAOHIEM = 'A' WHERE maXe = ?";
			pstm = conn.prepareStatement(duyet);
			pstm.setInt(1, maXe);
			pstm.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public void insuranceB(int maXe) {
		PreparedStatement pstm = null;
		try {
			String duyet = "UPDATE ITSOL.OTO " + "SET BAOHIEM = 'B' WHERE maXe = ?";
			pstm = conn.prepareStatement(duyet);
			pstm.setInt(1, maXe);
			pstm.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public void insuranceC(int maXe) {
		PreparedStatement pstm = null;
		try {
			String duyet = "UPDATE ITSOL.OTO " + "SET BAOHIEM = 'C' WHERE maXe = ?";
			pstm = conn.prepareStatement(duyet);
			pstm.setInt(1, maXe);
			pstm.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(BaiVietDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
