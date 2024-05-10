package src.test;

import org.junit.jupiter.api.Test;
import src.main.dao.DaoFactory;
import src.main.dao.PlateDAO;
import src.main.dao.ProductDAO;
import src.main.entity.Plate;
import src.main.entity.Product;

import static org.junit.jupiter.api.Assertions.*;

class DaoFactoryTest {

        @Test
        void shouldReturnNullWhenUnknownClassIsPassed() {
            class DummyAppliance extends Product<DummyAppliance> {}
            ProductDAO<DummyAppliance> dao = DaoFactory.INSTANCE.getApplianceDAO(DummyAppliance.class);
            assertNull(dao);
        }

        @Test
        void shouldReturnPlateDao() {
            ProductDAO<Plate> dao = DaoFactory.INSTANCE.getApplianceDAO(Plate.class);
            assertNotNull(dao);
            assertTrue(dao instanceof PlateDAO);
        }
    }
