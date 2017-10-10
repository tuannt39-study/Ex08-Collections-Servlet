package vn.its.ex07.dao;

import java.util.ArrayList;

import vn.its.ex07.model.Oto;

public interface OtoDAO {

	ArrayList<Oto> getAllOto();

	ArrayList<Oto> getDoiMoi();

	ArrayList<Oto> getDoiTrung();

	ArrayList<Oto> getDoiCu();

	Oto getOtoByBKS(int maXe);

	void create(Oto oto);

	void update(Oto oto);

	void delete(int maXe);

	void insuranceA(int maXe);

	void insuranceB(int maXe);

	void insuranceC(int maXe);
}
