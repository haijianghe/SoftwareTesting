/*
 *用于黑盒测试。 （作者：何海江）
 */

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;  
  
public class MainProcess extends JFrame{  
  
    /**
	 * 这是我的主程序，创建一个Java的Frame,使用Swing技术。（作者：何海江）
	 */
	private static final long serialVersionUID = 1L;
	private static MainProcess m_mProc = null;
	
	public static void main(String[] args) {  
        //现在创建了一个对象，不过什么都显示不出来  
		m_mProc = new MainProcess();  
    	//添加菜单栏，不能设定位置，会自动放在最上部       
    	//创建菜单处理类
    	HMenuAction hmaMenuAction = new HMenuAction();//菜单响应事件
    	JMenuBar jmb = AddMenu(hmaMenuAction);
    	m_mProc.setJMenuBar(jmb);  
        //加上这一句就可以显示一个仅有关闭，最小化，最大化的按钮的Frame了  
    	m_mProc.setVisible(true);
    	m_mProc.setTitle("黑盒测试教学案例");
        //再加上这一句就可以显示一个在左上角，拥有指定大小的Frame了  
    	m_mProc.setSize(800,600);  
        //再加上这一句就可以把Frame放在最中间了  
    	m_mProc.setLocationRelativeTo(null);  
        //如果没有这一句，在点击关闭Frame的时候程序其实还是在执行状态中的，加上这一句才算是真正的把资源释放掉了  
    	m_mProc.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	//显示所有航班记录
    	m_mProc.setLayout(new FlowLayout());  
    	JLabel txtPrompt = new JLabel("<html><body><h1>所有航班记录</h1></body></html>");  
    	m_mProc.add(txtPrompt);
    	JTextArea txtAllFlight = null; //显示所有航班记录
    	txtAllFlight = new JTextArea(""); 
    	txtAllFlight.setLineWrap(true);// 如果内容过长。自动换行

    	//txtAllFlight.setRows(100);
    	txtAllFlight.setColumns(100);
    	txtAllFlight.setEditable(false);  
    	hmaMenuAction.SetShowArea(txtAllFlight);//关联显示区域，减少耦合。
    	m_mProc.add(txtAllFlight);
    	m_mProc.setLayout(new FlowLayout(FlowLayout.LEFT));
    	//mProc.setLayout(new GridLayout());//每行两个组件
    	m_mProc.validate();
	}  
	//添加菜单条。
	//菜单处理类	 hmaAction
	protected static JMenuBar AddMenu(HMenuAction hmaAction)
	{
		 JMenuBar jmbWork;   //主菜单条组件  
		 JMenu mnuFile, mnuOperator, mnuHelp;//菜单  
		 JMenuItem jmiReadFile, jmiWriteFile, jmiAddTick,jmiDelTick,jmiRemoveAll;//mnuFile文件的菜单项
		 JMenuItem jmiSearchPrice, jmiSearchCompany;//mnuOperator查询统计的菜单项
		 JMenuItem jmiIntroduce, jmiAboutMe;//mnuHelp帮助的菜单项
		 
		 //创建菜单  
		 jmbWork = new JMenuBar();  
	     //文件操作     
		 mnuFile = new JMenu("文件(F)");  
		 mnuFile.setMnemonic('F'); //助记符  
		 jmiReadFile = new JMenuItem(HMenuAction.strReadFile);  
		 jmiReadFile.addActionListener(hmaAction );// 菜单添加事件
		 jmiWriteFile = new JMenuItem(HMenuAction.strWriteFile);
		 jmiWriteFile.addActionListener(hmaAction );// 菜单添加事件
		 jmiAddTick = new JMenuItem(HMenuAction.strAddFlight);
		 jmiAddTick.addActionListener(hmaAction );// 菜单添加事件
		 jmiDelTick = new JMenuItem(HMenuAction.strDelFlight);
		 jmiDelTick.addActionListener(hmaAction );// 菜单添加事件
		 jmiRemoveAll = new JMenuItem(HMenuAction.strRemoveAllFlight);
		 jmiRemoveAll.addActionListener(hmaAction );// 菜单添加事件
		 //添加菜单项至菜单上 
		 mnuFile.add(jmiReadFile);
		 mnuFile.add(jmiWriteFile);
		 mnuFile.insertSeparator(2);
		 mnuFile.add(jmiAddTick);
		 mnuFile.add(jmiDelTick);
		 mnuFile.add(jmiRemoveAll);
		//将菜单加入至菜单栏 
		 jmbWork.add(mnuFile);
		//查询统计     
		 mnuOperator = new JMenu("查询统计(D)");  
		 mnuOperator.setMnemonic('D'); //助记符  
		 jmiSearchPrice = new JMenuItem(HMenuAction.strPriceSearch);
		 jmiSearchPrice.addActionListener(hmaAction );// 菜单添加事件
		 jmiSearchCompany = new JMenuItem(HMenuAction.strAirlineNameSearch);
		 jmiSearchCompany.addActionListener(hmaAction );// 菜单添加事件
		 //添加菜单项至菜单上 
		 mnuOperator.add(jmiSearchPrice);
		 mnuOperator.add(jmiSearchCompany);
		//将菜单加入至菜单栏 
		 jmbWork.add(mnuOperator);
			//查询统计     
		 mnuHelp = new JMenu("帮助(H)");  
		 mnuHelp.setMnemonic('H'); //助记符  
		 jmiIntroduce = new JMenuItem(HMenuAction.strHelp);
		 jmiIntroduce.addActionListener(hmaAction );// 菜单添加事件
		 jmiAboutMe = new JMenuItem(HMenuAction.strAboutMe);
		 jmiAboutMe.addActionListener(hmaAction );// 菜单添加事件
		 //添加菜单项至菜单上 
		 mnuHelp.add(jmiIntroduce);
		 mnuHelp.add(jmiAboutMe);
		//将菜单加入至菜单栏 
		 jmbWork.add(mnuHelp);
    	//建立主菜单
    	return jmbWork;
	}
}  

