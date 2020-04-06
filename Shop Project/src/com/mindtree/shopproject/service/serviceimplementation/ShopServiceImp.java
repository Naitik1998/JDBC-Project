package com.mindtree.shopproject.service.serviceimplementation;

import java.util.HashSet;
import java.util.Set;

import com.mindtree.shopproject.dao.ShopDao;
import com.mindtree.shopproject.dao.daoimplementation.ShopDaoImp;
import com.mindtree.shopproject.entity.Shop;
import com.mindtree.shopproject.exception.dao.DaoException;
import com.mindtree.shopproject.service.ShopService;

public class ShopServiceImp implements ShopService {

	Set<Shop> shopSet = new HashSet<Shop>();
	ShopDao shopDao = new ShopDaoImp();

	public String addShopDetail(Shop shop) {
		String message = "";
		try {
			message = shopDao.insertShopDetail(shop);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		return message;

	}

}
