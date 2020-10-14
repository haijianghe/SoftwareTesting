/*���ݸ���*/
public class LeverSense {
	private int nPosition; //���ݸ˵�λ��
	private int nStatus;  //��Դ״̬
	//���캯��
	public LeverSense()
	{
		nPosition = LeverPosition.OFF; //���ݸ˴��ڡ��ء�
		nStatus = PowerStatus.OFF;  //��Դ�ǹر�״̬
	}
	//����������Ĳ��ݸ���
	public LeverSense(int nPower,int nPos)
	{
		nPosition = nPos; //���ݸ�λ��
		nStatus = nPower;  //��Դ״̬
	}
	//���ݸ�̧��,ֻ�д���������á�
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
	//���ݸ˷���,ֻ�д���������á�
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
	//��ò��ݸ˵�λ��
	public int GetPosition()
	{
		return nPosition;
	}
	//�趨���ݸ˵�λ�á�
	public void SetPosition(int nPos)
	{
		nPosition = nPos;
	}
	//�ı��Դ״̬
	public void SetPowerStatus( int nps )
	{
		nStatus = nps;
	}
	//�������Լ���Up()
	//����ֵΪ0��˵�����в�������ִ�н������Ԥ�ڣ������ڵڣ�����ֵ����������������Ԥ�ڲ�����
	public int TestMyUp()
	{
		//��һ�������������ϵ���ܸı�״̬��
		SetPowerStatus(PowerStatus.OFF);
		SetPosition(LeverPosition.LOW);
		Up();
		if( LeverPosition.LOW!=GetPosition() ) //��ʼ״̬ΪLOW��̧����ݸ˺�״̬��ΪLOW��
			return 1;
		//�ڶ��������������ӵ��̧����ݸ˺�״̬��LOW->HIGH��
		SetPowerStatus(PowerStatus.ON);
		SetPosition(LeverPosition.LOW);
		Up();
		if( LeverPosition.HIGH!=GetPosition() )
			return 2;
		//�����������������ӵ��̧����ݸ˺�״̬��HIGH->HIGH��
		SetPowerStatus(PowerStatus.ON);
		SetPosition(LeverPosition.HIGH);
		Up();
		if( LeverPosition.HIGH!=GetPosition() )
			return 3;
		//���ĸ������������ӵ��̧����ݸ˺�״̬��OFF->INT��
		SetPowerStatus(PowerStatus.ON);
		SetPosition(LeverPosition.OFF);
		Up();
		if( LeverPosition.INT!=GetPosition() )
			return 4;
		return 0;
	}
}
