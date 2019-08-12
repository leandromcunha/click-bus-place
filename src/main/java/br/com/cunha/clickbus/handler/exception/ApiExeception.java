/**
 * Leandro Marques da Cunha.
 * Projeto HubFintech
 * Teste Tecnico - Transação com cartão de credito
 */
package br.com.cunha.clickbus.handler.exception;

import br.com.cunha.clickbus.services.enums.ExceptionCodeEnum;

/**
 * Class ApiExeception Responsible for throwing project exceptions.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$ Leandro
 */
public class ApiExeception extends RuntimeException {
    
    private static final long serialVersionUID = -3157268861766431642L;
    
    private ExceptionCodeEnum exceptionCodeEnum;
    
    public ApiExeception( final ExceptionCodeEnum exceptionCodeEnum, final Throwable e ) {
        super( e.getMessage(), e );
        this.exceptionCodeEnum = exceptionCodeEnum;
    }
    
    public ApiExeception( final ExceptionCodeEnum exceptionCodeEnum ) {
        this( exceptionCodeEnum, null );
    }
    
    /**
     * @return {@link ExceptionCodeEnum}
     */
    public ExceptionCodeEnum getExceptionCodeEnum() {
        return this.exceptionCodeEnum;
    }
}
