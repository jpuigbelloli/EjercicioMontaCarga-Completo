package ar.edu.unlam.pb2;

import java.util.Iterator;

public class Montacargas {

	private Integer PESO_MAXIMO;
	private Carga Cargas[];
	private final Integer CAPACIDAD_MAXIMA_DE_CARGAS;
	private Integer cantidadDeCargasRealizadas;
	private Integer pesoAcumuladoDeCarga;
	private Integer pesoTotalEstipulado;
	private Boolean sobrePeso;

	public Montacargas(Integer PESO_MAXIMO) {
		this.PESO_MAXIMO = PESO_MAXIMO;
		this.CAPACIDAD_MAXIMA_DE_CARGAS = 10;
		this.Cargas = new Carga[CAPACIDAD_MAXIMA_DE_CARGAS];
		this.cantidadDeCargasRealizadas = 0;
		this.pesoAcumuladoDeCarga = 0;
		this.pesoTotalEstipulado = 0;
		this.sobrePeso = false;
	}

	public Boolean agregarCarga(Carga nuevaCarga) {

		if (ingresarPesoDeCarga(nuevaCarga.getPeso())) {
			for (int i = 0; i < CAPACIDAD_MAXIMA_DE_CARGAS; i++) {
				if (this.Cargas[i] == null) {
					this.Cargas[cantidadDeCargasRealizadas++] = nuevaCarga;
					sobrePeso = false;
					return true;
				}
			}
			return true;
		} else {
			sobrePeso = true;
			return false;
		}
	}

	public Integer getCantidadDeCargasRealizadas() {
		return cantidadDeCargasRealizadas;
	}

	public Boolean ingresarPesoDeCarga(Integer pesoDeLaNuevaCarga) {

		pesoTotalEstipulado = pesoDeLaNuevaCarga + pesoAcumuladoDeCarga;

		if (pesoTotalEstipulado <= PESO_MAXIMO) {
			pesoAcumuladoDeCarga = pesoTotalEstipulado;
			return true;
		} else
			return false;
	}

	public Integer getPesoAcumuladoDeCarga() {
		return pesoAcumuladoDeCarga;
	}

	public Boolean getSobrePeso() {
		return this.sobrePeso;
	}

}
