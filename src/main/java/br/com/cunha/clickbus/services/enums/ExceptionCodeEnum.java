/**
 * Leandro Marques da Cunha.
 * Projeto HubFintech
 * Teste Tecnico - Transação com cartão de credito
 */
package br.com.cunha.clickbus.services.enums;

import org.springframework.http.HttpStatus;

/**
 * Enum ExceptionCodeEnum Responsible for identifying the error response code.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$ Leandro
 */
public enum ExceptionCodeEnum {
    
    INTERNAL_SERVER_ERROR("99", "Erro Internal", HttpStatus.INTERNAL_SERVER_ERROR),;
    
    private String code;
    private String descriprion;
    private HttpStatus httpStatus;
    
    ExceptionCodeEnum( final String code, final String descriprion, final HttpStatus httpStatus ) {
        this.code = code;
        this.descriprion = descriprion;
        this.httpStatus = httpStatus;
    }
    
    public String getDescriprion() {
        return this.descriprion;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}