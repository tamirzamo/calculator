
/*
 Sample Skeleton for 'test.fxml' Controller Class
*/
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML // fx:id="one"
    private Button one; // Value injected by FXMLLoader

    @FXML // fx:id="screen"
    private TextField screen; // Value injected by FXMLLoader

    @FXML // fx:id="two"
    private Button two; // Value injected by FXMLLoader

    @FXML // fx:id="minus"
    private Button minus; // Value injected by FXMLLoader

    @FXML // fx:id="tree"
    private Button tree; // Value injected by FXMLLoader

    @FXML // fx:id="four"
    private Button four; // Value injected by FXMLLoader

    @FXML // fx:id="five"
    private Button five; // Value injected by FXMLLoader

    @FXML // fx:id="Sixth"
    private Button Sixth; // Value injected by FXMLLoader

    @FXML // fx:id="seven"
    private Button seven; // Value injected by FXMLLoader

    @FXML // fx:id="Eight"
    private Button Eight; // Value injected by FXMLLoader

    @FXML // fx:id="mul"
    private Button mul; // Value injected by FXMLLoader

    @FXML // fx:id="Nine"
    private Button Nine; // Value injected by FXMLLoader

    @FXML // fx:id="l"
    private Button l; // Value injected by FXMLLoader

    @FXML // fx:id="zero"
    private Button zero; // Value injected by FXMLLoader

    @FXML // fx:id="div"
    private Button div; // Value injected by FXMLLoader

    @FXML // fx:id="r"
    private Button r; // Value injected by FXMLLoader

    @FXML // fx:id="pluse"
    private Button pluse; // Value injected by FXMLLoader

    @FXML // fx:id="run"
    private Button run; // Value injected by FXMLLoader

    @FXML // fx:id="dot"
    private Button dot; // Value injected by FXMLLoader

    @FXML // fx:id="exit"
    private Button exit; // Value injected by FXMLLoader

    @FXML // fx:id="del"
    private Button del; // Value injected by FXMLLoader
static int curser=0; //will used to know where to print

    @FXML
    void add_Eight(ActionEvent event) 
    {
    	screen.insertText(curser,"8");
    	curser++;
    }

    @FXML
    void add_Nine(ActionEvent event) 
    {
    	screen.insertText(curser,"9");
    	curser++;
    }

    @FXML
    void add_Seven(ActionEvent event)
    {
    	screen.insertText(curser,"7");
    	curser++;
    }

    @FXML
    void add_Sixth(ActionEvent event) 
    {
    	screen.insertText(curser,"6");
    	curser++;
    }

    @FXML
    void add_div(ActionEvent event) 
    {
    	screen.insertText(curser,"/");
    	curser++;
    }

    @FXML
    void add_dot(ActionEvent event) 
    {
    	screen.insertText(curser,".");
    	curser++;
    }

    @FXML
    void add_five(ActionEvent event)
    {
    	screen.insertText(curser,"5");
    	curser++;
    }

    @FXML
    void add_four(ActionEvent event) 
    {
    	screen.insertText(curser,"4");
    	curser++;
    }

    @FXML
    void add_l(ActionEvent event)
    {
    	screen.insertText(curser,"(");
    	curser++;
    }

    @FXML
    void add_minus(ActionEvent event) 
    {
    	screen.insertText(curser,"-");
    	curser++;
    }

    @FXML
    void add_mul(ActionEvent event)
    {
    	screen.insertText(curser,"*");
    	curser++;
    }

    @FXML
    void add_one(ActionEvent event)
    {
    	screen.insertText(curser,"1");
    	curser++;
    }

    @FXML
    void add_pluse(ActionEvent event) 
    {
    	screen.insertText(curser,"+");
    	curser++;
    }

    @FXML
    void add_r(ActionEvent event)
    {
    	screen.insertText(curser,")");
    	curser++;
    }

    @FXML
    void add_tree(ActionEvent event) 
    {
    	screen.insertText(curser,"3");
    	curser++;
    }

    @FXML
    void add_two(ActionEvent event) 
    {
    	screen.insertText(curser,"2");
    	curser++;
    }

    @FXML
    void add_zero(ActionEvent event) 
    {
    	screen.insertText(curser,"0");
    	curser++;
    }

    @FXML
    void del(ActionEvent event)
    {
    	screen.setText("");
    	curser=0;
    }

    @FXML
    void exit(ActionEvent event)
    {
    	System.exit(0);
    }

    @FXML
    void init(ActionEvent event) //if press enter equal to =
    {
       run(event);
    }

    @FXML
    void run(ActionEvent event)
    {
    	try{
    	screen.setText(ArithmeticApp.run(screen.getText()));;  //in case
    	
    	curser=screen.getText().length();
    	}
    	catch(RuntimeException e)
    	{
    		screen.setText("input ilegal");
    		
    	}
    }

}
