
public class Operator {
	
	LoginFrame lf = null;
	MyConnector connector = null;
	MainFrame home = null;
	informationFrame info = null;
	SignupFrame signup = null;

	public static void main(String[] args) {
		Operator operator = new Operator();
		operator.connector = new MyConnector();
		operator.lf = new LoginFrame(operator);
		operator.home = new MainFrame();
		operator.info = new informationFrame();
		operator.signup = new SignupFrame();

	}

}
