import java.awt.List;


public class WithBugOne {
	private int age;  //年龄
	private String name; //姓名
	private String Address;//地址
	private String Telphone;//电话
	private float w;//体重
	public WithBugOne()
	{
		age = 20;
		name = "";
	}
	public WithBugOne(int nl,String xm)
	{
		age = nl;
		name = xm;
	}
	
	public String ReplaceName(char c)
	{
		String aString = name;    
		aString.replace('b', c);    
		if(aString.equals(name)) 
			return name;
		else
			return aString;
	}
	
	//空指针的问题
	public String CheckNullPointer(String str)
	{
		List xmList = new List();
		xmList.add("张三");
		xmList.add("李四");
		xmList.add("wang5");
		xmList.add("he6");
		xmList.add(str);
		String nm = xmList.getItem(3);
		if( nm=="wang5" )
			return "wang5";
		else 
			return "other people";
	}
	//命名检查
	public int GetTheAgeOfClassOfWithBugOneWhenYouCallTheMethodItWillReturnToYou()
	{
		int i,j,k;
		int s;
		for( i=0;i<2;i++ )
		{
			j=1;
			s = j+age;
			for( k=0;k<3;k++)
				s = s+j;
		}
		return age;
	}
}
