package com.victorsaccucci.Sistemaorquidarioprojeto.Specification;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Gallery;
import com.victorsaccucci.Sistemaorquidarioprojeto.selector.GallerySelector;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class GallerySpecification {
    public static Specification<Gallery> wFilter(GallerySelector selector) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (selector.getTitle() != null) {
                predicates.add(cb.like(cb.lower(root.get("title")), "%"
                        + selector.getTitle().toLowerCase() + "%"));
            }
            if (selector.getUserId() != null) {
                predicates.add(cb.equal(root.get("userId"), selector.getUserId()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}