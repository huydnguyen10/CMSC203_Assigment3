import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {
	CryptoManager crytoManager;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testIsStringInBounds() {
		//fail("Not yet implemented");
		assertTrue(CryptoManager.isStringInBounds("ENCRYPT"));
		assertFalse(CryptoManager.isStringInBounds("{PO"));
		//assertTrue(CryptoManager.isStringInBounds("{PO"));
	}

	@Test
	public void testCaesarEncryption() {
		//fail("Not yet implemented");
		assertEquals("ABC", CryptoManager.caesarEncryption("@AB", 1));
		assertEquals("12345", CryptoManager.caesarEncryption("QRSTU", 32));
	}

	@Test
	public void testBellasoEncryption() {
		//fail("Not yet implemented");
		assertEquals("OIXZGQ", CryptoManager.bellasoEncryption("NGUYEN", "ABC"));
		assertEquals("$", CryptoManager.bellasoEncryption("1", "3"));
	}

	@Test
	public void testCaesarDecryption() {
		//fail("Not yet implemented");
		assertEquals("@AB", CryptoManager.caesarDecryption("ABC", 1));
		assertEquals("12345", CryptoManager.caesarDecryption("RSTUV", 33));
	}

	@Test
	public void testBellasoDecryption() {
		//fail("Not yet implemented");
		assertEquals("Z", CryptoManager.bellasoDecryption("L", "2"));
		assertEquals("NGUYEN", CryptoManager.bellasoDecryption("OIXZGQ", "ABC"));
	}

}
