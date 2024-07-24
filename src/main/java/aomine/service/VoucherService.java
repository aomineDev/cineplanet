package aomine.service;

import java.util.ArrayList;

import aomine.db.CineplanetDB;
import aomine.model.Voucher;

public class VoucherService {
  private ArrayList<Voucher> voucherList;

  public VoucherService() {
    voucherList = CineplanetDB.getInstance().getVoucherList();
  }

  public ArrayList<Voucher> getAll() {
    ArrayList<Voucher> voucherListCloned = new ArrayList<>(voucherList);

    return voucherListCloned;
  }

  public void create(Voucher voucher) {
    voucherList.add(voucher);
  }
}
