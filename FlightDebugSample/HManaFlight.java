/*
  *用于学生学习调试程序技能：包括定位错误、设置断点、单步执行、观察变量值变化等。 
 *（作者：何海江）
 *调试程序。里面人工植入了几处错误代码，让学生通过学习到的调试技能找出错误代码。
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
	 * 这是航班管理类。（作者：何海江）
	 * 增加一个航班，删除一个航班，删除所有航班。
	 * 从文件读航班信息，将航班信息写入文件
	 */
public class HManaFlight {
	private ArrayList<HFlightInfo> m_listFlight = null; //保存所有航班。
	
	//构造函数，初始化数组。ArrayList
	public HManaFlight()
	{
		m_listFlight = new  ArrayList<HFlightInfo>();
	}
	
	//析构函数
	protected void finalize()
	 {
		m_listFlight.removeAll(null);
	 }
	
	/*增加一个航班到数列m_listFlight 
	航班号strID
	航班名称strName
	航空公司名称strCompany
	fPrice;  价格
	nSeat; 座位数目
	*/
	public  void AddFlight(String strID,String strName,String strCompany,
			float fPrice,int nSeat) 
	{         
		HFlightInfo hfiFlight = new HFlightInfo(strID,strName,strCompany,fPrice,nSeat);
		m_listFlight.add(hfiFlight);     
	}     
	
	// 根据航班名称，获得以换行符结尾的航班信息   
	//返回该航班的所有信息，包括：航班号，航班名称，航空公司名称，价格，座位数目
	private String GetFlightInfo(String strName)     
	{         
		int nSize = m_listFlight.size();
		StringBuffer sbInfo = null;
		// 遍历整个ArrayList         
		for(int i=0;i<nSize;i++)         
		{             
			// 取出HFlightInfo对象             
			HFlightInfo hfiFlight=(HFlightInfo)m_listFlight.get(i);                            
			// 比较姓名             
			if(hfiFlight.getStrName().equals(strName))             
			{                 
				sbInfo = new StringBuffer(); 
				sbInfo.append(hfiFlight.GetInfo()+"\r\n");
				break;
			}         
		} //end of for
		return sbInfo.toString();
	}
	
	//可以将航班从列表中删除     
	//strName航班名称
	//如果找到对应航班，并删除成功，则返回true，否则返回false
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
	
	//删除航空公司的所有航班
	//strName航班名称
	//如果找到对应航班，并删除成功，则返回true，否则返回false
	public boolean DelCompanyFlight(String strName)     
	{         
		boolean flag = false;
		int nSize = m_listFlight.size();
		for(int i=0;i<nSize;i++)         
		{             
			HFlightInfo hfiFlight=(HFlightInfo)m_listFlight.get(i);              
			if(hfiFlight.getStrCompany().equals(strName))             
			{                 
				m_listFlight.remove(i);
				flag = true;
				break;
			}         
		}//end of for
		return flag;
	} 
	
	//删除所有航班
	public void RemoveAllFlight()
	{
		m_listFlight.clear();//删除所有航班
	}
	
	//从文件FlightInfo.txt中读入航班信息
	//如果找到文件，并读入成功，则返回true，否则返回false
	private  boolean ReadFlightFile()
	{
		boolean bFlag = true;
		m_listFlight.clear();//清除旧的
		try{
			DataInputStream fm = new DataInputStream(new BufferedInputStream(
					new FileInputStream("FlightInfo.txt")));
			//航班个数
			int number = fm.readInt();
			for( int i=1;i<number;i++ )
			{
				String strID = fm.readUTF();//航班号
				String strName = fm.readUTF();//航班名称
				String strCompany = fm.readUTF();//航空公司名称
				float fPrice = fm.readFloat();//价格
				int nSeat = fm.readInt();//座位数目
				AddFlight(strID,strName,strCompany,fPrice,nSeat);
			}
			fm.close();
		}//end of for...
		catch(IOException e)
		{
			//System.err.println("文件FlightInfo.txt读错误。"+e.toString());
			JOptionPane.showMessageDialog(null, 
					"<html><body><h1>文件FlightInfo.txt读错误。</h1><h3>检查该文件是否存在</h3></body></html>", 
					"报警信息",JOptionPane.WARNING_MESSAGE);  
			bFlag = false;
		}
		return bFlag;
	}
	
	//向文件FlightInfo.txt写入航班信息
	//如果写入成功，则返回true，否则返回false
	public  boolean WriteFlightFile()
	{
		boolean bFlag = true;

		try{
			DataOutputStream fm = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream("FlightInfo.txt")));
			//航班个数
			int number = m_listFlight.size();
			fm.writeInt(number);
			for( int i=0;i<number;i++ )
			{
				// 取出hfiFlight对象             
				HFlightInfo hfiFlight=(HFlightInfo)m_listFlight.get(i);       
				fm.writeUTF(hfiFlight.getStrID());//航班号
				fm.writeUTF(hfiFlight.getStrName());//航班名称
				fm.writeUTF(hfiFlight.getStrCompany());//航空公司名称
				fm.writeFloat(hfiFlight.getfPrice());//价格
				fm.writeInt(hfiFlight.getSeat());//座位数目
			}
			fm.close();
		}
		catch(IOException e)
		{
			//System.err.println("文件passenger.txt写错误。"+e.toString());
			JOptionPane.showMessageDialog(null, 
					"<html><body><h1>文件FlightInfo.txt写入错误。</h1><h3>检查该文件是否存在</h3></body></html>", 
					"程序出错",JOptionPane.ERROR_MESSAGE);  
			bFlag = false;
		}
		return bFlag;
	}
	
	//返回该航班的所有信息，包括：航班号，航班名称，航空公司名称，价格，座位数目
	public String GetAllFlightInfo()     
	{         
		int nSize = m_listFlight.size();
		StringBuffer sbInfo = new StringBuffer();
		// 遍历整个ArrayList         
		for(int i=0;i<nSize;i++)         
		{             
			// 取出HFlightInfo对象             
			HFlightInfo hfiFlight=(HFlightInfo)m_listFlight.get(i);                            
			if( i!=(nSize-1) )
				sbInfo.append(hfiFlight.GetInfo()+"\r\n");
			else//最后一个不换行
				sbInfo.append(hfiFlight.GetInfo());
		} //end of for
		return sbInfo.toString();
	}
	
	//从文件读入所有航班信息，并打包为字符串
	//如果读入成功，则返回true，strAllInfo装入所有航班记录；否则返回false，
	//注意：调用前，保证sbAllInfo开辟了空间。
	public boolean ReadFileToString(StringBuffer sbAllInfo)
	{
		boolean bFlag = ReadFlightFile();
		if( bFlag==true )
			sbAllInfo.append(GetAllFlightInfo());
		return bFlag;
	}
	
	//从当前的航班记录内搜索票价在一个范围内的航班
	//fMin最小票价
	public String SearchPriceRange(float fMin,float fMax)
	{
		int nSize = m_listFlight.size();
		StringBuffer sbInfo = new StringBuffer();
		// 遍历整个ArrayList         
		for(int i=0;i<nSize;i++)         
		{             
			// 取出HFlightInfo对象             
			HFlightInfo hfiFlight=(HFlightInfo)m_listFlight.get(i);    
			String strTmp;
			if( hfiFlight.getSeat()>=fMin && hfiFlight.getSeat()<=fMax )
			{
				strTmp = hfiFlight.GetInfo();
				sbInfo.append(strTmp+"\r\n");
			}
		} //end of for
		return sbInfo.toString();
	}

	//从当前的航班记录内搜索所属航空公司所有的航班
	//strCompany航空公司名称
	public String SearchByCompanyName(String strCompany)
	{
		int nSize = m_listFlight.size();
		StringBuffer sbInfo = new StringBuffer();
		// 遍历整个ArrayList         
		for(int i=0;i<nSize;i++)         
		{             
			// 取出HFlightInfo对象             
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