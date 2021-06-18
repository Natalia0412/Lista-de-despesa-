import java.sql.Date;
public class Despesa {
	private int idDespesa;
	private String descr;
	private Date data;
	private TipoDespesa tipoDespesa;
	private float valor;
	
	public Despesa() {
	}
	
	public Despesa(int idDespesa, String descr, Date data, TipoDespesa tipoDespesa, float valor) {
		this.idDespesa = idDespesa;
		this.descr = descr;
		this.data = data;
		this.tipoDespesa = tipoDespesa;
		this.valor = valor;
	}	
	public Despesa(String descr, Date data, TipoDespesa tipoDespesa, float valor) {
		this.descr = descr;
		this.data = data;
		this.tipoDespesa = tipoDespesa;
		this.valor = valor;
	}

	public int getIdDespesa() {
		return idDespesa;
	}

	public void setIdDespesa(int idDespesa) {
		this.idDespesa = idDespesa;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Despesa [idDespesa=" + idDespesa + ", descr=" + descr + ", data=" + data + ", tipoDespesa="
				+ tipoDespesa + ", valor=" + valor + "]";
	}
}
