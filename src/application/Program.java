package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Entre data dp trabalhador:");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nível: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Salário Base: ");
		double salarioBase = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase,new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos possui esse trabalhador: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Entre com a data do contrato nº" + (i+1));
			System.out.print("Data (DD/MM/AAAA): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			HoraContrato contrato = new HoraContrato(dataContrato, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Entre com o mês e o ano para calcular a renda: ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getName());
		System.out.println("Renda para: " + mesAno + ": " + String.format("%.2f",trabalhador.renda(ano, mes)));
		
		sc.close();

	}

}
