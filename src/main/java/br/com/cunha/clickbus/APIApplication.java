package br.com.cunha.clickbus;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.cunha.clickbus.config.APIProperties;
import br.com.cunha.clickbus.config.Constants;
import br.com.cunha.clickbus.config.DefaultProfileUtil;

@Configuration
@SpringBootApplication( scanBasePackages = {"br.com.cunha"} )
@SpringBootConfiguration
@EnableJpaRepositories
@EnableConfigurationProperties( value = {APIProperties.class} )
public class APIApplication {
    
    /**
     * Atribute LOG
     */
    private static final Logger LOG = LoggerFactory.getLogger( APIApplication.class );
    
    /**
     * Vari\u00e1vel para defini\u00e7\u00e3o do profile
     */
    @Autowired
    private Environment env;
    
    @PostConstruct
    public void initApplication() {
        final Collection<String> activeProfiles = Arrays.asList( this.env.getActiveProfiles() );
        if( activeProfiles.contains( Constants.PROFILE_DEV ) && activeProfiles.contains( Constants.PROFILE_PROD ) ){
            APIApplication.LOG.error( "Escolha somente um perfil para executar sua aplica\u00e7\u00e3o, DEV ou PROD" );
        }
        if( activeProfiles.contains( Constants.PROFILE_DEV ) && activeProfiles.contains( Constants.PROFILE_CLOUD ) ){
            APIApplication.LOG
                    .error( "Escolha somente um perfil para executar sua aplica\\u00e7\\u00e3o, DEV ou CLOUD" );
        }
    }
    
    /**
     * M\u00e9todo principal para executar a aplica\u00e7\u00e3o
     *
     * @param args
     * @throws UnknownHostException
     */
    public static void main( final String[] args ) throws UnknownHostException {
        final SpringApplication app = new SpringApplication( APIApplication.class );
        DefaultProfileUtil.addDefaultProfile( app );
        final Environment env = app.run( args ).getEnvironment();
        String protocol = "http";
        if( env.getProperty( "server.ssl.key-store" ) != null ){
            protocol = "https";
        }
        APIApplication.LOG.info(
                "\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n\t" +
                        "External: \t{}://{}:{}\n\t" +
                        "Database: \t{} / {} \n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty( "spring.application.name" ), protocol, env.getProperty( "server.port" ), protocol,
                InetAddress.getLocalHost().getHostAddress(), env.getProperty( "server.port" ),
                env.getProperty( "spring.datasource.url" ), env.getProperty( "spring.datasource.username" ),
                env.getActiveProfiles() );
        
        final String configServerStatus = env.getProperty( "configserver.status" );
        APIApplication.LOG.info(
                "\n----------------------------------------------------------\n\t" +
                        "Config Server: \t{}\n----------------------------------------------------------",
                configServerStatus == null ? "Not found or not setup for this application" : configServerStatus );
    }
}