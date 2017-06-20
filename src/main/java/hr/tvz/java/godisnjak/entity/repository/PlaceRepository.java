package hr.tvz.java.godisnjak.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import hr.tvz.java.godisnjak.entity.Place;

public interface PlaceRepository extends CrudRepository<Place, Long>, JpaRepository<Place, Long> {

	public List<Place> findAllByOrderByNameAsc();
	public List<Place> findAllByOrderByCity_NameAsc();
}
