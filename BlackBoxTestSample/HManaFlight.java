/*
 *���ںںв��ԡ� 
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
	 * ���Ǻ�������ࡣ�����ߣ��κ�����
	 * ����һ�����࣬ɾ��һ�����࣬ɾ�����к��ࡣ
	 * ���ļ���������Ϣ����������Ϣд���ļ�
	 */
public class HManaFlight {
	private ArrayList<HFlightInfo> m_listFlight = null; //�������к��ࡣ
	
	//���캯������ʼ�����顣ArrayList
	public HManaFlight()
	{
		m_listFlight = new  ArrayList<HFlightInfo>();
	}
	
	//��������
	protected void finalize()
	 {
		m_listFlight.removeAll(null);
	 }
	
	/*����һ�����ൽ����m_listFlight 
	�����strID
	��������strName
	���չ�˾����strCompany
	fPrice;  �۸�
	nSeat; ��λ��Ŀ
	*/
	public  void AddFlight(String strID,String strName,String strCompany,
			float fPrice,int nSeat) 
	{         
		HFlightInfo hfiFlight = new HFlightInfo(strID,strName,strCompany,fPrice,nSeat);
		m_listFlight.add(hfiFlight);     
	}     
	
	// ���ݺ������ƣ�����Ի��з���β�ĺ�����Ϣ   
	//���ظú����������Ϣ������������ţ��������ƣ����չ�˾���ƣ��۸���λ��Ŀ
	private String GetFlightInfo(String strName)     
	{         
		int nSize = m_listFlight.size();
		StringBuffer sbInfo = null;
		// ��������ArrayList         
		for(int i=0;i<nSize;i++)         
		{             
			// ȡ��HFlightInfo����             
			HFlightInfo hfiFlight=(HFlightInfo)m_listFlight.get(i);                            
			// �Ƚ�����             
			if(hfiFlight.getStrName().equals(strName))             
			{                 
				sbInfo = new StringBuffer(); 
				sbInfo.append(hfiFlight.GetInfo()+"\r\n");
				break;
			}         
		} //end of for
		return sbInfo.toString();
	}
	
	//���Խ�������б���ɾ��     
	//strName��������
	//����ҵ���Ӧ���࣬��ɾ���ɹ����򷵻�true�����򷵻�false
	public boolean DelFlight(String strName)     
	{         
		boolean flag = false;
		int nSize = m_listFlight.size();
		for(int i=0;i<nSize;i++)         
		{             
			HFlightInfo hfiFlight=(HFlightInfo)m_listFlight.get(i);              
			if(hfiFlight.getStrName().equals(strName))             
			{                 
				m_listFlight.remove(i);
				flag = true;
				break;
			}         
		}//end of for
		return flag;
	} 
	
	
	//ɾ�����к���
	public void RemoveAllFlight()
	{
		m_listFlight.clear();//ɾ�����к���
	}
	
	//���ļ�FlightInfo.txt�ж��뺽����Ϣ
	//����ҵ��ļ���������ɹ����򷵻�true�����򷵻�false
	private  boolean ReadFlightFile()
	{
		boolean bFlag = true;
		m_listFlight.clear();//����ɵ�
		try{
			DataInputStream fm = new DataInputStream(new BufferedInputStream(
					new FileInputStream("FlightInfo.txt")));
			//�������
			int number = fm.readInt();
			for( int i=0;i<number;i++ )
			{
				String strID = fm.readUTF();//�����
				String strName = fm.readUTF();//��������
				String strCompany = fm.readUTF();//���չ�˾����
				float fPrice = fm.readFloat();//�۸�
				int nSeat = fm.readInt();//��λ��Ŀ
				AddFlight(strID,strName,strCompany,fPrice,nSeat);
			}
			fm.close();
		}//end of for...
		catch(IOException e)
		{
			//System.err.println("�ļ�FlightInfo.txt������"+e.toString());
			JOptionPane.showMessageDialog(null, 
					"<html><body><h1>�ļ�FlightInfo.txt������</h1><h3>�����ļ��Ƿ����</h3></body></html>", 
					"������Ϣ",JOptionPane.WARNING_MESSAGE);  
			bFlag = false;
		}
		return bFlag;
	}
	
	//���ļ�FlightInfo.txtд�뺽����Ϣ
	//���д��ɹ����򷵻�true�����򷵻�false
	public  boolean WriteFlightFile()
	{
		boolean bFlag = true;

		try{
			DataOutputStream fm = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream("FlightInfo.txt")));
			//�������
			int number = m_listFlight.size();
			fm.writeInt(number);
			for( int i=0;i<number;i++ )
			{
				// ȡ��hfiFlight����             
				HFlightInfo hfiFlight=(HFlightInfo)m_listFlight.get(i);       
				fm.writeUTF(hfiFlight.getStrID());//�����
				fm.writeUTF(hfiFlight.getStrName());//��������
				fm.writeUTF(hfiFlight.getStrCompany());//���չ�˾����
				fm.writeFloat(hfiFlight.getfPrice());//�۸�
				fm.writeInt(hfiFlight.getSeat());//��λ��Ŀ
			}
			fm.close();
		}
		catch(IOException e)
		{
			//System.err.println("�ļ�passenger.txtд����"+e.toString());
			JOptionPane.showMessageDialog(null, 
					"<html><body><h1>�ļ�FlightInfo.txtд�����</h1><h3>�����ļ��Ƿ����</h3></body></html>", 
					"�������",JOptionPane.ERROR_MESSAGE);  
			bFlag = false;
		}
		return bFlag;
	}
	
	//���ظú����������Ϣ������������ţ��������ƣ����չ�˾���ƣ��۸���λ��Ŀ
	public String GetAllFlightInfo()     
	{         
		int nSize = m_listFlight.size();
		StringBuffer sbInfo = new StringBuffer();
		// ��������ArrayList         
		for(int i=0;i<nSize;i++)         
		{             
			// ȡ��HFlightInfo����             
			HFlightInfo hfiFlight=(HFlightInfo)m_listFlight.get(i);                            
			if( i!=(nSize-1) )
				sbInfo.append(hfiFlight.GetInfo()+"\r\n");
			else//���һ��������
				sbInfo.append(hfiFlight.GetInfo());
		} //end of for
		return sbInfo.toString();
	}
	
	//���ļ��������к�����Ϣ�������Ϊ�ַ���
	//�������ɹ����򷵻�true��strAllInfoװ�����к����¼�����򷵻�false��
	//ע�⣺����ǰ����֤sbAllInfo�����˿ռ䡣
	public boolean ReadFileToString(StringBuffer sbAllInfo)
	{
		boolean bFlag = ReadFlightFile();
		if( bFlag==true )
			sbAllInfo.append(GetAllFlightInfo());
		return bFlag;
	}
	
	//�ӵ�ǰ�ĺ����¼������Ʊ����һ����Χ�ڵĺ���
	//fMin��СƱ��
	public String SearchPriceRange(float fMin,float fMax)
	{
		int nSize = m_listFlight.size();
		StringBuffer sbInfo = new StringBuffer();
		// ��������ArrayList         
		for(int i=0;i<nSize;i++)         
		{             
			// ȡ��HFlightInfo����             
			HFlightInfo hfiFlight=(HFlightInfo)m_listFlight.get(i);    
			String strTmp;
			if( hfiFlight.getfPrice()>=fMin && hfiFlight.getfPrice()<=fMax )
			{
				strTmp = hfiFlight.GetInfo();
				sbInfo.append(strTmp+"\r\n");
			}
		} //end of for
		return sbInfo.toString();
	}

	//�ӵ�ǰ�ĺ����¼�������������չ�˾���еĺ���
	//strCompany���չ�˾����
	public String SearchByCompanyName(String strCompany)
	{
		int nSize = m_listFlight.size();
		StringBuffer sbInfo = new StringBuffer();
		// ��������ArrayList         
		for(int i=0;i<nSize;i++)         
		{             
			// ȡ��HFlightInfo����             
			HFlightInfo hfiFlight=(HFlightInfo)m_listFlight.get(i);    
			String strTmp;
			if( true==hfiFlight.getStrCompany().equals(strCompany) )
			{
				strTmp = hfiFlight.GetInfo();
				sbInfo.append(strTmp+"\r\n");
			}
		} //end of for
		return sbInfo.toString();
	}

}