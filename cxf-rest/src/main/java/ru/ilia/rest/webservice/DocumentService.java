package ru.ilia.rest.webservice;

import ru.ilia.rest.data.Chapter;
import ru.ilia.rest.data.Document;
import ru.ilia.rest.exception.NotImplementedException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by ILIA on 11.04.2017.
 */
@Path("/documents/")
public interface DocumentService {


    /**
     * Create document.
     * @param document Document
     * */
    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    void create(Document document);

    /**
     * Read document.
     * @param id identifier of document.
     * @return Document
     * */
    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_XML })
    Document read(@PathParam("id") long id);

    /**
     * Update document.
     * @param document Document
     * */
    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    void update(Document document);

    /**
     * Delete document.
     * @param id identifier of document
     * */
    @DELETE
    @Path("{id}")
    void delete(@PathParam("id") long id);

    /**
     * Read all document.
     * @return Documents
     * */
    @GET
    @Produces({ MediaType.APPLICATION_XML })
    Collection<Document> readAll();

    /**
     * getDocumentShortestChapter.
     * @return Document
     * */
    @GET
    @Path("/short")
    @Produces({ MediaType.APPLICATION_XML })
    Document getDocumentShortestChapter();


    /**
     * getDocumentChapters.
     * @throws NotImplementedException 501
     * @return Chapters
     * */
    @GET
    @Path("{id}/chapters")
    @Produces({ MediaType.APPLICATION_XML })
    Collection<Chapter> getDocumentChapters() throws NotImplementedException;

}
