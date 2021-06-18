
public class Teste {

	public static void main(String[] args) {
		
		/*
		// Teste Insert
		TipoDespesaDAO.insert(new TipoDespesa("Contas de Consumo"));
		
		// Teste find
		JOptionPane.showMessageDialog(null, TipoDespesaDAO.find(1));
		
		// Teste getAll
		JOptionPane.showMessageDialog(null, TipoDespesaDAO.getAll());
		
		// Teste update
		TipoDespesaDAO.update(new TipoDespesa(1, "Contas de Consumo"));
		
		// Teste delete
		TipoDespesaDAO.delete(1);
		*/

		//PessoaDAO.insert(new Pessoa("1223323-32",Date.valueOf(LocalDate.of(2000, 3, 10)),"Pedro", "pedro@gmail.com", 72.71f ));
		//PessoaDAO.insert(new Pessoa("2345762-21",Date.valueOf(LocalDate.of(1998, 5, 23)),"Maria", "maria@gmail.com", 55.48f ));
		//PessoaDAO.update(new Pessoa(5,"2345762-21",Date.valueOf(LocalDate.of(1998, 7, 23)),"Maria Aparecida", "maria@gmail.com", 54.48f ));
		//PessoaDAO.delete(1);
		//PessoaDAO.delete(2);

		//System.out.println(PessoaDAO.find(4));
		//System.out.println(PessoaDAO.find(5));
		//for (Pessoa pessoa: PessoaDAO.getAll()) 
		//	System.out.println(pessoa);
		
		/*
		TipoDespesa t1 = new TipoDespesa(1,"Contas de Consumo");

		Despesa d1 = new Despesa("Conta de Luz",Date.valueOf(LocalDate.of(2021, 6, 1)), t1, 102.25f );
		PessoaDAO.insertDespesa(4, d1);
		
		Despesa d2 = new Despesa("Conta de Água",Date.valueOf(LocalDate.of(2021, 6, 4)), t1, 70.43f );
		PessoaDAO.insertDespesa(4, d2);

		Despesa d3 = new Despesa("Conta de Luz",Date.valueOf(LocalDate.of(2021, 6, 1)), t1, 100.09f );
		PessoaDAO.insertDespesa(5, d3);
		
		Despesa d4 = new Despesa("Conta de Água",Date.valueOf(LocalDate.of(2021, 6, 4)), t1, 87.55f );
		PessoaDAO.insertDespesa(5, d4);
		*/
		Pessoa p1 = PessoaDAO.find(4);
		p1.setDespesas(PessoaDAO.getAllDespesa(p1.getIdPessoa()));
		System.out.println(p1);
		for (Despesa despesa : p1.getDespesas())
			System.out.println(despesa);
		

		Pessoa p2 = PessoaDAO.find(5);
		PessoaDAO.deleteDespesa(4);
		p2.setDespesas(PessoaDAO.getAllDespesa(p2.getIdPessoa()));
		System.out.println(p2);
		for (Despesa despesa : p2.getDespesas())
			System.out.println(despesa);
		
		p2.getDespesas().get(0).setValor(250.19f);
		PessoaDAO.UpdateDespesa(p2.getDespesas().get(0));
		p2.setDespesas(PessoaDAO.getAllDespesa(p2.getIdPessoa()));
		for (Despesa despesa : p2.getDespesas())
			System.out.println(despesa);

	}

}
