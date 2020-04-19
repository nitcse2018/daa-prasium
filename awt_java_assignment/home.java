import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class home  {	
	String name;
	String dateob;
	String email;
	String phone;
	String address;
	String gender;
	String nation;
	String Skills[];
	String EQ[];
	String WE[];

	Frame f;
	TextField t;
	Label l; // For Resume Builder
	Label l1; // For Personal Information
	Label l2; // For Educational Qualifications
	Label l3; // For Work Experience 
	Label l4; // For Skills
	Label p[]; // label arrays for personal
	Label e[]; // label arrays for educational qualification
	Label we[]; // label arrays for work experience
	TextField tp[];   // personal textfield arrays
	TextField te[];   // qualifications textfield arrays
	TextField twe[]; // work experience textfield arrays
	TextField ts[];  // skills textfield arrays
	
    Button b1; // Button to Generate a File 
	Button b2; // to clear data in text fields.
	
	home()
	{
		
		f= new Frame();
		f.setSize(1080,720);
		f.setVisible(true);
		f.setLayout(null);
		f.setTitle("CV");
		f.setBackground(Color.cyan);
		t= new TextField("Enter Here ");
	    l= new Label("RESUME BUILDER");
	    l.setFont(new Font("SanSerif",Font.BOLD,30));
		l.setBounds(700, 50, 400, 40);
	    f.add(l);
	    personal(); // Initializes labels and fields for Personal Detail section
	    eQualification(); // Initializes labels and fields for Educational Stuff
	    workExp(); // Initializes labels and fields for Work Experience
	    skills();  // Initializes labels and fields for Skills
	    generateFile();  // Calls File Generator Method
	    f.addWindowListener(new WindowAdapter()
	    {
	    	public void windowClosing(WindowEvent e)
	    	{
	    		System.exit(0);
	    	}
	    });
	}
	public void personal ()
	{
	    l1 = new Label ("PERSONAL INFORMATION");
	    l1.setFont(new Font("Times New Roman",Font.BOLD,16));
	    l1.setBounds(100,100,300,40);
	    f.add(l1);
	    p= new Label[8];
		p[0] = new Label ("First Name : ");
		p[1] = new Label ("Last Name : ");
		p[2]= new Label ("Date of Birth (DD/MM/YYYY) : ");
	    p[3] = new Label ("E-mail : ");
		p[4] = new Label ("Contact Number : ");
		p[5] = new Label ("Address : ");
		p[6] = new Label ("Gender : ");
		p[7] = new Label ("Nationality : "); 
	    tp = new TextField[8];
		for(int i=0;i<8;i++)
	{
			p[i].setFont(new Font("Cambria",Font.PLAIN,14));
			p[i].setBounds(30,150+i*40,200,40);
	        tp[i]=new TextField();
			tp[i].setBounds(240,150+i*40,200,30);
	}
		for(int i=0;i<8;i++)
	{
	    f.add(p[i]);
	    f.add(tp[i]);
	}
	
	}
	
	public void eQualification()
	{
		 l2 = new Label ("EDUCATIONAL QUALIFICATIONS");
		    l2.setFont(new Font("Times New Roman",Font.BOLD,16));
		    l2.setBounds(1000,100,300,40);
		    f.add(l2);
		    e= new Label[4];
			e[0] = new Label ("Title/Qualification");
		    e[0].setBounds(800,150, 180, 40);
		    e[0].setFont(new Font("Cambria",Font.PLAIN,14));
			e[1] = new Label ("College/University");
			 e[1].setBounds(1150,150, 140, 40);
			 e[1].setFont(new Font("Cambria",Font.PLAIN,14));
			e[2]= new Label ("Year");
			 e[2].setBounds(1380,150,60, 40);
			 e[2].setFont(new Font("Cambria",Font.PLAIN,14));
			 e[3]= new Label ("Grade/GPA");
			 e[3].setBounds(1450,150,80, 40);
			 e[3].setFont(new Font("Cambria",Font.PLAIN,14));
			 f.add(e[0]);
		   f.add(e[1]);
		   f.add(e[2]);
		   f.add(e[3]);
			 te = new TextField[12];
		int j=0;
		   for(int i=0;i<12;i++)
			{
	            te[i]=new TextField();   
				if((i+1)%4==1)
	               {
	            	   te[i].setBounds(650, 190+(j*50),350,30);
	               }
	               else if((i+1)%4==2)
	               {
	            	   te[i].setBounds(1050, 190+(j*50),300,30);
		                  
	               }
	               else if((i+1)%4==3)
	               {
	            	   te[i].setBounds(1380,190+(j*50),60,30);		                      
	               }
	               else if((i+1)%4==0)
	               {
	            	   te[i].setBounds(1450,190+(j*50),50,30);
		               j++;          
	               }
			}
			for(int i=0;i<12;i++)
		{
				f.add(te[i]);
		}
	}
      public void workExp()
      {
    	  l3 = new Label ("WORK EXPERIENCE");
		    l3.setFont(new Font("Times New Roman",Font.BOLD,16));
		    l3.setBounds(1000,400,300,40);
		    f.add(l3);
		    we= new Label[3];
			we[0] = new Label ("Company Name");
		    we[0].setBounds(800,440, 200, 40);
		    we[0].setFont(new Font("Cambria",Font.PLAIN,14));
			we[1] = new Label ("Job Position/Title");
			we[1].setBounds(1150,440, 150, 40);
			we[1].setFont(new Font("Cambria",Font.PLAIN,14));
			we[2]= new Label ("No.of Years");
			we[2].setBounds(1400,440,100, 40);
			we[2].setFont(new Font("Cambria",Font.PLAIN,14));
		   f.add(we[0]);
		   f.add(we[1]);
		   f.add(we[2]);
		   
			 twe = new TextField[9];
		int j=0;
		   for(int i=0;i<9;i++)
			{
	            twe[i]=new TextField();   
				if((i+1)%3==1)
	               {
	            	   twe[i].setBounds(650, 480+(j*50),350,30);
	               }
	               else if((i+1)%3==2)
	               {
	            	   twe[i].setBounds(1050, 480+(j*50),300,30);
		                  
	               }
	               else if((i+1)%3==0)
	               {
	            	   twe[i].setBounds(1400,480+(j*50),60,30);
		               j++;          
	               }
			}
			for(int i=0;i<9;i++)
		{
				f.add(twe[i]);
		}
      }
	public void skills()
	{
		 l4 = new Label ("SKILLS/ACHIEVEMENTS");
		    l4.setFont(new Font("Times New Roman",Font.BOLD,16));
		    l4.setBounds(100,480,200,40);
		    f.add(l4);
		    ts = new TextField[5];
		    for(int i=0;i<5;i++)
		    {
		       ts[i]=new TextField();
		       ts[i].setBounds(50,540+i*50,400,30);
		    }
			for(int i=0;i<5;i++)
		{
		    f.add(ts[i]);
		}
		
	}
	
	public void generateFile()    // Method to generate file
	{
		Label temp=new Label();
		temp.setBounds(1000, 780,600, 20);
		temp.setFont(new Font("Calibri",Font.BOLD,12));
		b1 = new Button("GENERATE");
		b1.setBounds(800, 700, 200, 50);
		b1.setBackground(Color.ORANGE);
		b1.setFont(new Font("Helvetica",Font.BOLD,18));
		b2 = new Button("RESET");
		b2.setBounds(1050, 700, 200, 50);
		b2.setBackground(Color.RED);
		b2.setFont(new Font("Helvetica",Font.BOLD,18));
		f.add(b1);
		f.add(b2);
		 b1.addActionListener(new ActionListener()
		 {
			public void actionPerformed(ActionEvent e) 
			{
				Boolean c=CheckFields();   
				System.out.print(c);//check textFields
			String a= e.getActionCommand();
			if(a=="GENERATE"&&c)   // if button is pressed
			{
	         b1.setBackground(Color.GREEN);
	         temp.setText("File has been generated! ");
	         	try {
					writeFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
			else {
				 temp.setText("*Atleast Fill up the Personal info. fields ! We don't create empty RESUMES!");
			}
			  f.add(temp);
			}
 		 });
		 b2.addActionListener(new ActionListener()
		 {
			public void actionPerformed(ActionEvent e) 
			{
			String a= e.getActionCommand();
			if(a=="RESET")  // if button is pressed
			{
	         b2.setBackground(Color.MAGENTA);
					resetFields();	
					 temp.setText("");
			b1.setBackground(Color.ORANGE);					
			}
			}
		 });
	}
        public void writeFile() throws IOException
        {
        	name = tp[0].getText();
        	name=name+" "+tp[1].getText();
        	dateob = tp[2].getText();
        	email=tp[3].getText();
        	phone=tp[4].getText();
        	address=tp[5].getText();
        	gender=tp[6].getText();
        	nation=tp[7].getText();
        	Skills=new String[5];
    		EQ=new String[3];
    		WE=new String[3];
    		for(int i=0,j=0;j<3;i=i+4,j++)
    		{
    			EQ[j]=new String();
    		EQ[j]="Qualification : "+te[i].getText()+" \n Name of College/University : "+te[i+1].getText() +" \n Year Passed : " +te[i+2].getText()+""
    				+ " \n Grade/GPA : "+te[i+3].getText()+"\n";
    		}
    		for(int i=0,j=0;j<3;i=i+3,j++)
    		{
    			WE[j]=new String();
    		WE[j]="Company : "+twe[i].getText()+" \n Job Title : "+twe[i+1].getText() +" \n Years Worked : " +twe[i+2].getText()+"\n";
    		}
    		for(int i=0;i<5;i++)
    		{
    			Skills[i]=new String();
    	       Skills[i]= ts[i].getText()+"\n";
    		}
    		FileWriter fileWriter = new FileWriter("Resume.txt");  // SET FILE LOCATION HERE
        	    PrintWriter write = new PrintWriter(fileWriter);
        	    write.printf("\t \t \t \t***** RESUME *****\n \n \t \t~ PERSONAL INFO ~ \n \n Full Name : %s \n Date Of Birth : %s "
        	    		+ "\n E-Mail ID : %s \n Contact Number : %s \n Address : %s \n Gender : %s "
        	    		+ " \n Nationality : %s ",name,dateob,email,phone,address,gender,nation);
        	    write.printf("\n_____________________________________________________________________________________________");
        	    write.printf("\n \t \t~ EDUCATIONAL QUALIFICATIONS ~ \n \n");
        	    for(int i =0 ;i<3;i++)
        	    {
        	    	write.printf(" %d. %s  \n",(i+1),EQ[i]);
        	    }
        	    write.printf("\n_____________________________________________________________________________________________");
        	    write.printf("\n \t \t~ WORK EXPERIENCE ~ \n \n");
        	    for(int i =0 ;i<3;i++)
        	    {
        	    	write.printf(" %d. %s  \n",(i+1),WE[i]);
        	    }
        	    write.printf("\n_____________________________________________________________________________________________");
        	    write.printf("\n \t \t~ SKILLS/ACHIEVEMENTS ~ \n \n");
        	    for(int i =0 ;i<5;i++)
        	    {
        	    	write.printf(" %d. %s  \n",(i+1),Skills[i]);
        	    }
        	    write.close();
        }

        public void resetFields()
        {
        	for(int i=0;i<5;i++)
        	{
        		tp[i].setText("");
        		te[i].setText("");
        		twe[i].setText("");
        		ts[i].setText("");
        	}
        	for(int i=5;i<7;i++)
        	{
        		tp[i].setText("");
        		twe[i].setText("");
        		twe[i+2].setText("");
           	    te[i].setText("");       	    
           	    te[i+2].setText("");       	    
           	    te[i+3].setText("");
           	    te[i+4].setText("");
        	}
        	tp[7].setText("");
        	te[11].setText("");
        }
        public Boolean CheckFields()
        {
        	Boolean var=true;
        	for(int i=0;i<8;i++)
        	{
        		if(tp[i].getText().isEmpty())
        		{
        			var=false;
        		}
        		else
        			var=true;
        	}
       return var;
        }
public static void main (String args[]) throws IOException
{
	home o =new home();
}
}
