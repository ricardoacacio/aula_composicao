package entities;

import java.util.Date;

public class HoraContrato {

	private Date data;
	private Double ValorPorHora;
	private Integer Hora;
	
	public HoraContrato () {
		
	}

	public HoraContrato(Date data, Double valorPorHora, Integer hora) {
		this.data = data;
		this.ValorPorHora = valorPorHora;
		this.Hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return ValorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		ValorPorHora = valorPorHora;
	}

	public Integer getHora() {
		return Hora;
	}

	public void setHora(Integer hora) {
		Hora = hora;
	}
	
	public double ValorTotal() {
		return ValorPorHora * Hora;
	}
}
