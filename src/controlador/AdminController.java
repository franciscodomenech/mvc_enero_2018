package controlador;

import model.Centro;
import model.questions.MainQuestions;
import vista.Consola;

public class AdminController {
	private Consola vista;
	private Centro centro;
	private MainQuestions questions;
	public AdminController() {
		vista = new Consola();
		centro = new Centro();
		questions = new MainQuestions();
	}
}
