package com.example.userjpacriteriaex.specification;

import com.example.userjpacriteriaex.entity.SearchCriteria;
import com.example.userjpacriteriaex.entity.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserSpecificationsBuilder {

    private final List<SearchCriteria> params;

    public UserSpecificationsBuilder(){
        params=new ArrayList<>();
    }

    public UserSpecificationsBuilder with(SearchCriteria searchCriteria){
        params.add(searchCriteria);
        return this;
    }

    public Specification<User> build(){
        if(params.size()==0){
            return null;
        }

        List<Specification> specs = params.stream()
                .map(UserSpecification::new)
                .collect(Collectors.toList());

        Specification result = specs.get(0);//берем 1 элемент списка

        for (int i = 1; i < params.size(); i++) { // в цикле добавляем через and следующую спецификацию
            result = Specification.where(result).and(specs.get(i));
        }
        return result;

    }
}
