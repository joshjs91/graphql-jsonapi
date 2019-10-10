// Copyright (c) 2019 Travelex Ltd

package com.josh.graphql.filter;

import io.crnk.core.engine.filter.RepositoryFilterBase;
import io.crnk.core.engine.filter.RepositoryFilterContext;
import io.crnk.core.engine.filter.RepositoryRequestFilterChain;
import io.crnk.core.engine.http.HttpMethod;
import io.crnk.core.module.Module;
import io.crnk.core.repository.response.JsonApiResponse;

public class BeerFilter extends RepositoryFilterBase implements Module {

    @Override
    public String getModuleName() {
        return BeerFilter.class.getName();
    }

    @Override
    public void setupModule(ModuleContext context) {
        context.addRepositoryFilter(this);
    }

    @Override
    public JsonApiResponse filterRequest(RepositoryFilterContext context, RepositoryRequestFilterChain chain) {
        HttpMethod method = context.getRequest().getMethod();
        //if post do this blah
        return super.filterRequest(context, chain);
    }
}
