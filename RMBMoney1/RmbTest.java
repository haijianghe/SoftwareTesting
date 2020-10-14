import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class RmbTest {
	private Money mnyUSD; //������Ĳ���ʹ�ã���setUp�ܳ�ʼ��
	@Before
	public void setUp() throws Exception {
		mnyUSD = new Money(80,"USD");
	}

	@After
	public void tearDown() throws Exception {
		//�˴��ɷ����ͷ���Դ�Ĵ��롣
	}

	@Test
	public void test() {
		//�������һ��ʧ�ܵĲ���������
		fail("Not yet implemented");
	}

	//�˲�������������Money�ķ���AddAmount
	//ע�⣺��ʱ����Ҫ��������������ܷ��ִ�����롣
	//�������жϣ�TestCase.assertEquals(expected, actual);
	//���������жϣ�TestCase.assertEquals(expected, actual, delta);

	@Test
	public void testAddAmount()
	{
		mnyUSD.AddAmount(30); 
		TestCase.assertEquals(110, mnyUSD.GetAmount(),1e-5);
	}
	
	//�˲�������������Money�ķ���multiply
	@Test
	public void testMultiAmount()
	{
		mnyUSD.multiply(3);
		TestCase.assertEquals(240, mnyUSD.GetAmount(),1e-5);
	}
	
	//�˲�������������Money�ķ���ToString
	@Test
	public void testToString()
	{
		
		TestCase.assertEquals("[80.0 USD]", mnyUSD.toString());
	}
}
