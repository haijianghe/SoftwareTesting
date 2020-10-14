/*
 *用于白盒测试。 
 */
public class HFlightInfo {
	private String m_strID; //航班号
	private String m_strName; //航班名称
	private String m_strCompany; //航空公司名称
	private float m_fPrice;  //价格
	private int m_nSeat; //座位数目
    //构造函数
	public HFlightInfo()
	{
		setStrID("");
		setStrName("");
		setStrCompany("");
		setfPrice(0.0f);
		setSeat(0);
	}
	//允许所有属性设置的构造函数
	public HFlightInfo(String sid, String sname, String scmy, float  price, int seat)
	{
		setStrID(sid);
		setStrName(sname);
		setStrCompany(scmy);
		setfPrice(price);
		setSeat(seat);
	}
	
	//获取航空公司名称
	public String getStrCompany() {
		return m_strCompany;
	}
	
	//设置航空公司名称
	public void setStrCompany(String strCompany) {
		this.m_strCompany = strCompany;
	}
	
	//获取航班名称
	public String getStrName() {
		return m_strName;
	}
	
	//设置航班名称
	public void setStrName(String strName) {
		this.m_strName = strName;
	}
	
	//获取航班号
	public String getStrID() {
		return m_strID;
	}
	
	//设置航班号
	public void setStrID(String strID) {
		this.m_strID = strID;
	}
	
	//获取价格
	public float getfPrice() {
		return m_fPrice;
	}
	
	//设置价格
	public void setfPrice(float fPrice) {
		this.m_fPrice = fPrice;
	}
	
	//获取座位数目
	public int getSeat() {
		return m_nSeat;//by hehaijiang
	}
	
	//设置座位数目
	public void setSeat(int nSeat) {
		this.m_nSeat = nSeat;
	}
	
	//获取航班号信息,打包为字符串
	//航班信息包括：航班号，航班名称，航空公司名称，价格，座位数目
	public String GetInfo()
	{
		StringBuffer sbInfo = new StringBuffer();
		sbInfo.append("航班号:"+ m_strID+", ");
		sbInfo.append("航班名称:"+m_strName+", ");
		sbInfo.append("航空公司名称:"+m_strCompany+", ");
		sbInfo.append("价格:"+String.valueOf(m_fPrice)+", ");
		sbInfo.append("座位数目:"+String.valueOf(m_nSeat));
		return sbInfo.toString();
	}
}
