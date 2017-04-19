package ru.ilia.rest.client;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.client.WebClient;
import ru.ilia.rest.data.Chapter;
import ru.ilia.rest.data.Document;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ILIA on 17.04.2017.
 */
public class Main {
    /**
     * url to service.
     */
    private static String urlService = "http://localhost:9999/war-module/cxf/";

    /**
     * Main.
     * @param args any args
     */
    public static void main(final String[] args) {
        System.out.println("getDocument");
        Document document = getDocument(0);
        document.printDocument();

        System.out.println("\n\nupdateDocument: new name OneNew");
        document.setName("OneNew");
        updateDocument(document);
        document = getDocument(0);
        document.printDocument();

        System.out.println("\n\nCreate document");
        Document document1 = new Document();
        document1.getChapters().add(new Chapter(1, 7, 1));
        document1.getChapters().add(new Chapter(2, 4, 9));
        document1.setName("Two");
        createDocument(document1);

        System.out.println("\n\nAll documents");
        ArrayList<Document> documents = readAllDocuments();
        /* Java 8: documents.forEach(Document::printDocument); */
        for (Document doc : documents) {
            doc.printDocument();
        }

        System.out.println("\n\nDocumentShortestChapter");
        Document document2 = getDocumentShortestChapter();
        document2.printDocument();

        System.out.println("\n\nDelete document");
        deleteDocument(1);

        System.out.println("\n\ngetDocumentChapters with 501");
        getDocumentChapters();
    }

    /**
     * Get document.
     * @param id id
     * @return document
     */
    private static Document getDocument(final long id) {
        return WebClient.create(urlService)
                .path("documents/" + id)
                .accept(MediaType.APPLICATION_XML)
                .get(Document.class);
    }

    /**
     * Create document.
     * @param document document
     */
    private static void createDocument(final Document document) {
        WebClient webClient = WebClient
                .create(urlService,
                        Collections.singletonList(new JacksonJsonProvider()))
                .path("documents")
                .type(MediaType.APPLICATION_JSON);
        Response response = webClient.post(document);
        System.out.println(response.getStatus());
    }

    /**
     * Update document.
     * @param document document
     */
    private static void updateDocument(final Document document) {
        WebClient webClient = WebClient.create(urlService,
                Collections.singletonList(new JacksonJsonProvider()))
                .path("documents")
                .type(MediaType.APPLICATION_JSON);
        Response response = webClient.put(document);
        System.out.println("Code: " + response.getStatus());
    }

    /**
     * Delete document.
     * @param id id
     */
    private static void deleteDocument(final long id) {
        WebClient webClient = WebClient.create(urlService)
                .path("documents/" + id);
        Response response = webClient.delete();
        System.out.println("Code: " + response.getStatus());
    }

    /**
     * Read all documents.
     * @return list documents
     */
    private static ArrayList<Document> readAllDocuments() {
        return (ArrayList<Document>)
                WebClient.create(urlService)
                .path("documents")
                .accept(MediaType.APPLICATION_XML)
                .getCollection(Document.class);
    }

    /**
     * Get document with shortest chapter.
     * @return document
     */
    private static Document getDocumentShortestChapter() {
        return WebClient.create(urlService)
                .path("documents/short")
                .accept(MediaType.APPLICATION_XML)
                .get(Document.class);
    }

    /**
     * Method for test error 501 on service.
     */
    private static void getDocumentChapters() {
        Response response = WebClient.create(urlService)
                .path("documents/0/chapters")
                .accept(MediaType.APPLICATION_XML)
                .get();
        System.out.println("Code: " + response.getStatus());
    }
}
