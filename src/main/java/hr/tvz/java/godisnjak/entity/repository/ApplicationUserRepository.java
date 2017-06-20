package hr.tvz.java.godisnjak.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import hr.tvz.java.godisnjak.entity.AcademicYear;
import hr.tvz.java.godisnjak.entity.ApplicationUser;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long>, JpaRepository<ApplicationUser, Long> {

	public List<ApplicationUser> findAllByOrderByUsernameAsc();
}
