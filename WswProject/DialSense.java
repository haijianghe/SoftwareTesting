/*�̶�����*/
public class DialSense {
	private int nPointer; //�̶���ָ��
	private int nStatus;//��Դ״̬
	//���캯��
	public DialSense()
	{
		nPointer = 1; //�̶���ָ����ʼλ�ã� 1
		nStatus = PowerStatus.OFF;  //��Դ�ǹر�״̬
	}
	//����������Ĳ��ݸ���
	public DialSense(int nPower,int nPos)
	{
		nPointer = nPos; //�̶���ָ��
		nStatus = nPower;  //��Դ״̬
	}
	//���ӿ̶���,ֻ�д���������á�
	public void Increment()
	{
		if( PowerStatus.OFF==nStatus )
			return;
		if( 1==nPointer )	nPointer = 2;
		else if( 2==nPointer )	nPointer = 3;
		else nPointer = 3;
	}
	//��С�̶���,ֻ�д���������á�
	public void Decrement()
	{
		if( PowerStatus.OFF==nStatus )
			return;
		if( 3==nPointer )	nPointer = 2;
		else if( 2==nPointer )	nPointer = 1;
		else nPointer = 1;
	}
	//��ÿ̶���ָ��
	public int GetPointer()
	{
		return nPointer;
	}
	//�趨�̶���ָ�롣
	public void SetPointer(int nPos)
	{
		nPointer = nPos;
	}
	//�ı��Դ״̬
	public void SetPowerStatus( int nps )
	{
		nStatus = nps;
	}
}
