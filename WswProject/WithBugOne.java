import java.awt.List;


public class WithBugOne {
	private int age;  //����
	private String name; //����
	private String Address;//��ַ
	private String Telphone;//�绰
	private float w;//����
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
	
	//��ָ�������
	public String CheckNullPointer(String str)
	{
		List xmList = new List();
		xmList.add("����");
		xmList.add("����");
		xmList.add("wang5");
		xmList.add("he6");
		xmList.add(str);
		String nm = xmList.getItem(3);
		if( nm=="wang5" )
			return "wang5";
		else 
			return "other people";
	}
	//�������
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
