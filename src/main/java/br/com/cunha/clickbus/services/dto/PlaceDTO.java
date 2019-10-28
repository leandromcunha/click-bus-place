package br.com.cunha.clickbus.services.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlaceDTO
 *
 * @author Leandro
 */
@Api
@ApiModel( value = "PlaceDTO", description = "Information of a place" )
public class PlaceDTO implements Serializable {
    
    private static final long serialVersionUID = -5947011039467798193L;
    
    @ApiModelProperty( name = "id", notes = "Identification Key of a place" )
    private Long id;
    
    @ApiModelProperty( name = "name", notes = "The name of a place" )
    private String name;
    
    @ApiModelProperty( name = "slug", notes = "The slug of a place" )
    private String slug;
    
    @ApiModelProperty( name = "city", notes = "City of place" )
    private String city;
    
    @ApiModelProperty( name = "state", notes = "State of place" )
    private String state;
    
    @ApiModelProperty( name = "created", notes = "Create date of place", readOnly = true )
    private LocalDateTime created;
    
    @ApiModelProperty( name = "updated", notes = "Last date update of place", readOnly = true )
    private LocalDateTime updated;
    
    public Long getId() {
        return this.id;
    }
    
    public void setId( final Long id ) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName( final String name ) {
        this.name = name;
    }
    
    public String getSlug() {
        return this.slug;
    }
    
    public void setSlug( final String slug ) {
        this.slug = slug;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public void setCity( final String city ) {
        this.city = city;
    }
    
    public String getState() {
        return this.state;
    }
    
    public void setState( final String state ) {
        this.state = state;
    }
    
    public LocalDateTime getCreated() {
        return this.created;
    }
    
    public void setCreated( final LocalDateTime created ) {
        this.created = created;
    }
    
    public LocalDateTime getUpdated() {
        return this.updated;
    }
    
    public void setUpdated( final LocalDateTime updated ) {
        this.updated = updated;
    }
    
    @Override
    public String toString() {
        return "PlaceDTO [id=" + this.id +
                ", name=" +
                this.name +
                ", slug=" +
                this.slug +
                ", city=" +
                this.city +
                ", state=" +
                this.state +
                ", created=" +
                this.created +
                ", updated=" +
                this.updated +
                "]";
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = ( prime * result ) + ( ( this.id == null ) ? 0 : this.id.hashCode() );
        return result;
    }
    
    @Override
    public boolean equals( final Object obj ) {
        if( this == obj ){
            return true;
        }
        if( obj == null ){
            return false;
        }
        if( this.getClass() != obj.getClass() ){
            return false;
        }
        final PlaceDTO other = ( PlaceDTO )obj;
        if( this.id == null ){
            if( other.id != null ){
                return false;
            }
        }else if( !this.id.equals( other.id ) ){
            return false;
        }
        return true;
    }
    
}
