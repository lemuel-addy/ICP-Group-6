import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;  
  
//create LoginForm class to create login form    
//class implements ActionListener 
//the ActionListener class performs an action on button click  
class LoginForm extends JFrame implements ActionListener  
{  
    //initialize button, panel, label, and text field  
    JButton b1;  
    JPanel newPanel;  
    JLabel username, password;  
    final JTextField  textField1, textField2;  
      
    //calling constructor  
    LoginForm()  
    {     
          
        //create label for username   
        username = new JLabel();  
        username.setText("Enter your Username");      //set label value for textField1  
          
        //create text field to get username from the user  
        textField1 = new JTextField(15);    //set length of the text  
  
        //create label for password  
        passLabel = new JLabel();  
        passLabel.setText("Password");      //set label value for textField2  
          
        //create text field to get password from the user  
        textField2 = new JPasswordField(15);    //set length for the password  
          
        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  
          
        //create panel to put form elements  
        newPanel = new JPanel(new GridLayout(3, 1));  
        newPanel.add(userLabel);     
        newPanel.add(textField1);   
        newPanel.add(passLabel);   
        newPanel.add(textField2);   
        newPanel.add(b1);           
          
        //set border to panel   
        add(newPanel, BorderLayout.CENTER);  
          
        //perform action on button click   
        b1.addActionListener(this);   
        setTitle("LOGIN FORM");      
    }  
      
       public void actionPerformed(ActionEvent)     //pass action listener as a parameter  
    {  
        String userValue = textField1.getText();        //user enters username from the textField1  
        String passValue = textField2.getText();        //user enters pasword from the textField2  
          
        //check whether the credentials are authentic or not  
        if (userValue.equals("Sampson.nani@ashesi@ashesi.edu.gh") && passValue.equals("test")) {  //if authentic, navigate user to a new page  
              
            //create instance of the NewPage  
            NewPage page = new NewPage();  
              
            //make page visible to the user  
            page.setVisible(true);  
              
            //create a welcome label and set it to the new page  
            JLabel wel_label = new JLabel("Welcome: "+userValue);  
            page.getContentPane().add(wel_label);  
        }  
        else{  
            //show error message  
            System.out.println("Please enter valid username and password");  
        }  
    }  
}  
//create the main class  
class FormDemo  
{  
    //main() method start  
    public static void main(String arg[])  
    {  
        try  
        {  
            //create instance of the LoginForm  
            LoginForm form = new LoginForm();  
            form.setSize(300,100);  //set size of the frame  
            form.setVisible(true);  //make form visible to the user  
        }  
        catch(Exception e)  
        {     
            //handle exception   
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
}  