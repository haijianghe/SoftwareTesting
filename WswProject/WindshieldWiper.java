/*���粣����ˢ��*/
public class WindshieldWiper {
	private LeverSense lever;  //���ݸ�
	private DialSense dial;    //�̶���
	private int nPowerStatus;  //��Դ״̬
	//���캯��
	public WindshieldWiper()
	{
		nPowerStatus = PowerStatus.OFF;
	}
	//����������ĵ��粣����ˢ��
	public WindshieldWiper(int nPower,int nLeverPos,int nDialPot)
	{
		nPowerStatus = nPower;
		lever.SetPowerStatus(nPower);
		lever.SetPosition(nLeverPos);
		dial.SetPowerStatus(nPower);
		dial.SetPointer(nDialPot);
	}
	//���ò��ݸ˺Ϳ̶��̵�λ��
	public void SetLeverDial(int nLeverPos,int nDialPot)
	{
		lever.SetPosition(nLeverPos);
		dial.SetPointer(nDialPot);
	}
	//�ӵ�
	public void PowerOn()
	{
		nPowerStatus = PowerStatus.ON;
		lever.SetPowerStatus(PowerStatus.ON);
		dial.SetPowerStatus(PowerStatus.ON);
	}
	//�ϵ�
	public void PowerOff()
	{
		nPowerStatus = PowerStatus.OFF;
		lever.SetPowerStatus(PowerStatus.OFF);
		dial.SetPowerStatus(PowerStatus.OFF);
	}
	//�����ˢ���ٶ�
	public int GetSpeed()
	{
		int nSpeed = 0;
		if( PowerStatus.OFF==nPowerStatus )
			return nSpeed = 0; //�ϵ��״̬���ٶ�Ϊ�㡣
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
