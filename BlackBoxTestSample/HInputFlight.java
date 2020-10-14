/*
 *���ںںв��ԡ� 
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
	 * ���Ǻ�����Ϣ¼���ࡣ�����ߣ��κ�����
	 */
public class HInputFlight extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblID;//�����
	JTextField txtID;//�����
	JLabel lblFname;//��������
	JTextField txtFname;//��������
	JLabel lblCompany;//���չ�˾����
	JTextField txtCompany;//���չ�˾����
	JLabel lblPrice;//�۸�
	JTextField txtPrice;//�۸�
	JLabel lblSeat;//��λ��Ŀ
	JTextField txtSeat;//��λ��Ŀ
	JButton btnOK,btnCancel;//ȷ����ȡ����ť
	
	boolean bDoOK = false; //������ȷ����ť������true����Ч�������ݣ�����false
	
	//���캯��
	HInputFlight(JFrame jFrame,String strTitle)
	{
	    super(jFrame,strTitle,true);//ģ̬
	    //this.setBounds(100, 100, 400, 400);
	    Container con = this.getContentPane();
	    //�����
	    lblID = new JLabel("���뺽��ţ�3-8λ�������ַ���:");
	    txtID = new JTextField(8);
	    txtID.setEditable(true);
	    con.add(lblID);
	    con.add(txtID);
	    //��������
	    lblFname = new JLabel("���뺽�����ƣ�5-10λ�����ּ�Ӣ�Ĵ�д�ַ���:");
	    txtFname = new JTextField(10);
	    txtFname.setEditable(true);
	    con.add(lblFname);
	    con.add(txtFname);
	    //���չ�˾����
	    lblCompany = new JLabel("���뺽�չ�˾���ƣ���H��ͷ�����5-19�������ַ���:");
	    txtCompany = new JTextField(20);
	    txtCompany.setEditable(true);
	    con.add(lblCompany);
	    con.add(txtCompany);
	    //�۸�
	    lblPrice = new JLabel("�����Ʊ�۸�����С����100<=�۸�<=1800��:");
	    txtPrice = new JTextField(8);
	    txtPrice.setEditable(true);
	    con.add(lblPrice);
	    con.add(txtPrice);
	    //��λ��Ŀ
	    lblSeat = new JLabel("������λ��Ŀ��������100��200֮�䣩:");
	    txtSeat = new JTextField(6);
	    txtSeat.setEditable(true);
	    con.add(lblSeat);
	    con.add(txtSeat);
	    
		//setModalityType(false);
		btnOK = new JButton("ȷ��");
		btnOK.addActionListener(this);
		btnCancel = new JButton("ȡ��");
		btnCancel.addActionListener(this);
		con.add(btnOK);
		con.add(btnCancel);
	    con.setVisible(true);
		con.setLayout(new FlowLayout(FlowLayout.LEFT));
		con.setLayout(new GridLayout(6,2,25,40));//ÿ���������
		con.setSize(200,100);
	    this.pack();
	    this.setLocationRelativeTo(null);
	  }
	  
	//"ȷ��""ȡ��"��ť����Ӧ
	  public void actionPerformed(ActionEvent e)
	  {
		  if( e.getActionCommand()=="ȷ��")
		  {
			  boolean bResult = ValidFlightInfo();
			  if( false==bResult )
				JOptionPane.showMessageDialog(this, 
							"¼�������޷�ͨ����֤��������¼�룬��ȡ����", 
							"������Ϣ",JOptionPane.PLAIN_MESSAGE);
			  else
			  {
				  setVisible(false);
				  dispose();
				  bDoOK = true;
				  //System.out.println("ȷ��");
			  }
		  }
		  else if( e.getActionCommand()=="ȡ��")
		  {
			  setVisible(false);
			  dispose();
			  bDoOK = false;
		  }//end of else if
	  }
	  
	  //����û����������Ƿ���Ч��
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
	  
	  //��֤���������Ƿ�������ȷ��
	  //���뺽�����ƣ�5-10λ�����ּ�Ӣ�Ĵ�д�ַ���
	  //��Ч������true;���򣬷���false.
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
	  
	  //��֤������Ƿ�������ȷ��
	  //���뺽��ţ�3-8λ�������ַ���
	  //��Ч������true;���򣬷���false.
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
	  
	  //��֤���չ�˾�����Ƿ�������ȷ��
	  //���뺽�չ�˾���ƣ���H��ͷ�����5-19�������ַ���
	  //��Ч������true;���򣬷���false.
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

	  //��֤��Ʊ�۸��Ƿ�������ȷ��
	  //�����Ʊ�۸�����С����100<=�۸�<=1800
	  //��Ч������true;���򣬷���false.
	  private boolean ValidPrice()
	  {
		  boolean flag = true;
		  String str = txtPrice.getText();
		  float price = 0.0f;
		  try
		  {//txtPrice����Ϊ���ַ������������Ƿ��������ַ���������Ҫ������
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
	  
	  //��֤��λ��Ŀ�Ƿ�������ȷ��
	  //������λ��Ŀ��������100��200֮�䣩
	  //��Ч������true;���򣬷���false.
	  private boolean ValidSeat()
	  {
		  boolean flag = true;
		  String str = txtSeat.getText();
		  int seat = 0;
		  try
		  {//txtSeat����Ϊ���ַ������������Ƿ������ַ���������Ҫ������
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
	  
	  //������ȷ����ť���򷵻�true��
	  //���򷵻�false
	  public boolean GetValidFlight()
	  {
		  return bDoOK;
	  }
	  
	  //������ĺ����¼���浽��������� 
	  //����ǰ����֤sbSid��sbName,sbCompany�����˿ռ䡣
	  //ע�⣺�˴���Ը�鷳������������������򵥵���һ����HFlightInfo�����ݣ���Ϊ������HFlightInfo��HMenuAction֮�����ϡ�
	  //ͬѧ�����Ժ�Ĵ����п���ѧϰ�����ķ�����
	  //����һ�����Ŀ��һ��Ҫ��ѭ������̵Ļ���ԭ�򣺵���ϣ����ھۡ�
	  public void GetInputFlightRecord(StringBuffer sbSid, StringBuffer sbName, StringBuffer sbCompany, float[]  price, int[] seat)
	  {
		  sbSid.append(this.txtID.getText());//�����
		  sbName.append(this.txtFname.getText());//��������
		  sbCompany.append(this.txtCompany.getText());//���չ�˾����
		  String str = this.txtPrice.getText();
		  price[0] = Float.parseFloat(str);//�۸�
		  str = this.txtSeat.getText();
		  seat[0] = Integer.parseInt(str);//��λ��Ŀ
	  }
}

 

