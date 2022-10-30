package com.example.skilltracker.repository.impl;

import com.example.skilltracker.model.UserEntity;
import com.example.skilltracker.repository.CustomUserRepository;
import com.example.skilltracker.search.SearchCriteria;
import com.example.skilltracker.search.UserSearchQueryCriteriaConsumer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> getUserByNameAssociateIdAndSkill(List<SearchCriteria> params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = builder.createQuery(UserEntity.class);
        Root r = query.from(UserEntity.class);

        Predicate predicate = builder.conjunction();

        UserSearchQueryCriteriaConsumer searchConsumer =
                new UserSearchQueryCriteriaConsumer(predicate, builder, r);
        params.stream().forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        List<UserEntity> result = entityManager.createQuery(query).getResultList();
        return result;
    }
}
