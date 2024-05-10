package src.test;

import org.junit.jupiter.api.Test;
import src.main.criteria.PlateSearchCriteria;
import src.main.criteria.SearchCriteria;
import src.main.dao.PlateDAO;
import src.main.entity.Plate;
import src.main.entity.Product;
import src.main.parameter.Parameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.*;



class PlateDAOTest {
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
        PlateDAO dao = new PlateDAO();
        Plate[] expected = new Plate[] {
                new Plate(4, 8.3, "FloralPlate", "blue", "big"),
                new Plate(5, 6.9, "SimplePlate", "red", "medium"),
                new Plate(6, 10.3, "KidsPlate", "white", "small")
        };

        Iterable<Plate> iterable = dao.find(
                new PlateSearchCriteria().add(ParameterExtTest.any()));

        assertNotNull(iterable);
        Plate[] plates = toArray(iterable, Plate[]::new);
        assertArrayEquals(expected, plates);
    }



    @Test
    public void shouldFindNone() {
        // arrange
        PlateDAO dao = new PlateDAO();

        // action
        Iterable<Plate> iterable = dao.find(new PlateSearchCriteria().add(ParameterExtTest.none()));

        // assert
        assertNotNull(iterable);
        Plate[] plates = toArray(iterable, Plate[]::new);
        assertArrayEquals(new Plate[0], plates);
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

