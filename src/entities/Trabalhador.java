package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	
	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<HoraContrato> contratos = new ArrayList<HoraContrato>();
	
	public Trabalhador() {
		
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}

	
	public void adicionarContrato(HoraContrato contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}
	
	public Double renda(Integer year, Integer month) {
		double sum = salarioBase;
		Calendar cal = Calendar.getInstance(); //instanciando a classe Calendar para poder usar os funções da classe no programa
		
		for(HoraContrato c : contratos) {
			cal.setTime(c.getData()); // associação da data da lista com a função do calendário
			int c_year = cal.get(Calendar.YEAR); // inserindo na variável os anos da lista
			int c_month = 1 + cal.get(Calendar.MONTH); // inserindo na variável os meses da lista
			
			if(c_year == year && c_month == month) { 
				sum = sum + c.ValorTotal();
			}
		}
		
		return sum;
	}
	
	
	//Comentários do código
	
	/*
	public void setContratos(List<HoraContrato> contratos) {
		this.contratos = contratos;
	}
	
	O setContratos foi retirado pois existem dois métodos que são responsáveis por
	adicionar e remover contratos, ou seja, o SetContratos não deve ser deixado ativo.
	*/
	
}
