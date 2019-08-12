package br.com.cunha.clickbus.services.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlaceDTO
 *
 * @author Leandro
 */
@ApiModel( value = "PlaceDTO", description = "Information of a place" )
public class PlaceDTO implements Serializable {
    
    private static final long serialVersionUID = -5947011039467798193L;
    
    @ApiModelProperty( name = "id", notes = "Key of identification of a place" )
    private Long id;
    
    @ApiModelProperty( name = "name", notes = "The name of a place" )
    private String name;
    
    @ApiModelProperty( name = "slug", notes = "The slug of a place" )
    private String slug;
    
    @ApiModelProperty( name = "city", notes = "City of place" )
    private String city;
    
    @ApiModelProperty( name = "state", notes = "State of place" )
    private String state;
    
    @ApiModelProperty( name = "created", notes = "Date create of place" )
    private LocalDateTime created;
    
    @ApiModelProperty( name = "updated", notes = "Date of last update of place" )
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
}
