package D2.POJO;

import java.util.List;

public class Items {
    private List<GetItems> items;
    private boolean hasMore;
    private int limit;
    private int offset;
    private int count;
    private List<GetLinks> links;

    public List<GetItems> getItems() {
        return items;
    }

    public void setItems(List<GetItems> items) {
        this.items = items;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<GetLinks> getLinks() {
        return links;
    }

    public void setLinks(List<GetLinks> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Items{" +
                "items=" + items +
                ", hasMore=" + hasMore +
                ", limit=" + limit +
                ", offset=" + offset +
                ", count=" + count +
                ", links=" + links +
                '}';
    }
}
