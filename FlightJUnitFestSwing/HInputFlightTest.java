import static org.junit.Assert.*;
/*
 * 何海江 for JUnit Fest-Swing GUI测试
 */
import org.fest.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HInputFlightTest {
	DialogFixture jfDlg; //测试对应的对话框。
	HInputFlight hif; //被测对象，能够获取该对象的值。  
	@Before
	public void setUp() throws Exception {
		hif = new HInputFlight(null,"测试：输入航班的相关数据");
		jfDlg = new DialogFixture( hif );
		jfDlg.show();
	}

	@After
	public void tearDown() throws Exception {
		hif.dispose();
		jfDlg.cleanUp();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	//测试增加一个航班的座位数目
	//使用的测试技术：条件覆盖
	@Test
	public void testSeatForAddFlight() {
		/*第一个测试用例，测试：座位数不能有0-9以外的字符，也就是	
		 *   在方法private boolean ValidSeat()内
		 *   可以跳到catch(Exception e)里面。
		 *注意：其它输入项必须正确，否则，如何测试ValidSeat	
		 */
		jfDlg.textBox("txtIDFest").setText("93687");
		jfDlg.textBox("txtFnameFest").setText("YE4002");
		jfDlg.textBox("txtCompanyFest").setText("Hguohang");
		jfDlg.textBox("txtPriceFest").setText("800.5");
		jfDlg.textBox("txtSeatFest").setText("126.0");
		jfDlg.button("btnOKFest").click();
		assertEquals(false,hif.GetValidFlight());
		/*第二个测试用例，测试：座位数不能小于100。
		 *注意：其它输入项必须正确，否则，如何测试ValidSeat	
		 */		
		jfDlg.textBox("txtIDFest").setText("93687");
		jfDlg.textBox("txtFnameFest").setText("YE4002");
		jfDlg.textBox("txtCompanyFest").setText("Hguohang");
		jfDlg.textBox("txtPriceFest").setText("800.5");
		jfDlg.textBox("txtSeatFest").setText("98");
		jfDlg.button("btnOKFest").click();
		assertEquals(false,hif.GetValidFlight());
		/*第三个测试用例，测试：座位数不能大于100。
		 *注意：其它输入项必须正确，否则，如何测试ValidSeat	
		 */		
		jfDlg.textBox("txtIDFest").setText("93687");
		jfDlg.textBox("txtFnameFest").setText("YE4002");
		jfDlg.textBox("txtCompanyFest").setText("Hguohang");
		jfDlg.textBox("txtPriceFest").setText("800.5");
		jfDlg.textBox("txtSeatFest").setText("298");
		jfDlg.button("btnOKFest").click();
		assertEquals(false,hif.GetValidFlight());
		/*第四个测试用例，测试：座位数不能大于100。
		 *注意：其它输入项必须正确，否则，如何测试ValidSeat	
		 */		
		jfDlg.textBox("txtIDFest").setText("93687");
		jfDlg.textBox("txtFnameFest").setText("YE4002");
		jfDlg.textBox("txtCompanyFest").setText("Hguohang");
		jfDlg.textBox("txtPriceFest").setText("800.5");
		jfDlg.textBox("txtSeatFest").setText("128");
		jfDlg.button("btnOKFest").click();
		assertEquals(true,hif.GetValidFlight());
	}
}
