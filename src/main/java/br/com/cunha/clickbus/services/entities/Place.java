/**
 * Leandro Marques da Cunha.
 * Projeto HubFintech
 * Teste Tecnico - Transação com cartão de credito
 */
package br.com.cunha.clickbus.services.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe Place Entity TB_PLACE.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$ Leandro
 */
@Entity
@Table( name = "TB_PLACE" )
@SequenceGenerator( name = "SEQ_PLACE", sequenceName = "SEQ_PLACE", initialValue = 1, allocationSize = 1 )
public class Place implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -5214050205234161066L;
    
    @Id
    @Column( name = "ID_PLACE" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_PLACE" )
    private Long id;
    
    @Column( name = "NM_NAME", nullable = false )
    private String name;
    
    @Column( name = "NM_SLUG", nullable = false )
    private String slug;
    
    @Column( name = "NM_CITY", length = 150, nullable = false )
    private String city;
    
    @Column( name = "SG_UF", length = 2, nullable = false )
    private String state;
    
    @Column( name = "DH_CREATED", updatable = false )
    private LocalDateTime created;
    
    @Column( name = "DH_UPDATED" )
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
        final Place other = ( Place )obj;
        if( this.id == null ){
            if( other.id != null ){
                return false;
            }
        }else if( !this.id.equals( other.id ) ){
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Place [id=" + this.id +
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
    
}
