package com.prodyna.pac.conference.config;

import graphql.Scalars;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;

public class GraphQLConfiguration {

    @Bean
    GraphQLSchema schema() {
        return GraphQLSchema.newSchema()
                .query(GraphQLObjectType.newObject()
                        .name("query")
                        .field(field->field
                                .name("test")
                                .type(Scalars.GraphQLString)
                                .dataFetcher( environment -> "response" ))
                        .build() )
                .build();
    }

}
