package model.questions;


public class QuestionsDesmatricula extends Questions{

	private static final int STEP_NIF = 0;
	private static final int STEP_CONFIRM = 1;
	private String nif;
	
	public  QuestionsDesmatricula(){
		super();
		nif = new String();
	}
	
	
	@Override
	public void init() {
		this.questionsText.add("Nif a eliminar: ");
		this.questionsText.add("Confirmar: Si/No ");
	}

	@Override
	public StatusResponse processResponse(int step, String response) {
		StatusResponse sr = new StatusResponse();
		sr.setIsok(true);
		switch(step) {
		case STEP_NIF:
			nif = response;
			break;
		case STEP_CONFIRM:
				if(response.equals("Si"))
					sr.setResult(nif);
				else if(response.equals("No"))
					sr.setResult(null);
				else
					sr.setResult(false);
			break;
		}
		return sr;
	}

}
