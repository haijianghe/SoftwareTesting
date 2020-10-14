/*挡风玻璃雨刷类*/
public class WindshieldWiper {
	private LeverSense lever;  //操纵杆
	private DialSense dial;    //刻度盘
	private int nPowerStatus;  //电源状态
	//构造函数
	public WindshieldWiper()
	{
		nPowerStatus = PowerStatus.OFF;
	}
	//构造带参数的挡风玻璃雨刷类
	public WindshieldWiper(int nPower,int nLeverPos,int nDialPot)
	{
		nPowerStatus = nPower;
		lever.SetPowerStatus(nPower);
		lever.SetPosition(nLeverPos);
		dial.SetPowerStatus(nPower);
		dial.SetPointer(nDialPot);
	}
	//设置操纵杆和刻度盘的位置
	public void SetLeverDial(int nLeverPos,int nDialPot)
	{
		lever.SetPosition(nLeverPos);
		dial.SetPointer(nDialPot);
	}
	//加电
	public void PowerOn()
	{
		nPowerStatus = PowerStatus.ON;
		lever.SetPowerStatus(PowerStatus.ON);
		dial.SetPowerStatus(PowerStatus.ON);
	}
	//断电
	public void PowerOff()
	{
		nPowerStatus = PowerStatus.OFF;
		lever.SetPowerStatus(PowerStatus.OFF);
		dial.SetPowerStatus(PowerStatus.OFF);
	}
	//获得雨刷的速度
	public int GetSpeed()
	{
		int nSpeed = 0;
		if( PowerStatus.OFF==nPowerStatus )
			return nSpeed = 0; //断电的状态，速度为零。
		switch(lever.GetPosition())
		{
		case LeverPosition.OFF:
			nSpeed = 0;	break;
		case LeverPosition.INT:
			int ndp = dial.GetPointer();
			if(ndp==1)
				nSpeed = 4;
			else if(ndp==2)
				nSpeed = 6;
			else
				nSpeed = 12;
			break;
		case LeverPosition.LOW:
			nSpeed = 30;	break;
		case LeverPosition.HIGH:
			nSpeed = 60;	break;
		}
		return nSpeed;
	}
}
