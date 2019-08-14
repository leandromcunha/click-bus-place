/**
 * Leandro Marques da Cunha.
 * Projeto HubFintech
 * Teste Tecnico - Transação com cartão
 */
package br.com.cunha.clickbus.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import br.com.cunha.clickbus.services.PlaceService;
import br.com.cunha.clickbus.services.dto.ErroMessageExceptionDTO;
import br.com.cunha.clickbus.services.dto.PlaceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Class PlaceResource Responsible for exposing the API - CRUD a place.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$ Leandro
 */

@RestController
@RequestMapping( "/api" )
@Api( value = "CRUD - Manage a place" )
public class PlaceResource {
    
    @Autowired
    private PlaceService placeService;
    
    @PostMapping( "/place" )
    @ApiOperation( value = "Save a place", response = Long.class )
    @ApiResponses( value = {@ApiResponse( code = 200, message = "200 OK. Success.", response = Long.class ),
            @ApiResponse( code = 204, message = "204 NO CONTENT. No records found." ),
            @ApiResponse( code = 400, message = "400 BAD REQUEST Query error?", response = ErroMessageExceptionDTO.class ),
            @ApiResponse( code = 402, message = "402 UNAUTHORIZED. You are not authorized to access this service." ),
            @ApiResponse( code = 403, message = "403 FORBIDDEN. This service is not allowed to access." ),
            @ApiResponse( code = 404, message = "404 NOT FOUND. The service was not found." ),
            @ApiResponse( code = 405, message = "405 METHOD NOT ALLOWED. Unexpected retrieval method (final GET or POST)." ),
            @ApiResponse( code = 422, message = "422 UNPROCESSABLE ENTITY. Validation error." ),
            @ApiResponse( code = 500, message = "500 INTERNAL SERVER ERROR. An error occurred in our API.", response = ErroMessageExceptionDTO.class )} )
    @Timed
    
    public ResponseEntity<Long> save( @RequestBody
    final PlaceDTO place ) {
        place.setId( null );
        final Long idPlace = this.placeService.save( place );
        return new ResponseEntity<>( idPlace, HttpStatus.OK );
    }
    
    @PutMapping( "/place" )
    @ApiOperation( value = "Update a place", response = Long.class )
    @ApiResponses( value = {@ApiResponse( code = 200, message = "200 OK. Success." ),
            @ApiResponse( code = 204, message = "204 NO CONTENT. No records found." ),
            @ApiResponse( code = 400, message = "400 BAD REQUEST Query error?", response = ErroMessageExceptionDTO.class ),
            @ApiResponse( code = 402, message = "402 UNAUTHORIZED. You are not authorized to access this service." ),
            @ApiResponse( code = 403, message = "403 FORBIDDEN. This service is not allowed to access." ),
            @ApiResponse( code = 404, message = "404 NOT FOUND. The service was not found." ),
            @ApiResponse( code = 405, message = "405 METHOD NOT ALLOWED. Unexpected retrieval method (final GET or POST)." ),
            @ApiResponse( code = 422, message = "422 UNPROCESSABLE ENTITY. Validation error." ),
            @ApiResponse( code = 500, message = "500 INTERNAL SERVER ERROR. An error occurred in our API.", response = ErroMessageExceptionDTO.class )} )
    @Timed
    
    public ResponseEntity<Long> update( @RequestBody
    final PlaceDTO place ) {
        final Long idPlace = this.placeService.save( place );
        return new ResponseEntity<>( idPlace, HttpStatus.OK );
    }
    
    @GetMapping( "/place/{id}" )
    @ApiOperation( value = "Find a place by ID", response = PlaceDTO.class )
    @ApiResponses( value = {@ApiResponse( code = 200, message = "200 OK. Success." ),
            @ApiResponse( code = 204, message = "204 NO CONTENT. No records found." ),
            @ApiResponse( code = 400, message = "400 BAD REQUEST Query error?", response = ErroMessageExceptionDTO.class ),
            @ApiResponse( code = 402, message = "402 UNAUTHORIZED. You are not authorized to access this service." ),
            @ApiResponse( code = 403, message = "403 FORBIDDEN. This service is not allowed to access." ),
            @ApiResponse( code = 404, message = "404 NOT FOUND. The service was not found." ),
            @ApiResponse( code = 405, message = "405 METHOD NOT ALLOWED. Unexpected retrieval method (final GET or POST)." ),
            @ApiResponse( code = 422, message = "422 UNPROCESSABLE ENTITY. Validation error." ),
            @ApiResponse( code = 500, message = "500 INTERNAL SERVER ERROR. An error occurred in our API.", response = ErroMessageExceptionDTO.class )} )
    @Timed
    public ResponseEntity<PlaceDTO> findById( @PathVariable
    final Long id ) {
        final PlaceDTO place = this.placeService.findById( id );
        return new ResponseEntity<>( place, place == null ? HttpStatus.NO_CONTENT : HttpStatus.OK );
    }
    
    @GetMapping( "/place/{name}/find-by-name" )
    @ApiOperation( value = "Find a place by name", response = PlaceDTO.class )
    @ApiResponses( value = {@ApiResponse( code = 200, message = "200 OK. Success." ),
            @ApiResponse( code = 204, message = "204 NO CONTENT. No records found." ),
            @ApiResponse( code = 400, message = "400 BAD REQUEST Query error?", response = ErroMessageExceptionDTO.class ),
            @ApiResponse( code = 402, message = "402 UNAUTHORIZED. You are not authorized to access this service." ),
            @ApiResponse( code = 403, message = "403 FORBIDDEN. This service is not allowed to access." ),
            @ApiResponse( code = 404, message = "404 NOT FOUND. The service was not found." ),
            @ApiResponse( code = 405, message = "405 METHOD NOT ALLOWED. Unexpected retrieval method (final GET or POST)." ),
            @ApiResponse( code = 422, message = "422 UNPROCESSABLE ENTITY. Validation error." ),
            @ApiResponse( code = 500, message = "500 INTERNAL SERVER ERROR. An error occurred in our API.", response = ErroMessageExceptionDTO.class )} )
    @Timed
    public ResponseEntity<PlaceDTO> findByName( @PathVariable
    final String name ) {
        final PlaceDTO place = this.placeService.findByName( name );
        return new ResponseEntity<>( place, place == null ? HttpStatus.NO_CONTENT : HttpStatus.OK );
    }
    
    @GetMapping( "/place/{name}/find-by-like-name" )
    @ApiOperation( value = "Find a place list by like name" )
    @ApiResponses( value = {@ApiResponse( code = 200, message = "200 OK. Success." ),
            @ApiResponse( code = 204, message = "204 NO CONTENT. No records found." ),
            @ApiResponse( code = 400, message = "400 BAD REQUEST Query error?", response = ErroMessageExceptionDTO.class ),
            @ApiResponse( code = 402, message = "402 UNAUTHORIZED. You are not authorized to access this service." ),
            @ApiResponse( code = 403, message = "403 FORBIDDEN. This service is not allowed to access." ),
            @ApiResponse( code = 404, message = "404 NOT FOUND. The service was not found." ),
            @ApiResponse( code = 405, message = "405 METHOD NOT ALLOWED. Unexpected retrieval method (final GET or POST)." ),
            @ApiResponse( code = 422, message = "422 UNPROCESSABLE ENTITY. Validation error." ),
            @ApiResponse( code = 500, message = "500 INTERNAL SERVER ERROR. An error occurred in our API.", response = ErroMessageExceptionDTO.class )} )
    @Timed
    public ResponseEntity<List<PlaceDTO>> findByLikeName( @PathVariable
    final String name ) {
        final List<PlaceDTO> placeList = this.placeService.findByLikeName( name );
        return new ResponseEntity<>( placeList,
                CollectionUtils.isEmpty( placeList ) ? HttpStatus.NO_CONTENT : HttpStatus.OK );
    }
}
