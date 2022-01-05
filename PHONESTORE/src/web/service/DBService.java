package web.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import web.entity.BrandEntity;
import web.entity.CartEntity;
import web.entity.CustomerEntity;
import web.entity.ProductEntity;
import web.entity.SaleEntity;
import web.entity.StaffEntity;

public class DBService {
	private SessionFactory factory;

	public DBService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DBService(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public List<CustomerEntity> getAllCustomer() {
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerEntity";
		Query query = session.createQuery(hql);
		List<CustomerEntity> list = query.list();
		
		return list;
	}
	
	public CustomerEntity getCustomer(Integer id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerEntity where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		CustomerEntity cus = (CustomerEntity) query.list().get(0);

		return cus;
	}
	
	public CustomerEntity getCustomerByPhone(String phone) {
		String fnt = "getCustomerByPhone: ";
		
		Session session = factory.getCurrentSession();
		String hql = "FROM CustomerEntity WHERE phone = :phone";
		CustomerEntity cus;
		
		try {
			Query query = session.createQuery(hql);
			query.setParameter("phone", phone);
			cus = (CustomerEntity) query.list().get(0);
		} catch (Exception e) {
			System.err.print(fnt + e);
			return null;
		}
		
		return cus;
	}
	
	public Integer insertCustomer(CustomerEntity customer) {
		String fnt = "insertCustomer: ";
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(customer);
			t.commit();
		} catch (Exception e) {
			System.err.print(fnt + e);
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public Integer deleteCustomer(Integer id) {
		String fnt = "deleteCustomer: ";
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			CustomerEntity customer = (CustomerEntity) session.get(CustomerEntity.class, id);
			session.delete(customer);
			t.commit();
		} catch (Exception e) {
			System.err.print(fnt + e);
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public List<StaffEntity> getAllStaff() {
		Session session = factory.getCurrentSession();
		String hql = "FROM StaffEntity";
		Query query = session.createQuery(hql);
		List<StaffEntity> list = query.list();
		
		return list;
	}
	
	public StaffEntity getStaff(Integer id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM StaffEntity where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		StaffEntity staff = (StaffEntity) query.list().get(0);

		return staff;
	}
	
	public StaffEntity getStaffByPhone(String phone) {
		String fnt = "getStaffByPhone: ";
		
		Session session = factory.getCurrentSession();
		String hql = "FROM StaffEntity where phone = :phone";
		StaffEntity staff;
		
		try {
			Query query = session.createQuery(hql);
			query.setParameter("phone", phone);
			staff = (StaffEntity) query.list().get(0);
		} catch (Exception e) {
			System.err.print(fnt + e);
			return null;
		}
		
		return staff;
	}			
	
	public Integer insertStaff(StaffEntity staff) {
		String fnt = "insertStaff: ";
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(staff);
			t.commit();
		} catch (Exception e) {
			System.err.print(fnt + e);
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteStaff(Integer id) {
		String fnt = "deleteStaff: ";
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			StaffEntity staff = (StaffEntity) session.get(StaffEntity.class, id);
			session.delete(staff);
			t.commit();
		} catch (Exception e) {
			System.err.print(fnt + e);
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductEntity> getAllProduct() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ProductEntity";
		Query query = session.createQuery(hql);
		List<ProductEntity> list = query.list();
		
		return list;
	}
	
	public ProductEntity getProduct(Integer id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ProductEntity where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		ProductEntity pd = (ProductEntity) query.list().get(0);

		return pd;
	}
	
	public Integer insertProduct(ProductEntity product) {
		String fnt = "insertProduct: ";
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(product);
			t.commit();
		} catch (Exception e) {
			System.err.print(fnt + e);
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateProduct(ProductEntity product) {
		String fnt = "updateProduct: ";
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(product);
			t.commit();
		} catch (Exception e) {
			System.err.print(fnt + e);
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public Integer deleteProduct(Integer id) {
		String fnt = "deleteProduct: ";
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {			
			ProductEntity product = (ProductEntity) session.get(ProductEntity.class, id);
			session.delete(product);
			t.commit();
		} catch (Exception e) {
			System.err.print(fnt + e);
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public List<BrandEntity> getAllBrand() {
		Session session = factory.getCurrentSession();
		String hql = "FROM BrandEntity";
		Query query = session.createQuery(hql);
		List<BrandEntity> list = query.list();
		
		return list;
	}
	
	public BrandEntity getBrand(String id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM BrandEntity where id = :id";		
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		BrandEntity br = (BrandEntity) query.list().get(0);
		
		return br;
	}
	
	public List<CartEntity> getCartsByPhone(String phone) {		
		Session session = factory.getCurrentSession();
		String hql = "FROM CartEntity WHERE phone = :phone";
		Query query = session.createQuery(hql);
		query.setParameter("phone", phone);
		List<CartEntity> list = query.list();
		
		return list;
	}
	
	public CartEntity getCartByPhoneAndProduct(String phone, Integer productId) {		
		String fnt = "checkExistCartByPhoneAndProduct: ";
		
		Session session = factory.getCurrentSession();
		String hql = "FROM CartEntity WHERE phone = :phone AND productid = :productId";		
		CartEntity cart;
		
		try {
			Query query = session.createQuery(hql);
			query.setParameter("phone", phone);
			query.setParameter("productId", productId);
			cart = (CartEntity) query.list().get(0);			
		} catch (Exception e) {
			System.err.print(fnt + e);
			return null;
		}
		
		return cart;
	}
	
	public Integer insertCart(CartEntity cart) {
		String fnt = "insertCart: ";
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(cart);
			t.commit();
		} catch (Exception e) {
			System.err.print(fnt + e);
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		
		return 1;
	}
	
	public Integer deleteCart(Integer id) {
		String fnt = "deleteCart: ";
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			CartEntity cart = (CartEntity) session.get(CartEntity.class, id);
			session.delete(cart);
			t.commit();
		} catch (Exception e) {
			System.err.print(fnt + e);
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public List<SaleEntity> getAllSale() {
		Session session = factory.getCurrentSession();
		String hql = "FROM SaleEntity";
		Query query = session.createQuery(hql);
		List<SaleEntity> list = query.list();
		
		return list;
	}
	
	
	// COMMON DB CHECKS
	
//	public String checkPhoneSignUp(String phone) {
//		
//	}
}
