package ar.edu.unlam.pb2;

import java.util.Objects;

public abstract class Tarjeta {
	private Long NUMERO_ESPERADO ;
	private String TITULAR_ESPERADO ;
	private Integer CODIGO_DE_SEGURIDAD_ESPERADO;
	private String FECHA_DE_VENCIMIENTO_ESPERADO ;
	
	public Tarjeta(Long nUMERO_ESPERADO, String tITULAR_ESPERADO, Integer cODIGO_DE_SEGURIDAD_ESPERADO,
			String fECHA_DE_VENCIMIENTO_ESPERADO) {
		super();
		NUMERO_ESPERADO = nUMERO_ESPERADO;
		TITULAR_ESPERADO = tITULAR_ESPERADO;
		CODIGO_DE_SEGURIDAD_ESPERADO = cODIGO_DE_SEGURIDAD_ESPERADO;
		FECHA_DE_VENCIMIENTO_ESPERADO = fECHA_DE_VENCIMIENTO_ESPERADO;
	}

	public Long getNumero() {
		return NUMERO_ESPERADO;
	}

	public void setNumero(Long nUMERO_ESPERADO) {
		NUMERO_ESPERADO = nUMERO_ESPERADO;
	}

	public String getTitular() {
		return TITULAR_ESPERADO;
	}

	public void setTitular(String tITULAR_ESPERADO) {
		TITULAR_ESPERADO = tITULAR_ESPERADO;
	}

	public Integer getCodigoDeSeguridad() {
		return CODIGO_DE_SEGURIDAD_ESPERADO;
	}

	public void setCodigoDeSeguridad(Integer cODIGO_DE_SEGURIDAD_ESPERADO) {
		CODIGO_DE_SEGURIDAD_ESPERADO = cODIGO_DE_SEGURIDAD_ESPERADO;
	}

	public String getFechaDeVencimiento() {
		return FECHA_DE_VENCIMIENTO_ESPERADO;
	}

	public void setFECHA_DE_VENCIMIENTO_ESPERADO(String fECHA_DE_VENCIMIENTO_ESPERADO) {
		FECHA_DE_VENCIMIENTO_ESPERADO = fECHA_DE_VENCIMIENTO_ESPERADO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(NUMERO_ESPERADO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Tarjeta other = (Tarjeta) obj;
		return Objects.equals(NUMERO_ESPERADO, other.NUMERO_ESPERADO);
	}
	
	
	
	
}
