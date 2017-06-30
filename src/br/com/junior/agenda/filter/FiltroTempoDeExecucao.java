package br.com.junior.agenda.filter;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException{
		Instant inicio = Instant.now();
		
		//long tempoInicial = System.currentTimeMillis();
		chain.doFilter(request, response);
		Instant fim = Instant.now();
		//long tempoFinal = System.currentTimeMillis();
		
		Duration duracao = Duration.between(inicio, fim);//intervalo, no meio
		
		String uri = ((HttpServletRequest)request).getRequestURI();//Uniform Resource Identifier
		String parametros = ((HttpServletRequest)request).getParameter("logica");
		
		System.out.println("Tempo de requisição de " + uri 
				+ "?logica="
				+ parametros + " demorou (ms):"
				//+ (tempoFinal - tempoInicial));
				+ (duracao.toMillis()));
	}
}
