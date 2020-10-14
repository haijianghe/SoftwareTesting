import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class RmbTest {
	private Money mnyUSD; //供后面的测试使用，在setUp总初始化
	@Before
	public void setUp() throws Exception {
		mnyUSD = new Money(80,"USD");
	}

	@After
	public void tearDown() throws Exception {
		//此处可放置释放资源的代码。
	}

	@Test
	public void test() {
		//故意放置一个失败的测试用例。
		fail("Not yet implemented");
	}

	//此测试用例：测试Money的方法AddAmount
	//注意：有时候需要多个测试用例才能发现错误代码。
	//整数的判断：TestCase.assertEquals(expected, actual);
	//浮点数的判断：TestCase.assertEquals(expected, actual, delta);

	@Test
	public void testAddAmount()
	{
		mnyUSD.AddAmount(30); 
		TestCase.assertEquals(110, mnyUSD.GetAmount(),1e-5);
	}
	
	//此测试用例：测试Money的方法multiply
	@Test
	public void testMultiAmount()
	{
		mnyUSD.multiply(3);
		TestCase.assertEquals(240, mnyUSD.GetAmount(),1e-5);
	}
	
	//此测试用例：测试Money的方法ToString
	@Test
	public void testToString()
	{
		
		TestCase.assertEquals("[80.0 USD]", mnyUSD.toString());
	}
}
