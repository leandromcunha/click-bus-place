package br.com.cunha.clickbus.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import br.com.cunha.clickbus.handler.exception.ApiExeception;
import br.com.cunha.clickbus.repository.PlaceRepository;
import br.com.cunha.clickbus.services.PlaceService;
import br.com.cunha.clickbus.services.dto.PlaceDTO;
import br.com.cunha.clickbus.services.entities.Place;
import br.com.cunha.clickbus.services.enums.ExceptionCodeEnum;
import br.com.cunha.clickbus.services.mapper.PlaceMapper;

/**
 * Service class responsible for managing location registration
 *
 * @author Leandro
 */
@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {
    
    private final Logger LOG = LoggerFactory.getLogger( PlaceService.class );
    
    @Autowired
    private PlaceRepository placeRepository;
    
    @Autowired
    private PlaceMapper placeMapper;
    
    /**
     * Save or update a place
     */
    @Override
    public Long save( final PlaceDTO placeDTO ) {
        try{
            this.LOG.debug( "Begin save a place" );
            final LocalDateTime now = LocalDateTime.now();
            this.LOG.debug( "Converting Place DTO to Place Entity" );
            final Place place = this.placeMapper.toEntity( placeDTO );
            place.setCreated( now );
            place.setUpdated( now );
            this.LOG.debug( "Sending to repository" );
            this.placeRepository.save( place );
            this.LOG.debug( "Fininsh save a place: ID: {} ", place.getId() );
            return place.getId();
        }catch( final Exception e ){
            this.LOG.error( "A error: Save a place: {} ", e.getMessage() );
            throw new ApiExeception( ExceptionCodeEnum.INTERNAL_SERVER_ERROR, e );
        }
    }
    
    /**
     * Find a place by ID
     */
    @Override
    public PlaceDTO findById( final Long id ) {
        try{
            
            this.LOG.debug( "Begin find by id" );
            final Optional<Place> place = this.placeRepository.findById( id );
            if( place.isPresent() ){
                this.LOG.debug( "Success find by id: {}", id );
                return this.placeMapper.toDto( place.get() );
            }
            this.LOG.debug( "Place no found with id: {}", id );
            return null;
        }catch( final Exception e ){
            this.LOG.error( "A error: find by Id Place {} ", e.getMessage() );
            throw new ApiExeception( ExceptionCodeEnum.INTERNAL_SERVER_ERROR, e );
        }
    }
    
    /**
     * Find a place by name
     */
    @Override
    public PlaceDTO findByName( final String name ) {
        try{
            this.LOG.debug( "Begin find by name" );
            final Place place = this.placeRepository.findByName( name );
            if( place != null ){
                this.LOG.debug( "Success find by name {}", name );
                return this.placeMapper.toDto( place );
            }
            this.LOG.debug( "Place no found with name: {}", name );
            return null;
        }catch( final Exception e ){
            this.LOG.error( "A error: find by name Place {} ", e.getMessage() );
            throw new ApiExeception( ExceptionCodeEnum.INTERNAL_SERVER_ERROR, e );
        }
    }
    
    /**
     * Find a place list by like name
     */
    @Override
    public List<PlaceDTO> findByLikeName( final String name ) {
        try{
            this.LOG.debug( "Begin find by name" );
            final List<Place> places = this.placeRepository.findByLikeName( name );
            if( CollectionUtils.isEmpty( places ) ){
                this.LOG.debug( "Not found places with name" );
                return null;
            }
            final List<PlaceDTO> placeDTOs = this.placeMapper.toDto( places );
            this.LOG.debug( "Success find by like name: {}", name );
            return placeDTOs;
        }catch( final Exception e ){
            this.LOG.error( "A error: find by like name Place {} ", e.getMessage() );
            throw new ApiExeception( ExceptionCodeEnum.INTERNAL_SERVER_ERROR, e );
        }
    }
}