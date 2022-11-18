package com.xworkz.jewellery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;

import com.xworkz.jewellery.entity.GoldJewelleryEntity;
import com.xworkz.jewellery.enums.JewelleryType;
import com.xworkz.jewellery.service.GoldJewelleryService;
import com.xworkz.jewellery.service.GoldJewelleryServiceImpl;
import com.xworkz.jewellery.util.EMFUtil;

public class GoldJewelleryDisplay {

	public static void main(String[] args) {
		GoldJewelleryEntity entity = new GoldJewelleryEntity(JewelleryType.BRACELETT, 50000.00, 9000.00, 10.0, 2000.00,
				1000.00, true, "Kalyan jewellery");
		GoldJewelleryEntity entity1 = new GoldJewelleryEntity(JewelleryType.EARRINGS, 50000.00, 9000.00, 10.0, 3000.00,
				5000.00, true, "Malabar");
		GoldJewelleryEntity entity2 = new GoldJewelleryEntity(JewelleryType.NECKLESS, 50000.00, 9000.00, 10.0, 4000.00,
				3000.00, true, "Joyalukas");
		GoldJewelleryEntity entity3 = new GoldJewelleryEntity(JewelleryType.RING, 50000.00, 9000.00, 10.0, 5000.00,
				2000.00, true, "Lalitha gold");
		GoldJewelleryEntity entity4 = new GoldJewelleryEntity(JewelleryType.BRACELETT, 50000.00, 9000.00, 10.0, 2000.00,
				4000.00, true, "Kalyan jewellery");
		try {
			GoldJewelleryService service = new GoldJewelleryServiceImpl();

//		service.validateAndSave(entity);

			List<GoldJewelleryEntity> list = new ArrayList<GoldJewelleryEntity>();
			list.add(entity1);
			list.add(entity2);
			list.add(entity3);
			list.add(entity4);
//		service.validateAndSave(list);
			Optional<GoldJewelleryEntity> findByShopNameAndId = service.findByShopNameAndId(2, "Malabar");
			if (findByShopNameAndId.isPresent()) {
				GoldJewelleryEntity goldJewelleryEntity = findByShopNameAndId.get();
				System.out.println(goldJewelleryEntity);
			}

			System.out.println("=================================");

			Optional<String> findShopNameById = service.findShopNameById(4);
			if (findShopNameById.isPresent()) {
				String string = findShopNameById.get();
				System.out.println(string);
			}

			System.out.println("=================================");

			Optional<String> findShopNameByIds = service.findShopNameByIds(1);
			if (findShopNameByIds.isPresent()) {
				String string = findShopNameByIds.get();
				System.out.println(string);
			}

			System.out.println("=================================");

			Optional<Double> findMakingChargesByShopName = service.findMakingChargesByShopName("Lalitha gold");
			if (findMakingChargesByShopName.isPresent()) {
				Double makingCharge = findMakingChargesByShopName.get();
				System.out.println(makingCharge);
			}

			System.out.println("=================================");

			Optional<Object[]> findWasteAgeChargesAndMakingChargesByShopName = service
					.findWasteAgeChargesAndMakingChargesByShopName("Lalitha gold");
			if (findWasteAgeChargesAndMakingChargesByShopName.isPresent()) {
				Object[] objects = findWasteAgeChargesAndMakingChargesByShopName.get();
				for (Object object : objects) {
					System.out.println(object);
				}

			}

			System.out.println("=================================");

			Optional<Double> findTotalPriceByGramAndShopName = service.findTotalPriceByGramAndShopName(10.0,
					"Joyalukas");
			if (findTotalPriceByGramAndShopName.isPresent()) {
				Double double1 = findTotalPriceByGramAndShopName.get();
				System.out.println(double1);
			}

			System.out.println("=================================");

			Optional<List<GoldJewelleryEntity>> findMakingChargesByShopNames = service
					.findMakingChargesByShopNames("Kalyan jewellery");
			if (findMakingChargesByShopNames.isPresent()) {
				List<GoldJewelleryEntity> list2 = findMakingChargesByShopNames.get();
				System.out.println(list2);
			}

			System.out.println("=================================");

			Collection<GoldJewelleryEntity> all = service.getAll();
			all.forEach(ref -> System.out.println(ref));

			System.out.println("=================================");

			Collection<String> allShop = service.getAllShopName();
			allShop.forEach(ref -> System.out.println(ref));

			System.out.println("=================================");

			Collection<Object[]> allShopAndType = service.getAllShopNameAndType();
			for (Object[] objects : allShopAndType) {
				for (int i = 0; i < objects.length; i++) {
					System.out.println(objects[i]);
				}

			}

			System.out.println("=================================");

			Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesGreaterThan = service
					.findAllByMakingChargesGreaterThan(2000.00);
			if (findAllByMakingChargesGreaterThan.isPresent()) {
				System.out.println(findAllByMakingChargesGreaterThan.get());

			}

			System.out.println("=================================");

			Optional<Collection<GoldJewelleryEntity>> findAllByWasteageChargesLessThan = service
					.findAllByWasteageChargesLessThan(5000.00);
			if (findAllByWasteageChargesLessThan.isPresent()) {
				System.out.println(findAllByWasteageChargesLessThan.get());

			}

			System.out.println("=================================");

			Optional<Collection<GoldJewelleryEntity>> findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan = service
					.findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan(2000, 1000);
			if (findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan.isPresent()) {
				System.out.println(findAllByWasteageChargesGreaterThanAndMakingChargesGreaterThan.get());

			}

		} finally {
			EMFUtil.getFactory().close();
		}

	}

}
