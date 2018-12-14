package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private Label lblSaveEachMonth;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturn1;
	
	@FXML
	private Label lblTotalSave;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtAnnualReturn2;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		
		//Retirement r1 = new Retirement(40,0.07,20,0.02,10000.0,2640.0);
		
		this.lblSaveEachMonth.setText("");
		this.txtYearsToWork.setText("");
		this.txtAnnualReturn1.setText("");
		this.lblTotalSave.setText("");
		this.txtYearsRetired.setText("");
		this.txtAnnualReturn2.setText("");
		this.txtRequiredIncome.setText("");
		this.txtMonthlySSI.setText("");
		
		System.out.println("Clear pressed");
		
		
		//	TODO: Clear all the text inputs
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		if(this.txtYearsToWork==null || this.txtAnnualReturn1==null ||
		   this.txtYearsRetired==null || this.txtAnnualReturn2==null ||
		   this.txtRequiredIncome==null || this.txtMonthlySSI==null)
		{
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Empty TestField");
            alert.setHeaderText("Empty TestField");
            alert.setContentText("Please Provide all imformations needed.");

            alert.showAndWait();
		}
		
		else 
		{
			try 
			{
				Integer.parseInt(this.txtYearsToWork.getText());
			}
			catch(Exception e)
			{
				Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Incorrect Data Type");
	            alert.setHeaderText("Incorrect Data Type");
	            alert.setContentText("Please Provade an integer for \"Years To Work\".");

	            alert.showAndWait();
			}
			try 
			{
				Double.parseDouble(this.txtAnnualReturn1.getText());
			}
			catch(Exception e)
			{
				Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Incorrect Data Type");
	            alert.setHeaderText("Incorrect Data Type");
	            alert.setContentText("Please Provade a Double for the first \"Annual Return\".");

	            alert.showAndWait();
			}
			try 
			{
				Integer.parseInt(this.txtYearsRetired.getText());
			}
			catch(Exception e)
			{
				Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Incorrect Data Type");
	            alert.setHeaderText("Incorrect Data Type");
	            alert.setContentText("Please Provade an integer for \"Years Retired\".");

	            alert.showAndWait();
			}
			try 
			{
				Double.parseDouble(this.txtAnnualReturn2.getText());
			}
			catch(Exception e)
			{
				Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Incorrect Data Type");
	            alert.setHeaderText("Incorrect Data Type");
	            alert.setContentText("Please Provade a double for the second \"Annual Return\".");

	            alert.showAndWait();
			}
			try 
			{
				Double.parseDouble(this.txtRequiredIncome.getText());
			}
			catch(Exception e)
			{
				Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Incorrect Data Type");
	            alert.setHeaderText("Incorrect Data Type");
	            alert.setContentText("Please Provade a double for the second \"Required Income\".");

	            alert.showAndWait();
			}
			try 
			{
				Double.parseDouble(this.txtMonthlySSI.getText());
			}
			catch(Exception e)
			{
				Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Incorrect Data Type");
	            alert.setHeaderText("Incorrect Data Type");
	            alert.setContentText("Please Provade a double for the second \"Monthly SSI\".");

	            alert.showAndWait();
			}
			
			if(Double.parseDouble(this.txtAnnualReturn2.getText())<0 || 
			   Double.parseDouble(this.txtAnnualReturn2.getText())>0.03)
			{
				Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Out Of Range");
	            alert.setHeaderText("Out Of Range");
	            alert.setContentText("Please use a range of 0-3% for annual return when in payback mode.");

	            alert.showAndWait();
			}
			
			else if(Double.parseDouble(this.txtAnnualReturn1.getText())<0||
					Double.parseDouble(this.txtAnnualReturn1.getText())>0.2)
			{
				Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Out Of Range");
	            alert.setHeaderText("Out Of Range");
	            alert.setContentText("Please use a range of 0-20% for annual return when in investment mode.");

	            alert.showAndWait();
			}
			
			else
			{
				Retirement r = new Retirement(Integer.parseInt(this.txtYearsToWork.getText()),
						  					  Double.parseDouble(this.txtAnnualReturn1.getText()),
						  					  Integer.parseInt(this.txtYearsRetired.getText()),
						  					  Double.parseDouble(this.txtAnnualReturn2.getText()),
						  					  Double.parseDouble(this.txtRequiredIncome.getText()),
						  					  Double.parseDouble(this.txtMonthlySSI.getText()));
			
				Double pv = r.TotalAmountSaved();
				Double pmt = r.AmountToSave();
				
				this.lblTotalSave.setText(String.format("%.2f", pv));	
				this.lblSaveEachMonth.setText(String.format("%.2f", pmt));
				
				//	TODO: Call AmountToSave and TotalAmountSaved and populate 
			}
		}
	}
	
}
