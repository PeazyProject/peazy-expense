package com.peazy.expense.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.peazy.expense.model.entity.CommonCodeConverterEntity;

@Repository
public interface CommonCodeConverterRepository
        extends JpaRepository<CommonCodeConverterEntity, Long> {

    public List<CommonCodeConverterEntity> findByMainCategoryAndSubCategoryAndIsActivated(
            String mainCategory, String subCategory, String IsActivated);

}
