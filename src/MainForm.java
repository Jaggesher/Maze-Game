import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MainForm {
	private int Global=0;
	private int Move_Number=0;
	private JFrame frame;
	private JButton Btn1,Btn2,Btn3,Btn4,Btn5,Btn6,Btn7,Btn8,Btn9;
	private JPanel panel_1;
	private JLabel MainImage;
	private JTextField MoveTB;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JLabel SwapIcon;
	Icon Im_1,Im_2,Im_3,Im_4,Im_5,Im_6,Im_7,Im_8,Im_9,Im_10;
	
	Boolean[] array = new Boolean[11];
	int[] Number=new int[11];
	private JTextField Status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(new File("src//Res//LG.jpg").getAbsolutePath()));
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.setBounds(100, 100, 710, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(10, 81, 375, 375);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3,3));
		
		Btn1=new JButton();
		panel.add(Btn1);
		
		Btn2=new JButton();
		panel.add(Btn2);
		
		Btn3=new JButton();
		panel.add(Btn3);
		
		Btn4=new JButton();
		panel.add(Btn4);
		
		Btn5=new JButton();
		panel.add(Btn5);
		
		Btn6=new JButton();
		panel.add(Btn6);
		
		Btn7=new JButton();
		panel.add(Btn7);
		
		Btn8=new JButton();
		panel.add(Btn8);
		
		Btn9=new JButton();
		panel.add(Btn9);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 255));
		panel_1.setBounds(469, 81, 224, 224);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1,1));
		
		MainImage = new JLabel("");
		panel_1.add(MainImage);
		
		MoveTB = new JTextField();
		MoveTB.setEditable(false);
		MoveTB.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		MoveTB.setHorizontalAlignment(SwingConstants.CENTER);
		MoveTB.setBounds(260, 466, 125, 42);
		frame.getContentPane().add(MoveTB);
		MoveTB.setColumns(10);
		
		JLabel MoveLB = new JLabel("MOVE:");
		MoveLB.setHorizontalAlignment(SwingConstants.CENTER);
		MoveLB.setFont(new Font("Times New Roman", Font.BOLD, 18));
		MoveLB.setBounds(189, 469, 61, 40);
		frame.getContentPane().add(MoveLB);
		
		JButton ChangeImage = new JButton("CHANGE");
		ChangeImage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ChangeImage.setBounds(604, 316, 89, 23);
		frame.getContentPane().add(ChangeImage);
		ChangeImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Global++;
				Init_ICON();
			}
		});
		
		JButton Reset = new JButton("RESET");
		Reset.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Reset.setBounds(469, 316, 89, 23);
		frame.getContentPane().add(Reset);
		Reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Init_ICON();
			}
		});
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 255));
		panel_2.setBounds(10, 11, 685, 59);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(new File("src//Res//Ic.png").getAbsolutePath()));
		lblNewLabel_1.setBounds(0, 0, 685, 59);
		panel_2.add(lblNewLabel_1);
		
		panel_3 = new JPanel();
		panel_3.setBounds(568, 383, 125, 125);
		panel_3.setLayout(new GridLayout(1,1));
		frame.getContentPane().add(panel_3);
		
		SwapIcon = new JLabel("");
		panel_3.add(SwapIcon);
		
		lblNewLabel = new JLabel("Swap with Neighbours.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(535, 365, 188, 14);
		frame.getContentPane().add(lblNewLabel);
		
		Status = new JTextField();
		Status.setEditable(false);
		Status.setText("TRY..");
		Status.setHorizontalAlignment(SwingConstants.CENTER);
		Status.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		Status.setColumns(10);
		Status.setBounds(10, 467, 169, 42);
		frame.getContentPane().add(Status);
		
		Btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!IsDone()){
				if(Btn2.getIcon()==SwapIcon.getIcon()){
					Icon tm=Btn2.getIcon();
					Btn2.setIcon(Btn1.getIcon());
					Btn1.setIcon(tm);
					Move_Number++;
				}
				else if(Btn4.getIcon()==SwapIcon.getIcon()){
					Icon tm=Btn4.getIcon();
					Btn4.setIcon(Btn1.getIcon());
					Btn1.setIcon(tm);
					Move_Number++;
				}
				MoveTB.setText(Integer.toString(Move_Number));
				if(IsDone())JOptionPane.showMessageDialog(null, "CongraTulation!\n You have "+Integer.toString(Move_Number)+"move.");
				
			 }
			}
		});
		
		Btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!IsDone()){
				if(Btn1.getIcon()==SwapIcon.getIcon()){
					Icon tm=Btn1.getIcon();
					Btn1.setIcon(Btn2.getIcon());
					Btn2.setIcon(tm);
					Move_Number++;
				}
				else if(Btn5.getIcon()==SwapIcon.getIcon()){
					Icon tm=Btn5.getIcon();
					Btn5.setIcon(Btn2.getIcon());
					Btn2.setIcon(tm);
					Move_Number++;
				}
				else if(Btn3.getIcon()==SwapIcon.getIcon()){
					Icon tm=Btn3.getIcon();
					Btn3.setIcon(Btn2.getIcon());
					Btn2.setIcon(tm);
					Move_Number++;
				}
				MoveTB.setText(Integer.toString(Move_Number));
				if(IsDone())JOptionPane.showMessageDialog(null, "CongraTulation!\n You have "+Integer.toString(Move_Number)+"move.");
				
			 }
			}
		});
		
		Btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!IsDone()){
					if(Btn2.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn2.getIcon();
						Btn2.setIcon(Btn3.getIcon());
						Btn3.setIcon(tm);
						Move_Number++;
					}
					else if(Btn6.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn6.getIcon();
						Btn6.setIcon(Btn3.getIcon());
						Btn3.setIcon(tm);
						Move_Number++;
					}
					MoveTB.setText(Integer.toString(Move_Number));
					if(IsDone())JOptionPane.showMessageDialog(null, "CongraTulation!\n You have "+Integer.toString(Move_Number)+"move.");
					
				}
				
			}
		});
		
		
		Btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!IsDone()){
					if(Btn1.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn1.getIcon();
						Btn1.setIcon(Btn4.getIcon());
						Btn4.setIcon(tm);
						Move_Number++;
					}
					else if(Btn5.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn5.getIcon();
						Btn5.setIcon(Btn4.getIcon());
						Btn4.setIcon(tm);
						Move_Number++;
					}
					else if(Btn7.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn7.getIcon();
						Btn7.setIcon(Btn4.getIcon());
						Btn4.setIcon(tm);
						Move_Number++;
					}
					MoveTB.setText(Integer.toString(Move_Number));
					if(IsDone())  JOptionPane.showMessageDialog(null, "CongraTulation!\n You have "+Integer.toString(Move_Number)+"move.");
					
				}
			}
		});
		
		Btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!IsDone()){
					if(Btn2.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn2.getIcon();
						Btn2.setIcon(Btn5.getIcon());
						Btn5.setIcon(tm);
						Move_Number++;
					}
					else if(Btn4.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn4.getIcon();
						Btn4.setIcon(Btn5.getIcon());
						Btn5.setIcon(tm);
						Move_Number++;
					}
					else if(Btn6.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn6.getIcon();
						Btn6.setIcon(Btn5.getIcon());
						Btn5.setIcon(tm);
						Move_Number++;
					}
					else if(Btn8.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn8.getIcon();
						Btn8.setIcon(Btn5.getIcon());
						Btn5.setIcon(tm);
						Move_Number++;
					}
					MoveTB.setText(Integer.toString(Move_Number));
					if(IsDone())JOptionPane.showMessageDialog(null, "CongraTulation!\n You have "+Integer.toString(Move_Number)+"move.");
					
				}
			}
		});
		
		Btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!IsDone()){
					if(Btn9.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn9.getIcon();
						Btn9.setIcon(Btn6.getIcon());
						Btn6.setIcon(tm);
						Move_Number++;
					}
					else if(Btn5.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn5.getIcon();
						Btn5.setIcon(Btn6.getIcon());
						Btn6.setIcon(tm);
						Move_Number++;
					}
					else if(Btn3.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn3.getIcon();
						Btn3.setIcon(Btn6.getIcon());
						Btn6.setIcon(tm);
						Move_Number++;
					}
					MoveTB.setText(Integer.toString(Move_Number));
					if(IsDone()) JOptionPane.showMessageDialog(null, "CongraTulation!\n You have "+Integer.toString(Move_Number)+"move.");
					
				}
				
			}
		});
		
		Btn7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!IsDone()){
					if(Btn4.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn4.getIcon();
						Btn4.setIcon(Btn7.getIcon());
						Btn7.setIcon(tm);
						Move_Number++;
					}
					else if(Btn8.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn8.getIcon();
						Btn8.setIcon(Btn7.getIcon());
						Btn7.setIcon(tm);
						Move_Number++;
					}
					MoveTB.setText(Integer.toString(Move_Number));
					if(IsDone())JOptionPane.showMessageDialog(null, "CongraTulation!\n You have "+Integer.toString(Move_Number)+"move.");
					
				}
			}
		});
		
		Btn8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!IsDone()){
					if(Btn9.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn9.getIcon();
						Btn9.setIcon(Btn8.getIcon());
						Btn8.setIcon(tm);
						Move_Number++;
					}
					else if(Btn7.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn7.getIcon();
						Btn7.setIcon(Btn8.getIcon());
						Btn8.setIcon(tm);
						Move_Number++;
					}
					else if(Btn5.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn5.getIcon();
						Btn5.setIcon(Btn8.getIcon());
						Btn8.setIcon(tm);
						Move_Number++;
					}
					MoveTB.setText(Integer.toString(Move_Number));
					if(IsDone())JOptionPane.showMessageDialog(null, "CongraTulation!\n You have "+Integer.toString(Move_Number)+"move.");
					
				}
				
			}
		});
		
		Btn9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!IsDone()){
					if(Btn8.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn8.getIcon();
						Btn8.setIcon(Btn9.getIcon());
						Btn9.setIcon(tm);
						Move_Number++;
					}
					else if(Btn6.getIcon()==SwapIcon.getIcon()){
						Icon tm=Btn6.getIcon();
						Btn6.setIcon(Btn9.getIcon());
						Btn9.setIcon(tm);
						Move_Number++;
					}
					MoveTB.setText(Integer.toString(Move_Number));
					if(IsDone()) JOptionPane.showMessageDialog(null, "CongraTulation!\n You have "+Integer.toString(Move_Number)+"move.");
					
				 }
				}
		});
		
		Init_ICON();
	}
	
	
	
	private void GenerateRandom(){
		Arrays.fill(array, Boolean.TRUE);
		Random ran = new Random();
		int x;
		//for(int i=1;i<10;i++) Number[i]=i;
		int cnt=0;
		for(int i=1;i<10;){
			 x= ran.nextInt(9) + 1;
			if(array[x]){
				Number[i]=x;
				if(i==x) cnt++;
				i++;
				array[x]=false;
			}
		}
		if(cnt==9) GenerateRandom();
	}
	
	private void Init_ICON(){
		Move_Number=0;
		MoveTB.setText("0");
		Global%=6;
		GenerateRandom();
		if(Global==0) St_Icon_0();
		else if(Global==1) St_Icon_1();
		else if(Global==2) St_Icon_2();
		else if(Global==3) St_Icon_3();
		else if(Global==4) St_Icon_4();
		else St_Icon_5();
		Set_Button_Icon();
	}
	
	private void St_Icon_0(){
		Status.setText("RU LOGO");
    	File file=new File("src//Res//RU LOGO//1.png");
		Im_1=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//RU LOGO//2.png");
		Im_2=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//RU LOGO//3.png");
		Im_3=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//RU LOGO//4.png");
		Im_4=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//RU LOGO//5.png");
		Im_5=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//RU LOGO//6.png");
		Im_6=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//RU LOGO//7.png");
		Im_7=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//RU LOGO//8.png");
		Im_8=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//RU LOGO//9.png");
		Im_9=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//RU LOGO//10.png");
		Im_10=new ImageIcon(file.getAbsolutePath());
	}
	
	private void St_Icon_1(){
		Status.setText("Main Gate");
		File file=new File("src//Res//Main Gate//1.jpeg");
		Im_1=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Main Gate//2.jpeg");
		Im_2=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Main Gate//3.jpeg");
		Im_3=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Main Gate//4.jpeg");
		Im_4=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Main Gate//5.jpeg");
		Im_5=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Main Gate//6.jpeg");
		Im_6=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Main Gate//7.jpeg");
		Im_7=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Main Gate//8.jpeg");
		Im_8=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Main Gate//9.jpeg");
		Im_9=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Main Gate//10.jpeg");
		Im_10=new ImageIcon(file.getAbsolutePath());
		
	}
	
    
	
    private void St_Icon_2(){
    	Status.setText("SabashBangla");
    	File file=new File("src//Res//Sabash Bangla//1.JPG");
		Im_1=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Sabash Bangla//2.JPG");
		Im_2=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Sabash Bangla//3.JPG");
		Im_3=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Sabash Bangla//4.JPG");
		Im_4=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Sabash Bangla//5.JPG");
		Im_5=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Sabash Bangla//6.JPG");
		Im_6=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Sabash Bangla//7.JPG");
		Im_7=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Sabash Bangla//8.JPG");
		Im_8=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Sabash Bangla//9.JPG");
		Im_9=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Sabash Bangla//10.JPG");
		Im_10=new ImageIcon(file.getAbsolutePath());
		
	}
    
    private void St_Icon_3(){
    	Status.setText("ShaheedMinar");
    	File file=new File("src//Res//Shaheed Minar//1.jpg");
		Im_1=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Shaheed Minar//2.jpg");
		Im_2=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Shaheed Minar//3.jpg");
		Im_3=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Shaheed Minar//4.jpg");
		Im_4=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Shaheed Minar//5.jpg");
		Im_5=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Shaheed Minar//6.jpg");
		Im_6=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Shaheed Minar//7.jpg");
		Im_7=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Shaheed Minar//8.jpg");
		Im_8=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Shaheed Minar//9.jpg");
		Im_9=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Shaheed Minar//10.jpg");
		Im_10=new ImageIcon(file.getAbsolutePath());
    }
    
    private void St_Icon_4(){
    	Status.setText("4'th Science");
    	File file=new File("src//Res//4th Science//1.jpg");
		Im_1=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//4th Science//2.jpg");
		Im_2=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//4th Science//3.jpg");
		Im_3=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//4th Science//4.jpg");
		Im_4=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//4th Science//5.jpg");
		Im_5=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//4th Science//6.jpg");
		Im_6=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//4th Science//7.jpg");
		Im_7=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//4th Science//8.jpg");
		Im_8=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//4th Science//9.jpg");
		Im_9=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//4th Science//10.jpg");
		Im_10=new ImageIcon(file.getAbsolutePath());
    }
    
    private void St_Icon_5(){
    	Status.setText("VirtualClass");
    	File file=new File("src//Res//Virtual Classroom//1.jpg");
		Im_1=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Virtual Classroom//2.jpg");
		Im_2=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Virtual Classroom//3.jpg");
		Im_3=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Virtual Classroom//4.jpg");
		Im_4=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Virtual Classroom//5.jpg");
		Im_5=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Virtual Classroom//6.jpg");
		Im_6=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Virtual Classroom//7.jpg");
		Im_7=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Virtual Classroom//8.jpg");
		Im_8=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Virtual Classroom//9.jpg");
		Im_9=new ImageIcon(file.getAbsolutePath());
		file=new File("src//Res//Virtual Classroom//10.jpg");
		Im_10=new ImageIcon(file.getAbsolutePath());
    }
    
    private void Set_Button_Icon(){
    	St(Btn1,Number[1]);
    	St(Btn2,Number[2]);
    	St(Btn3,Number[3]);
    	St(Btn4,Number[4]);
    	St(Btn5,Number[5]);
    	St(Btn6,Number[6]);
    	St(Btn7,Number[7]);
    	St(Btn8,Number[8]);
    	St(Btn9,Number[9]);
    	SwapIcon.setIcon(Im_9);
    	MainImage.setIcon(Im_10);
    }
    
    private void St(JButton Tm,int num){
    	if(num==1) Tm.setIcon(Im_1);
    	else if(num==2) Tm.setIcon(Im_2);
    	else if(num==3) Tm.setIcon(Im_3);
    	else if(num==4) Tm.setIcon(Im_4);
    	else if(num==5) Tm.setIcon(Im_5);
    	else if(num==6) Tm.setIcon(Im_6);
    	else if(num==7) Tm.setIcon(Im_7);
    	else if(num==8) Tm.setIcon(Im_8);
    	else Tm.setIcon(Im_9);
    }
    
    private boolean IsDone(){
    	if(Btn1.getIcon()!=Im_1) return false;
    	if(Btn2.getIcon()!=Im_2) return false;
    	if(Btn3.getIcon()!=Im_3) return false;
    	if(Btn4.getIcon()!=Im_4) return false;
    	if(Btn5.getIcon()!=Im_5) return false;
    	if(Btn6.getIcon()!=Im_6) return false;
    	if(Btn7.getIcon()!=Im_7) return false;
    	if(Btn8.getIcon()!=Im_8) return false;
    	if(Btn9.getIcon()!=Im_9) return false;
    	return true;
    }
}
