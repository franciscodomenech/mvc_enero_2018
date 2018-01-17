package controlador;

import model.Centro;
import model.questions.MainQuestions;
import model.questions.StatusResponse;
import vista.Consola;
import vista.Consola.OnEvent;

public class AdminController implements Consola.OnEvent {
	//El modelo es el centro y vista es la vista
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
	//Espera respuesta
	public void onResponse(String response) {
		String r = centro.processResponse(response);
		if(r!=null)
			vista.printResponse(r);
		nextQuestion();
	}
	//Para dar paso a la siguiente pregunta
	private void nextQuestion() {
		vista.printQuestion(centro.nextQuestion());
	}
}
