import static org.junit.Assert.*;
/*
 * �κ��� for JUnit Fest-Swing GUI����
 */
import org.fest.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HInputFlightTest {
	DialogFixture jfDlg; //���Զ�Ӧ�ĶԻ���
	HInputFlight hif; //��������ܹ���ȡ�ö����ֵ��  
	@Before
	public void setUp() throws Exception {
		hif = new HInputFlight(null,"���ԣ����뺽����������");
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
	
	//��������һ���������λ��Ŀ
	//ʹ�õĲ��Լ�������������
	@Test
	public void testSeatForAddFlight() {
		/*��һ���������������ԣ���λ��������0-9������ַ���Ҳ����	
		 *   �ڷ���private boolean ValidSeat()��
		 *   ��������catch(Exception e)���档
		 *ע�⣺���������������ȷ��������β���ValidSeat	
		 */
		jfDlg.textBox("txtIDFest").setText("93687");
		jfDlg.textBox("txtFnameFest").setText("YE4002");
		jfDlg.textBox("txtCompanyFest").setText("Hguohang");
		jfDlg.textBox("txtPriceFest").setText("800.5");
		jfDlg.textBox("txtSeatFest").setText("126.0");
		jfDlg.button("btnOKFest").click();
		assertEquals(false,hif.GetValidFlight());
		/*�ڶ����������������ԣ���λ������С��100��
		 *ע�⣺���������������ȷ��������β���ValidSeat	
		 */		
		jfDlg.textBox("txtIDFest").setText("93687");
		jfDlg.textBox("txtFnameFest").setText("YE4002");
		jfDlg.textBox("txtCompanyFest").setText("Hguohang");
		jfDlg.textBox("txtPriceFest").setText("800.5");
		jfDlg.textBox("txtSeatFest").setText("98");
		jfDlg.button("btnOKFest").click();
		assertEquals(false,hif.GetValidFlight());
		/*�������������������ԣ���λ�����ܴ���100��
		 *ע�⣺���������������ȷ��������β���ValidSeat	
		 */		
		jfDlg.textBox("txtIDFest").setText("93687");
		jfDlg.textBox("txtFnameFest").setText("YE4002");
		jfDlg.textBox("txtCompanyFest").setText("Hguohang");
		jfDlg.textBox("txtPriceFest").setText("800.5");
		jfDlg.textBox("txtSeatFest").setText("298");
		jfDlg.button("btnOKFest").click();
		assertEquals(false,hif.GetValidFlight());
		/*���ĸ��������������ԣ���λ�����ܴ���100��
		 *ע�⣺���������������ȷ��������β���ValidSeat	
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
