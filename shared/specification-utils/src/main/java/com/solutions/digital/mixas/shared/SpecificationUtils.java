package com.solutions.digital.mixas.shared;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SpecificationUtils {

    /**
     * Equals ignore case with one property to traverse, passed as string to improved readability of the client
     * @param value the value we want to match
     * @param property the property we're checking equality against
     */
    public static <T> Specification<T> equalsIgnoreCase(String value, String property) {
        if (value == null) return null;
        return (root, cq, cb) -> cb.equal(cb.lower(root.get(property)), value.toLowerCase());
    }

    /**
     * Equals ignore case with more than one property to traverse. The root extraction must be given through a function.
     * @param value the value we want to match
     * @param rootGetter a lambda representing a way of getting the correct expression<String></String>
     */
    public static <T> Specification<T> equalsIgnoreCase(String value, Function<Root<T>, Expression<String>> rootGetter) {
        if (value == null) return null;
        return (root, cq, cb) -> cb.equal(cb.lower(rootGetter.apply(root)), value.toLowerCase());
    }

    public static <T> Specification<T> inListObject(Collection<?> values, String property) {
        if (values == null) return null;

        Set<?> set = new HashSet<>(values);

        return (root, cq, cb) -> cb.lower(root.get(property)).in(set);
    }

    /**
     * Check whether the given property belongs to a collection.
     * If we have one property to traverse we can give it as string to improve client readability
     *
     * @param values the values we are checking the property against
     * @param property the property to check if it is found in the collection
     */
    public static <T> Specification<T> inListIgnoreCase(Collection<String> values, String property) {
        if (values == null) return null;

        Set<String> valuesInLowerCase = values.stream().map(String::toLowerCase).collect(Collectors.toSet());

        return (root, cq, cb) -> cb.lower(root.get(property)).in(valuesInLowerCase);
    }

    /**
     * Check whether the given property belongs to a collection.
     * If the properties to traverse is only one use the overloaded method. Else use this with the root given as lambda
     *
     * @param values the values we are checking the property against
     * @param property the property to check if it is found in the collection
     */
    public static <T> Specification<T> inListIgnoreCase(Collection<String> values, Function<Root<T>, Expression<String>> rootGetter) {
        if (values == null) return null;

        Set<String> valuesInLowerCase = values.stream().map(String::toLowerCase).collect(Collectors.toSet());

        return (root, cq, cb) -> cb.lower(rootGetter.apply(root)).in(valuesInLowerCase);
    }


    public static <T> Specification<T> numberEquals(Object value, String property) {
        if (value == null) return null;
        return (root, cq, cb) -> cb.equal(root.get(property), value);
    }

    public static <T> Specification<T> greaterThanOrEqualTo(Double value, String property) {
        if (value == null) return null;

        return (root, cq, cb) -> cb.greaterThanOrEqualTo(root.get(property), value);
    }

    public static <T> Specification<T> lessThanOrEqualTo(Double value, String property) {
        if (value == null) return null;

        return (root, cq, cb) -> cb.lessThanOrEqualTo(root.get(property), value);
    }

}



