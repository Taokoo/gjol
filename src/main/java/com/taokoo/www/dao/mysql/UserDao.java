package com.taokoo.www.dao.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taokoo.www.domain.po.User;

public interface UserDao extends JpaRepository<User, Integer>{
    List<User> findByUsernameAndPasswordAndActive(String username, String password, Boolean active);
  /*  User findByUsernameIs(String username);
    User findByDisplayNameIs(String username);
    Page<User> findByProvinceId(int provinceId, Pageable pageable);
    Page<User> findByCityId(int cityId, Pageable pageable);
    Page<User> findByDistrictId(int districtId, Pageable pageable);
    Page<User> findByUsernameContainingOrDisplayNameContainingOrProvinceNameContainingOrCityNameContainingOrDistrictNameContaining(
            String username,
            String displayName,
            String provinceName,
            String cityName,
            String districtName,
            Pageable pageable);
    List<User> findByCityId(int cityId);*/
}
