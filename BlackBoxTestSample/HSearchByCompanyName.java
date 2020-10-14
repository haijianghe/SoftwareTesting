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

public class HSearchByCompanyName extends JDialog implements ActionListener
{
	/**
	 * "�Ժ��չ�˾����Ϊ��������"
	 */
	private static final long serialVersionUID = 1L;
	public static final String strSearch = "��ʼ��ѯ";
	public static final String strCancel = "��ֹ��ѯ";
	JTextField txtCompanyName;//���չ�˾���������
	
	String m_strCompany;//���չ�˾����
	boolean bDoOK = false; //�����Ч��ѯ������true��������false
	
	//���캯��
	HSearchByCompanyName(JFrame jFrame)
	{
	    super(jFrame,"�Ժ��չ�˾����Ϊ��ѯ��������ѯ������Ϣ",true);//ģ̬
	    m_strCompany = "";	
	    //this.setBounds(100, 100, 400, 400);
		Container con = this.getContentPane();
		JLabel lblTitle1 = new JLabel("�Ժ��չ�˾����Ϊ��ѯ��������ѯ������Ϣ");
		JLabel lblTitle2 = new JLabel("���չ�˾����Ϊ6-20�������ַ��� ");
		con.add(lblTitle1);
		con.add(lblTitle2);
		//���չ�˾����
		JLabel lblPrice1 = new JLabel("���չ�˾����:");
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
		con.setLayout(new GridLayout(3,2,25,40));//ÿ���������
		con.setSize(200,100);
		this.pack();
		this.setLocationRelativeTo(null);
	  }
		  
		//"ȷ��""ȡ��"��ť����Ӧ
	  public void actionPerformed(ActionEvent e)
	  {
		  if( e.getActionCommand()==strSearch)
		  {
			  boolean bResult = ValidCompanyName();
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
	  
	  //���չ�˾����Ϊ6-20�������ַ��� 
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
		  else //�Ƿ��ļ۸�
			  flag = false;
		  return flag;
	  }
	  
	  //��ȡ���չ�˾����
	  public String GetCompanyTitle()
	  {
		  return this.m_strCompany;
	  }

  	  //�����Ч��ѯ���򷵻�true��
	  //���򷵻�false
	  public boolean GetValidSearch()
	  {
		  return bDoOK;
	  }

}
