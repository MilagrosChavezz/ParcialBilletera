package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Consumidor {

	private Integer dni;
	private String nombre;
	private Set<MedioDePAgo> medios;

	public Consumidor(Integer dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.medios = new HashSet<>();
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumidor other = (Consumidor) obj;
		return Objects.equals(dni, other.dni);
	}

	public Pagadora getPagadora(Long l) throws MedioDePagoInexistenteExeption {
		for (MedioDePAgo medioDePAgo : medios) {
			 if(medioDePAgo instanceof Pagadora && ((Pagadora) medioDePAgo).getNumero().equals(l)) {
				return (Pagadora) medioDePAgo;
			 }
		}
		throw new MedioDePagoInexistenteExeption();
	}

	public void setMedios(MedioDePAgo medios) {
		this.medios.add(medios);
	}

	public Integer cantidadMedios() {
		return this.medios.size();
	}

}
