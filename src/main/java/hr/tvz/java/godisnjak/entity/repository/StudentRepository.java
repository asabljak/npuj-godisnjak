package hr.tvz.java.godisnjak.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import hr.tvz.java.godisnjak.entity.AcademicYear;
import hr.tvz.java.godisnjak.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>, JpaRepository<Student, Long> {

	public List<Student> findAllByOrderByNameAsc();
}
