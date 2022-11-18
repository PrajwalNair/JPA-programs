package com.xworkz.jewellery.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.jewellery.entity.GoldJewelleryEntity;
import com.xworkz.jewellery.repo.GoldJewelleryRepo;
import com.xworkz.jewellery.repo.GoldJewelleryRepoImpl;

public class GoldJewelleryServiceImpl implements GoldJewelleryService {

	private GoldJewelleryRepo repo = new GoldJewelleryRepoImpl();

	public boolean validateAndSave(GoldJewelleryEntity entity) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<GoldJewelleryEntity>> validate = validator.validate(entity);
		if (validate.size() > 0) {
			System.out.println("fix the errors");
		} else {
			this.repo.save(entity);
			System.out.println("data is valid");
		}
		return true;
	}

	public boolean validateAndSave(List<GoldJewelleryEntity> list) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		for (GoldJewelleryEntity goldJewelleryEntity : list) {
			Set<ConstraintViolation<GoldJewelleryEntity>> validate = validator.validate(goldJewelleryEntity);
			if (validate.size() > 0) {
				System.out.println("fix the errors");
			}
		}
		System.out.println(list);
		this.repo.save(list);

		return true;
	}

	public Optional<GoldJewelleryEntity> findByShopNameAndId(int id, String shopName) {

		return repo.findByShopNameAndId(id, shopName);
	}

	public Optional<String> findShopNameById(int id) {

		return repo.findShopNameById(id);
	}

	public Optional<String> findShopNameByIds(int id) {

		return repo.findShopNameByIds(id);
	}

	public Optional<Double> findMakingChargesByShopName(String shopName) {

		return repo.findMakingChargesByShopName(shopName);
	}

	public Optional<Object[]> findWasteAgeChargesAndMakingChargesByShopName(String shopName) {

		return repo.findWasteAgeChargesAndMakingChargesByShopName(shopName);
	}

	public Optional<Double> findTotalPriceByGramAndShopName(double gram, String shopName) {

		return repo.findTotalPriceByGramAndShopName(gram, shopName);
	}

	public Optional<List<GoldJewelleryEntity>> findMakingChargesByShopNames(String shopName) {

		return repo.findMakingChargesByShopNames(shopName);
	}

	public Collection<GoldJewelleryEntity> getAll() {

		return repo.getAll();
	}

	@Override
	public Collection<String> getAllShopName() {

		return repo.getAllShopName();
	}

	@Override
	public Collection<Object[]> getAllShopNameAndType() {

		return repo.getAllShopNameAndType();
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesGreaterThan(double charges) {

		return repo.findAllByMakingChargesGreaterThan(charges);
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByWasteageChargesLessThan(double charges) {

		return repo.findAllByWasteageChargesLessThan(charges);
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan(
			double wasteAgecharges, double makingCharges) {

		return repo.findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan(wasteAgecharges, makingCharges);
	}

}
