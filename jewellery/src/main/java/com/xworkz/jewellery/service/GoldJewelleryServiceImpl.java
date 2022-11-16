package com.xworkz.jewellery.service;

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

}
