
package com.josh.graphql.exception;

import static graphql.ErrorType.DataFetchingException;
import static java.util.Arrays.asList;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;
import java.util.Map;

public class ResourceNotFoundException extends RuntimeException implements GraphQLError {

    public ResourceNotFoundException(String message) {
        super(message);
    }


    @Override
    public List<SourceLocation> getLocations() {
        return asList(new SourceLocation(1,1));
    }

    @Override
    public ErrorType getErrorType() {
        return DataFetchingException;
    }

    @Override
    public List<Object> getPath() {
        return null;
    }

    @Override
    public Map<String, Object> toSpecification() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return null;
    }
}
