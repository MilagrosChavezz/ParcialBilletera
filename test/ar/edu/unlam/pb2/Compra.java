package ar.edu.unlam.pb2;

public class Compra {

	private Long numTarjeta;
	private Double monto;
	
	public Compra(Long numTarjeta, Double monto) {
		super();
		this.numTarjeta = numTarjeta;
		this.monto = monto;
	}
	
	public Long getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(Long numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	
	
}
