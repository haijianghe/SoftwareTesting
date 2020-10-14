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


/**
	 * 这是航班信息录入类。（作者：何海江）
	 */
public class HInputFlight extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblID;//航班号
	JTextField txtID;//航班号
	JLabel lblFname;//航班名称
	JTextField txtFname;//航班名称
	JLabel lblCompany;//航空公司名称
	JTextField txtCompany;//航空公司名称
	JLabel lblPrice;//价格
	JTextField txtPrice;//价格
	JLabel lblSeat;//座位数目
	JTextField txtSeat;//座位数目
	JButton btnOK,btnCancel;//确定、取消按钮
	
	boolean bDoOK = false; //如果点击确定按钮，则是true，有效航班数据；否则false
	
	//构造函数
	HInputFlight(JFrame jFrame,String strTitle)
	{
	    super(jFrame,strTitle,true);//模态
	    //this.setBounds(100, 100, 400, 400);
	    Container con = this.getContentPane();
	    //航班号
	    lblID = new JLabel("输入航班号（3-8位的数字字符）:");
	    txtID = new JTextField(8);
	    txtID.setEditable(true);
	    con.add(lblID);
	    con.add(txtID);
	    //航班名称
	    lblFname = new JLabel("输入航班名称（5-10位的数字及英文大写字符）:");
	    txtFname = new JTextField(10);
	    txtFname.setEditable(true);
	    con.add(lblFname);
	    con.add(txtFname);
	    //航空公司名称
	    lblCompany = new JLabel("输入航空公司名称（以H开头，后接5-19个任意字符）:");
	    txtCompany = new JTextField(20);
	    txtCompany.setEditable(true);
	    con.add(lblCompany);
	    con.add(txtCompany);
	    //价格
	    lblPrice = new JLabel("输入机票价格（允许小数，100<=价格<=1800）:");
	    txtPrice = new JTextField(8);
	    txtPrice.setEditable(true);
	    con.add(lblPrice);
	    con.add(txtPrice);
	    //座位数目
	    lblSeat = new JLabel("输入座位数目（整数，100到200之间）:");
	    txtSeat = new JTextField(6);
	    txtSeat.setEditable(true);
	    con.add(lblSeat);
	    con.add(txtSeat);
	    
		//setModalityType(false);
		btnOK = new JButton("确定");
		btnOK.addActionListener(this);
		btnCancel = new JButton("取消");
		btnCancel.addActionListener(this);
		con.add(btnOK);
		con.add(btnCancel);
	    con.setVisible(true);
		con.setLayout(new FlowLayout(FlowLayout.LEFT));
		con.setLayout(new GridLayout(6,2,25,40));//每行两个组件
		con.setSize(200,100);
	    this.pack();
	    this.setLocationRelativeTo(null);
	  }
	  
	//"确定""取消"按钮的响应
	  public void actionPerformed(ActionEvent e)
	  {
		  if( e.getActionCommand()=="确定")
		  {
			  boolean bResult = ValidFlightInfo();
			  if( false==bResult )
				JOptionPane.showMessageDialog(this, 
							"录入数据无法通过验证，请重新录入，或取消。", 
							"警告信息",JOptionPane.PLAIN_MESSAGE);
			  else
			  {
				  setVisible(false);
				  dispose();
				  bDoOK = true;
				  //System.out.println("确定");
			  }
		  }
		  else if( e.getActionCommand()=="取消")
		  {
			  setVisible(false);
			  dispose();
			  bDoOK = false;
		  }//end of else if
	  }
	  
	  //检查用户输入数据是否有效。
	  private boolean ValidFlightInfo()
	  {
		  if( ValidID()==false )
			  return false;
		  if( ValidFname()==false )
			  return false;
		  if( ValidCompany()==false )
			  return false;
		  if( ValidPrice()==false )
			  return false;
		  if( ValidSeat()==false )
			  return false;
		  //by hehaijiang	
		  return true;
	  }
	  
	  //验证航班名称是否输入正确。
	  //输入航班名称（5-10位的数字及英文大写字符）
	  //有效，返回true;否则，返回false.
	  private boolean ValidFname()
	  {
		  boolean flag = true;
		  String str = txtFname.getText();
		  int len = str.length();
		  if( len<5 || len>10 )
			  flag = false;
		  else
		  {
			  for( int i=0;i<len;i++ )
			  {
				  char ch = str.charAt(i);
				  if( (ch>='0'&& ch<='9') ||
						  (ch>='A'&& ch<='Z')
						  || (ch>='a'&& ch<='z') )
					  continue;
				  else
				  {
					  flag = false;
					  break;
				  }
			  }//end of for
		  }//end of else
		  return flag;
	  }
	  
	  //验证航班号是否输入正确。
	  //输入航班号（3-8位的数字字符）
	  //有效，返回true;否则，返回false.
	  private boolean ValidID()
	  {
		  boolean flag = true;
		  String str = txtID.getText();
		  int len = str.length();
		  if( len<3 || len>8 )
			  flag = false;
		  else
		  {
			  for( int i=0;i<len;i++ )
			  {
				  char ch = str.charAt(i);
				  if( ch<'0'|| ch>'9' )
				  {
					  flag = false;
					  break;
				  }
			  }//end of for
		  }//end of else
		  return flag;
	  }
	  
	  //验证航空公司名称是否输入正确。
	  //输入航空公司名称（以H开头，后接5-19个任意字符）
	  //有效，返回true;否则，返回false.
	  private boolean ValidCompany()
	  {
		  boolean flag = true;
		  String str = txtCompany.getText();
		  int len = str.length();
		  if( len<6 || len>20 )
			  flag = false;
		  else
		  {
			  char ch = str.charAt(0);
			  if( ch!='H' && ch!='h' )
				  flag = false;
		  }
		  return flag;
	  }

	  //验证机票价格是否输入正确。
	  //输入机票价格（允许小数，100<=价格<=1800
	  //有效，返回true;否则，返回false.
	  private boolean ValidPrice()
	  {
		  boolean flag = true;
		  String str = txtPrice.getText();
		  float price = 0.0f;
		  try
		  {//txtPrice可能为空字符串或者其它非法浮点数字符串，所以要出错处理
			  price = (float)Integer.parseInt(str);
		  }
		  catch(Exception e)
		  {
			  flag = false;
		  }
		  if( (true==flag) && (price>=100.0f) && (price<=1800.0f) )
				  flag = true;
		  return flag;
	  }
	  
	  //验证座位数目是否输入正确。
	  //输入座位数目（整数，100到200之间）
	  //有效，返回true;否则，返回false.
	  private boolean ValidSeat()
	  {
		  boolean flag = true;
		  String str = txtSeat.getText();
		  int seat = 0;
		  try
		  {//txtSeat可能为空字符串或者其它非法整数字符串，所以要出错处理
			  seat = Integer.parseInt(str);
		  }
		  catch(Exception e)
		  {
			  flag = false;
		  }
		  if( true==flag && seat>=100 && seat<=200 )
				  flag = true;
		  return flag;
	  }
	  
	  //如果点击确定按钮，则返回true；
	  //否则返回false
	  public boolean GetValidFlight()
	  {
		  return bDoOK;
	  }
	  
	  //将输入的航班记录保存到各项参数中 
	  //调用前，保证sbSid，sbName,sbCompany开辟了空间。
	  //注意：此处宁愿麻烦地用五个参数，而不简单地用一个类HFlightInfo来传递，是为了消除HFlightInfo和HMenuAction之间的耦合。
	  //同学们在以后的代码中可以学习这样的方法。
	  //做大一点的项目，一定要遵循软件工程的基本原则：低耦合；高内聚。
	  public void GetInputFlightRecord(StringBuffer sbSid, StringBuffer sbName, StringBuffer sbCompany, float[]  price, int[] seat)
	  {
		  sbSid.append(this.txtID.getText());//航班号
		  sbName.append(this.txtFname.getText());//航班名称
		  sbCompany.append(this.txtCompany.getText());//航空公司名称
		  String str = this.txtPrice.getText();
		  price[0] = Float.parseFloat(str);//价格
		  str = this.txtSeat.getText();
		  seat[0] = Integer.parseInt(str);//座位数目
	  }
}

 

