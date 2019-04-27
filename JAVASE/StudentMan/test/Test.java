import Ppf.Mybatis.imp.LoginDao;
import Ppf.dao.ILoginDao;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}
	public static void test1() {
		ILoginDao aa =LoginDao.getInstance();
		aa.findAdminByusernameAndPasseord("zs","admin");
	}
}
