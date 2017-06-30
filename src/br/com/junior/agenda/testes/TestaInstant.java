package br.com.junior.agenda.testes;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TestaInstant {

	public static void main(String[] args) {
		Instant inicio = Instant.now();
		
		System.out.println("blablablla");System.out.println("blablablala");System.out.println("blablablala");
		
		Instant fim = Instant.now();
		Duration duracao = Duration.between(inicio, fim);
		
		long duracaoEmMilissegundos = duracao.toMillis();
		long duracaoEmNanosegundos = duracao.toNanos();
		
		System.out.println("Tempo em milissegundos: " + duracaoEmMilissegundos);
		System.out.println("Tempo em nanos: " +duracaoEmNanosegundos);
		System.out.println("nano sem jogar no long:"+duracao.toNanos());

		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = 
		  DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("formatada: "+hoje.format(formatador));
	}
}
