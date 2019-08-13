package br.com.cunha.clickbus.services.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cunha.clickbus.services.PlaceService;
import br.com.cunha.clickbus.services.dto.PlaceDTO;

@RunWith( SpringRunner.class )
@SpringBootTest
public class PlaceServiceImplTest {
    
    @Autowired
    private PlaceService placeService;
    
    /**
     * Test: Find by ID - Not Found
     */
    @Test
    public void placeTest1() {
        final PlaceDTO place = this.placeService.findById( 99l );
        Assert.assertNull( place );
    }
    
    /**
     * Test: Find by name - Not found
     */
    @Test
    public void placeTest2() {
        final PlaceDTO place = this.placeService.findByName( "NOT FOUND BY NAME" );
        Assert.assertNull( place );
    }
    
    /**
     * Test: Find by like name not found
     */
    @Test
    public void placeTest3() {
        final List<PlaceDTO> place = this.placeService.findByLikeName( "NOT FOUND BY LIKE NAME" );
        Assert.assertEquals( null, place );
    }
    
    /**
     * Test: Save places with success
     */
    @Test
    public void placeTest4() {
        Assert.assertNotNull( this.placeService.save( this.getPlace( "PLACE 1" ) ) );
        Assert.assertNotNull( this.placeService.save( this.getPlace( "PLACE 2" ) ) );
        Assert.assertNotNull( this.placeService.save( this.getPlace( "PLACE 3" ) ) );
        Assert.assertNotNull( this.placeService.save( this.getPlace( "PLACE 4" ) ) );
        Assert.assertNotNull( this.placeService.save( this.getPlace( "PLACE 5" ) ) );
    }
    
    /**
     * Test: Update place with success
     */
    @Test
    public void placeTest5() {
        final PlaceDTO place = this.placeService.findByName( "PLACE 1" );
        place.setName( "UPDATE PLACE 1" );
        final Long placeId = this.placeService.save( place );
        Assert.assertEquals( placeId, place.getId() );
    }
    
    /**
     * Test: Find by like name places list with success
     */
    @Test
    public void placeTest6() {
        final List<PlaceDTO> place = this.placeService.findByLikeName( "PLACE" );
        Assert.assertEquals( 5, place.size() );
    }
    
    /**
     * Test: Find by ID with success
     */
    @Test
    public void placeTest7() {
        final Long placeRequest = this.placeService.save( this.getPlace( "PLACE6" ) );
        final PlaceDTO placeResponse = this.placeService.findById( placeRequest );
        Assert.assertEquals( placeRequest, placeResponse.getId() );
    }
    
    private PlaceDTO getPlace( final String name ) {
        final PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setName( name );
        placeDTO.setCity( "SAO PAULO" );
        placeDTO.setSlug( "NEW SLUG " + name );
        placeDTO.setState( "SP" );
        return placeDTO;
    }
    
}
