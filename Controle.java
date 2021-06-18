import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controle {

	static String[] principal=
		{
				"0 - Sair",
				"1 - Tipo Despesa",
				"2 - Pessoa",
				"3 - Despesa"
		};
	static String[] itens=
		{
				"0 - Voltar",
				"1 - Incluir",
				"2 - Alterar",
				"3 - Excluir",
				"4 - Buscar",
				"5 - Listar"
		};
	public static void main(String[] args) {
		 Menu();
		

	}
	
	public static void Menu() {
		Menu menuPrincipal= new Menu(principal);
		int opcao=0;
		do {
			
			opcao=menuPrincipal.input();
			switch (opcao) {
			case 1:
				menuTipoDespesa();
				break;
			case 2:
				menuPessoa();
				break;
			case 3:
				menuDespesa();
				break;
			}
		}while(opcao!=0);
	}
	
	public static void menuTipoDespesa() {
		Menu menuItens= new Menu(itens);
		int opcao=0;
		do {
			TipoDespesa tipoDespesa=new TipoDespesa();
			opcao=menuItens.input();
			switch (opcao) {
			case 1:
				tipoDespesa=TipoDespesaUI.input(tipoDespesa);
				TipoDespesaDAO.insert(tipoDespesa);
				break;
			case 2:
				tipoDespesa.setIdTipo(TipoDespesaUI.inputIdTipo(0));
				tipoDespesa=TipoDespesaDAO.find(tipoDespesa.getIdTipo());
				tipoDespesa=TipoDespesaUI.input(tipoDespesa);
				TipoDespesaDAO.update(tipoDespesa);
				break;
			case 3:
				TipoDespesaDAO.delete(TipoDespesaUI.inputIdTipo(0));
				break;
			case 4:
				tipoDespesa=TipoDespesaDAO.find(TipoDespesaUI.inputIdTipo(0));
				JOptionPane.showMessageDialog(null, tipoDespesa);
				break;
			case 5:
				String dados="";
				for(TipoDespesa desp: TipoDespesaDAO.getAll())
					dados+=desp+"\n";
				JOptionPane.showMessageDialog(null,
						dados);
				break;
			}
			
		}while(opcao!=0);
		
	}
	public static void menuPessoa() {
		Menu menuItens= new Menu(itens);
		int opcao=0;
		do {
			Pessoa pessoaa=new Pessoa();
			opcao=menuItens.input();
			switch (opcao) {
			case 1:
				//pessoa=TipoDespesaUI.input(pessoa);
				//PessoaDAO.insert(tipoDespesa);
				break;
			case 2:
				//tipoDespesa.setIdTipo(TipoDespesaUI.inputIdTipo(0));
				//tipoDespesa=TipoDespesaDAO.find(tipoDespesa.getIdTipo());
				//tipoDespesa=TipoDespesaUI.input(tipoDespesa);
				//TipoDespesaDAO.update(tipoDespesa);
				break;
			case 3:
				//TipoDespesaDAO.delete(TipoDespesaUI.inputIdTipo(0));
				break;
			case 4:
				//tipoDespesa=TipoDespesaDAO.find(TipoDespesaUI.inputIdTipo(0));
				//JOptionPane.showMessageDialog(null, tipoDespesa);
				break;
			case 5:
				//String dados="";
				//for(TipoDespesa desp: TipoDespesaDAO.getAll())
				///	dados+=desp+"\n";
				//JOptionPane.showMessageDialog(null,
					//	dados);
				ArrayList<Object>objetos=new ArrayList<Object>();
				for(TipoDespesa tipoDespesa:TipoDespesaDAO.getAll())
					objetos.add(tipoDespesa);
				mostraDados(objetos);
				break;
			}
			
		}while(opcao!=0);
	}
	public static void menuDespesa() {
		
	}

}
