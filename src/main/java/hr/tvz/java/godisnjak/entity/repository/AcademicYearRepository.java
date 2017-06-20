package hr.tvz.java.godisnjak.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import hr.tvz.java.godisnjak.entity.AcademicYear;


public interface AcademicYearRepository extends CrudRepository<AcademicYear, Long>, JpaRepository<AcademicYear, Long>  {

	public List<AcademicYear> findAllByOrderByNameAsc();
}
