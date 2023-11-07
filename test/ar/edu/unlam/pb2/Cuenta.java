package ar.edu.unlam.pb2;

public abstract class Cuenta {
	
	private String ENTIDAD_ESPERADA ;
	private String TITULAR_ESPERADO ;
	
	
	public Cuenta(String eNTIDAD_ESPERADA, String tITULAR_ESPERADO) {
		super();
		ENTIDAD_ESPERADA = eNTIDAD_ESPERADA;
		TITULAR_ESPERADO = tITULAR_ESPERADO;
	}
	
	public String getEntidad() {
		return ENTIDAD_ESPERADA;
	}
	public void setEntidad(String eNTIDAD_ESPERADA) {
		ENTIDAD_ESPERADA = eNTIDAD_ESPERADA;
	}
	public String getTitular() {
		return TITULAR_ESPERADO;
	}
	public void setTITULAR_ESPERADO(String tITULAR_ESPERADO) {
		TITULAR_ESPERADO = tITULAR_ESPERADO;
	}
	

	
}
