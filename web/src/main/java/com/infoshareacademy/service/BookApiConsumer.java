package com.infoshareacademy.service;


import com.infoshareacademy.domain.api.BookJson;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class BookApiConsumer {


   private static final String URI = "http://isa-proxy.blueazurit.com/books/books/";

    private WebTarget webTarget;

    @Inject
    private ParserService parserService;

    public List<BookJson> consumeBooks() {
        configureClientTarget();
        Response response = webTarget.request().get();
        String resp = response.readEntity(String.class);
        response.close();
        return parserService.parseBookFromUri(resp);
    }

    private void configureClientTarget() {
        Client client = ClientBuilder.newClient();
        webTarget = client.target(URI);
    }
}