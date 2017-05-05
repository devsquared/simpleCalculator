package application;

public class Model {
	public float Calculate(long x, long y, String operator){
		// im a unicorn
		switch (operator) {
		case "+":
			return x + y;
		case "-":
			return x - y;
		case "*":
			return x * y;
		case "/":
			if (y == 0) {
				return 0; //need to write a function to catch this
			}
			return x / y;
		}
		
		return 0;
	}
}
