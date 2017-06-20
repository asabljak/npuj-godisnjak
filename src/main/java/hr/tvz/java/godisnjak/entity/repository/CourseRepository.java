package hr.tvz.java.godisnjak.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import hr.tvz.java.godisnjak.entity.AcademicYear;
import hr.tvz.java.godisnjak.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long>, JpaRepository<Course, Long> {

	public List<Course> findAllByOrderByNameAsc();
}
