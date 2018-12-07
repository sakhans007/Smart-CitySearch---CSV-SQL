import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHandler {
	private static SessionFactory factory;
	public DBHandler() {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(City.class);
		cfg.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		factory = cfg.buildSessionFactory(serviceRegistry);
	}
	
	//saves new record
	public void save(City city) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Integer id = (Integer) session.save(city);
		tx.commit();
		session.close();
	}

	public List listCities(){
	    Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        List cities = session.createQuery("FROM City").list();
        tx.commit();
        session.close();
        return cities;
    }

    public Double[] searchCity(String city){
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();

        Query query = session.createQuery("FROM City where city = :city");
        query.setParameter("city", city);

        Object queryResult = query.uniqueResult();
        City city_record = (City) queryResult;

        tx.commit();

        Double[] lat_longs = new Double[2];
        try {
            lat_longs[0] = Double.parseDouble(city_record.getLatitude());
            lat_longs[1] = Double.parseDouble(city_record.getLongitude());
        }catch (NullPointerException e){
            System.out.println("This city does not exists in the database");
            return null;
        }
        return lat_longs;
    }

    public boolean checkDB(){
	    Session session = factory.openSession();
        return session.createQuery("select 1 from City").setFetchSize(1).scroll(ScrollMode.FORWARD_ONLY).next() == false;
    }

	public void close(){
		factory.close();
	}
	
}