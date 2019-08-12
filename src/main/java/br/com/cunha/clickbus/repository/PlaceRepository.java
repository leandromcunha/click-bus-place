/**
 * Leandro Marques da Cunha.
 * Projeto HubFintech
 * Teste Tecnico - Transação com cartão de credito
 */
package br.com.cunha.clickbus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cunha.clickbus.services.entities.Place;

/**
 * Interface PlaceRepository Responsible for persisting the information in the
 * database.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$ Leandro
 */
public interface PlaceRepository extends CrudRepository<Place,Long> {
    /**
     * Return a place
     *
     * @param name
     * @return {@link Place}
     */
    public Place findByName( String name );
    
    /**
     * Return a list place
     *
     * @param name
     * @return {@link List<Place>}
     */
    @Query( value = "SELECT * FROM TB_PLACE u WHERE u.NM_NAME like %:name%", nativeQuery = true )
    public List<Place> findByLikeName( @Param( "name" ) String name );
}