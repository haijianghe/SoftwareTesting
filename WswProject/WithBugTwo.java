
public class WithBugTwo {
	private String strName;//书名
	private String strPublisher;//出版社
	private String strAuthor;//作者
	private double price; //价格
	
	public WithBugTwo()
	{
		strName = "";
		price = 0.0;
	}
	public WithBugTwo(String sm,String cbs,String zz,double jg)
	{
		strName = sm;
		strPublisher = cbs;
		strAuthor = zz;
		price = jg;
	}
	public String GetName()
	{
		return strName;
	}
	public String GetPublisher()
	{
		return strPublisher;
	}
	public double GetPrice()
	{
		return price;
	}
	public int IsThisPrice(double np)
	{
		if( np==price )
			return 1;
		else
			return 0;
	}
}
