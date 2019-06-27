package rocket.app.view;

import java.awt.Button;
import java.awt.TextField;

import com.sun.xml.ws.org.objectweb.asm.Label;

import eNums.eAction;
import exceptions.RateException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	@FXML
	private TextField txtIncome;
	@FXML
	private TextField txtExpenses;
	@FXML
	private TextField txtCreditScore;
	@FXML
	private TextField txtHouseCost;
	@FXML
	private ComboBox comboBoxLoanTerm;
	@FXML
	private Label lblIncome;
	@FXML
	private Label lblExpenses;
	@FXML
	private Label lblCreditScore;
	@FXML
	private Label lblHouseCost;
	@FXML
	private Label lblLoanTerm;
	@FXML
	private Label lblPayment;
	@FXML
	private Label lblError;
	
	@FXML
	private Button calculateButton;
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event) throws NumberFormatException, RateException
	{
		Object message = null;
		
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		
		lq.setdRate(RateBLL.getRate(Integer.parseInt(txtCreditScore.getText())));
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		lq.setdIncome(Double.parseDouble(txtIncome.getText()));
		lq.setExpenses(Double.parseDouble(txtCreditScore.getText()));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		lq.setiTerm(Integer.parseInt(((String)comboBoxLoanTerm.getValue()).substring(0, 2))*12);
		
		
		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		double PossPayment = lRequest.getdIncome()*0.28;
		
		double PossPayment2 = (lRequest.getdIncome()-lRequest.getdExpenses())*0.36;
		double PaymentF=0;
		if(PossPayment > PossPayment2){
			PaymentF = PossPayment;
		}
		else{
			PaymentF = PossPayment2;
			
		}
		
		
	}
}
