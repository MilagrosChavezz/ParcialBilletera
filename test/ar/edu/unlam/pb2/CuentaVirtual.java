package ar.edu.unlam.pb2;

public class CuentaVirtual extends Cuenta implements Transferible ,MedioDePAgo{

	private String cvu;
	
	public CuentaVirtual(String cvu,String eNTIDAD_ESPERADA, String tITULAR_ESPERADO) throws CVUInvalidoException {
		super(eNTIDAD_ESPERADA, tITULAR_ESPERADO);
		// TODO Auto-generated constructor stub
		setCvu(cvu);
	}

	public String getCvu() {
		return cvu;
	}

	public void setCvu(String cvu) throws CVUInvalidoException {
		char[] cvu1=cvu.toCharArray();
		Integer c=0;
	for (int i = 0; i < cvu1.length; i++) {
		c++;
	}
		if(c==23) {
		this.cvu = cvu;}
		else {
			throw new CVUInvalidoException();
		}
		
		
	}

}
