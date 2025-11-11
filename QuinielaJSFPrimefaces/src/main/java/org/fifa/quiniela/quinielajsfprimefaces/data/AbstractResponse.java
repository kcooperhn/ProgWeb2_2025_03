package org.fifa.quiniela.quinielajsfprimefaces.data;

import java.util.List;

public class AbstractResponse<T> {
    private List<T> items;
    private boolean hasMore;
    private int count;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
