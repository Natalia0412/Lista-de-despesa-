import javax.swing.JOptionPane;

public class Menu {

	private String [] itens;
	Menu(String[] itens) {
		this.itens=itens;
		
	}
	
	public int input() {
		boolean flagErro =  false;
		int opcao=0;
		String mens="";
		for(String item:itens)
			mens+= item +"\n";
		do {
			try {
				flagErro=false;
				opcao=Integer.valueOf(JOptionPane.showInputDialog(mens));
			}catch(NumberFormatException e) {
				flagErro=true;
			}
		}while(flagErro);
		return opcao;
		
	}
	

}
