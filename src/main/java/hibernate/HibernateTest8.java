package hibernate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Controller
public class HibernateTest8 {
  @PostMapping("/hibernateTest8")
  public void hibernateTest8(HttpServletRequest request) {
    String id = request.getParameter("id");
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("todos");
    EntityManager em = factory.createEntityManager();
    Query q = em.createQuery("select Employee set salary = 100 WHERE id = " + id);
    String result = (String) q.getSingleResult();
    System.out.print(result);
    em.close();
  }
}