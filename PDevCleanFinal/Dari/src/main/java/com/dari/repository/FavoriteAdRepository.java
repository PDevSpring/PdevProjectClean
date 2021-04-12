package com.dari.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dari.model.FavoriteAd;

public interface FavoriteAdRepository extends CrudRepository<FavoriteAd, Long> {

	@Query(value="select * from FAVORITE_AD where ad_adid=? AND user_id=?",nativeQuery=true)
	public FavoriteAd getVoteBySujetAndUser(long adId, long userId);
}
