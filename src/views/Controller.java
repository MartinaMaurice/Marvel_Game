package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import engine.Game;

public class Controller implements ActionListener {
	private Game engine;
	private View view;

	public Controller() throws IOException {
		this.engine = new Game(null, null);
		this.view = new View();
	
	}	

	public static void main(String[] args) {
		View start=	new View();
	}
   
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public Game getEngine() {
		
		return engine;
	}

	public View getView() {
		return view;
	}
	
	
	

}


