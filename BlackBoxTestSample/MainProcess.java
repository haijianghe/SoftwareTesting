/*
 *���ںںв��ԡ� �����ߣ��κ�����
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
	 * �����ҵ������򣬴���һ��Java��Frame,ʹ��Swing�����������ߣ��κ�����
	 */
	private static final long serialVersionUID = 1L;
	private static MainProcess m_mProc = null;
	
	public static void main(String[] args) {  
        //���ڴ�����һ�����󣬲���ʲô����ʾ������  
		m_mProc = new MainProcess();  
    	//��Ӳ˵����������趨λ�ã����Զ��������ϲ�       
    	//�����˵�������
    	HMenuAction hmaMenuAction = new HMenuAction();//�˵���Ӧ�¼�
    	JMenuBar jmb = AddMenu(hmaMenuAction);
    	m_mProc.setJMenuBar(jmb);  
        //������һ��Ϳ�����ʾһ�����йرգ���С������󻯵İ�ť��Frame��  
    	m_mProc.setVisible(true);
    	m_mProc.setTitle("�ںв��Խ�ѧ����");
        //�ټ�����һ��Ϳ�����ʾһ�������Ͻǣ�ӵ��ָ����С��Frame��  
    	m_mProc.setSize(800,600);  
        //�ټ�����һ��Ϳ��԰�Frame�������м���  
    	m_mProc.setLocationRelativeTo(null);  
        //���û����һ�䣬�ڵ���ر�Frame��ʱ�������ʵ������ִ��״̬�еģ�������һ������������İ���Դ�ͷŵ���  
    	m_mProc.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	//��ʾ���к����¼
    	m_mProc.setLayout(new FlowLayout());  
    	JLabel txtPrompt = new JLabel("<html><body><h1>���к����¼</h1></body></html>");  
    	m_mProc.add(txtPrompt);
    	JTextArea txtAllFlight = null; //��ʾ���к����¼
    	txtAllFlight = new JTextArea(""); 
    	txtAllFlight.setLineWrap(true);// ������ݹ������Զ�����

    	//txtAllFlight.setRows(100);
    	txtAllFlight.setColumns(100);
    	txtAllFlight.setEditable(false);  
    	hmaMenuAction.SetShowArea(txtAllFlight);//������ʾ���򣬼�����ϡ�
    	m_mProc.add(txtAllFlight);
    	m_mProc.setLayout(new FlowLayout(FlowLayout.LEFT));
    	//mProc.setLayout(new GridLayout());//ÿ���������
    	m_mProc.validate();
	}  
	//��Ӳ˵�����
	//�˵�������	 hmaAction
	protected static JMenuBar AddMenu(HMenuAction hmaAction)
	{
		 JMenuBar jmbWork;   //���˵������  
		 JMenu mnuFile, mnuOperator, mnuHelp;//�˵�  
		 JMenuItem jmiReadFile, jmiWriteFile, jmiAddTick,jmiDelTick,jmiRemoveAll;//mnuFile�ļ��Ĳ˵���
		 JMenuItem jmiSearchPrice, jmiSearchCompany;//mnuOperator��ѯͳ�ƵĲ˵���
		 JMenuItem jmiIntroduce, jmiAboutMe;//mnuHelp�����Ĳ˵���
		 
		 //�����˵�  
		 jmbWork = new JMenuBar();  
	     //�ļ�����     
		 mnuFile = new JMenu("�ļ�(F)");  
		 mnuFile.setMnemonic('F'); //���Ƿ�  
		 jmiReadFile = new JMenuItem(HMenuAction.strReadFile);  
		 jmiReadFile.addActionListener(hmaAction );// �˵�����¼�
		 jmiWriteFile = new JMenuItem(HMenuAction.strWriteFile);
		 jmiWriteFile.addActionListener(hmaAction );// �˵�����¼�
		 jmiAddTick = new JMenuItem(HMenuAction.strAddFlight);
		 jmiAddTick.addActionListener(hmaAction );// �˵�����¼�
		 jmiDelTick = new JMenuItem(HMenuAction.strDelFlight);
		 jmiDelTick.addActionListener(hmaAction );// �˵�����¼�
		 jmiRemoveAll = new JMenuItem(HMenuAction.strRemoveAllFlight);
		 jmiRemoveAll.addActionListener(hmaAction );// �˵�����¼�
		 //��Ӳ˵������˵��� 
		 mnuFile.add(jmiReadFile);
		 mnuFile.add(jmiWriteFile);
		 mnuFile.insertSeparator(2);
		 mnuFile.add(jmiAddTick);
		 mnuFile.add(jmiDelTick);
		 mnuFile.add(jmiRemoveAll);
		//���˵��������˵��� 
		 jmbWork.add(mnuFile);
		//��ѯͳ��     
		 mnuOperator = new JMenu("��ѯͳ��(D)");  
		 mnuOperator.setMnemonic('D'); //���Ƿ�  
		 jmiSearchPrice = new JMenuItem(HMenuAction.strPriceSearch);
		 jmiSearchPrice.addActionListener(hmaAction );// �˵�����¼�
		 jmiSearchCompany = new JMenuItem(HMenuAction.strAirlineNameSearch);
		 jmiSearchCompany.addActionListener(hmaAction );// �˵�����¼�
		 //��Ӳ˵������˵��� 
		 mnuOperator.add(jmiSearchPrice);
		 mnuOperator.add(jmiSearchCompany);
		//���˵��������˵��� 
		 jmbWork.add(mnuOperator);
			//��ѯͳ��     
		 mnuHelp = new JMenu("����(H)");  
		 mnuHelp.setMnemonic('H'); //���Ƿ�  
		 jmiIntroduce = new JMenuItem(HMenuAction.strHelp);
		 jmiIntroduce.addActionListener(hmaAction );// �˵�����¼�
		 jmiAboutMe = new JMenuItem(HMenuAction.strAboutMe);
		 jmiAboutMe.addActionListener(hmaAction );// �˵�����¼�
		 //��Ӳ˵������˵��� 
		 mnuHelp.add(jmiIntroduce);
		 mnuHelp.add(jmiAboutMe);
		//���˵��������˵��� 
		 jmbWork.add(mnuHelp);
    	//�������˵�
    	return jmbWork;
	}
}  

