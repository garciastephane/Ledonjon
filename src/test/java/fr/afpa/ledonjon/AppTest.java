package fr.afpa.ledonjon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.Room;
import fr.afpa.ledonjon.services.MobService;
import fr.afpa.ledonjon.services.PlayerService;

/**
 * Unit test for simple App.
 */
public class AppTest {

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		Assertions.assertTrue(true);
	}

	@Test
	public void testCreateMob() {
		Donjon donjon = new Donjon(3, 1);
		donjon.getMaze()[1][0].getMobs().add(new Mob(30, 20, 10, true));
		donjon.getMaze()[1][0].getMobs().add(new Mob(30, 20, 10, true));
		MobService.CreateMob(donjon, 3, 1);
		Assertions.assertEquals(3, donjon.getMaze()[1][0].getMobs().size());
	}

	@Test
	public void testAttack() {

	}

	/**
	 * 
	 * Create the test case
	 *
	 * 
	 * 
	 * @param testName name of the test case
	 * 
	 */

	@Test
	public void creerListPlayer() {
		Room room = new Room();
		Assertions.assertNull(room.getDidier());
		PlayerService.CreatePlayer(room);
		Assertions.assertNotNull(room.getDidier());
	}

//	public void testSize() {
//
//		assertEquals("Taille de la liste", 2, listTest.size());
//
//	}
//
//	public void testDonjonContainGenerator() {
//
//		assertNotNull("A new donjon is generate ", DonjonService.DonjonContainGenerator("Toto", donjon, 8, 8));
//
//	}
//
//	public void testAddGeneratePlayer() {
//
//		lisTest.add("Pepe", room);
//
//		assertEquals("A new player is add to the list ", PlayerService.CreatePlayer();
//
//
//
//	}
//
//	public void testGenerateMob() {
//
//		assertEquals("A new mob is generate", MobService.CreateMob(donjon, 8, 8));
//
//	}
//
//	public void testGenerateHealthPotion() {
//
//		assertNotNull("A new healthPotion is generate", ItemService.CreateHealthPotion(room));
//
//	}
//
//	public void testGenerateStrenghtPotion() {
//
//		assertNotNull("A new strenghtPotion is generate", ItemService.CreateStrengthPotion(room));
//
//	}
//
//	public void testGenerateGoldPouch() {
//
//		assertNotNull("A new goldPouch is generate", ItemService.CreateGoldPouch(room));
//
//	}
//
//	public void testGenerateSlotMachine() {
//
//		assertNotNull("A new slot is generate", ItemService.CreateSlotMachine(room));
//
//	}
//
//	public void testPlayerMove() {
//
//		assertEquals("The player move to the ", PlayerService.Move(room, roomS));
//
//	}
//
//	public void testPlayerAttack() {
//
//		assertEquals("The player attack ", PlayerService.Attack(attacker, defender));
//
//	}
//
//	/**
//	 * 
//	 * 
//	 * 
//	 * @return
//	 * 
//	 */
//
//	public boolean testIsAlive() {
//
//		return this.getLifePoints() > 0;
//
//	}
//
//	/**
//	 * 
//	 * 
//	 * 
//	 * @return
//	 * 
//	 */
//
//	public int getLifePoints() {
//
//		return this.getLifePoints();
//
//	}
//
//	/**
//	 * 
//	 * 
//	 * 
//	 * @param lifePoints
//	 * 
//	 */
//
//	public void setLifePoints(int lifePoints) {
//
//		this.setLifePoints = lifePoints;
//
//	}
//
//	/**
//	 * 
//	 * 
//	 * 
//	 * @return
//	 * 
//	 */
//
//	public int getAttackPoints() {
//
//		return this.getAttackPoints();
//
//	}
//
//	/**
//	 * 
//	 * 
//	 * 
//	 * @param attackPoints
//	 * 
//	 */
//
//	public void setAttackPoints(int attackPoints) {
//
//		this.AttackPoints = attackPoints;
//
//	}
//
//	/**
//	 * 
//	 * 
//	 * 
//	 * @return
//	 * 
//	 */
//
//	public int getGold() {
//
//		return this.getGold();
//
//	}
//
//	/**
//	 * 
//	 * 
//	 * 
//	 * @param gold
//	 * 
//	 */
//
//	public void setGold(int gold) {
//
//		this.gold = gold;
//
//	}
//
//	/**
//	 * 
//	 * 
//	 * 
//	 * @return
//	 * 
//	 */
//
//	public boolean foundStartRoom() {
//
//	}
//
//	/**
//	 * 
//	 * 
//	 * 
//	 * @return
//	 * 
//	 */
//
//	public boolean foundEndRoom() {
//
//	}
}
