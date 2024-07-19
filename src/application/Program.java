package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Cliente> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
			
		for(int i = 0; i < n; i++) {
			System.out.println("Tax payer #" + (i+ 1) + "data:");
			
			System.out.print("Individual or company (i/c)? ");
			char res = sc.next().charAt(0);
			
			if(res == 'i') {
				System.out.print("Name: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.print("Anual income: ");
				double rendaAnual = sc.nextDouble();
				System.out.print("Health expenditures: ");
				double gastosSaude = sc.nextDouble();
				list.add( new PessoaFisica(nome, rendaAnual, gastosSaude));
			} 
			else {
				System.out.print("Name: ");
				sc.nextLine();
				String nome = sc.nextLine();
				System.out.print("Anual income: ");
				double rendaAnual = sc.nextDouble();
				System.out.print("Number of employees: ");
				double numeroFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
			}
			
			
		}
		double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for(Cliente imposto : list) {
			double taxa = imposto.imposto();
			System.out.println(imposto.getNome()+ ": $ "+ String.format("%.2f", imposto.imposto()));
			sum += taxa;
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES : $ " + String.format("%.2f", sum));
		sc.close();
	}
}
