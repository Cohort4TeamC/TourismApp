package com.tourism_org.com.tourismapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.tourism_org.com.tourismapp.dao.ReservePackageDao;
import com.tourism_org.com.tourismapp.model.ReservePackage;

public class ReservePackageDaoTest {

	int unexpected = 0;
	
	@Test
	public void testUserDbCall() {
		ReservePackageDao reservePackageDao = new ReservePackageDao();
		List<ReservePackage> reservePackages = reservePackageDao.getAll();
		int actual = reservePackages.size();
		
		assertNotEquals(unexpected, actual);
	}
	

	
	int reserve_id = 3001;
	
	@Test
	public void testAReservePackage() {
		ReservePackageDao reservePackageDao = new ReservePackageDao();
		ReservePackage reservePackages = reservePackageDao.getAReservePackage(reserve_id);
		
		assertNotNull(reservePackages);
	}
	
	private int expected = 4;
	@Test
	public void GetReservePackages() {
		ReservePackageDao reservePackageDao = new ReservePackageDao();
		List<ReservePackage> reservePackages = reservePackageDao.getReservePackageFromDb();
		int actual = reservePackages.size();
		
		assertEquals(expected, actual);
	}
	
}