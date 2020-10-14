/*
 *���ںںв��ԡ� 
 */
/**

	 * ���ǲ˵������¼������ࡣ�����ߣ��κ�����
	 * ����һ�����࣬ɾ��һ�����࣬ɾ�����к��ࡣ
	 * ���ļ���������Ϣ����������Ϣд���ļ�
	 * ��Ʊ��Ϊ��������,�Ժ��չ�˾����Ϊ��������
	 * ������ܽ���,����......
	 * 
	 * ע�⣺�������˺ܶ��鷳��������������HFlightInfo��HMenuAction֮�����ϡ�HFlightInfo��HMenuAction֮�����ϵʱ��ӵģ�
	 * ͨ��HManaFlightʵ�֡�
	 * ͬѧ�����Ժ�Ĵ����п���ѧϰ�����ķ�����
	 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class HMenuAction implements ActionListener{
	public static final String strReadFile = "���ļ���������";
	public static final String strWriteFile = "�������ݵ��ļ�";
	public static final String strAddFlight = "����һ������";
	public static final String strDelFlight = "ɾ��һ������";
	public static final String strRemoveAllFlight = "ɾ�����к���";
	public static final String strPriceSearch = "��Ʊ��Ϊ��������";
	public static final String strAirlineNameSearch = "�Ժ��չ�˾����Ϊ��������";
	public static final String strHelp ="������ܽ���";
	public static final String strAboutMe ="����......";
	private HManaFlight m_hmfDmana;  //���������
	private JTextArea m_jtaShow;   //������ʾ���򣬼�����ϡ�
	//���캯��
	HMenuAction()
	{
		m_hmfDmana = new HManaFlight();
	}
	
	//��ʾ���к�����Ϣ��
	public void SetShowArea(JTextArea jxa)
	{
		m_jtaShow = jxa;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String strMenu = e.getActionCommand();
		if( strHelp==strMenu )
			DoHelp();
		else if( strAboutMe==strMenu )
			DoAboutMe();
		else if( strReadFile==strMenu )
		{//���ļ��������ݣ������¼
			StringBuffer strAllFlightInfo = new StringBuffer();
			boolean bResult = m_hmfDmana.ReadFileToString(strAllFlightInfo);
			if( bResult==true )
				ShowAllFlight(strAllFlightInfo.toString());
		}
		else if( strWriteFile==strMenu )
		{//�������ݣ������¼���ļ�
			boolean bResult = m_hmfDmana.WriteFlightFile();
			if( bResult==true )
				JOptionPane.showMessageDialog(null, 
						"<html><body><h1>���к����¼�ɹ����浽�ļ���</h1></body></html>", 
						"�����ļ�",JOptionPane.PLAIN_MESSAGE);  
		}
		else if( strAddFlight==strMenu )//����һ������
		{
			AddOneFlight();
		}
		else if( strDelFlight==strMenu )//ɾ��һ������
		{
			DelOneFlight();
		}//end of else if ( strDelFlight==strMenu )//ɾ��һ������
		else if( strRemoveAllFlight==strMenu )//ɾ�����к���
		{
			m_hmfDmana.RemoveAllFlight();
			ShowAllFlight("");
		}
		else if( strPriceSearch==strMenu )//��Ʊ��Ϊ��������
		{
			SearchFlightByPrice();
		}
		else if( strAirlineNameSearch==strMenu )//�Ժ��չ�˾����Ϊ��������
		{
			SearchFlightByCompanyName();
		}
		else{}
	}//end of actionPerformed
	
	//��Ʊ�۲�ѯ�����¼
	private void SearchFlightByPrice()
	{
		HSearchPrice hsp = new HSearchPrice(null);
		hsp.setVisible(true);
		boolean bResult = hsp.GetValidSearch();
		if( true==bResult )
		{ 
			float fMin = hsp.GetMinPrice();
			float fMax = hsp.GetMaxPrice();
			String strInfo =  m_hmfDmana.SearchPriceRange(fMin, fMax);
			if( strInfo.length()<2 )
				JOptionPane.showMessageDialog(null, 
						"<html><body><h1>û���ҵ����������ĺ���</h1></body></html>", 
						"��ѯ���",JOptionPane.PLAIN_MESSAGE);  
			else
				JOptionPane.showMessageDialog(null, strInfo, 
					"��ѯ���",JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	//��Ʊ�۲�ѯ�����¼
	private void SearchFlightByCompanyName()
	{
		HSearchByCompanyName hsbc = new HSearchByCompanyName(null);
		hsbc.setVisible(true);
		boolean bResult = hsbc.GetValidSearch();
		if( true==bResult )
		{ 
			String strCompany = hsbc.GetCompanyTitle();
			String strInfo =  m_hmfDmana.SearchByCompanyName(strCompany);
			if( strInfo.length()<2 )
				JOptionPane.showMessageDialog(null, 
						"<html><body><h1>û���ҵ����������ĺ���</h1></body></html>", 
						"��ѯ���",JOptionPane.PLAIN_MESSAGE);  
			else
				JOptionPane.showMessageDialog(null, strInfo, 
					"��ѯ���",JOptionPane.PLAIN_MESSAGE);
		}
	}
	//����һ������
	private void AddOneFlight()
	{
		HInputFlight hif = new HInputFlight(/*mpFrame*/null,"���뺽����������");
		hif.setVisible(true);
		//HFlightInfo hfiInfo=null;//��ô���������HFlightInfo��HMenuAction֮�����ϡ�
		boolean bResult = hif.GetValidFlight();
		if( true==bResult )
		{
			StringBuffer strSid = new StringBuffer();
			StringBuffer strName = new StringBuffer();
			StringBuffer strCompany = new StringBuffer();
			float[]  fPrice = {0.0f};
			int[] nSeat = {0};
			hif.GetInputFlightRecord(strSid,strName,strCompany,fPrice,nSeat);
			m_hmfDmana.AddFlight(strSid.toString(), strName.toString(), strCompany.toString(), fPrice[0], nSeat[0]);
			String strInfo = m_hmfDmana.GetAllFlightInfo();
			ShowAllFlight(strInfo);
		}
	}

	//ɾ��һ������
	private void DelOneFlight()
	{
		String strName = JOptionPane.showInputDialog(null, "������Ҫɾ������ĺ�������","ɾ��һ������" , JOptionPane.INFORMATION_MESSAGE);
		if( null!=strName )
		{ //strName=null����ȡ����ť��
			boolean bResult = m_hmfDmana.DelFlight(strName);
			if( true==bResult )//�ɹ�ɾ��
				ShowAllFlight(m_hmfDmana.GetAllFlightInfo());
			else
				JOptionPane.showMessageDialog(null, 
						"<html><body><h1>�ú������Ʋ����ڣ�ע���뺽��źͺ��๫˾�������ֿ�����</h1></body></html>", 
						"ɾ��һ������",JOptionPane.PLAIN_MESSAGE);
		}
	}
		
	//about me����......
	private void DoAboutMe()
	{
		JOptionPane.showMessageDialog(null, 
				"<html><body><h1>�ںв��Խ�ѧ����</h1><h3>�ο�ʵ��ָ����</h3></body></html>", 
				"����......",JOptionPane.PLAIN_MESSAGE);  
	}
	
	//help������ܽ���
	private void DoHelp()
	{
		JOptionPane.showMessageDialog(null, 
				"<html><body><h1>������ܽ���</h1><h3>1,��������ǰ���ȶ��ļ���ʹ�ý����������ļ���</h3>"
				+ "<h3>2,���Թ����У���ͨ���˵����ƺ����¼��</h3>"
				+ "<h3>3,Ҫ�����ݣ����ܲ�ѯͳ�ơ�</h3></body></html>", 
				"������ܽ���",JOptionPane.PLAIN_MESSAGE);  
		
	}
	//��ʾ��ǰ���еĺ����¼
	//�����¼����strInfo�С�
	//��HMenuAction����
	public void ShowAllFlight(String strInfo)
	{
		m_jtaShow.setText(strInfo);
	}

	//�ڵ�ǰ���еĺ����¼�����ϣ������һ�������¼
	//�����¼����strInfo�С�
	//��HMenuAction����
	public void IncrementShowOneFlight(String strInfo)
	{
		//String strAllFlight = m_jtaShow.getText();
		//m_jtaShow.setText(strAllFlight+strInfo);
		//mProc.validate();
	}
}
