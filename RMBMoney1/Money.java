/*һ���򵥵��࣬��ѧ������Junit�İ�װ��ʹ��.*/

public class Money {
	private float fAmount; //���
	private String strCurrency; //����
	//���캯�����κ���
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
	//���
	public void AddAmount(float amount)
	{
		fAmount += amount;
	}
	//���
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
