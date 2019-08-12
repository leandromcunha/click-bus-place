/**
 * Leandro Marques da Cunha.
 * Projeto HubFintech
 * Teste Tecnico - Transação com cartão de credito
 */
package br.com.cunha.clickbus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Classe HubFintechProperty responsável por carregar os parametro do sistema no
 * application.xml.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$ Leandro
 */

@ConfigurationProperties( "api" )
public class APIProperties {
    
}
