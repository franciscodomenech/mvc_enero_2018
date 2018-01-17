package model.questions;

public class QuestionsBorrar extends Questions {
	
	private final int STEP_NIF = 0;
	private final int STEP_BORRAR = 1;
	
	private String nif;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		questionsText.add("Nif: ");
		questionsText.add("¿Seguro? (Si/No):");
	}
	
	@Override
	public StatusResponse processResponse(int step, String response) {
		StatusResponse sr = new StatusResponse();
		sr.setIsok(true);
		switch(step) {
		case STEP_NIF:
			nif=response;
			break;
		case STEP_BORRAR:
			if(response.equals("Si")) {
				sr.setResult(nif);
			}	
			else if(response.equals("No")) {
				sr.setResult(null);
			}else
				sr.setIsok(false);
			break;
		}
		return sr;
	}

	

}
