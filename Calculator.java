import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator extends Applet implements ActionListener,Runnable//,KeyListener
{
	String msg="0:0:0";
	Thread t=null;
	boolean stopFlag;
	public void start()
	{
	t=new Thread(this);
	t.start();
	stopFlag=false;
	}
	public void paint(Graphics g)
	{
		showStatus(msg);
	}
	public void stop()
	{
		stopFlag=true;
		t=null;
	}
	public void run()
	{
		int i=0,j=0,k=1;
		while(true)
		{
			try
			{
				Thread.sleep(500);
				msg=" "+i+":"+j+":"+k;
				repaint();
				Thread.sleep(500);
				msg=" "+i+" "+j+" "+k;
				repaint();
				k++;
				if(k>=60)
				{
					j++;
					k=0;
				}	
				if(j>=60)
				{
					i++;
					j=0;
				}	
				if(stopFlag)
					break;
			}
			catch(Exception e)
			{
				System.out.println("Clock is off");
			}
		}
	}
	int permutation(int n,int r)
	{
		int k;
		k=factorial(n)/(factorial(n-r));
		return k;	
	}
	int combination(int n,int r)
	{
		int k;
		k=factorial(n)/(factorial(n-r)*factorial(r));
		return k;
	}
	String prime(int num)
	{
		int i,s=0;
		if(num==1)
			return "Not Defined";
		else
		{	
			for(i=2;i<=num/2;i++)
			{
				if(num%i==0)
					s++;
			}	
			if(s==0)
				return "Prime";
			else
				return "Not Prime";
		}
	}
	String composite(int num)
	{
		int i,s=0;
		if(num==1)
			return "Not Defined";
		else
		{	
			for(i=2;i<=num/2;i++)
			{
				if(num%i==0)
					s++;
			}	
			if(s==0)
				return "Not Composite";
			else
				return "Composite";
		}
	}
	String armstrong(int num)
	{
		int i,s=0,a,t;
		double k=0;
		a=num;
		while(a>0)
		{
			a=a/10;
			s++;
		}
		t=num;
		while(num>0)
		{
			k=k+Math.pow((num%10),s);
			num=num/10;
		}
		if(t==k)
			return "Armstrong";
		else
			return "Not Armstrong";
		
	}
	String reverse(int num)
	{
		int reverse[]=new int[40];
		int i,index=0;
		String s=null;
		while(num>0)
		{
			reverse[index++]=num%10;	
			num=num/10;
		}
		for(i=0;i<=index-1;i++)
		{
			if(i==0)
				s=""+reverse[i];
			else
				s=s+reverse[i];
		}
		return s;
	}
	String palindrome(int num)
	{
		int num1;
		double s=0;
		num1=num;
		while(num>0)
		{
			s=(s*10)+(num%10);
			num=num/10;
		}
		if(s==num1)
			return "Palindrome";
		else
			return "Not Palindrome";
	}
	String binary(int num)
	{
	   int binary[] = new int[40];
  	   int index = 0;
	   String s=null;
   	   while(num>0)
	   {
		binary[index++] = num%2;
   	        num = num/2;
	   }
    	  for(int i = index-1;i >= 0;i--)
	  {
		if(i==index-1)
			s=""+binary[i];
		else
       	 		s=s+binary[i];
	   }
	  return s;
	}
	String octal(int num)
	{
	   int octal[] = new int[40];
  	   int index = 0;
	   String s=null;
   	   while(num>0)
	   {
		octal[index++] = num%8;
   	        num = num/8;
	   }
    	  for(int i = index-1;i >= 0;i--)
	  {
		if(i==index-1)
			s=""+octal[i];
		else
       	 		s=s+octal[i];
	   }
	  return s;
	}
	String hexa(int num)
	{
		int hexa[]=new int[40];
		int index=0;
		String s=null;
		while(num>0)
		{
			hexa[index++]=num%16;
			num=num/16;
		}
		for(int i=index-1;i>=0;i--)
		{
			if(i==index-1)
			{
				if(hexa[i]==10)
					s=""+"A";
				else if(hexa[i]==11)
					s=""+"B";
				else if(hexa[i]==12)
					s=""+"C";
				else if(hexa[i]==13)
					s=""+"D";
				else if(hexa[i]==14)
					s=""+"E";
				else if(hexa[i]==15)
					s=""+"F";
				else
					s=""+hexa[i];
			}
			else
			{
				if(hexa[i]==10)
					s=s+"A";
				else if(hexa[i]==11)
					s=s+"B";
				else if(hexa[i]==12)
					s=s+"C";
				else if(hexa[i]==13)
					s=s+"D";
				else if(hexa[i]==14)
					s=s+"E";
				else if(hexa[i]==15)
					s=s+"F";
				else
					s=s+hexa[i];
			}
		}
		return s;
	}
	int factorial(int num)
	{
		int i,s=1;
		for(i=1;i<=num;i++)
		{
			s=s*i;
		}
		return s;
	}
	Label l1;
	TextField t1,t2;
	Button b1,b3,b5,b2,b4,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32;
	int r=1;
	double a=0,b=0;	
	public void init()
	{
		setBackground(Color.black);
		//setResizable(false);
		l1=new Label("RESULT");
		l1.setFont(new Font("Arial",0,30));
		l1.setForeground(Color.white);
		t1=new TextField(100);
		t1.setFont(new Font("Arial",0,30));
		t2=new TextField(100);
		t2.setFont(new Font("Arial",0,30));
		b1=new Button("+");
		b1.setFont(new Font("Arial",0,20));
		//b1.setForeground(Color.yellow);
		b2=new Button("-");
		b2.setFont(new Font("Arial",0,20));
		b3=new Button("*");
		b3.setFont(new Font("Arial",0,20));
		b4=new Button("/");
		b4.setFont(new Font("Arial",0,20));
		b5=new Button("=");
		b5.setFont(new Font("Arial",0,20));
		b6=new Button("sin");
		b6.setFont(new Font("Arial",0,20));
		b7=new Button("cos");
		b7.setFont(new Font("Arial",0,20));
		b8=new Button("tan");
		b8.setFont(new Font("Arial",0,20));
		b9=new Button("CLR");
		b9.setFont(new Font("Arial",0,20));
		b9.setBackground(Color.red);
		b10=new Button("BIN");
		b10.setFont(new Font("Arial",0,20));
		b11=new Button("OCT");
		b11.setFont(new Font("Arial",0,20));
		b12=new Button("HEX");
		b12.setFont(new Font("Arial",0,20));
		b13=new Button("Palindrome");
		b13.setFont(new Font("Arial",0,20));
		b14=new Button("Armstrong");
		b14.setFont(new Font("Arial",0,20));
		b15=new Button("Reverse");
		b15.setFont(new Font("Arial",0,20));
		b16=new Button("Prime");
		b16.setFont(new Font("Arial",0,20));
		b17=new Button("Composite");
		b17.setFont(new Font("Arial",0,20));
		b18=new Button("nPr");
		b18.setFont(new Font("Arial",0,20));
		b19=new Button("nCr");
		b19.setFont(new Font("Arial",0,20));
		b20=new Button("^");
		b20.setFont(new Font("Arial",0,20));
		b21=new Button("x^2");
		b21.setFont(new Font("Arial",0,20));
		b22=new Button("x^3");
		b22.setFont(new Font("Arial",0,20));
		b24=new Button("\u221A"+"x");
		b24.setFont(new Font("Arial",0,20));
		b23=new Button("%");
		b23.setFont(new Font("Arial",0,20));
		b25=new Button("cbrt");
		b25.setFont(new Font("Arial",0,20));
		b26=new Button("x!");
		b26.setFont(new Font("Arial",0,20));
		b27=new Button("ln");
		b27.setFont(new Font("Arial",0,20));
		b28=new Button("log10");
		b28.setFont(new Font("Arial",0,20));
		b29=new Button("e^x");
		b29.setFont(new Font("Arial",0,20));
		b30=new Button("e");
		b30.setFont(new Font("Arial",0,20));
		b31=new Button("\u03C0");
		b31.setFont(new Font("Arial",0,20));
		b32=new Button("+/-");
		b32.setFont(new Font("Arial",0,20));
		setLayout(null);
		add(t1);t1.setBounds(10,10,350,50);
		add(b1);b1.setBounds(10,80,50,50);
		add(b2);b2.setBounds(70,80,50,50);
		add(b3);b3.setBounds(130,80,50,50);
		add(b4);b4.setBounds(190,80,50,50);
		add(b5);b5.setBounds(310,80,50,50);
		add(b23);b23.setBounds(250,80,50,50);
		add(b6);b6.setBounds(10,140,50,50);
		add(b7);b7.setBounds(70,140,50,50);
		add(b8);b8.setBounds(130,140,50,50);
		add(b10);b10.setBounds(190,140,50,50);
		add(b11);b11.setBounds(250,140,50,50);
		add(b12);b12.setBounds(310,140,50,50);
		add(b13);b13.setBounds(10,380,110,50);
		add(b14);b14.setBounds(130,380,110,50);
		add(b15);b15.setBounds(250,380,110,50);
		add(b16);b16.setBounds(10,320,110,50);
		add(b17);b17.setBounds(130,320,110,50);
		add(b18);b18.setBounds(250,320,50,50);
		add(b19);b19.setBounds(310,320,50,50);
		add(b20);b20.setBounds(10,200,50,50);
		add(b21);b21.setBounds(70,200,50,50);
		add(b22);b22.setBounds(130,200,50,50);
		add(b24);b24.setBounds(190,200,50,50);
		add(b25);b25.setBounds(250,200,50,50);
		add(b26);b26.setBounds(310,200,50,50);
		add(b27);b27.setBounds(10,260,50,50);
		add(b28);b28.setBounds(70,260,50,50);
		add(b29);b29.setBounds(130,260,50,50);
		add(b30);b30.setBounds(190,260,50,50);
		add(b31);b31.setBounds(250,260,50,50);
		add(b32);b32.setBounds(310,260,50,50);
		add(b9);b9.setBounds(100,440,150,50);
		add(l1);l1.setBounds(10,500,130,50);
		add(t2);t2.setBounds(140,500,220,50);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		b15.addActionListener(this);
		b16.addActionListener(this);
		b17.addActionListener(this);
		b18.addActionListener(this);
		b19.addActionListener(this);
		b20.addActionListener(this);
		b21.addActionListener(this);
		b22.addActionListener(this);
		b23.addActionListener(this);
		b24.addActionListener(this);
		b25.addActionListener(this);
		b26.addActionListener(this);
		b27.addActionListener(this);
		b28.addActionListener(this);
		b29.addActionListener(this);
		b30.addActionListener(this);
		b31.addActionListener(this);
		b32.addActionListener(this);
		t1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			a=Double.parseDouble(t1.getText());
			t1.setText(null);
			r=1;
			t1.requestFocus();
		}
		if(e.getSource()==b2)
		{
			a=Double.parseDouble(t1.getText());
			t1.setText(null);
			r=2;
			t1.requestFocus();
		}
		if(e.getSource()==b3)
		{
			a=Double.parseDouble(t1.getText());
			t1.setText(null);
			r=3;
			t1.requestFocus();
		}
		if(e.getSource()==b4)
		{
			a=Double.parseDouble(t1.getText());
			t1.setText(null);
			r=4;
			t1.requestFocus();
		}
		if(e.getSource()==b18)
		{
			a=Double.parseDouble(t1.getText());
			t1.setText(null);
			r=5;
			t1.requestFocus();
		}
		if(e.getSource()==b19)
		{
			a=Double.parseDouble(t1.getText());
			t1.setText(null);
			r=6;
			t1.requestFocus();
		}
		if(e.getSource()==b20)
		{
			a=Double.parseDouble(t1.getText());
			t1.setText(null);
			r=7;
			t1.requestFocus();
		}
		if(e.getSource()==b23)
		{
			a=Double.parseDouble(t1.getText());
			t1.setText(null);
			r=8;
			t1.requestFocus();
		}
		if(e.getSource()==b5 || e.getSource()==t1)
		{
			b=Double.parseDouble(t1.getText());
			switch(r)
			{
				case 1:
					double s1=a+b;
					t2.setText(""+s1);
					break;
				case 2:
					double s2=a-b;
					t2.setText(""+s2);
					break;
				case 3:
					double s3=a*b;
					t2.setText(""+s3);
					break;
				case 4:
					double s4=a/b;
					t2.setText(""+s4);
					break;	
				case 5:
					int s5=permutation((int)a,(int)b);
					t2.setText(""+s5);
					break;
				case 6:
					int s6=combination((int)a,(int)b);
					t2.setText(""+s6);
					break;
				case 7:
					int s7=(int)Math.pow(a,b);
					t2.setText(""+s7);
					break;
				case 8:
					double s8=((a/b)*100);
					t2.setText(""+s8+"%");
					break;
			}
		}
		if(e.getSource()==b6)
		{
			double d;
			d=Double.parseDouble(t1.getText());
			
			t2.setText(""+Math.sin(d));
		}
		if(e.getSource()==b7)
		{
			double d;
			d=Double.parseDouble(t1.getText());
			
			t2.setText(""+Math.cos(d));
		}
		if(e.getSource()==b8)
		{
			double d;
			d=Double.parseDouble(t1.getText());
			
			t2.setText(""+Math.tan(d));
		}
		if(e.getSource()==b9)
		{
			t1.setText(null);
			t2.setText(null);
		}
		if(e.getSource()==b10)
		{
			int i=Integer.parseInt(t1.getText());
			String res=binary(i);
			t2.setText(res);
		}
		if(e.getSource()==b11)
		{
			int i=Integer.parseInt(t1.getText());
			String res=octal(i);
			t2.setText(res);
		}
		if(e.getSource()==b12)
		{
			int i=Integer.parseInt(t1.getText());
			String res=hexa(i);
			t2.setText(res);
		}
		if(e.getSource()==b13)
		{
			int i=Integer.parseInt(t1.getText());
			String res=palindrome(i);
			t2.setText(res);
		}
		if(e.getSource()==b14)
		{
			int i=Integer.parseInt(t1.getText());
			String res=armstrong(i);
			t2.setText(res);
		}
		if(e.getSource()==b15)
		{
			int i=Integer.parseInt(t1.getText());
			String res=reverse(i);
			t2.setText(res);
		}
		if(e.getSource()==b16)
		{
			int i=Integer.parseInt(t1.getText());
			String res=prime(i);
			t2.setText(res);
		}
		if(e.getSource()==b17)
		{
			int i=Integer.parseInt(t1.getText());
			String res=composite(i);
			t2.setText(res);
		}
		if(e.getSource()==b21)
		{
			double i=Double.parseDouble(t1.getText());
			int res=(int)Math.pow(i,2);
			t2.setText(""+res);
		}
		if(e.getSource()==b22)
		{
			double i=Double.parseDouble(t1.getText());
			int res=(int)Math.pow(i,3);
			t2.setText(""+res);
		}
		if(e.getSource()==b24)
		{
			double i=Double.parseDouble(t1.getText());
			double res=Math.pow(i,0.5);
			t2.setText(""+res);
		}
		if(e.getSource()==b25)
		{
			double i=Double.parseDouble(t1.getText());
			double res=Math.cbrt(i);
			t2.setText(""+res);
		}
		if(e.getSource()==b26)
		{
			int i=Integer.parseInt(t1.getText());
			int res=factorial(i);
			t2.setText(""+res);
		}
		if(e.getSource()==b27)
		{
			double i=Double.parseDouble(t1.getText());
			double res=Math.log(i);
			t2.setText(""+res);
		}
		if(e.getSource()==b28)
		{
			double i=Double.parseDouble(t1.getText());
			double res=Math.log10(i);
			t2.setText(""+res);
		}
		if(e.getSource()==b29)
		{
			double i=Double.parseDouble(t1.getText());
			double res=Math.exp(i);
			t2.setText(""+res);
		}
		if(e.getSource()==b30)
		{
				double exp=2.71828;
				t1.setText(""+exp);
		}
		if(e.getSource()==b31)
		{
				double exp=3.1419;
				t1.setText(""+exp);
		}
		if(e.getSource()==b32)
		{
				double i=Double.parseDouble(t1.getText());
				i=-i;
				t1.setText(""+i);
		}
	}
}