/*
 *���ڰ׺в��ԡ� 
 */
public class HFlightInfo {
	private String m_strID; //�����
	private String m_strName; //��������
	private String m_strCompany; //���չ�˾����
	private float m_fPrice;  //�۸�
	private int m_nSeat; //��λ��Ŀ
    //���캯��
	public HFlightInfo()
	{
		setStrID("");
		setStrName("");
		setStrCompany("");
		setfPrice(0.0f);
		setSeat(0);
	}
	//���������������õĹ��캯��
	public HFlightInfo(String sid, String sname, String scmy, float  price, int seat)
	{
		setStrID(sid);
		setStrName(sname);
		setStrCompany(scmy);
		setfPrice(price);
		setSeat(seat);
	}
	
	//��ȡ���չ�˾����
	public String getStrCompany() {
		return m_strCompany;
	}
	
	//���ú��չ�˾����
	public void setStrCompany(String strCompany) {
		this.m_strCompany = strCompany;
	}
	
	//��ȡ��������
	public String getStrName() {
		return m_strName;
	}
	
	//���ú�������
	public void setStrName(String strName) {
		this.m_strName = strName;
	}
	
	//��ȡ�����
	public String getStrID() {
		return m_strID;
	}
	
	//���ú����
	public void setStrID(String strID) {
		this.m_strID = strID;
	}
	
	//��ȡ�۸�
	public float getfPrice() {
		return m_fPrice;
	}
	
	//���ü۸�
	public void setfPrice(float fPrice) {
		this.m_fPrice = fPrice;
	}
	
	//��ȡ��λ��Ŀ
	public int getSeat() {
		return m_nSeat;//by hehaijiang
	}
	
	//������λ��Ŀ
	public void setSeat(int nSeat) {
		this.m_nSeat = nSeat;
	}
	
	//��ȡ�������Ϣ,���Ϊ�ַ���
	//������Ϣ����������ţ��������ƣ����չ�˾���ƣ��۸���λ��Ŀ
	public String GetInfo()
	{
		StringBuffer sbInfo = new StringBuffer();
		sbInfo.append("�����:"+ m_strID+", ");
		sbInfo.append("��������:"+m_strName+", ");
		sbInfo.append("���չ�˾����:"+m_strCompany+", ");
		sbInfo.append("�۸�:"+String.valueOf(m_fPrice)+", ");
		sbInfo.append("��λ��Ŀ:"+String.valueOf(m_nSeat));
		return sbInfo.toString();
	}
}
