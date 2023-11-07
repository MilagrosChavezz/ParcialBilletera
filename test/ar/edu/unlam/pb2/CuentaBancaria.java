package ar.edu.unlam.pb2;

public class CuentaBancaria extends Cuenta implements Transferible,MedioDePAgo {

	private String cbu;
	private Double saldo;
	
	public CuentaBancaria(String cbu,String eNTIDAD_ESPERADA, String tITULAR_ESPERADO) throws CBUInvalidoException {
		super(eNTIDAD_ESPERADA, tITULAR_ESPERADO);
		// TODO Auto-generated constructor stub
		setCbu(cbu);
		this.saldo=0.0;
	}


	public void setCbu(String cbu) throws CBUInvalidoException {
		char[] cbu1=cbu.toCharArray();
		Integer c=0;
	for (int i = 0; i < cbu1.length; i++) {
		c++;
	}
		if(c==20) {
		this.cbu = cbu;}
		else {
			throw new CBUInvalidoException();
		}
	}


	public String getCbu() {
		return cbu;
	}


	@Override
	public Double getSaldo() {
		// TODO Auto-generated method stub
		return saldo;
	}


	@Override
	public Double setSaldo(Double saldo) {
		// TODO Auto-generated method stub
		return this.saldo=saldo;
	}



	
	
}
