
package starter.models.unknown;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class Unknown {

    @Expose
    private List<DatumU> data;
    @Expose
    private Long page;
    @SerializedName("per_page")
    private Long perPage;
    @Expose
    private Long total;
    @SerializedName("total_pages")
    private Long totalPages;

    public List<DatumU> getData() {
        return data;
    }

    public void setData(List<DatumU> data) {
        this.data = data;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPerPage() {
        return perPage;
    }

    public void setPerPage(Long perPage) {
        this.perPage = perPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

}
