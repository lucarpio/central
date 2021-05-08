package edu.programacion.central.domain;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.*;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_order")
public class Order {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private BigDecimal total;
    @Temporal(TemporalType.DATE)
    private Date created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customerID;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<OrderDetail> details;



    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Customer getCustomerID() {
        return this.customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public List<OrderDetail> getDetails() {
        return this.details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

}
