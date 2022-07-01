package com.example.userjpacriteriaex;

import com.example.userjpacriteriaex.entity.SearchCriteria;
import com.example.userjpacriteriaex.entity.User;
import com.example.userjpacriteriaex.repository.UserRepository;
import com.example.userjpacriteriaex.specification.UserSpecificationsBuilder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CriteriaController {

    @NonNull
    private UserRepository repository;

    @PostMapping()
    public List<User> getUsers(@RequestBody List<SearchCriteria> searchCriterias){

        UserSpecificationsBuilder builder = new UserSpecificationsBuilder();
        for(SearchCriteria criteria:searchCriterias) {
            builder.with(criteria);
        }
        return repository.findAll(builder.build());
    }
}
