package hr.tvz.java.godisnjak.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import hr.tvz.java.godisnjak.entity.ApplicationUserType;

public interface ApplicationUserTypeRepository extends CrudRepository<ApplicationUserType, Long>, JpaRepository<ApplicationUserType, Long> {

	public List<ApplicationUserType> findAllByOrderByNameAsc();
}
