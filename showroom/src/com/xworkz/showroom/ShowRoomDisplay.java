package com.xworkz.showroom;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.xworkz.showroom.entity.ShowroomEntity;
import com.xworkz.showroom.service.ShowRoomService;
import com.xworkz.showroom.service.ShowRoomServiceImpl;
import com.xworkz.showroom.util.EMFUtil;

public class ShowRoomDisplay {

	public static void main(String[] args) {
		ShowroomEntity entity = new ShowroomEntity("shanti honda", "bike", "hubli", "india");
		ShowroomEntity entity1 = new ShowroomEntity(" honda", "cars", "hubli", "india");
		ShowroomEntity entity2 = new ShowroomEntity("nagshanti ", "truck", "hubli", "india");
		ShowroomEntity entity3 = new ShowroomEntity("kirloskar", "tractor", "hubli", "india");
		ShowroomEntity entity4 = new ShowroomEntity("shanti honda", "bike", "hubli", "india");
		ShowroomEntity entity5 = new ShowroomEntity("shanti honda", "bike", "hubli", "india");
		ShowroomEntity entity6 = new ShowroomEntity("shanti honda", "bike", "hubli", "india");

		ShowRoomService service = new ShowRoomServiceImpl();
		// try {
//			service.validateAndSave(entity);
//			service.validateAndSave(entity1);
//			service.validateAndSave(entity2);
//			service.validateAndSave(entity3);
//			service.validateAndSave(entity4);

		List<ShowroomEntity> list = new ArrayList<ShowroomEntity>();
		list.add(entity1);
		list.add(entity2);
//		for (int i = 1000; i > 0; i--) {
//			list.add(entity);
////			list.add(entity1);
//			System.out.println(list.size());
//		}
		boolean validateAndSave = service.validateAndSave(list);
		System.out.println(validateAndSave);

//			Optional<ShowroomEntity> valiadateAndFindById = service.valiadateAndFindById(2);
//			if (valiadateAndFindById.isPresent()) {
//				ShowroomEntity showroomEntity = valiadateAndFindById.get();
//				System.out.println(showroomEntity);
//			}
//
//			service.validateAndUpdateNameById(5, "kirloskar");
//			service.deleteById(3);
	} // finally {
		// EMFUtil.getFactory().close();
//		}
//
//	}

}
