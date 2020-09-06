package com.codeodyssey.fileparser.api.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

/**
 * @author hiran
 * @Description Entity Object
 * used for persisting store orders to database
 */
@Entity
@Table(name="store_order")
public class StoreOrder implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@NonNull
	@Column(name="ORDER_ID")
	private String orderId;
	
	@NonNull
	@Column(name="ORDER_DATE")
	private Date orderDate;
	
	@NonNull
	@Column(name="SHIP_DATE")
	private Date shipDate;
	
	@Column(name="SHIP_MODE")
	private String shipMode;
	
	@NonNull
	@Column(name="CUSTOMER_ID")
	private String customerId;
	
	@NonNull
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="SEGMENT")
	private String segment;
	
	@NonNull
	@Column(name="COUNTRY")
	private String country;
	
	@NonNull
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@NonNull
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="REGION")
	private String region;
	
	@NonNull
	@Column(name="PRODUCT_ID")
	private String productId;
	
	@NonNull
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="SUB_CATEGORY")
	private String subCategory;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="SALES")
	private Double sales;
	
	@NonNull
	@Column(name="QUANTITY")
	private Integer quantity;
	
	@Column(name="DISCOUNT")
	private Double discount;
	
	@NonNull
	@Column(name="PROFIT")
	private Float profit;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the shipDate
	 */
	public Date getShipDate() {
		return shipDate;
	}
	/**
	 * @param shipDate the shipDate to set
	 */
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	/**
	 * @return the shipMode
	 */
	public String getShipMode() {
		return shipMode;
	}
	/**
	 * @param shipMode the shipMode to set
	 */
	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the segment
	 */
	public String getSegment() {
		return segment;
	}
	/**
	 * @param segment the segment to set
	 */
	public void setSegment(String segment) {
		this.segment = segment;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the subCategory
	 */
	public String getSubCategory() {
		return subCategory;
	}
	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the sales
	 */
	public Double getSales() {
		return sales;
	}
	/**
	 * @param sales the sales to set
	 */
	public void setSales(Double sales) {
		this.sales = sales;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	/**
	 * @return the profit
	 */
	public Float  getProfit() {
		return profit;
	}
	/**
	 * @param profit the profit to set
	 */
	public void setProfit(Float profit) {
		this.profit = profit;
	}
	@Override
	public String toString() {
		return "StoreOrder [id=" + id + ", orderId=" + orderId + ", orderDate=" + orderDate + ", shipDate=" + shipDate
				+ ", shipMode=" + shipMode + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", segment=" + segment + ", country=" + country + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", region=" + region + ", productId=" + productId + ", category="
				+ category + ", subCategory=" + subCategory + ", productName=" + productName + ", sales=" + sales
				+ ", quantity=" + quantity + ", discount=" + discount + ", profit=" + profit + "]";
	}
	

}
