package ca.shopping.springbootlibrary.config;
import ca.shopping.springbootlibrary.entity.Book;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
// TODO this code snippet is written in Java and is a method to configure the RepositoryRestConfiguration and CorsRegistry for a Spring Boot application.
//  In summary, the method is doing the following:
//  Defining an array of unsupported HTTP methods for the Book entity.
//  Exposing the Book entity IDs in the REST responses.
//  Disabling the unsupported HTTP methods for the Book entity.
//  Configuring the allowed origins for CORS requests.
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
    private String theAllowedOrigins="http://localhost:8088";
    @Override
    public void  configureRepositoryRestConfiguration(@NotNull RepositoryRestConfiguration config, CorsRegistry cors){
             HttpMethod[] theUnsupportedAcyions={
                     HttpMethod.POST,
                     HttpMethod.PATCH,
                     HttpMethod.DELETE,
                     HttpMethod.PUT};

                     config.exposeIdsFor(Book.class);

                     disableHttpMethods(Book.class,config,theUnsupportedAcyions);

                     cors.addMapping(config.getBasePath()+"/**")
                             .allowedOrigins(theAllowedOrigins);

             }
// TODO This method disables the specified HTTP methods for a given class in the RepositoryRestConfiguration. It takes in the class, the RepositoryRestConfiguration object, and an array of HttpMethod objects that should be disabled. The method first gets the ExposureConfiguration for the given class in the RepositoryRestConfiguration. It then sets the item exposure and collection exposure for the domain type, which determines how the item and collection resources are exposed in the REST API. For each of these, it disables the specified HTTP methods using the httpMethods.disable method.
    private void disableHttpMethods(Class theClass,
        RepositoryRestConfiguration config,
        HttpMethod[] theUnsupportedAcyions){
                 config.getExposureConfiguration()
                         .forDomainType(theClass)
                         .withItemExposure((metdata,httpMethods) ->httpMethods.disable(theUnsupportedAcyions))
                         .withCollectionExposure((metdata,httpMethods) ->httpMethods.disable(theUnsupportedAcyions));
        }
        }

