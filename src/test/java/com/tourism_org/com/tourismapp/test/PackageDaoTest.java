package com.tourism_org.com.tourismapp.test;

import com.tourism_org.com.tourismapp.dao.PackageDao;
import com.tourism_org.com.tourismapp.model.Package;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PackageDaoTest {

	
	private int expected = 10;
	@Test
	public void GetPackages() {
		PackageDao packageDao = new PackageDao();
		List<Package> packages = packageDao.getPackageFromDb();
		int actual = packages.size();
		
		assertEquals(expected, actual);
	}
	
	// PUT Annotation Test when you need to add a Package
	
	public void AddPackage() {
		
		int expected = 1;
				
		Package package1 = new Package();
		
		package1.setPackage_code(2114);
		package1.setPackage_name("FAMILY PACKAGE");
		package1.setCountry("Sri Lanka");
		package1.setCountry_area1("Kalutara");
		package1.setCountry_area2(null);
		package1.setNumber_of_nights("3 Nights");
		package1.setWeekly_schedule("Thursday");
		package1.setStart_date("2021-12-06");
		package1.setEnd_date("2021-12-09");
		package1.setHotel1("Turya");
		package1.setHotel2(null);
		package1.setActivity1("Surfing");
		package1.setActivity2(null);
		package1.setDescription(null);
		package1.setPrice_per_person("7500.00");

		PackageDao packageDao = new PackageDao();
		int actual = packageDao.addPackage(package1);
				
		assertEquals(expected, actual);
	
	}
	
}