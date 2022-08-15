package com.dictionary.repository.impl;

import com.dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String,String> dictionary = new HashMap<>();
    static {
        dictionary.put("hi","xin chào");
        dictionary.put("one","một");
        dictionary.put("two","hai");
        dictionary.put("three","ba");
        dictionary.put("four","bốn");
        dictionary.put("five","năm");
        dictionary.put("six","sáu");
        dictionary.put("seven","bảy");
        dictionary.put("eight","tám");
        dictionary.put("nine","chín");
        dictionary.put("ten","mười");
    }


    @Override
    public String search(String word) {
        String result = "Không tìm thấy từ tương ứng với từ bạn vừa nhập";
        if (dictionary.containsKey(word.toLowerCase())){
            result = dictionary.get(word);
        }
        return result;
    }
}
