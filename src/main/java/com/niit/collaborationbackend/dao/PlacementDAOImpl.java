package com.niit.collaborationbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.Placement;

@Repository("placementDAOImpl")
public class PlacementDAOImpl implements PlacementDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public PlacementDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addPlacement(Placement p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
//		session.close();
	}

	@Transactional
	public Placement getPlacementByPlacementId(int id) {
		Session session = sessionFactory.getCurrentSession();
		// System.out.print(id);
		Placement p = (Placement) session.load(Placement.class, new Integer(id));
		System.out.println("get placement by id :" + p);
		// session.close();
		return p;
	}

	@Transactional
	public List<Placement> getAllPlacements() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Placement");
		@SuppressWarnings("unchecked")
		List<Placement> placementsDetail = query.list();

		return placementsDetail;
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public Placement getPlacementByPlacementname(String placementname) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Placement where placementname = ?");
		query.setString(0, placementname);

		return (Placement) query.uniqueResult();
	}

	@Transactional
	public void deletePlacement(Placement placement) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (null != placement) {
			session.delete(placement);
		}
		// logger.info("Product deleted successfully, product details="+p);
		tx.commit();
//		session.close();
	}

	@Transactional
	public Placement updatePlacement(int id , Placement placement) {
		Session session = this.sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.update(placement);
		tx.commit();
		Placement p = (Placement) session.load(Placement.class, new Integer(id));
//		session.close();
		// logger.info("Product updated successfully, Product Details="+p);
		return p;
	}
	// public void storeFile(Placement placement) {
	//
	// MultipartFile file= placement.getFile();
	//
	// if (!file.isEmpty()) {
	//
	// try{
	// byte[] bytes =file.getBytes();
	// System.out.println(file.getOriginalFilename());
	//
	// String BASE_PATH="E:/";
	// File serverFile = new
	// File(BASE_PATH+p.getProduct_category()+"/"+placement.getImage());
	// serverFile.createNewFile();
	// BufferedOutputStream stream = new BufferedOutputStream(
	// new FileOutputStream(serverFile));
	// stream.write(bytes);
	// stream.close();
	// System.out.println("img stored");
	// }
	// catch(Exception ex)
	// {
	// System.out.println(ex);
	// }
	//
	// }
	// }

}
