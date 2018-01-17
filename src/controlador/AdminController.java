package controlador;

import model.Centro;
import model.questions.MainQuestions;
import model.questions.StatusResponse;
import vista.Consola;
import vista.Consola.OnEvent;

public class AdminController implements Consola.OnEvent {
	private Consola vista;
	private Centro centro;
	
	public AdminController() {
		vista = new Consola();
		centro = new Centro();
		
		vista.setOnEventListener(this);
		/*vista.setOnEventListener(new OnEvent() {

			@Override
			public void onResponse(String response) {
				
			}
			
		});*/
		nextQuestion();
	}
	@Override
	public void onResponse(String response) {
		String r = centro.processResponse(response);
		if(r!=null)
			vista.printResponse(r);
		nextQuestion();
	}
	private void nextQuestion() {
		vista.printQuestion(centro.nextQuestion());
	}
}
