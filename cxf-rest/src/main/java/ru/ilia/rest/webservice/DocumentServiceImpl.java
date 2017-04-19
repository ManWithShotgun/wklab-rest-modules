package ru.ilia.rest.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.ilia.rest.data.Chapter;
import ru.ilia.rest.data.Document;
import ru.ilia.rest.exception.NotImplementedException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ILIA on 11.04.2017.
 */
@Service("DocumentServiceImpl")
public final class DocumentServiceImpl implements DocumentService {

    /**
     * Global id.
     * */
    private static long globalId = 1;

    /**
     * Logger.
     * */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Emulating a database.
     */
    private Map<Long, Document> documents = new HashMap<Long, Document>();

    {
        Document one = new Document(0, "One");
        one.getChapters().add(new Chapter(1, 2, 3));
        one.getChapters().add(new Chapter(2, 4, 4));
        one.getChapters().add(new Chapter(3, 11, 7));
        documents.put(one.getId(), one);
    }

    @Override
    public void create(final Document document) {
        this.generateId(document);
        documents.put(document.getId(), document);
    }

    @Override
    public Document read(final long id) {
        return documents.get(id);
    }

    @Override
    public void update(final Document document) {
        if (documents.get(document.getId()) == null) {
            this.generateId(document);
        }
        documents.put(document.getId(), document);
    }

    @Override
    public void delete(final long id) {
        if (documents.get(id) == null) {
            throw new NullPointerException();
        }
        documents.remove(id);
    }

    @Override
    public Collection<Document> readAll() {
        return documents.values();
    }

    @Override
    public Document getDocumentShortestChapter() {
        Document minChapterDoc = null;
        int min = Integer.MAX_VALUE;
        for (Document document : documents.values()) {
            if (document.minimumLengthChapter() < min) {
                minChapterDoc = document;
                min = minChapterDoc.minimumLengthChapter();
                logger.info("Min " + min);
            }
        }
        return minChapterDoc;
    }

    @Override
    public Collection<Chapter> getDocumentChapters()
            throws NotImplementedException {
        throw new NotImplementedException();
    }

    /**
     * Generator id.
     * @param document Document
     * */
    private void generateId(final Document document) {
        document.setId(globalId);
        globalId++;
    }
}
