package com.chatboot.utils;

import org.springframework.util.Assert;

/**
 * Define un contenedor para asignar y optener el context user
 * @author Angel Mercado Ponce
 * 
 *
 */
public class UserContextHolder {
	private static final ThreadLocal<UserContext> userContext  = new ThreadLocal<UserContext>();
	
	/**
	 * 
	 * @return UserContext
	 */
	public static final UserContext getContext() {
		//optiene el contexto del hilo, en este caso user context
		UserContext context = userContext.get();
		//si no tiene aun valor crea un User context vacio y lo asigna
		if (context==null) {
			context = createEmptyContext();
			userContext.set(context);
		}
		return userContext.get();
	}
	
	/**
	 * Asigna el contexto User de una peticion rest
	 * @param context
	 */
	public static final void setContext(UserContext context) {
		//valida que el contexto no sea nulo
		Assert.notNull(context,"Only non-null UserContext instance are permitted");
		userContext.set(context);
	}
	
	public static final UserContext createEmptyContext() {
		return new UserContext();
	}
}
