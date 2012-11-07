package com.github.olagache.mongoweblog.utils

public class Page<E> {
    /**
     * Query that have been used to get this page.
     */
    private Query query;

    /**
     * All items in current page.
     */
    private List<E> items = new ArrayList<E>()

    /**
     * Total count of items in store.
     */
    int totalCount = 0


    private Page() {super()}

    public static <E> Page<E> fromQuery(Query query) {
        Page<E> page = new Page<E>()

        page.query = query
        return page
    }

    public int getPageCount() {
        if(totalCount <= 0) {
            return 1
        }

        int pageCount = totalCount / query.size

        if(pageCount * query.size != pageCount) {
            pageCount += 1
        }

        if(pageCount == 0) {
            pageCount = 1
        }

        return pageCount
    }

    public Query getQuery() {
        return query
    }

    public List<E> getItems() {
        return new ArrayList<E>(items);
    }

    public void setItems(List<E> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items can not be null");
        }

        this.items = new ArrayList<E>(items);
    }
}
