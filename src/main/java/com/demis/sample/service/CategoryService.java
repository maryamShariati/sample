package com.demis.sample.service;

import com.demis.sample.model.Category;
import com.demis.sample.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private static CategoryRepository categoryRepository;


    public List<Category>getAllCategory(){
        return categoryRepository.findAll();
    }



}
