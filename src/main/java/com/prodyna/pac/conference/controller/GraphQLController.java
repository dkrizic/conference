package com.prodyna.pac.conference.controller;

import com.prodyna.pac.conference.repository.LocationRepository;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class GraphQLController {

    private final GraphQL graphQL;

    public GraphQLController( LocationRepository locationRepository) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withResolverBuilders(
                        new AnnotatedResolverBuilder())
                .withOperationsFromSingleton( locationRepository, LocationRepository.class )
                .withValueMapperFactory(
                        new JacksonValueMapperFactory())
                .generate();
        graphQL = GraphQL.newGraphQL( schema ).build();
    }

    @PostMapping(value="/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String,Object> graphql(@RequestBody Map<String,String> request, HttpServletRequest raw ) {
        ExecutionResult result = graphQL.execute(ExecutionInput.newExecutionInput()
                .query(request.get("query"))
                .operationName( request.get("operationName"))
                .context(raw)
                .build());
        return result.toSpecification();
    }

}
