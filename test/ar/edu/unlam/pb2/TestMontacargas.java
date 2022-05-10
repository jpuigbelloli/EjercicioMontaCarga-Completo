package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestMontacargas {

	@Test
	public void queSePuedaCrearUnMontacargasConPesoMaximo() {
		Montacargas nuevoMontacarga;
		nuevoMontacarga = new Montacargas(800);

		assertNotNull(nuevoMontacarga);
	}

	@Test
	public void queSePuedanCrearCargasConPeso() {
		Carga nuevaCarga;
		nuevaCarga = new Carga(18);

		assertNotNull(nuevaCarga);
	}

	@Test
	public void queAlMontacargasSeLePuedaAgregarCargas() {

		Montacargas nuevoMontacarga;
		nuevoMontacarga = new Montacargas(500);

		Carga nuevaCarga;
		nuevaCarga = new Carga(200);

		final Integer CANTIDAD_DE_CARGAS_ESPERADAS = 1;

		nuevoMontacarga.agregarCarga(nuevaCarga);

		assertEquals(CANTIDAD_DE_CARGAS_ESPERADAS, nuevoMontacarga.getCantidadDeCargasRealizadas());
	}

	@Test
	public void queSeAcumuleElPesoDelMontacarga() {
		Montacargas nuevoMontacarga;
		nuevoMontacarga = new Montacargas(500);

		Carga primerCarga;
		primerCarga = new Carga(200);

		Carga segundaCarga;
		segundaCarga = new Carga(200);

		final Integer PESO_ESPERADO = 400;

		nuevoMontacarga.ingresarPesoDeCarga(primerCarga.getPeso());
		nuevoMontacarga.ingresarPesoDeCarga(segundaCarga.getPeso());

		assertEquals(PESO_ESPERADO, nuevoMontacarga.getPesoAcumuladoDeCarga());
	}

	@Test
	public void queSePuedaAguantarElPesoMaximoDelMontacargas() {
		Montacargas nuevoMontacarga;
		nuevoMontacarga = new Montacargas(500);

		Carga primerCargaDeseada;
		primerCargaDeseada = new Carga(500);

		assertTrue(nuevoMontacarga.agregarCarga(primerCargaDeseada));

	}

	@Test
	public void queNoSePuedaSuperarElPesoMaximoDelMontacargas() {
		Montacargas nuevoMontacarga;
		nuevoMontacarga = new Montacargas(500);

		Carga primerCargaDeseada;
		primerCargaDeseada = new Carga(501);

		assertFalse(nuevoMontacarga.agregarCarga(primerCargaDeseada));

	}

	@Test
	public void queAlPasarseElPesoMaximoDelMontacargasSeGenereLaExcepcion() {
		Montacargas nuevoMontacarga;
		nuevoMontacarga = new Montacargas(500);

		Carga primerCargaDeseada;
		primerCargaDeseada = new Carga(501);

		nuevoMontacarga.agregarCarga(primerCargaDeseada);

		assertTrue(nuevoMontacarga.getSobrePeso());

	}

}
