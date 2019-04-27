import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.UIManager.*;
import  sun.audio.*; 
import java.io.*;
class start implements ActionListener
{
	 JButton b[]=new JButton[9];
	 ArrayList<String> numbers=new ArrayList<String>();
	 int i;
	 String logicarr[]=new String[9];
	 String arr[][]=new String[3][3];
	 static int click=0;
	 JFrame f;
 	start()
 	{
 	 f=new JFrame();
 		f.setSize(600,600);
 		f.setVisible(true);
 		f.setTitle("Tic Tac Toe");
 		
 		GridLayout grid=new GridLayout(3,3,2,2);
 		f.setLayout(grid);
 		f.getContentPane().setBackground(Color.black);
 		f.setLocation(70,70);
 		for(int i=0;i<9;i++)
 		{
 			 b[i]=new JButton(""+i);
 			 numbers.add(""+i);
 			 b[i].setBackground(Color.white);
 			 b[i].setForeground(Color.white);
 			 b[i].addActionListener(this);
 			 logicarr[i]="0";
 				f.add(b[i]);


 		}
 		f.setResizable(false);


	
	}
	public void sound()
	{
		try
		{
		InputStream in=new FileInputStream("click.wav");
		@SuppressWarnings("valuegoeshere")
		AudioStream as=new AudioStream(in);
		AudioPlayer.player.start(as);
		}
		catch(Exception e)
		{

		}
	}
	public void actionPerformed(ActionEvent e)
	{
		
		
		ImageIcon icon=new ImageIcon("X.png");
		JButton button=(JButton)e.getSource();
		click++;
		logicarr[Integer.parseInt(button.getText())]="x";
		sound();
		if(button.getIcon()==null)
		{	
		button.setIcon(icon);
		
		numbers.remove(button.getText());
		//button.setEnabled(false);
		//System.out.println(index);
		System.out.println(numbers);

		clickauto();
		}
		
	}

	public void clickauto()
	{	
	if(click>=2)
	{
		makecall();

	}

	else
	{
		
		System.out.println("herejnj");
		
		Collections.shuffle(numbers);
		int random=Integer.parseInt(numbers.get(0));
		logicarr[random]="o";
		numbers.remove(numbers.get(0));	
		System.out.println(random);
		b[random].setIcon(new ImageIcon("o.png"));
		
		//b[random].setEnabled(false);
		
	}
	

		
		
	}
	public void makecall()
	{
		winner();
		int value=logic("o");
		if(value==0)
		{
			
			value=logic("x");
			System.out.println("disha");
			if(value==0)
			{	
				if(numbers.size()!=0)
				{
					Collections.shuffle(numbers);
				
		int random=Integer.parseInt(numbers.get(0));
		logicarr[random]="o";
		numbers.remove(numbers.get(0));	
		System.out.println(random);
		b[random].setIcon(new ImageIcon("o.png"));
			}

			}
		}
		
	}
	public int  logic(String str)
	{
		int count=0;
		
		
		
	int countarr=0;
	int row=0;
	for(int k=0;k<3;k++)
	{
		count=0;
		int pos=countarr;
		for(int j=countarr;j<countarr+3;j++)
		{
			System.out.println("j"+j);
			if(logicarr[j]==str)
			{

				count++;
				if(count==2)
				{
				
					for(int y=pos;y<pos+3;y++)
					{

						if(logicarr[y]=="0")
						{
							row=1;
							b[y].setIcon(new ImageIcon("o.png"));
							numbers.remove(Integer.toString(y));
					
							logicarr[y]="o";
							break;

						}

					}

				}
			}

			
		}
		countarr=countarr+3;

	}
	System.out.println("second"+Arrays.toString(logicarr));
	int diagonal=0;	
	if(row!=1)
	{
		//System.out.println("diagolcount");
		int diagolcount=0;
		count=0;
		for(int k=0;k<3;k++)
		{
			System.out.println("countd"+diagolcount);
			if(logicarr[diagolcount]==str)
			{
				count++;
				System.out.println("count"+count);

				if(count==2)
				{	int midcount=0;
					for(int j=0;j<3;j++)
					{
						if(logicarr[midcount]=="0")
						{	
							b[midcount].setIcon(new ImageIcon("o.png"));
							numbers.remove(Integer.toString(j));
							logicarr[midcount]="o";
							diagonal=1;	

						}
						midcount=midcount+4;
					}

				}
			}
			diagolcount=diagolcount+4;


		}

	}

int diagonal2=0;
if(row!=1 && diagonal!=1)
{
	int diagolcount=logicarr.length-3;
		count=0;
		for(int k=0;k<3;k++)
		{
			System.out.println("countdkdjfkgjkfjgkfjg"+diagolcount);
			if(logicarr[diagolcount]==str)
			{
				count++;
				System.out.println("count"+count);

				if(count==2)
				{	int midcount=logicarr.length-3;
					for(int j=0;j<3;j++)
					{
						if(logicarr[midcount]=="0")
						{	
							b[midcount].setIcon(new ImageIcon("o.png"));
							logicarr[midcount]="o";
							numbers.remove(Integer.toString(j));
							diagonal2=1;	

						}
						midcount=midcount-2;
					}

				}
			}
			diagolcount=diagolcount-2;


		}

	}
	int column=0;
	if(row!=1 && diagonal!=1 && diagonal2!=1)
	{
		
		int pointer=0,sum=0;
		for(int k=0;k<3;k++)
		{
			count=0;
			for(int j=pointer;j<9;j=j+3)
			{
				System.out.println("j"+j);
				if(logicarr[j]==str)
				{
					count++;
					if(count==2)
					{
						int pointer1=pointer;
						for(int y=pointer1;y<9;y=y+3)
						{
							if(logicarr[y]=="0")
							{
								b[y].setIcon(new ImageIcon("o.png"));
								logicarr[y]="o";
								numbers.remove(Integer.toString(y));
								column=1;
								break;

							}

						}

					}


				}


			}
			pointer++;

		}

	}
	if(row!=1 && column!=1 && diagonal!=1 && diagonal2!=1)
	{
		return 0;

	}
	else
	{
		return 1;
	}



}
public void winner()
{
	String winnerarr[][]=new String[3][3];
	int count=0;
	for(int k=0;k<3;k++)
	{
		for(int j=0;j<3;j++)
		{
			winnerarr[k][j]=logicarr[count];
			count++;


		}
	}
	for(int k=0;k<3;k++)
	{
		for(int j=0;j<3;j++)
		{
			System.out.print(winnerarr[k][j]);
			


		}
		System.out.println();
	}
	//---------------------------row-------------------------------------

	int rowx=0,rowo=0,setrowx=0,setrowo=0;
	for(int k=0;k<3;k++)
	{
		rowx=0;
		rowo=0;
		for(int j=0;j<3;j++)
		{
			if(winnerarr[k][j]=="x")
			{
				rowx++;
			
				if(rowx==3)
				{
					setrowx=1;
					break;

				}
					

			}
			else if(winnerarr[k][j]=="o")
			{
			
				rowo++;

				if(rowo==3)
				{	
				setrowo=1;
				break;
				}
					
			}

		}
	}

	//------------------------------column----------------------------------------------
	int columnx=0,columno=0,setcolumno=0,setcolumnx=0;
	for(int k=0;k<3;k++)
	{
		columnx=0;
		columno=0;
		for(int j=0;j<3;j++)
		{
			if(winnerarr[j][k]=="x")
			{
				columnx++;
			
				if(columnx==3)
				{
					setcolumnx=1;
					break;

				}
				
			}
			else if(winnerarr[j][k]=="o")
			{
				columno++;
			
				if(columno==3)
				{
					setcolumno=1;
					break;

				}

			}

		}
	}
	

//----------------------------daigonal1--------------------------------------

int digo=0,digx=0,dx=0,doo=0,j=0;
		for(int k=0;k<3;k++)
		{
			
			
			
				if(winnerarr[k][j]=="o")
				{
					digo++;
					if(digo==3)
					{
						doo=1;
						break;
					}
				}
				if(winnerarr[k][j]=="x")
				{
					digx++;
					if(digx==3)
					{
						dx=1;
						break;
					}
				}
			j++;
		}
		//------------------------------------------daigonal 2-----------------

		int digonalx=0,digonalo=0,x1=0,o1=0;
		j=0;

        for(int k=2;k>=0;k--)
		{
			
				
				if(winnerarr[k][j]=="o")
				{
					digonalo++;
					if(digonalo==3)
					{
						o1=1;
						break;
					}
				}
				if(winnerarr[k][j]=="x")
				{
					digonalx++;
					if(digonalx==3)
					{
						x1=1;
						break;
					}
				}
				j++;
		}
		//-----------------------checking all blocks-------------------------------

int count0=0;
		for(int k=0;k<3;k++)
		{
			for( j=0;j<3;j++)
			{
				if(winnerarr[k][j]=="0")
				{
					count0++;

				}

			}

		}
		
	if(setrowx!=0 || setcolumnx!=0 || dx!=0 || x1!=0)
	{
		System.out.println(setrowx);
		System.out.println(setcolumnx);
		System.out.println(dx);
		System.out.println(1);
	//	System.out.println(setrowx);
		JOptionPane.showMessageDialog(new JFrame(),"you won");
		
		f.setVisible(false);
		new start();
		//System.out.println("x winnnnn");

	}
	else if(setrowo!=0 || setcolumno!=0 || doo!=0 || o1!=0)
	{
	
		JOptionPane.showMessageDialog(new JFrame(),"o won");
		
		f.setVisible(false);
			new start();
		//System.out.println("o winnnnnn");
	}
	else if(count0==0)
	{
		JOptionPane.showMessageDialog(new JFrame(),"draw");
		f.setVisible(false);
			new start();

	}

	






}

	


}
public class Tictoe
{
	public static void main(String[] a)
	{
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		}
		catch(Exception e)
		{

		}
		new start();

	}
}