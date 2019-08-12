/**
 * Leandro Marques da Cunha.
 * Projeto HubFintech
 * Teste Tecnico - Transação com cartão de credito
 */
package br.com.cunha.clickbus.services.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class responsible for returning a default response when an exception occurs
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$ Leandro
 */

@ApiModel( value = "ErroMessageExceptionDTO", description = "Default response when an exception occurs" )
public class ErroMessageExceptionDTO implements Serializable {
    
    private static final long serialVersionUID = -1567360184052836818L;
    
    @ApiModelProperty( name = "description", notes = "Description of exception" )
    private String description;
    
    @ApiModelProperty( name = "code", notes = "Code exception" )
    private String code;
    
    public ErroMessageExceptionDTO( final String code, final String description ) {
        super();
        this.description = description;
        this.code = code;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription( final String description ) {
        this.description = description;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode( final String code ) {
        this.code = code;
    }
    
}
