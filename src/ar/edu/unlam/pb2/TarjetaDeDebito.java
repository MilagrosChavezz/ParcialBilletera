package ar.edu.unlam.pb2;

public class TarjetaDeDebito extends Tarjeta implements Pagadora ,MedioDePAgo,ISaldo{
	
	private Double saldo;

	public TarjetaDeDebito(Long nUMERO_ESPERADO, String tITULAR_ESPERADO, Integer cODIGO_DE_SEGURIDAD_ESPERADO,
			String fECHA_DE_VENCIMIENTO_ESPERADO) {
		super(nUMERO_ESPERADO, tITULAR_ESPERADO, cODIGO_DE_SEGURIDAD_ESPERADO, fECHA_DE_VENCIMIENTO_ESPERADO);
		// TODO Auto-generated constructor stub
		this.saldo=0.0;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	
}
