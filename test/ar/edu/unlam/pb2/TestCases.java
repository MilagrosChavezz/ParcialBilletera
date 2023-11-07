package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
	public void queSePuedaCrearUnaTarjetaDeDebito() throws NumeroDeTarjetaInvalidoException{
		// Preparaci�n 
		final Long NUMERO_ESPERADO = 5446789813221201L;
		final String TITULAR_ESPERADO = "CAMILA CIENFUEGOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 123;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2022";
		final Double SALDO_ESPERADO = 10000.0;
		
		// Ejecuci�n
		Pagadora tarjetaDeDebito = new TarjetaDeDebito(NUMERO_ESPERADO, TITULAR_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO);
		((TarjetaDeDebito) tarjetaDeDebito).setSaldo(10000.0);
		
		// Verificaci�n
		assertEquals(NUMERO_ESPERADO, ((Tarjeta) tarjetaDeDebito).getNumero());
		assertEquals(TITULAR_ESPERADO, ((Tarjeta) tarjetaDeDebito).getTitular());
		assertEquals(CODIGO_DE_SEGURIDAD_ESPERADO, ((Tarjeta) tarjetaDeDebito).getCodigoDeSeguridad());
		assertEquals(FECHA_DE_VENCIMIENTO_ESPERADO, ((Tarjeta) tarjetaDeDebito).getFechaDeVencimiento());
		assertEquals(SALDO_ESPERADO, ((TarjetaDeDebito) tarjetaDeDebito).getSaldo());
	}
	
	@Test
	public void queSePuedaCrearUnaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException{
		// Preparaci�n 
		final Long NUMERO_ESPERADO = 4246789813221201L;
		final String TITULAR_ESPERADO = "SOFIA BARRIENTOS";
		final Integer CODIGO_DE_SEGURIDAD_ESPERADO = 567;
		final String FECHA_DE_VENCIMIENTO_ESPERADO = "25/05/2025";
		final Double LIMITE_COMPRA_EN_PESOS = 100000.0;
		final Double LIMITE_COMPRA_EN_DOLARES = 1000.0;
		
		// Ejecuci�n
		Pagadora tarjetaDeCredito = new TarjetaDeCredito(NUMERO_ESPERADO, TITULAR_ESPERADO, CODIGO_DE_SEGURIDAD_ESPERADO, FECHA_DE_VENCIMIENTO_ESPERADO, LIMITE_COMPRA_EN_PESOS, LIMITE_COMPRA_EN_DOLARES);

		// Verificaci�n
		assertEquals(NUMERO_ESPERADO, ((Tarjeta) tarjetaDeCredito).getNumero());
		assertEquals(TITULAR_ESPERADO, ((Tarjeta) tarjetaDeCredito).getTitular());
		assertEquals(CODIGO_DE_SEGURIDAD_ESPERADO, ((Tarjeta) tarjetaDeCredito).getCodigoDeSeguridad());
		assertEquals(FECHA_DE_VENCIMIENTO_ESPERADO, ((Tarjeta) tarjetaDeCredito).getFechaDeVencimiento());
		assertEquals(LIMITE_COMPRA_EN_PESOS, ((TarjetaDeCredito) tarjetaDeCredito).getLimiteDeCompraEnPesos());
		assertEquals(LIMITE_COMPRA_EN_DOLARES, ((TarjetaDeCredito) tarjetaDeCredito).getLimiteDeCompraEnDolares());
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaBancaria() throws CBUInvalidoException{
		// Preparaci�n 
		final String CBU_ESPERADO = "01702046600000087865";
		final String ENTIDAD_ESPERADA = "Santander";
		final String TITULAR_ESPERADO = "Vicente De La Pradera";
		
		// Ejeruci�n
		Transferible cuentaBancaria = new CuentaBancaria(CBU_ESPERADO, ENTIDAD_ESPERADA, TITULAR_ESPERADO);
		
		// Verificaci�n
		assertEquals(CBU_ESPERADO, ((CuentaBancaria) cuentaBancaria).getCbu());
		assertEquals(ENTIDAD_ESPERADA, ((Cuenta) cuentaBancaria).getEntidad());
		assertEquals(TITULAR_ESPERADO, ((Cuenta) cuentaBancaria).getTitular());
	}
	
	@Test
	public void queSePuedaCrearUnaCuentaVirtual() throws CVUInvalidoException{
		// Preparaci�n 
		final String CVU_ESPERADO = "46467898132212011234552";
		final String ENTIDAD_ESPERADA = "Mercado Pago";
		final String TITULAR_ESPERADO = "Leticia Bridgeton";
		
		// Ejecuci�n
		Transferible cuentaVirtual = new CuentaVirtual(CVU_ESPERADO, ENTIDAD_ESPERADA, TITULAR_ESPERADO);
		
		// Verificaci�n
		assertEquals(CVU_ESPERADO, ((CuentaVirtual) cuentaVirtual).getCvu());
		assertEquals(ENTIDAD_ESPERADA, ((Cuenta) cuentaVirtual).getEntidad());
		assertEquals(TITULAR_ESPERADO, ((Cuenta) cuentaVirtual).getTitular());
	}
	
	@Test
	public void queSePuedaCrearUnComercio() throws CuitInvalidoException{
		// Preparaci�n 
		final String NOMBRE_ESPERADO = "El almacen de la esquina";
		final Long CUIT_ESPERADO = 30215654124L;
		
		// Ejecuci�n
		Comercio elAlmacen = new Comercio(NOMBRE_ESPERADO, CUIT_ESPERADO);
		
		// Verificaci�n
		assertEquals(NOMBRE_ESPERADO, elAlmacen.getNombre());
		assertEquals(CUIT_ESPERADO, elAlmacen.getCuit());
	}
	
	@Test
	public void queSePuedaCrearUnConsumidor() {
		// Preparaci�n 
		final String NOMBRE_ESPERADO = "Erika Romeo";
		final Integer DNI_ESPERADO = 33458712;
		
		// Ejecuci�n
		Consumidor nuevo = new Consumidor(DNI_ESPERADO, NOMBRE_ESPERADO);
		
		// Verificaci�n
		assertEquals(NOMBRE_ESPERADO, nuevo.getNombre());
		assertEquals(DNI_ESPERADO, nuevo.getDni());
	}
	
	@Test
	public void queSePuedanAgregarComerciosALaBilletera() throws CuitInvalidoException{
		// Preparaci�n 
		final Integer CANTIDAD_DE_COMERCIOS_ESPERADOS = 2;
		
		// Ejecuci�n
		Billetera mataGalan = new Billetera("Ank");
		
		mataGalan.agregarComercio(new Comercio("Supermercado", 30456213545L));
		mataGalan.agregarComercio(new Comercio("Panader�a", 30215654124L));
		mataGalan.agregarComercio(new Comercio("Panader�a", 30215654124L));
		
		// Verificaci�n
		assertEquals(CANTIDAD_DE_COMERCIOS_ESPERADOS, mataGalan.getCantidadDeComercios());
	}
	
	@Test
	public void queSePuedanAgregarConsumidoresALaBilletera() {
		// Preparaci�n 
		final Integer CANTIDAD_DE_CONSUMIDORES_ESPERADOS = 2;
		
		// Ejecuci�n
		Billetera mataGalan = new Billetera("Bna+");
		
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarConsumidor(new Consumidor(36541231, "Sofia Molina"));
		
		// Verificaci�n
		assertEquals(CANTIDAD_DE_CONSUMIDORES_ESPERADOS, mataGalan.getCantidadDeConsumidores());
	}
	
	@Test
	public void queSePuedanAgregarDistintosMediosDePagoALaBilleteraDeUnConsumidor() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, NoCoincideTitularException{
		// Preparaci�n 
		final Integer CANTIDAD_DE_MEDIOS_EN_LA_BILLETERA_ESPERADOS = 4;
		
		// Ejecuci�n
		Billetera mataGalan = new Billetera("MercadoPago");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		
		
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeDebito(48332562153254623L, "Luis Gomez", 265, "10/10/2026"));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeDebito(48332562153254623L, "Luis Gomez", 312, "10/10/2026"));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeCredito(5423542385612354L, "Luis Gomez",346, "10/10/2026",153.0,153.0));
		mataGalan.agregarMedioDePago(27541231, new CuentaBancaria("01702046600000087865", "Naci�n", "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new CuentaVirtual("00000031000365215718062", "Mercado Pago", "Luis Gomez"));
		
		// Verificaci�n
		assertEquals(CANTIDAD_DE_MEDIOS_EN_LA_BILLETERA_ESPERADOS,mataGalan.getCantidadDeMediosDePago(27541231));
	}
	
	@Test
	public void queSePuedaPagarConUnaTarjetaDeCredito() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, ExcedeLimiteDeCompraException, MedioDePagoInexistenteExeption, NoCoincideTitularException, SaldoInsuficienteException{
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ank");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeCredito(48332562153254623L, "Luis Gomez", 265, "10/10/2026", 100000.0, 1000.0));
		mataGalan.agregarComercio(new Comercio("Panader�a", 30456213545L));	
		// Ejecuci�n	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 10.0);
		Boolean resultado = mataGalan.pagar(codigoQR,  mataGalan.buscarConsumidor(27541231).getPagadora(48332562153254623L));
		
		// Verificaci�n
		assertTrue(resultado);
	}
	
	@Test
	public void queSePuedaTransferirDeUnaCuentaAOtra() throws NumeroDeTarjetaInvalidoException, CBUInvalidoException, CVUInvalidoException, SaldoInsuficienteException, NoCoincideTitularException{
		// Preparaci�n 
		Billetera mataGalan = new Billetera("Ual�");
		Transferible cuentaOrigen = new CuentaBancaria("01702046600000087865", "Naci�n", "Luis Gomez");
		Consumidor consumidorOrigen = new Consumidor(27541231, "Luis Gomez");
		mataGalan.agregarConsumidor(consumidorOrigen);
		((Billetera) mataGalan).agregarMedioDePago(27541231, cuentaOrigen);
		
		Transferible cuentaDestino = new CuentaBancaria("01744046600000087335", "Galicia", "Sandra Bustos");
		Consumidor consumidorDestino = new Consumidor(33896541, "Sandra Bustos");
		mataGalan.agregarConsumidor(consumidorDestino);
		mataGalan.agregarMedioDePago(33896541, cuentaDestino);
				
		cuentaOrigen.setSaldo(23431241.0);
		// Ejecuci�n
		Boolean resultado = mataGalan.transferir(cuentaOrigen, cuentaDestino, (double) 123);
				
		// Verificaci�n
		assertTrue(resultado);
	}
	
	@Test (expected=SaldoInsuficienteException.class)
	public void queNoSePuedaTransferirSiElSaldoNoEsSuficiente() throws SaldoInsuficienteException, CBUInvalidoException, NoCoincideTitularException {
		Billetera mataGalan = new Billetera("Ual�");
		Transferible cuentaOrigen = new CuentaBancaria("01702046600000087865", "Naci�n", "Luis Gomez");
		Consumidor consumidorOrigen = new Consumidor(27541231, "Luis Gomez");
		mataGalan.agregarConsumidor(consumidorOrigen);
		((Billetera) mataGalan).agregarMedioDePago(27541231, cuentaOrigen);
		
		Transferible cuentaDestino = new CuentaBancaria("01744046600000087335", "Galicia", "Sandra Bustos");
		Consumidor consumidorDestino = new Consumidor(33896541, "Sandra Bustos");
		mataGalan.agregarConsumidor(consumidorDestino);
		mataGalan.agregarMedioDePago(33896541, cuentaDestino);
				
	
		// Ejecuci�n
		Boolean resultado = mataGalan.transferir(cuentaOrigen, cuentaDestino, (Double) 12323234.0);
				
		// Verificaci�n
		assertTrue(resultado);
	}
	
	@Test (expected=SaldoInsuficienteException.class)
	public void queNoSePuedaComprarSiElSaldoDeLaTarjetaDeDebitoEsInsuficiente() throws ExcedeLimiteDeCompraException, MedioDePagoInexistenteExeption, NoCoincideTitularException, SaldoInsuficienteException {
		// Preparaci�n 
				Billetera mataGalan = new Billetera("Ank");
				mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
				mataGalan.agregarMedioDePago(27541231, new TarjetaDeCredito(48332562153254623L, "Luis Gomez", 265, "10/10/2026", 10.0, 10.0));
				mataGalan.agregarComercio(new Comercio("Panader�a", 30456213545L));	
				// Ejecuci�n	
				Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 1023424.0);
				Boolean resultado = mataGalan.pagar(codigoQR,   mataGalan.buscarConsumidor(27541231).getPagadora(48332562153254623L));
				
				// Verificaci�n
				assertTrue(resultado);
	}
	
	@Test (expected=ExcedeLimiteDeCompraException.class)
	public void queNoSePuedaComprarSiSeExcedeElLimiteDeCompraDeLaTarjetaDeCredito() throws NoCoincideTitularException, ExcedeLimiteDeCompraException, MedioDePagoInexistenteExeption, SaldoInsuficienteException {
		Billetera mataGalan = new Billetera("Ank");
		mataGalan.agregarConsumidor(new Consumidor(27541231, "Luis Gomez"));
		mataGalan.agregarMedioDePago(27541231, new TarjetaDeDebito(48332562153254623L, "Luis Gomez", 265, "10/10/2026"));
		mataGalan.agregarComercio(new Comercio("Panader�a", 30456213545L));	
		mataGalan.agregarDineroAUnaTarjetaDeDebito(27541231, 13.0,48332562153254623L);
		// Ejecuci�n	
		Compra codigoQR = mataGalan.generarCodigoQR(30456213545L, 1042353425324.0);
		Boolean resultado = mataGalan.pagar(codigoQR,   mataGalan.buscarConsumidor(27541231).getPagadora(48332562153254623L));
		
		// Verificaci�n
		assertTrue(resultado);
	}

}
