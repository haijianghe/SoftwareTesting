/*
 *用于白盒测试。 
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
 * 这是以价格来查询航班的类。（作者：何海江）
 */
public class HSearchPrice extends JDialog implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String strSearch = "开始查询";
	public static final String strCancel = "终止查询";
	JTextField txtMinPrice;//小的那个票价输入框
	JTextField txtMaxPrice;//大的那个票价输入框
	
	float fMinPrice,fMaxPrice;//小的那个票价,fMaxPrice大的那个票价
	boolean bDoOK = false; //如果有效查询，则是true，；否则false
	
	//构造函数
	HSearchPrice(JFrame jFrame)
	{
	    super(jFrame,"以票价为查询条件，查询航班信息",true);//模态
	    fMinPrice = 0.0f;	
	    fMaxPrice = 0.0f;	
	    //this.setBounds(100, 100, 400, 400);
		Container con = this.getContentPane();
		JLabel lblTitle1 = new JLabel("以票价为查询条件");
		JLabel lblTitle2 = new JLabel("按终止查询，退出对话框。 ");
		con.add(lblTitle1);
		con.add(lblTitle2);
		//小的那个票价
		JLabel lblPrice1 = new JLabel("机票价格处于:");
		txtMinPrice = new JTextField(8);
		txtMinPrice.setEditable(true);
		con.add(lblPrice1);
		con.add(txtMinPrice);
		//大的那个票价
		JLabel lblPrice2 = new JLabel("和:");
		txtMaxPrice = new JTextField(10);
		txtMaxPrice.setEditable(true);
		con.add(lblPrice2);
		con.add(txtMaxPrice);
		//提示信息
		JLabel lblPrompt1 = new JLabel("输入注意事项：1，两个输入框");
		JLabel lblPrompt2 = new JLabel("都只能输入大于零的浮点数。");
		JLabel lblPrompt3 = new JLabel("其值只能在100到1800之间。");
		JLabel lblPrompt4 = new JLabel(" ");
		JLabel lblPrompt5 = new JLabel("第一个输入框的数值（价格）");
		JLabel lblPrompt6 = new JLabel("必须小于第二个输入框的数值。");
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
		con.setLayout(new GridLayout(7,2,25,40));//每行两个组件
		con.setSize(200,100);
		this.pack();
		this.setLocationRelativeTo(null);
	  }
		  
		//"确定""取消"按钮的响应
	  public void actionPerformed(ActionEvent e)
	  {
		  if( e.getActionCommand()==strSearch)
		  {
			  boolean bResult = ValidPrice();
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
	  
	  //验证机票价格是否输入正确。
	  //输入机票价格（允许小数，100<=价格<=1800  第一个价格必须小于第二个价格
	  //有效，返回true;否则，返回false.
	  private boolean ValidPrice()
	  {
		  boolean flag = true;
		  String str = txtMinPrice.getText();
		  float price = 0.0f;
		  try
		  {//txtMinPrice可能为空字符串或者其它非法浮点数字符串，所以要出错处理
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
			  else //非法的价格
				  flag = false;
		  }
		  if( true==flag)
		  {
			  fMinPrice = price;
			  str = txtMaxPrice.getText();
			  try
			  {//txtMinPrice可能为空字符串或者其它非法浮点数字符串，所以要出错处理
				  price = Float.parseFloat(str);
			  }
			  catch(Exception e)
			  {
				  flag = true;
			  }
			  if( true==flag )
			  {
				  if( price>=100.0f && price<=1800.0f )
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
	  
	  //获取查询票价的最小值
	  public float GetMinPrice()
	  {
		  return this.fMinPrice;
	  }

	  //获取查询票价的最大值
	  public float GetMaxPrice()
	  {
		  return this.fMaxPrice;
	  }
	  
	  //如果有效查询，则返回true；
	  //否则返回false
	  public boolean GetValidSearch()
	  {
		  return bDoOK;
	  }
}
