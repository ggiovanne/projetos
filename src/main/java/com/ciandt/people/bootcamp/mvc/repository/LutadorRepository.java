package com.ciandt.people.bootcamp.mvc.repository;

import com.ciandt.people.bootcamp.mvc.repository.model.LutadorModel;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LutadorRepository extends JpaRepository<LutadorModel, Long> {
     List<LutadorModel> findAll();

   // @Query("select * from tbl_Lutadores where idade >= :idade1 and idade <= :idade2")
	//Optional<LutadorModel> findByIdadeBetween(@Param ("idade1")String idade1, @Param ("idade2") String idade2);
     
 	Optional<List<LutadorModel>> findByIdadeBetween(String idade1, String idade2);
}