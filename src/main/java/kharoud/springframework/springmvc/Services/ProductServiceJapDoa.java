package kharoud.springframework.springmvc.Services;

import kharoud.springframework.springmvc.Model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("japDoa")
public class ProductServiceJapDoa implements ProductService {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public List<Product> listAllProducts() {

        EntityManager em = emf.createEntityManager();

        return em.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getProductById(Integer id) {
        EntityManager em = emf.createEntityManager();

        return em.find(Product.class,id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Product savedProduct = em.merge(product);
        em.getTransaction().commit();

        return savedProduct;
    }

    @Override
    public void deleteProduct(Integer id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
    }
}
