package com.demis.sample.service;

import com.demis.sample.model.Item;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    public List<Item> getItems() {
        return Arrays.asList(
                new Item(1L, "item1"),
                new Item(2L, "item2")
        );
    }
}
