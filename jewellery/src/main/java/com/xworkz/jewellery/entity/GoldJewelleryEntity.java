package com.xworkz.jewellery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.xworkz.jewellery.enums.JewelleryType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gold_jewellery")
@NamedQuery(name = "findByShopNameAndId", query = "select alia from GoldJewelleryEntity alia where alia.shopName=:sh and alia.id=:tag")
@NamedQuery(name = "findShopNameById", query = "select alia.shopName from GoldJewelleryEntity alia where alia.id=:tag")
@NamedQuery(name = "findMakingChargesByShopName", query = "select alia.makingCharges from GoldJewelleryEntity alia where alia.shopName=:sh")
@NamedQuery(name = "findWasteAgeChargesAndMakingChargesByShopName", query = "select alia.wastageCharges,alia.makingCharges from GoldJewelleryEntity alia where alia.shopName=:sh")
@NamedQuery(name = "findTotalPriceByGramAndShopName", query = "select sum(goldPrice + gstPrice + makingCharges + wastageCharges) from GoldJewelleryEntity alia where alia.shopName=:sh and alia.grams=:gm")
@NamedQuery(name = "findMakingChargesByShopNames", query = "select alia.makingCharges from GoldJewelleryEntity alia where alia.shopName=:sh")
@NamedQuery(name = "getAll", query = "select alia from GoldJewelleryEntity alia")
@NamedQuery(name = "getAllShopName", query = "select alia.shopName from GoldJewelleryEntity alia")
@NamedQuery(name = "getAllShopNameAndType", query = "select alia.shopName,alia.type from GoldJewelleryEntity alia")
@NamedQuery(name = "findAllByMakingChargesGreaterThan", query = "select alia from GoldJewelleryEntity alia where alia.makingCharges>:ch")
@NamedQuery(name = "findAllByWasteageChargesLessThan", query = "select alia from GoldJewelleryEntity alia where alia.wastageCharges<:ch")
@NamedQuery(name = "findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan", query = "select alia from GoldJewelleryEntity alia where alia.wastageCharges>:wa and alia.makingCharges>:mk")
public class GoldJewelleryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private JewelleryType type;
	@DecimalMin(value = "0.0", message = "values are naot valid")
	@Column(name = "price")
	private double goldPrice;
	@DecimalMin(value = "0.0", message = "values are naot valid")
	private double gstPrice;
	@DecimalMin(value = "0.0", message = "values are naot valid")
	private double grams;
	@DecimalMin(value = "0.0", message = "values are naot valid")
	private double makingCharges;
	@DecimalMin(value = "0.0", message = "values are naot valid")
	private double wastageCharges;
	private boolean copper;
	@NotNull
	@NotEmpty
	@Length(min = 3, max = 50)
	private String shopName;

	public GoldJewelleryEntity(JewelleryType type, double goldPrice, double gstPrice, double grams,
			double makingCharges, double wastageCharges, boolean copper, String shopName) {
		super();
		this.type = type;
		this.goldPrice = goldPrice;
		this.gstPrice = gstPrice;
		this.grams = grams;
		this.makingCharges = makingCharges;
		this.wastageCharges = wastageCharges;
		this.copper = copper;
		this.shopName = shopName;
	}

}
