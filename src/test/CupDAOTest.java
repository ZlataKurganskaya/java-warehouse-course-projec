package src.test;

import org.junit.jupiter.api.Test;
import src.main.criteria.CupSearchCriteria;
import src.main.criteria.SearchCriteria;
import src.main.dao.CupDAO;
import src.main.entity.Cup;
import src.main.entity.Product;
import src.main.parameter.Parameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.*;

class CupDAOTest {
    interface ParameterExtTest<A extends Product<A>> extends Parameter<A> {
        static <A extends Product<A>> Parameter<A> any() {
            return product -> true;
        }

        static <A extends Product<A>> Parameter<A> none() {
            return product -> false;
        }
    }

    @Test
    void shouldFindAll() {
        // arrange
        CupDAO dao = new CupDAO();
        Cup[] expected = new Cup[]{
                new Cup(1, 10.5, "FloralCup", "blue", 300),
                new Cup(2, 12.6, "BigCup", "white", 500),
                new Cup(3, 9.8, "CoffeeCup", "white", 300)
        };

        Iterable<Cup> iterable = dao.find(
                new CupSearchCriteria().add(ParameterExtTest.any()));

        assertNotNull(iterable);
        Cup[] cups = toArray(iterable, Cup[]::new);
        assertArrayEquals(expected, cups);
    }

    @Test
    public void shouldFindNone() {
        CupDAO dao = new CupDAO();

        Iterable<Cup> iterable = dao.find(new CupSearchCriteria().add(ParameterExtTest.none()));

        assertNotNull(iterable);
        Cup[] cups = toArray(iterable, Cup[]::new);
        assertArrayEquals(new Cup[0], cups);
    }

    private static <A extends Product<A>> A[] toArray(Iterable<A> iterable,
                                                      IntFunction<A[]> arrayGen) {
        ArrayList<A> list = new ArrayList<>();
        iterable.forEach(list::add);
        A[] arr = list.toArray(arrayGen);
        Arrays.sort(arr, Comparator.comparingInt(Product::getId));
        return arr;
    }
}
