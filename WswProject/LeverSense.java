/*操纵杆类*/
public class LeverSense {
	private int nPosition; //操纵杆的位置
	private int nStatus;  //电源状态
	//构造函数
	public LeverSense()
	{
		nPosition = LeverPosition.OFF; //操纵杆处于“关”
		nStatus = PowerStatus.OFF;  //电源是关闭状态
	}
	//构造带参数的操纵杆类
	public LeverSense(int nPower,int nPos)
	{
		nPosition = nPos; //操纵杆位置
		nStatus = nPower;  //电源状态
	}
	//操纵杆抬起,只有带电才起作用。
	public void Up()
	{
		if( PowerStatus.OFF==nStatus )
			return;
		switch( nPosition )
		{
		case LeverPosition.OFF:
			nPosition = LeverPosition.INT;	break;
		case LeverPosition.INT:
			nPosition = LeverPosition.LOW;	break;
		default:
			nPosition = LeverPosition.HIGH;	break;
		}
	}
	//操纵杆放下,只有带电才起作用。
	public void Down()
	{
		if( PowerStatus.OFF==nStatus )
			return;
		switch( nPosition )
		{
		case LeverPosition.HIGH:
			nPosition = LeverPosition.LOW;	break;
		case LeverPosition.LOW:
			nPosition = LeverPosition.INT;	break;
		default:
			nPosition = LeverPosition.OFF;	break;
		}
	}
	//获得操纵杆的位置
	public int GetPosition()
	{
		return nPosition;
	}
	//设定操纵杆的位置。
	public void SetPosition(int nPos)
	{
		nPosition = nPos;
	}
	//改变电源状态
	public void SetPowerStatus( int nps )
	{
		nStatus = nps;
	}
	//测试我自己的Up()
	//返回值为0，说明所有测试用例执行结果符合预期；否则，在第（返回值）个测试用例，与预期不符。
	public int TestMyUp()
	{
		//第一个测试用例，断电后不能改变状态。
		SetPowerStatus(PowerStatus.OFF);
		SetPosition(LeverPosition.LOW);
		Up();
		if( LeverPosition.LOW!=GetPosition() ) //起始状态为LOW，抬起操纵杆后状态仍为LOW。
			return 1;
		//第二个测试用例，加电和抬起操纵杆后状态从LOW->HIGH。
		SetPowerStatus(PowerStatus.ON);
		SetPosition(LeverPosition.LOW);
		Up();
		if( LeverPosition.HIGH!=GetPosition() )
			return 2;
		//第三个测试用例，加电和抬起操纵杆后状态从HIGH->HIGH。
		SetPowerStatus(PowerStatus.ON);
		SetPosition(LeverPosition.HIGH);
		Up();
		if( LeverPosition.HIGH!=GetPosition() )
			return 3;
		//第四个测试用例，加电和抬起操纵杆后状态从OFF->INT。
		SetPowerStatus(PowerStatus.ON);
		SetPosition(LeverPosition.OFF);
		Up();
		if( LeverPosition.INT!=GetPosition() )
			return 4;
		return 0;
	}
}
