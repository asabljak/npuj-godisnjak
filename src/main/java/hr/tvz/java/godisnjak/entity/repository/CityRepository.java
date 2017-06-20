package hr.tvz.java.godisnjak.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hr.tvz.java.godisnjak.entity.AcademicYear;
import hr.tvz.java.godisnjak.entity.City;


public interface CityRepository extends CrudRepository<City, Long>, JpaRepository<City, Long> {

	public List<City> findAllByOrderByNameAsc();
}
