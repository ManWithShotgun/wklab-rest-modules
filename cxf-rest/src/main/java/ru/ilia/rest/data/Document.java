package ru.ilia.rest.data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by ILIA on 11.04.2017.
 */
@XmlRootElement(name = "Document")
public class Document {

    /**
     * id.
     */
    private long id;
    /**
     * Name.
     */
    private String name;
    /**
     * Chapters.
     */
    private ArrayList<Chapter> chapters = new ArrayList<Chapter>();

    /**
     * Default constructor.
     */
    public Document() {
    }

    /**
     * Constructor.
     * @param id id
     * @param name name
     */
    public Document(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Get id.
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Set id.
     * @param id id
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * Get name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     * @param name name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get chapters.
     * @return list chapters
     */
    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    /**
     * Set chapters.
     * @param chapters chapters
     */
    public void setChapters(final ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    /**
     * Find and return minimal length chapter.
     * @return length
     */
    public int minimumLengthChapter() {
        int min = Integer.MAX_VALUE;
        for (Chapter chapter : chapters) {
            if (chapter.getPagesCount() < min) {
                min = chapter.getPagesCount();
            }
        }
        return min;
    }

    /**
     * Print document.
     */
    public void printDocument() {
        System.out.println("Document:");
        System.out.println("\tid:" + this.id);
        System.out.println("\tName:" + this.name);

        System.out.println("\tChapters");
        for (Chapter chapter : chapters) {
            System.out.println("\t\tChapter:");
            System.out.println("\t\t\tid: " + chapter.getId());
            System.out.println("\t\t\tNumber: " + chapter.getNumber());
            System.out.println("\t\t\tPages: " + chapter.getPagesCount());
        }
    }

    @Override
    public String toString() {
        String output = String.format(
                "Document:\n\tid: %d\n\tName: %s\n\t",
                getId(),
                getName());
        for (Chapter chapter : chapters) {
            output += chapter;
        }
        return output;
    }
}
