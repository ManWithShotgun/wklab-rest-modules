package ru.ilia.rest.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ILIA on 11.04.2017.
 */
@XmlRootElement(name = "Chapter")
public class Chapter {

    /**
     * id.
     */
    private long id;
    /**
     * Number.
     */
    private int number;
    /**
     * Number of pages.
     */
    private int pagesCount;

    /**
     * Constructor.
     */
    public Chapter() {
    }

    /**
     * Constructor.
     * @param id id
     * @param number number
     * @param pagesCount number of pages
     */
    public Chapter(final long id, final int number, final int pagesCount) {
        this.id = id;
        this.number = number;
        this.pagesCount = pagesCount;
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
     * Get number.
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Set number.
     * @param number number
     */
    public void setNumber(final int number) {
        this.number = number;
    }

    /**
     * Get number of pages.
     * @return number of pages
     */
    public int getPagesCount() {
        return pagesCount;
    }

    /**
     * Set number of pages.
     * @param pagesCount number of pages
     */
    public void setPagesCount(final int pagesCount) {
        this.pagesCount = pagesCount;
    }

    @Override
    public String toString() {
        return String.format(
                "Chapter:\n\tid: %d\n\tNumber: %d\n\tPages: %d",
                getId(),
                getNumber(),
                getPagesCount());
    }
}
