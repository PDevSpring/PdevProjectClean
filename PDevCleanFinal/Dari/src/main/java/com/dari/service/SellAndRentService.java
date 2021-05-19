package com.dari.service;

	import java.util.List;

	import com.dari.model.Rent;
	import com.dari.model.Sell;

public interface SellAndRentService {

	public List<Sell> SellAds();

	public List<Rent> RentAds();

	public List<Rent> RentAdsTypeRent();

	public List<Rent> RentAdsTypeHolidays();

	public List<Rent> RentAdsTypeTemp();

}
