/*一个简单的类，给学生介绍Junit的安装和使用.*/

public class Money {
	private float fAmount; //金额
	private String strCurrency; //币种
	//构造函数，何海江
	public Money(float amount,String currency)
	{
		fAmount = amount;
		strCurrency = currency;
	}
	public float GetAmount()
	{
		return fAmount;
	}
	public String GetCurrency()
	{
		return strCurrency;
	}
	//相加
	public void AddAmount(float amount)
	{
		fAmount += amount;
	}
	//相乘
	public void multiply(float factor)
	{
		fAmount *= factor;
	}
	@Override
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("["+GetAmount()+" "+GetCurrency()+"]");
		return buffer.toString();
	}
}
