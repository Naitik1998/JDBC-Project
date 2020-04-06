package com.mindtree.trainproject.service;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.trainproject.entity.Train;
import com.mindtree.trainproject.exception.DuplicateTrainIdException;

public class ServiceImplement {

	ArrayList<Train> trainList = new ArrayList<Train>();

	public String addTrainRecord(Train train) throws DuplicateTrainIdException {
		
		for (Train train1 : trainList) {
			if(train1.getTrainId()==train.getTrainId()) {
				throw new DuplicateTrainIdException(" Enter Train id is already there !!!");
			}
			
		}
		trainList.add(train);
		return " Train Record is added !!!!";

	}

	public ArrayList<Train> displayTrainRecord() {
		return trainList;

	}

}
