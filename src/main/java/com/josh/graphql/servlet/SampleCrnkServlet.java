// Copyright (c) 2019 Travelex Ltd

package com.josh.graphql.servlet;

import io.crnk.core.boot.CrnkBoot;
import io.crnk.servlet.CrnkServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Note these needs extra config set up with web.xml
public class SampleCrnkServlet extends CrnkServlet {

    @Override
    protected void initCrnk(CrnkBoot boot) {
        // do your configuration here
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

}
