/**
 * Leandro Marques da Cunha.
 * Projeto HubFintech
 * Teste Tecnico - Transação com cartão de credito
 */
package br.com.cunha.clickbus.services;

import java.util.List;

import br.com.cunha.clickbus.services.dto.PlaceDTO;
import br.com.cunha.clickbus.services.entities.Place;

/**
 * Interface PlaceService Responsible for defining a service
 * provision signature.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$ Leandro
 */
public interface PlaceService {
    
    /**
     * Save a place
     *
     * @param PlaceDTO
     * @return ID {@link Long}
     */
    public Long save( PlaceDTO place );
    
    /**
     * Find a place by ID
     *
     * @param id
     *               {@link Long}
     * @return {@link PlaceDTO}
     */
    public PlaceDTO findById( Long id );
    
    /**
     * Find a place by name
     *
     * @param name
     *                 {@link String}
     * @return {@link Place}
     */
    public PlaceDTO findByName( String name );
    
    /**
     * find places by Like name
     *
     * @param name
     *                 {@link String}
     * @return {@link List<Place>}
     */
    public List<PlaceDTO> findByLikeName( String name );
}
