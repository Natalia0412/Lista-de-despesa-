import javax.swing.JOptionPane;

public class TipoDespesaUI {
	public static TipoDespesa input(TipoDespesa tipoDespesa) {
		tipoDespesa.setDescrTipo(inputDescrTipo(tipoDespesa.getDescrTipo()));
		return tipoDespesa;
	}
	
	public static int inputIdTipo(int idTipo){
		idTipo=Integer.valueOf(JOptionPane.showInputDialog(" Id Tipo:",idTipo));
		return idTipo;
	}
	
	public static String inputDescrTipo(String descrTipo){
		descrTipo=(JOptionPane.showInputDialog(" Tipo Despesa:",descrTipo));
		return descrTipo;
	}
}
