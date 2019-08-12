/**
 * Leandro Marques da Cunha.
 * Projeto HubFintech
 * Teste Tecnico - Transação com cartão de credito
 */
package br.com.cunha.clickbus.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.cunha.clickbus.handler.exception.ApiExeception;
import br.com.cunha.clickbus.services.dto.ErroMessageExceptionDTO;

/**
 * Classe APIExceptionHandler Responsable for throwing standard exception.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$ Leandro
 */
@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {
    
    private static final Logger LOG = LoggerFactory.getLogger( APIExceptionHandler.class );
    
    @ExceptionHandler( {Exception.class} )
    public ResponseEntity<Object> handleAPIException( final Exception ex, final WebRequest request ) {
        APIExceptionHandler.LOG.error( "Erro:: handleAPIException:: Exception", ex );
        return this.handleExceptionInternal( ex, new ErroMessageExceptionDTO( "99", ex.getMessage() ),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request );
    }
    
    @ExceptionHandler( {ApiExeception.class} )
    public ResponseEntity<Object> handleAPIException( final ApiExeception ex, final WebRequest request ) {
        APIExceptionHandler.LOG.error( "Erro:: handleAPIException:: ApiExeception", ex );
        return this.handleExceptionInternal( ex,
                new ErroMessageExceptionDTO( ex.getExceptionCodeEnum().getCode(),
                        ex.getExceptionCodeEnum().getDescriprion() ),
                new HttpHeaders(), ex.getExceptionCodeEnum().getHttpStatus(), request );
    }
    
}
