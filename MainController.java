package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MainController {
	
	@FXML
	private Label result;
	private long x;
	private String operator = "";
	private boolean start = true;
	private Model model = new Model();
	
	@FXML
	public void processNumbers(ActionEvent event){
		if (start){
			result.setText("");
			start = false;
		}
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText()+ value);
	}
	
	@FXML
	public void processOperators(ActionEvent event){
		String value = ((Button)event.getSource()).getText();
		
		if (!value.equals("=")) {
			if (!operator.isEmpty())
				return;
			if (value.equals("<")){
				String newString = result.getText().substring(0, result.getText().length() - 1);
				result.setText(newString);
				return;
			} else if (value.equals("C")) {
				result.setText("");
				start = true;
				return;
			} else {
				operator = value;
				x = Long.parseLong(result.getText());
				result.setText("");
			}
		} else { //if we have pressed =
			if (operator.isEmpty())
				return;
			long y = Long.parseLong(result.getText());
			float output = model.Calculate(x, y, operator);
			int convertOutput;
			if (!hasDecimals(output)) {
				convertOutput = (int)output;
				result.setText(String.valueOf(convertOutput));
			} else {
				result.setText(String.valueOf(output));
			}
			
			//cleaning and resetting
			operator = "";
			start = true;
		}
	}
	
	public boolean hasDecimals(float number){
		if (number % 1 != 0)
			return true;
		return false;
	}
}
