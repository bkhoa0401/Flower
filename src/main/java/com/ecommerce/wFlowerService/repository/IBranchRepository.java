package com.ecommerce.wFlowerService.repository;

import com.ecommerce.wFlowerService.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBranchRepository extends JpaRepository<Branch,Long> {

    List<Branch> findBranchesByEnable(String status);
}
