package com.mindtree.shopproject.dao;

import com.mindtree.shopproject.entity.Shop;
import com.mindtree.shopproject.exception.dao.DaoException;

public interface ShopDao {

	public String insertShopDetail(Shop shopList) throws DaoException;
}
