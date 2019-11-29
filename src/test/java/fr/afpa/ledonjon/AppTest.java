package fr.afpa.ledonjon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.afpa.ledonjon.controles.CharacterControl;
import fr.afpa.ledonjon.controles.DonjonControl;
import fr.afpa.ledonjon.controles.PlayerControl;
import fr.afpa.ledonjon.controles.RoomControl;
import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.GoldPouch;
import fr.afpa.ledonjon.entites.HealthPotion;
import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.entites.Room;
import fr.afpa.ledonjon.entites.SlotMachine;
import fr.afpa.ledonjon.entites.StrengthPotion;
import fr.afpa.ledonjon.services.CharacterSevice;
import fr.afpa.ledonjon.services.DonjonService;
import fr.afpa.ledonjon.services.ItemService;
import fr.afpa.ledonjon.services.MobService;
import fr.afpa.ledonjon.services.PlayerService;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void testCreateMob() {
		Donjon donjon = new Donjon(3, 1);
		donjon.getMaze()[1][0].getMobs().add(new Mob(30, 20, 10, true));
		donjon.getMaze()[1][0].getMobs().add(new Mob(30, 20, 10, true));
		MobService.CreateMob(donjon, 3, 1);
		Assertions.assertEquals(3, donjon.getMaze()[1][0].getMobs().size());
	}

	@Test
	public void testCreatePlayer() {
		Room room = new Room();
		Assertions.assertNull(room.getDidier());
		PlayerService.CreatePlayer("David", room);
		Assertions.assertNotNull(room.getDidier());
	}

	@Test
	public void testIsAlive() {
		Player player = new Player("Charles", 10, 1, 0, true);
		Assertions.assertTrue(CharacterControl.isAlive(player));

	}

	@Test
	public void testGenerateHealthPotion() {
		Room room = new Room();
		ItemService.CreateHealthPotion(room);
		Assertions.assertNotNull(room.getItems().get(0), "A new healthPotion is generate");

	}

	@Test

	public void testGenerateStrenghtPotion() {
		Room room = new Room();
		ItemService.CreateStrengthPotion(room);
		Assertions.assertNotNull("A new strenghtPotion is generate");

	}

	@Test

	public void testGenerateGoldPouch() {
		Room room = new Room();
		ItemService.CreateGoldPouch(room);
		Assertions.assertNotNull("A new goldPouch is generate");

	}

	@Test

	public void testGenerateSlotMachine() {
		Room room = new Room();
		ItemService.CreateSlotMachine(room);
		Assertions.assertNotNull("A new slot is generate");

	}

	@Test
	public void testGenerateItem() {
		Donjon donjon = new Donjon(3, 1);
		donjon.getMaze()[1][0].getItems().add(new HealthPotion());
		donjon.getMaze()[1][0].getItems().add(new StrengthPotion());
		donjon.getMaze()[1][0].getItems().add(new GoldPouch());
		donjon.getMaze()[1][0].getItems().add(new SlotMachine());
		DonjonService.generateItem(donjon, 3, 1);
		Assertions.assertTrue(4 < donjon.getMaze()[1][0].getItems().size());
	}
	
	@Test
	public void testDonjonContainGenerator() {
		Assertions.assertTrue(DonjonService.DonjonContainGenerator(new Donjon(5, 5), 5, 5, "2", "Benoist"));
	}

	@Test
	public void testChangeHighScore() {
		Assertions.assertTrue(DonjonService.ChangeHighScore(new Donjon(5, 5), new Player("Benoist", 100, 10, 54, true)));
	}
	
	@Test

	public void testUseItem() {
		Room room = new Room();
		Player player = new Player("Charles", 10, 1, 0, true);
		HealthPotion healthpotion = new HealthPotion();
		StrengthPotion strengthpotion = new StrengthPotion();
		GoldPouch goldpouch = new GoldPouch();
		SlotMachine slotmachine = new SlotMachine();
		PlayerService.UseItem(player, room, healthpotion);
		PlayerService.UseItem(player, room, strengthpotion);
		PlayerService.UseItem(player, room, goldpouch);
		PlayerService.UseItem(player, room, slotmachine);
		Assertions.assertNotNull("We use a item");
	}

	@Test

	public void testRemoveItem() {
		Room room = new Room();
		GoldPouch goldpouch = new GoldPouch();
		ItemService.CreateGoldPouch(room);
		ItemService.RemoveItem(room, goldpouch);
		Assertions.assertNotNull("We remove a item");

	}

	@Test
	public void testNumbItem() {
		Room room = new Room();
		ItemService.CreateGoldPouch(room);
		ItemService.CreateStrengthPotion(room);
		room.getItems().add(new GoldPouch());
		room.getItems().add(new StrengthPotion());
		Assertions.assertEquals(RoomControl.numbItem(room), room.getItems().size());

	}

	@Test

	public void testReceavedHeal() {

		Player player = new Player("Stephane", 10, 1, 0, true);
		ItemService.Heal(player);
		Assertions.assertNotNull("The player gain heal");

	}

	@Test

	public void testGainStrength() {

		Player player = new Player("Nicolas", 10, 1, 0, true);
		ItemService.GainStrength(player);
		Assertions.assertNotNull("The player gain strength");
	}

	@Test

	public void testLootGold() {

		Player player = new Player("Gaetan", 10, 1, 0, true);
		ItemService.LootGold(player);
		Assertions.assertNotNull("The player loot gold");

	}

	@Test

	public void testGamble() {
		Assertions.assertTrue(ItemService.Gamble(new Player("PAUL", 10, 1, 0, true)));

	}

	@Test

	public void testNumbAliveMob() {
		Room room = new Room();
		room.getMobs().add(new Mob(11, 1, 0, true));
		room.getMobs().add(new Mob(11, 1, 0, true));
		room.getMobs().add(new Mob(0, 1, 0, false));
		room.getMobs().add(new Mob(11, 1, 0, true));
		Assertions.assertEquals(RoomControl.numbAliveMob(room), 3);

	}

	@Test

	public void testPlayerMove() {
		Room room = new Room();
		Room roomS = new Room();
		PlayerService.Move(room, roomS);
		Assertions.assertNotNull("The player move to the");

	}

	@Test

	public void testValidNamePlayer() {
		Assertions.assertTrue(PlayerControl.validNamePlayer("Seti"));
		Assertions.assertFalse(PlayerControl.validNamePlayer("jeanmariegertrude"));
		Assertions.assertFalse(PlayerControl.validNamePlayer("jean8"));
	}

	@Test

	public void testPlayerAttack() {

		Player player = new Player("Seti", 10, 1, 0, true);
		Mob mob = new Mob(10, 1, 0, true);
		PlayerService.Attack(player, mob);
		PlayerService.Attack(mob, player);
		Assertions.assertNotNull("The player attack ");
		Assertions.assertNotNull("The mob attack ");

	}

	@Test

	public void testCharacterLoseHealth() {

		Player player = new Player("Guillaume", 10, 1, 0, true);
		Mob mob = new Mob(10, 1, 0, true);
		CharacterSevice.LoseHealth(player, 5);
		CharacterSevice.LoseHealth(mob, 7);
		Assertions.assertNotNull("The player lost HP ");

	}

	@Test

	public void testEndGame() {
		Player player2 = new Player("Guillaume", 0, 1, 0, true);
		Room room = new Room();
		room.setDidier(new Player("Guillaume", 10, 1, 0, true));
		Donjon donjon = new Donjon(3, 1);
		Assertions.assertFalse(DonjonControl.EndGame(donjon, room.getDidier(), room));
		Assertions.assertFalse(DonjonControl.EndGame(donjon, player2, room));
	}

}
