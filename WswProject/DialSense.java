/*刻度盘类*/
public class DialSense {
	private int nPointer; //刻度盘指针
	private int nStatus;//电源状态
	//构造函数
	public DialSense()
	{
		nPointer = 1; //刻度盘指针起始位置： 1
		nStatus = PowerStatus.OFF;  //电源是关闭状态
	}
	//构造带参数的操纵杆类
	public DialSense(int nPower,int nPos)
	{
		nPointer = nPos; //刻度盘指针
		nStatus = nPower;  //电源状态
	}
	//增加刻度盘,只有带电才起作用。
	public void Increment()
	{
		if( PowerStatus.OFF==nStatus )
			return;
		if( 1==nPointer )	nPointer = 2;
		else if( 2==nPointer )	nPointer = 3;
		else nPointer = 3;
	}
	//调小刻度盘,只有带电才起作用。
	public void Decrement()
	{
		if( PowerStatus.OFF==nStatus )
			return;
		if( 3==nPointer )	nPointer = 2;
		else if( 2==nPointer )	nPointer = 1;
		else nPointer = 1;
	}
	//获得刻度盘指针
	public int GetPointer()
	{
		return nPointer;
	}
	//设定刻度盘指针。
	public void SetPointer(int nPos)
	{
		nPointer = nPos;
	}
	//改变电源状态
	public void SetPowerStatus( int nps )
	{
		nStatus = nps;
	}
}
