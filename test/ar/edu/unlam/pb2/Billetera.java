package ar.edu.unlam.pb2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Billetera {

	private String nombre;
	private Set<Comercio> comercios;
	private Set<Consumidor> consumidores;
	

	public Billetera(String nombre) {
		super();
		this.nombre = nombre;
		this.comercios = new HashSet<>();
		this.consumidores = new HashSet<>();
		
	}

	public void agregarComercio(Comercio comercio) {
		// TODO Auto-generated method stub
		comercios.add(comercio);
	}

	public Integer getCantidadDeComercios() {
		// TODO Auto-generated method stub
		return comercios.size();
	}

	public void agregarConsumidor(Consumidor consumidor) {
		// TODO Auto-generated method stub
		consumidores.add(consumidor);
	}

	public Integer getCantidadDeConsumidores() {
		// TODO Auto-generated method stub
		return consumidores.size();
	}

	public Consumidor buscarConsumidor(Integer consumidorDni) throws NoCoincideTitularException {
		for (Consumidor c : consumidores) {
			if (c.getDni().equals(consumidorDni)) {
				return c;
			}
		}

		throw new NoCoincideTitularException();
	}

	public void agregarMedioDePago(Integer consumidorDni, MedioDePAgo medioDePago) throws NoCoincideTitularException {
		// TODO Auto-generated method stub
		if (buscarConsumidor(consumidorDni) != null) {
			buscarConsumidor(consumidorDni).setMedios(medioDePago);
		}

	}

	public Integer getCantidadDeMediosDePago(Integer i) throws NoCoincideTitularException {
		// TODO Auto-generated method stub

		return buscarConsumidor(i).cantidadMedios();

	}

	public Compra generarCodigoQR(long l, double d) {
		// TODO Auto-generated method stub
		return new Compra(l, d);
	}

	public Boolean pagar(Compra codigoQR, Pagadora pagadora) throws ExcedeLimiteDeCompraException, SaldoInsuficienteException {
		// TODO Auto-generated method stub

		if (pagadora instanceof ISaldoLimite && ((ISaldoLimite) pagadora).getLimiteDeCompraEnPesos() > codigoQR.getMonto()
				&& ((ISaldoLimite) pagadora).getLimiteDeCompraEnDolares() >= codigoQR.getMonto()) {

			return true;
		}else if(pagadora instanceof ISaldoLimite && ((ISaldoLimite) pagadora).getLimiteDeCompraEnPesos() < codigoQR.getMonto()
				&& ((ISaldoLimite) pagadora).getLimiteDeCompraEnDolares() <= codigoQR.getMonto()) {
			throw new SaldoInsuficienteException();
		}
		
		if (pagadora instanceof ISaldo && ((TarjetaDeDebito) pagadora).getSaldo() >= codigoQR.getMonto()) {
			((TarjetaDeDebito) pagadora).setSaldo(((TarjetaDeDebito) pagadora).getSaldo() - codigoQR.getMonto());
			return true;
		} else if(pagadora instanceof ISaldo && ((TarjetaDeDebito) pagadora).getSaldo() <= codigoQR.getMonto()){
			throw new ExcedeLimiteDeCompraException();
		}
		return false;
	}
	



	public void agregarMedioDePago(int consumidorDni, Transferible cuentaOrigen) throws NoCoincideTitularException {
		// TODO Auto-generated method stub
		if (buscarConsumidor(consumidorDni) != null) {
			buscarConsumidor(consumidorDni).setMedios((MedioDePAgo) cuentaOrigen);
		}
	}

	public void agregarDineroAUnaTarjetaDeDebito(Integer dniPropietario,Double saldo,Long Tarjeta) throws MedioDePagoInexistenteExeption, NoCoincideTitularException {
		if(buscarConsumidor(dniPropietario).getPagadora(Tarjeta) instanceof ISaldo) {
			Double saldoActual=((TarjetaDeDebito)buscarConsumidor(dniPropietario).getPagadora(Tarjeta)).getSaldo();
			((TarjetaDeDebito)buscarConsumidor(dniPropietario).getPagadora(Tarjeta)).setSaldo(saldo+saldoActual);
		
		}
	
		
	}
	
	public Boolean transferir(Transferible cuentaOrigen, Transferible cuentaDestino,Double dinero) throws SaldoInsuficienteException {
		// TODO Auto-generated method stub
		
		if(cuentaOrigen.getSaldo()>=dinero) {
			cuentaDestino.setSaldo(cuentaDestino.getSaldo()+dinero);
			return true;
		}else {
			throw new SaldoInsuficienteException();
		}
		
		
	}
}
