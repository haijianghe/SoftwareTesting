/************************************************************
 *  测试挡风玻璃雨刷系统。
 *                  作者： 何海江  
***********************************************************/
public class OOTestCase {
	public static void main(String args[])
	{
		//操纵杆"抬起"事件的测试用例
		System.out.println("操纵杆抬起事件的测试用例");
		LeverSense lSense = new LeverSense(LeverPosition.OFF,PowerStatus.ON);
		System.out.println("操纵杆的位置在关闭状态，加电后，抬起，状态预期为：间歇");
		lSense.Up();
		if( LeverPosition.INT==lSense.GetPosition() )
			System.out.println("操纵杆的位置当前为：间歇");
		else
			System.out.println("错误：其它位置！");
		//LeverSense的自测试
		System.out.println("LeverSense的自测试开始......");
		int nErr = lSense.TestMyUp();
		if( nErr>0 )
		{
			System.out.print(nErr);
			System.out.println("  开始出错。");
		}
		else
			System.out.println("所有测试用例成功。");
	}
}


