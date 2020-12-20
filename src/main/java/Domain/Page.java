package Domain;

/**
 * @author SiletFlower
 * @date 2020/11/15 10:27:34
 * @description
 */
public class Page {
    private Integer pageSize = 10;
    private Integer pageCount;
    private Integer currentPage = 1;
    private Integer Count = 0;

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
