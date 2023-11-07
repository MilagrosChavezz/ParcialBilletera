package ar.edu.unlam.pb2;

public class TarjetaDeCredito extends Tarjeta implements Pagadora,MedioDePAgo,ISaldoLimite{

	private Double limiteDeCompraEnPesos;
	private Double limiteDeCompraEnDolares;

	
	public TarjetaDeCredito(Long nUMERO_ESPERADO, String tITULAR_ESPERADO, Integer cODIGO_DE_SEGURIDAD_ESPERADO,
			String fECHA_DE_VENCIMIENTO_ESPERADO,Double limiteDeCompraEnPesos,Double limiteDeCompraEnDolares) {
		super(nUMERO_ESPERADO, tITULAR_ESPERADO, cODIGO_DE_SEGURIDAD_ESPERADO, fECHA_DE_VENCIMIENTO_ESPERADO);
		// TODO Auto-generated constructor stub
		this.limiteDeCompraEnDolares=limiteDeCompraEnDolares;
		this.limiteDeCompraEnPesos=limiteDeCompraEnPesos;
	}


	public Double getLimiteDeCompraEnPesos() {
		return limiteDeCompraEnPesos;
	}


	public void setLimiteDeCompraEnPesos(Double limiteDeCompraEnPesos) {
		this.limiteDeCompraEnPesos = limiteDeCompraEnPesos;
	}


	public Double getLimiteDeCompraEnDolares() {
		return limiteDeCompraEnDolares;
	}


	public void setLimiteDeCompraEnDolares(Double limiteDeCompraEnDolares) {
		this.limiteDeCompraEnDolares = limiteDeCompraEnDolares;
	}

	
	
}
