package src.test;

import org.junit.jupiter.api.Test;
import src.main.criteria.SearchCriteria;
import src.main.criteria.SpoonSearchCriteria;
import src.main.dao.SpoonDAO;
import src.main.entity.Product;
import src.main.entity.Spoon;
import src.main.parameter.Parameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.*;

class SpoonDAOTest {
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
        SpoonDAO dao = new SpoonDAO();
        Spoon[] expected = new Spoon[]{
                new Spoon(7, 8.1, "SoupSpoon", "white", "metal"),
                new Spoon(8, 7.2, "DecoratedSpoon", "blue", "plastic"),
                new Spoon(9, 5.3, "SmallSpoon", "red", "metal")
        };

        Iterable<Spoon> iterable = dao.find(
                new SpoonSearchCriteria().add(ParameterExtTest.any()));

        assertNotNull(iterable);
        Spoon[] spoons = toArray(iterable, Spoon[]::new);
        assertArrayEquals(expected, spoons);
    }

    @Test
    public void shouldFindNone() {
        SpoonDAO dao = new SpoonDAO();

        Iterable<Spoon> iterable = dao.find(new SpoonSearchCriteria().add(ParameterExtTest.none()));

        assertNotNull(iterable);
        Spoon[] spoons = toArray(iterable, Spoon[]::new);
        assertArrayEquals(new Spoon[0], spoons);
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
