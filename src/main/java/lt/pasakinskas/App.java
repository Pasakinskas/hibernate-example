package lt.pasakinskas;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        var configuration = new Configuration()
          .addAnnotatedClass(Darbuotojas.class)
          .configure();
        var sessionFactory = configuration.buildSessionFactory();

    }

    static void createDarbuotojas(SessionFactory factory) {
        var darbuotojas = new Darbuotojas("Marius", "Pasakinskas", 9999);

        try (var session = factory.openSession()) {
            session.beginTransaction();
            session.save(darbuotojas);
            session.getTransaction().commit();
        }
    }

    static void updateDarbuotojas(SessionFactory factory) {
        var darbuotojas = new Darbuotojas("Marius", "Pasakinskas", 11000);
        darbuotojas.setId(3);

        try (var session = factory.openSession()) {
            session.beginTransaction();
            session.update(darbuotojas);
            session.getTransaction().commit();
        }
    }

    static List<Darbuotojas> getDarbuotojai(SessionFactory factory) {
        try (var session = factory.openSession()) {
            session.beginTransaction();
            var darbuotojai = session.createQuery("from Darbuotojas", Darbuotojas.class).list();
            session.getTransaction().commit();

            return darbuotojai;
        }
    }

    static void deleteById(long id, SessionFactory factory) {
        try (var session = factory.openSession()) {
            session.beginTransaction();

            var darbuotojas = session.get(Darbuotojas.class, id);
            System.out.println("radau darbuotoja");
            System.out.println("jo atlyginimas yra " + darbuotojas.getAtlyginimas());
            session.delete(darbuotojas);

            session.getTransaction().commit();
        }
    }
}
