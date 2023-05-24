import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

class Calculator extends JFrame implements ActionListener{
    private JButton[] numberButtons,functionButtons;
    private JButton clearButton,deleteButton;
    private JPanel numberPanel,functionPanel,lablePanel;
    private JLabel newLable;
    private String operator="";
    private String oldTxt="";
    private String txt="";
    private double num1=0,num2=0;

    Calculator() {
        setSize(400,580);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lablePanel=new JPanel();
        lablePanel.setBackground(new Color(190,180,180));

        lablePanel.setPreferredSize(new Dimension(400,80));
        lablePanel.setFont(new Font("Hobo Std",Font.PLAIN,75));

        numberPanel = new JPanel(new GridLayout(4, 3, 5, 0));
        numberPanel.setPreferredSize(new Dimension(400,350));
        numberPanel.setBackground(Color.BLACK);

        functionPanel = new JPanel(new GridLayout(1, 5, 0, 0));
        functionPanel.setPreferredSize(new Dimension(400,150));

        newLable=new JLabel();
        newLable.setText("0");
        newLable.setFont(new Font("Hobo Std",Font.PLAIN,50));
        lablePanel.add(newLable);

        String[] btnNumbers = {"7", "8", "9", "4", "5", "6", "1", "2", "3"};
        String[] btnFunctions={"+","-","/","X","="};
        numberButtons = new JButton[btnNumbers.length+1];
        functionButtons=new JButton[btnFunctions.length];

        for (int i = 0; i < btnFunctions.length; i++) {
            functionButtons[i] = new JButton(btnFunctions[i]);
            functionButtons[i].setFont(new Font("Impact",Font.PLAIN,65));
            functionButtons[i].setBorder(new LineBorder(Color.BLACK,2));
            functionButtons[i].addActionListener(this);
            functionButtons[i].setBackground(Color.WHITE);
            functionPanel.add(functionButtons[i]);
        }

        for (int i = 0; i < btnNumbers.length; i++) {
            numberButtons[i] = new JButton(btnNumbers[i]);
            numberButtons[i].setFont(new Font("OCR A Std",Font.PLAIN,45));
            numberButtons[i].setBorder(new LineBorder(Color.BLACK,3));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(new Color(255,213,125));
            numberPanel.add(numberButtons[i]);
        }
         clearButton=new JButton("CLR");
         clearButton.setFont(new Font("Impact",Font.PLAIN,45));
         clearButton.setBorder(new LineBorder(Color.WHITE,1));
         clearButton.addActionListener(this);
         clearButton.setBackground(Color.RED);
         numberPanel.add(clearButton);

        numberButtons[numberButtons.length-1]=new JButton("0");
        numberButtons[numberButtons.length-1].setFont(new Font("OCR A Std",Font.PLAIN,45));
        numberButtons[numberButtons.length-1].setBorder(new LineBorder(Color.BLACK,3));
        numberButtons[numberButtons.length-1].addActionListener(this);
        numberButtons[numberButtons.length-1].setBackground(new Color(255,213,125));
        numberPanel.add(numberButtons[numberButtons.length-1]);

        deleteButton=new JButton("DEL");
        deleteButton.setFont(new Font("Impact",Font.PLAIN,45));
        deleteButton.setBorder(new LineBorder(Color.WHITE,1));
        deleteButton.addActionListener(this);
        deleteButton.setBackground(Color.RED);
        numberPanel.add(deleteButton);

        add(lablePanel, BorderLayout.NORTH);
        add(functionPanel,BorderLayout.CENTER);
        add(numberPanel, BorderLayout.PAGE_END);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        double num=0;
        switch (event.getActionCommand()){
            case "1"  : txt+=1;break;
            case "2"  : txt+=2;break;
            case "3"  : txt+=3;break;
            case "4"  : txt+=4;break;
            case "5"  : txt+=5;break;
            case "6"  : txt+=6;break;
            case "7"  : txt+=7;break;
            case "8"  : txt+=8;break;
            case "9"  : txt+=9;break;
            case "0"  : txt+=0;break;
            case "."  : txt+=".";break;
            case "+"  : num1=Double.parseDouble(txt);num=answer(num1,num2);oldTxt=Double.toString(num);num2=num;txt="";operator="+";break;
            case "-"  : num1=Double.parseDouble(txt);num=answer(num1,num2);oldTxt=Double.toString(num);num2=num;txt="";operator="-";break;
            case "/"  : num1=Double.parseDouble(txt);num=answer(num1,num2);oldTxt=Double.toString(num);num2=num;txt="";operator="/";break;
            case "X"  : num1=Double.parseDouble(txt);num=answer(num1,num2);oldTxt=Double.toString(num);num2=num;txt="";operator="*";break;
            case "="  : num2=Double.parseDouble(txt);txt=answer(num1,num2,operator);break;
            case "CLR": num1=0;num2=0;txt="0";oldTxt="";operator="";break;
            case "DEL": delete();break;
        }
        newLable.setText(oldTxt+" "+operator+" "+txt);
    }
    public String delete(){
       String delText="";
        for (int i = 0; i < txt.length()-1; i++) {
            delText+=txt.charAt(i);
        }
        txt=delText;
        return txt;
    }

    public String answer(double number1,double number2,String operator1){
        String text="";
        switch (operator){
            case "+": text+=(number1+number2);break;
            case "-": text+=(number1-number2);break;
            case "/": text+=(number1/number2);break;
            case "*": text+=(number1*number2);break;
        }
        oldTxt="";
        operator="";
        return text;
    }

    public Double answer(double number1,double number2){
        double text=0;
        if(operator.equals("")){
            return number1;
        }
        switch (operator){
            case "+": text+=(number1+number2);break;
            case "-": text+=(number1-number2);break;
            case "/": text+=(number1/number2);break;
            case "*": text+=(number1*number2);break;
        }
        return text;
    }
}

class Demo{
    public static void main(String args[]){
        Calculator c1 = new Calculator();
        c1.setVisible(true);
    }
}