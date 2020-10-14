/*
 *用于黑盒测试。 
 */
/**

	 * 这是菜单触发事件处理类。（作者：何海江）
	 * 增加一个航班，删除一个航班，删除所有航班。
	 * 从文件读航班信息，将航班信息写入文件
	 * 以票价为条件检索,以航空公司名称为条件检索
	 * 软件功能介绍,关于......
	 * 
	 * 注意：此类用了很多麻烦的做法，避免了HFlightInfo和HMenuAction之间的耦合。HFlightInfo和HMenuAction之间的联系时间接的，
	 * 通过HManaFlight实现。
	 * 同学们在以后的代码中可以学习这样的方法。
	 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class HMenuAction implements ActionListener{
	public static final String strReadFile = "从文件读入数据";
	public static final String strWriteFile = "保存数据到文件";
	public static final String strAddFlight = "增加一个航班";
	public static final String strDelFlight = "删除一个航班";
	public static final String strRemoveAllFlight = "删除所有航班";
	public static final String strPriceSearch = "以票价为条件检索";
	public static final String strAirlineNameSearch = "以航空公司名称为条件检索";
	public static final String strHelp ="软件功能介绍";
	public static final String strAboutMe ="关于......";
	private HManaFlight m_hmfDmana;  //航班管理类
	private JTextArea m_jtaShow;   //关联显示区域，减少耦合。
	//构造函数
	HMenuAction()
	{
		m_hmfDmana = new HManaFlight();
	}
	
	//显示所有航班信息。
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
		{//从文件读入数据：航班记录
			StringBuffer strAllFlightInfo = new StringBuffer();
			boolean bResult = m_hmfDmana.ReadFileToString(strAllFlightInfo);
			if( bResult==true )
				ShowAllFlight(strAllFlightInfo.toString());
		}
		else if( strWriteFile==strMenu )
		{//保存数据：航班记录到文件
			boolean bResult = m_hmfDmana.WriteFlightFile();
			if( bResult==true )
				JOptionPane.showMessageDialog(null, 
						"<html><body><h1>所有航班记录成功保存到文件。</h1></body></html>", 
						"保存文件",JOptionPane.PLAIN_MESSAGE);  
		}
		else if( strAddFlight==strMenu )//增加一个航班
		{
			AddOneFlight();
		}
		else if( strDelFlight==strMenu )//删除一个航班
		{
			DelOneFlight();
		}//end of else if ( strDelFlight==strMenu )//删除一个航班
		else if( strRemoveAllFlight==strMenu )//删除所有航班
		{
			m_hmfDmana.RemoveAllFlight();
			ShowAllFlight("");
		}
		else if( strPriceSearch==strMenu )//以票价为条件检索
		{
			SearchFlightByPrice();
		}
		else if( strAirlineNameSearch==strMenu )//以航空公司名称为条件检索
		{
			SearchFlightByCompanyName();
		}
		else{}
	}//end of actionPerformed
	
	//以票价查询航班记录
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
						"<html><body><h1>没有找到符合条件的航班</h1></body></html>", 
						"查询结果",JOptionPane.PLAIN_MESSAGE);  
			else
				JOptionPane.showMessageDialog(null, strInfo, 
					"查询结果",JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	//以票价查询航班记录
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
						"<html><body><h1>没有找到符合条件的航班</h1></body></html>", 
						"查询结果",JOptionPane.PLAIN_MESSAGE);  
			else
				JOptionPane.showMessageDialog(null, strInfo, 
					"查询结果",JOptionPane.PLAIN_MESSAGE);
		}
	}
	//增加一个航班
	private void AddOneFlight()
	{
		HInputFlight hif = new HInputFlight(/*mpFrame*/null,"输入航班的相关数据");
		hif.setVisible(true);
		//HFlightInfo hfiInfo=null;//这么做，会产生HFlightInfo和HMenuAction之间的耦合。
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

	//删除一个航班
	private void DelOneFlight()
	{
		String strName = JOptionPane.showInputDialog(null, "请输入要删除航班的航班名称","删除一个航班" , JOptionPane.INFORMATION_MESSAGE);
		if( null!=strName )
		{ //strName=null按的取消按钮。
			boolean bResult = m_hmfDmana.DelFlight(strName);
			if( true==bResult )//成功删除
				ShowAllFlight(m_hmfDmana.GetAllFlightInfo());
			else
				JOptionPane.showMessageDialog(null, 
						"<html><body><h1>该航班名称不存在，注意与航班号和航班公司名称区分开来！</h1></body></html>", 
						"删除一个航班",JOptionPane.PLAIN_MESSAGE);
		}
	}
		
	//about me关于......
	private void DoAboutMe()
	{
		JOptionPane.showMessageDialog(null, 
				"<html><body><h1>黑盒测试教学程序</h1><h3>参看实验指导书</h3></body></html>", 
				"关于......",JOptionPane.PLAIN_MESSAGE);  
	}
	
	//help软件功能介绍
	private void DoHelp()
	{
		JOptionPane.showMessageDialog(null, 
				"<html><body><h1>软件功能介绍</h1><h3>1,操作数据前，先读文件；使用结束，保存文件。</h3>"
				+ "<h3>2,测试过程中，可通过菜单控制航班记录。</h3>"
				+ "<h3>3,要有数据，才能查询统计。</h3></body></html>", 
				"软件功能介绍",JOptionPane.PLAIN_MESSAGE);  
		
	}
	//显示当前所有的航班记录
	//航班记录放在strInfo中。
	//供HMenuAction调用
	public void ShowAllFlight(String strInfo)
	{
		m_jtaShow.setText(strInfo);
	}

	//在当前所有的航班记录基础上，再添加一条航班记录
	//航班记录放在strInfo中。
	//供HMenuAction调用
	public void IncrementShowOneFlight(String strInfo)
	{
		//String strAllFlight = m_jtaShow.getText();
		//m_jtaShow.setText(strAllFlight+strInfo);
		//mProc.validate();
	}
}
