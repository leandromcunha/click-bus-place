package br.com.cunha.clickbus.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
            final LocalDateTime now = LocalDateTime.now();
            final Place place = this.placeMapper.toEntity( placeDTO );
            place.setCreated( now );
            if( placeDTO.getId() != null ){
                this.update( place, now );
            }
            place.setUpdated( now );
            this.placeRepository.save( place );
            return place.getId();
        }catch( final Exception e ){
            throw new ApiExeception( ExceptionCodeEnum.INTERNAL_SERVER_ERROR, e );
        }
    }
    
    /**
     * @param place
     * @param now
     */
    private void update( final Place place, final LocalDateTime now ) {
        if( this.placeRepository.existsById( place.getId() ) ){
            final PlaceDTO placeUpdate = this.findById( place.getId() );
            place.setCreated( placeUpdate.getCreated() );
        }
    }
    
    /**
     * Find a place by ID
     */
    @Override
    public PlaceDTO findById( final Long id ) {
        try{
            final Optional<Place> place = this.placeRepository.findById( id );
            if( place.isPresent() ){
                return this.placeMapper.toDto( place.get() );
            }
            return null;
        }catch( final Exception e ){
            throw new ApiExeception( ExceptionCodeEnum.INTERNAL_SERVER_ERROR, e );
        }
    }
    
    /**
     * Find a place by name
     */
    @Override
    public PlaceDTO findByName( final String name ) {
        try{
            final Place place = this.placeRepository.findByName( name );
            if( place != null ){
                final PlaceDTO placeDTO = this.placeMapper.toDto( place );
                return placeDTO;
            }
            return null;
        }catch( final Exception e ){
            throw new ApiExeception( ExceptionCodeEnum.INTERNAL_SERVER_ERROR, e );
        }
    }
    
    /**
     * Find a place list by like name
     */
    @Override
    public List<PlaceDTO> findByLikeName( final String name ) {
        try{
            final List<Place> places = this.placeRepository.findByLikeName( name );
            if( CollectionUtils.isEmpty( places ) ){
                return null;
            }
            final List<PlaceDTO> placeDTOs = this.placeMapper.toDto( places );
            return placeDTOs;
        }catch( final Exception e ){
            throw new ApiExeception( ExceptionCodeEnum.INTERNAL_SERVER_ERROR, e );
        }
    }
}