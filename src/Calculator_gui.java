import java.awt.*;
import javax.swing.*;

public class Calculator_gui {

    private JFrame fCal;
    private JTextField tfAnswer; 
    private JLabel IMycal;
    private  JPanel pButton; 
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0; 
    private JButton bPlus,bMinus,bMul,bPoint,bEqual,bClear,bDiv; 
    private String currentInput = "";
    private double result = 0.0;
    private String operator = "";

    void initGui() {
     

        fCal = new JFrame(" GUI Calculator");
        fCal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fCal.setSize(700, 400);

        tfAnswer = new JTextField(20);
        IMycal = new JLabel("My calculator");
        pButton = new JPanel(new GridLayout(4, 8));


        b0=new JButton("0");
        b1=new JButton("1");
        b2=new JButton("2");
        b3=new JButton("3");
        b4=new JButton("4");
        b5=new JButton("5");
        b6=new JButton("6");
        b7=new JButton("7");
        b8=new JButton("8");
        b9=new JButton("9");    
        
        bMinus=new JButton("-");
        bPlus=new JButton("+");
        bMul=new JButton("*");
        bDiv=new JButton("/");
        bEqual=new JButton("=");
        bPoint=new JButton(".");
        bClear=new JButton("C");

      pButton.add(b1);
      pButton.add(b2);
      pButton.add(b3);
      pButton.add(b4);
      pButton.add(b5);
      pButton.add(b6);
      pButton.add(b7);
      pButton.add(b8);
      pButton.add(b9);
      pButton.add(b0);
      pButton.add(bMinus);
      pButton.add(bClear);
      pButton.add(bDiv);
      pButton.add(bMul);
      pButton.add(bPoint);
      pButton.add(bPlus);
      pButton.add(bEqual);

addlistner();

        Container con = fCal.getContentPane();
        con.setLayout(new BorderLayout());
        con.add(tfAnswer, BorderLayout.NORTH);
        con.add(IMycal, BorderLayout.SOUTH);
        con.add(pButton, BorderLayout.CENTER);

        fCal.setSize(300, 300);
        fCal.setVisible(true);  

        
    }

     void addlistner(){
        b0.addActionListener(e -> onNumberButtonClicked("0"));
        b1.addActionListener(e -> onNumberButtonClicked("1"));
        b2.addActionListener(e -> onNumberButtonClicked("2"));
        b3.addActionListener(e -> onNumberButtonClicked("3"));
        b4.addActionListener(e -> onNumberButtonClicked("4"));
        b5.addActionListener(e -> onNumberButtonClicked("5"));
        b6.addActionListener(e -> onNumberButtonClicked("6"));
        b7.addActionListener(e -> onNumberButtonClicked("7"));
        b8.addActionListener(e -> onNumberButtonClicked("8"));
        b9.addActionListener(e -> onNumberButtonClicked("9"));

        bPlus.addActionListener(e -> onOperatorButtonClicked("+"));
        bMinus.addActionListener(e -> onOperatorButtonClicked("-"));
        bMul.addActionListener(e -> onOperatorButtonClicked("*"));
        bDiv.addActionListener(e -> onOperatorButtonClicked("/"));

        bPoint.addActionListener(e -> onPointButtonClicked());
        bEqual.addActionListener(e -> onEqualButtonClicked());
        bClear.addActionListener(e -> onClearButtonClicked());
    }

void onNumberButtonClicked(String number){
  currentInput = currentInput + number;
  tfAnswer.setText(currentInput);
}
void onClearButtonClicked(){
    currentInput=" ";
    result=0.0;
    operator="";
    tfAnswer.setText(" ");

}
 void onPointButtonClicked(){
    if (!currentInput.isEmpty() && !currentInput.contains(".")) {
        currentInput= currentInput + ".";
        tfAnswer.setText(currentInput);
    }
 }

void onOperatorButtonClicked(String newoperator){
    if (!currentInput.isEmpty()) {
        if (!operator.isEmpty()) {
            onEqualButtonClicked();
        }
        operator = newoperator;
        result = Double.parseDouble(currentInput);
        currentInput = "";
        tfAnswer.setText("");
}
}
        

 void onEqualButtonClicked() {
    if (!currentInput.isEmpty() && !operator.isEmpty()) {
        double secondOperand = Double.parseDouble(currentInput);
        switch (operator) {
            case "+":
                result += secondOperand;
                break;
            case "-":
                result -= secondOperand;
                break;
            case "*":
                result *= secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    result /= secondOperand;
                } else {
                    tfAnswer.setText("Error: Division by zero");
                    return;
                }
                break;
        }
        tfAnswer.setText(Double.toString(result));
        currentInput = "";
        operator = "";
    }
}


    public static void main(String[] args) {
        Calculator_gui cal=new Calculator_gui();
      cal.initGui();
    }
}
