package domain;

import java.util.Date;
import java.util.Objects;

public class Bucket {

    private  Integer id;
    private  Integer userId;
    private  Integer productId;
    private Date puchaseDate;

    public Bucket(Integer id, Integer userId, Integer productId, Date puchaseDate) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.puchaseDate = puchaseDate;
    }
    public Bucket( Integer userId, Integer productId, Date puchaseDate) {
        this.userId = userId;
        this.productId = productId;
        this.puchaseDate = puchaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public java.sql.Date getPuchaseDate() {
        return (java.sql.Date) puchaseDate;
    }

    public void setPuchaseDate(Date puchaseDate) {
        this.puchaseDate = puchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return Objects.equals(id, bucket.id) && Objects.equals(userId, bucket.userId) && Objects.equals(productId, bucket.productId) && Objects.equals(puchaseDate, bucket.puchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, productId, puchaseDate);
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", puchaseDate=" + puchaseDate +
                '}';
    }
}
