/************************************************************
 *  ���Ե��粣����ˢϵͳ��
 *                  ���ߣ� �κ���  
***********************************************************/
public class OOTestCase {
	public static void main(String args[])
	{
		//���ݸ�"̧��"�¼��Ĳ�������
		System.out.println("���ݸ�̧���¼��Ĳ�������");
		LeverSense lSense = new LeverSense(LeverPosition.OFF,PowerStatus.ON);
		System.out.println("���ݸ˵�λ���ڹر�״̬���ӵ��̧��״̬Ԥ��Ϊ����Ъ");
		lSense.Up();
		if( LeverPosition.INT==lSense.GetPosition() )
			System.out.println("���ݸ˵�λ�õ�ǰΪ����Ъ");
		else
			System.out.println("��������λ�ã�");
		//LeverSense���Բ���
		System.out.println("LeverSense���Բ��Կ�ʼ......");
		int nErr = lSense.TestMyUp();
		if( nErr>0 )
		{
			System.out.print(nErr);
			System.out.println("  ��ʼ����");
		}
		else
			System.out.println("���в��������ɹ���");
	}
}


