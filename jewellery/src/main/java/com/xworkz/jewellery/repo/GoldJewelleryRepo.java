package com.xworkz.jewellery.repo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.xworkz.jewellery.entity.GoldJewelleryEntity;

public interface GoldJewelleryRepo {
	boolean save(GoldJewelleryEntity entity);

	boolean save(List<GoldJewelleryEntity> list);

	Optional<GoldJewelleryEntity> findByShopNameAndId(int id, String shopName);

	Optional<String> findShopNameById(int id);

	Optional<String> findShopNameByIds(int id);

	Optional<Double> findMakingChargesByShopName(String shopName);

	Optional<Object[]> findWasteAgeChargesAndMakingChargesByShopName(String shopName);

	Optional<Double> findTotalPriceByGramAndShopName(double gram, String shopName);

	Optional<List<GoldJewelleryEntity>> findMakingChargesByShopNames(String shopName);

	Collection<GoldJewelleryEntity> getAll();

	Collection<String> getAllShopName();

	Collection<Object[]> getAllShopNameAndType();

	Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesGreaterThan(double charges);

	Optional<Collection<GoldJewelleryEntity>> findAllByWasteageChargesLessThan(double charges);

	Optional<Collection<GoldJewelleryEntity>> findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan(
			double wasteAgecharges, double makingCharges);

}
