/*
 *用于黑盒测试。 
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HSearchByCompanyName extends JDialog implements ActionListener
{
	/**
	 * "以航空公司名称为条件检索"
	 */
	private static final long serialVersionUID = 1L;
	public static final String strSearch = "开始查询";
	public static final String strCancel = "终止查询";
	JTextField txtCompanyName;//航空公司名称输入框
	
	String m_strCompany;//航空公司名称
	boolean bDoOK = false; //如果有效查询，则是true，；否则false
	
	//构造函数
	HSearchByCompanyName(JFrame jFrame)
	{
	    super(jFrame,"以航空公司名称为查询条件，查询航班信息",true);//模态
	    m_strCompany = "";	
	    //this.setBounds(100, 100, 400, 400);
		Container con = this.getContentPane();
		JLabel lblTitle1 = new JLabel("以航空公司名称为查询条件，查询航班信息");
		JLabel lblTitle2 = new JLabel("航空公司名称为6-20个任意字符。 ");
		con.add(lblTitle1);
		con.add(lblTitle2);
		//航空公司名称
		JLabel lblPrice1 = new JLabel("航空公司名称:");
		txtCompanyName = new JTextField(10);
		txtCompanyName.setEditable(true);
		con.add(lblPrice1);
		con.add(txtCompanyName);
		
		//setModalityType(false);
		JButton btnSearch = new JButton(strSearch);
		btnSearch.addActionListener(this);
		JButton btnCancel = new JButton(strCancel);
		btnCancel.addActionListener(this);
		con.add(btnSearch);
		con.add(btnCancel);
		con.setVisible(true);
		con.setLayout(new FlowLayout(FlowLayout.LEFT));
		con.setLayout(new GridLayout(3,2,25,40));//每行两个组件
		con.setSize(200,100);
		this.pack();
		this.setLocationRelativeTo(null);
	  }
		  
		//"确定""取消"按钮的响应
	  public void actionPerformed(ActionEvent e)
	  {
		  if( e.getActionCommand()==strSearch)
		  {
			  boolean bResult = ValidCompanyName();
			  if( false==bResult )
				JOptionPane.showMessageDialog(this, 
							"录入数据无法通过验证，请重新录入，或取消。", 
							"警告信息",JOptionPane.PLAIN_MESSAGE);
			  else
			  {//有效的输入价格，显示查询结果。
				  setVisible(false);
				  dispose();
				  bDoOK = true;
			  }
		  }
		  else if( e.getActionCommand()==strCancel)
		  {
			  setVisible(false);
			  dispose();
			  bDoOK = false;
		  }//end of else if
	  }//end of actionPerformed
	  
	  //航空公司名称为6-20个任意字符。 
	  private boolean ValidCompanyName()
	  {
		  boolean flag = true;
		  String str = txtCompanyName.getText();
		  int len = str.length();
		  if (len>=6 && len<=20 )
		  {
			  flag = true;
			  m_strCompany = str;
		  }
		  else //非法的价格
			  flag = false;
		  return flag;
	  }
	  
	  //获取航空公司名称
	  public String GetCompanyTitle()
	  {
		  return this.m_strCompany;
	  }

  	  //如果有效查询，则返回true；
	  //否则返回false
	  public boolean GetValidSearch()
	  {
		  return bDoOK;
	  }

}
