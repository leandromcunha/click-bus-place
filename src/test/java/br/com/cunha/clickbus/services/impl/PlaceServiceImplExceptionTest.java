package br.com.cunha.clickbus.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.cunha.clickbus.handler.exception.ApiExeception;
import br.com.cunha.clickbus.repository.PlaceRepository;
import br.com.cunha.clickbus.services.dto.PlaceDTO;
import br.com.cunha.clickbus.services.entities.Place;
import br.com.cunha.clickbus.services.mapper.PlaceMapper;

public class PlaceServiceImplExceptionTest {
    
    @InjectMocks
    private PlaceServiceImpl placeService;
    
    @Mock
    private PlaceRepository placeRepository;
    
    @Mock
    private PlaceMapper placeMapper;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks( this );
    }
    
    /**
     * Test: Find by ID : Exception
     */
    @Test( expected = ApiExeception.class )
    public void placeTest8() {
        Mockito.when( this.placeRepository.findById( ArgumentMatchers.anyLong() ) ).thenThrow( ApiExeception.class );
        this.placeService.findById( 1l );
    }
    
    /**
     * Test: Find by name : Exception
     */
    @Test( expected = ApiExeception.class )
    public void placeTest9() {
        Mockito.when( this.placeRepository.findByName( ArgumentMatchers.anyString() ) )
                .thenThrow( ApiExeception.class );
        this.placeService.findByName( "FIND WITH EXCEPTION" );
    }
    
    /**
     * Test: Find by name : Exception
     */
    @Test( expected = ApiExeception.class )
    public void placeTest10() {
        Mockito.when( this.placeRepository.findByLikeName( ArgumentMatchers.anyString() ) )
                .thenThrow( ApiExeception.class );
        this.placeService.findByLikeName( "FIND WITH EXCEPTION" );
    }
    
    /**
     * Test: Find by name : Exception
     */
    @Test( expected = ApiExeception.class )
    public void placeTest11() {
        Mockito.when( this.placeRepository.save( ArgumentMatchers.any( Place.class ) ) )
                .thenThrow( ApiExeception.class );
        final PlaceDTO placeDTO = new PlaceDTO();
        this.placeService.save( placeDTO );
    }
    
}
