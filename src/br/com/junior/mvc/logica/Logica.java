package br.com.junior.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Junior
 *
 */
public interface Logica{
	public void executa(HttpServletRequest request, HttpServletResponse response)throws Exception;
}