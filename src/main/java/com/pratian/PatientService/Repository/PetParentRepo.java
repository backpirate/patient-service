package com.pratian.PatientService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pratian.PatientService.Entities.PetParent;

@Repository
public interface PetParentRepo extends JpaRepository<PetParent, Long>
{
	@Query(value = "select pp from PetParent pp")
	public List<PetParent> getPetParentProfile();
	

	
	
}
