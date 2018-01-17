package vista;

import java.util.Scanner;

public class Consola {
	
	private OnEvent listener;
	private Scanner sc;
	
	public Consola() {
		sc = new Scanner(System.in);
	}
	
	public void printQuestion(String text) {
		System.out.println(text);
	    String response = sc.nextLine();
	    if(listener!=null)
	    	listener.onResponse(response);
	}
	
	public void printResponse(String text) {
		System.out.println(text);
	}
	
	public void setOnEventListener(OnEvent l) {
		listener = l;
	}
	
	public interface OnEvent{
		public void onResponse(String response);
	}
	
}
