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
 * �����Լ۸�����ѯ������ࡣ�����ߣ��κ�����
 */
public class HSearchPrice extends JDialog implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String strSearch = "��ʼ��ѯ";
	public static final String strCancel = "��ֹ��ѯ";
	JTextField txtMinPrice;//С���Ǹ�Ʊ�������
	JTextField txtMaxPrice;//����Ǹ�Ʊ�������
	
	float fMinPrice,fMaxPrice;//С���Ǹ�Ʊ��,fMaxPrice����Ǹ�Ʊ��
	boolean bDoOK = false; //�����Ч��ѯ������true��������false
	
	//���캯��
	HSearchPrice(JFrame jFrame)
	{
	    super(jFrame,"��Ʊ��Ϊ��ѯ��������ѯ������Ϣ",true);//ģ̬
	    fMinPrice = 0.0f;	
	    fMaxPrice = 0.0f;	
	    //this.setBounds(100, 100, 400, 400);
		Container con = this.getContentPane();
		JLabel lblTitle1 = new JLabel("��Ʊ��Ϊ��ѯ����");
		JLabel lblTitle2 = new JLabel("����ֹ��ѯ���˳��Ի��� ");
		con.add(lblTitle1);
		con.add(lblTitle2);
		//С���Ǹ�Ʊ��
		JLabel lblPrice1 = new JLabel("��Ʊ�۸���:");
		txtMinPrice = new JTextField(8);
		txtMinPrice.setEditable(true);
		con.add(lblPrice1);
		con.add(txtMinPrice);
		//����Ǹ�Ʊ��
		JLabel lblPrice2 = new JLabel("��:");
		txtMaxPrice = new JTextField(10);
		txtMaxPrice.setEditable(true);
		con.add(lblPrice2);
		con.add(txtMaxPrice);
		//��ʾ��Ϣ
		JLabel lblPrompt1 = new JLabel("����ע�����1�����������");
		JLabel lblPrompt2 = new JLabel("��ֻ�����������ĸ�������");
		JLabel lblPrompt3 = new JLabel("��ֵֻ����100��1800֮�䡣");
		JLabel lblPrompt4 = new JLabel(" ");
		JLabel lblPrompt5 = new JLabel("��һ����������ֵ���۸�");
		JLabel lblPrompt6 = new JLabel("����С�ڵڶ�����������ֵ��");
		con.add(lblPrompt1);
		con.add(lblPrompt2);
		con.add(lblPrompt3);
		con.add(lblPrompt4);
		con.add(lblPrompt5);
		con.add(lblPrompt6);
		
		//setModalityType(false);
		JButton btnSearch = new JButton(strSearch);
		btnSearch.addActionListener(this);
		JButton btnCancel = new JButton(strCancel);
		btnCancel.addActionListener(this);
		con.add(btnSearch);
		con.add(btnCancel);
		con.setVisible(true);
		con.setLayout(new FlowLayout(FlowLayout.LEFT));
		con.setLayout(new GridLayout(7,2,25,40));//ÿ���������
		con.setSize(200,100);
		this.pack();
		this.setLocationRelativeTo(null);
	  }
		  
		//"ȷ��""ȡ��"��ť����Ӧ
	  public void actionPerformed(ActionEvent e)
	  {
		  if( e.getActionCommand()==strSearch)
		  {
			  boolean bResult = ValidPrice();
			  if( false==bResult )
				JOptionPane.showMessageDialog(this, 
							"¼�������޷�ͨ����֤��������¼�룬��ȡ����", 
							"������Ϣ",JOptionPane.PLAIN_MESSAGE);
			  else
			  {//��Ч������۸���ʾ��ѯ�����
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
	  
	  //��֤��Ʊ�۸��Ƿ�������ȷ��
	  //�����Ʊ�۸�����С����100<=�۸�<=1800  ��һ���۸����С�ڵڶ����۸�
	  //��Ч������true;���򣬷���false.
	  private boolean ValidPrice()
	  {
		  boolean flag = true;
		  String str = txtMinPrice.getText();
		  float price = 0.0f;
		  try
		  {//txtMinPrice����Ϊ���ַ������������Ƿ��������ַ���������Ҫ������
			  price = Float.parseFloat(str);
		  }
		  catch(Exception e)
		  {
			  flag = false;
		  }
		  if( true==flag )
		  {
			  if (price>=100.0f && price<=1800.0f )
				  flag = true;
			  else //�Ƿ��ļ۸�
				  flag = false;
		  }
		  if( true==flag)
		  {
			  fMinPrice = price;
			  str = txtMaxPrice.getText();
			  try
			  {//txtMinPrice����Ϊ���ַ������������Ƿ��������ַ���������Ҫ������
				  price = Float.parseFloat(str);
			  }
			  catch(Exception e)
			  {
				  flag = false;
			  }
			  if( true==flag )
			  {
				  if( price>=100.0f && price<1800.0f )
					  flag = true;
				  else
					  flag = false;
			  }
			  if( true==flag)
			  {
				  fMaxPrice = price;
				  if( fMinPrice<fMaxPrice )
					  flag = true;
				  else
					  flag = false;
			  }
		  }
		  return flag;
	  }
	  
	  //��ȡ��ѯƱ�۵���Сֵ
	  public float GetMinPrice()
	  {
		  return this.fMinPrice;
	  }

	  //��ȡ��ѯƱ�۵����ֵ
	  public float GetMaxPrice()
	  {
		  return this.fMaxPrice;
	  }
	  
	  //�����Ч��ѯ���򷵻�true��
	  //���򷵻�false
	  public boolean GetValidSearch()
	  {
		  return bDoOK;
	  }
}
