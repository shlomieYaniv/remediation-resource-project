package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HibernateTest7 {
  @PostMapping("/hibernateTest7")
  public void hibernateTest7(HttpServletRequest request) {
    String id = request.getParameter("id");
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    String hql = "UPDATE Employee set salary = 100 WHERE id = " + getExtendedID(id);
    Query query = session.createSQLQuery(hql);
    session.getTransaction().commit();
    session.close();
  }

  private String getExtendedID(String id){
    return id +  "0000";
  }
}